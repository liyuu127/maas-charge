package com.haylion.charge.user.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.dto.ResourceDto;
import com.haylion.common.repository.mapper.ResourceTMapper;
import com.haylion.common.repository.mapper.RoleResourceTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyu
 * date 2021/1/17 17:06
 * description
 */
@Service
public class ResourceService {

    @Autowired
    RoleResourceTMapper roleResourceTMapper;
    @Autowired
    ResourceTMapper resourceTMapper;

    public PageInfo<ResourceDto> selectList(Integer userId, String name, Integer pId, Integer status, String group, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(resourceTMapper.selectList(userId, name, pId, status, group));
    }

    public List<ResourceDto> selectAll() {
        return resourceTMapper.selectAll();
    }
}
