package com.haylion.common.redis.dlock;

/**
 * @author liyu
 * date 2022/10/19 15:49
 * description
 */
public interface DistributedLock {
    /**
     * 获取锁
     *
     * @return 锁标识
     * @author zhi.li
     */
    String acquire();

    String acquire(String lockKey);

    String acquire(String lockKey, Integer acquireTimeout);

    String acquire(String lockKey, Integer acquireTimeout, Integer expireTime) throws Exception;

    /**
     * 释放锁
     *
     * @param identify
     * @return
     * @author zhi.li
     */
    void release(String identify, String lockKey);
}
