package com.haylion.common.redis.dlock;

import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.core.exception.SysStubInfo;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;

import static com.haylion.common.core.exception.SysStubInfo.ACQUIRE_REDIS_LOCK_ERROR;
import static com.haylion.common.core.exception.SysStubInfo.ACQUIRE_REDIS_UNLOCK_ERROR;

/**
 * @author liyu
 * date 2022/10/19 15:50
 * description
 */
@Slf4j
@Component
@NoArgsConstructor
public class RedisDistributedLock implements DistributedLock {

    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * redis 客户端
     */
    @Autowired
    private Jedis jedis;

    /**
     * 分布式锁的键值
     */
    private String lockKey;

    /**
     * 锁的超时时间 10s
     */
    int expireTime = 10 * 1000;

    /**
     * 锁等待，防止线程饥饿
     */
    int acquireTimeout = 1 * 1000;


    @Override
    public String acquire() {
        return acquire(null, null, null);
    }

    @Override
    public String acquire(String lockKey) {
        return acquire(lockKey, null, null);
    }

    @Override
    public String acquire(String lockKey, Integer acquireTimeout) {
        return acquire(lockKey, acquireTimeout, null);
    }

    @Override
    public String acquire(String lockKey, Integer acquireTimeout, Integer expireTime) {
        if (StringUtils.isBlank(lockKey)) {
            lockKey = this.lockKey;
        }
        if (acquireTimeout == null) {
            acquireTimeout = this.acquireTimeout;
        }
        if (expireTime == null) {
            expireTime = this.expireTime;
        }
        String requireToken;

        // 获取锁的超时时间，超过这个时间则放弃获取锁
        long end = System.currentTimeMillis() + acquireTimeout;
        // 随机生成一个value
        requireToken = UUID.randomUUID().toString();
        while (System.currentTimeMillis() < end) {
            String result = jedis.set(lockKey, requireToken, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
            if (LOCK_SUCCESS.equals(result)) {
                return requireToken;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        throw new ApplicationException(ACQUIRE_REDIS_LOCK_ERROR);
    }

    @Override
    public void release(String identify, String lockKey) {
        if (StringUtils.isBlank(lockKey)) {
            lockKey = this.lockKey;
        }
        if (identify == null) {
            throw new ApplicationException(ACQUIRE_REDIS_UNLOCK_ERROR);
        }

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey),
                Collections.singletonList(identify));
        if (RELEASE_SUCCESS.equals(result)) {
            log.info("release lock success, requestToken:{}", identify);
            return;
        }
        log.error("release lock failed, requestToken:{}, result:{}", identify, result);
        throw new ApplicationException(ACQUIRE_REDIS_UNLOCK_ERROR);
    }
}