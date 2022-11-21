package com.haylion.charge.system.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.LookupParentT;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.repository.mapper.LookupChildTMapper;
import com.haylion.common.repository.mapper.LookupParentTMapper;
import com.haylion.charge.system.constant.RetStubDetail;
import com.haylion.charge.system.model.form.LookupParentForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author hqf
 * @Date 2021/11/1
 */
@Service
public class LookupParentTService {

    @Autowired
    LookupParentTMapper lookupParentTMapper;

    @Autowired
    LookupChildTMapper lookupChildTMapper;

    public void addLookupParent(LookupParentForm lookupParentForm) {

        // 校验value值
        int count = lookupParentTMapper.countByValue(lookupParentForm.getValue(), null);
        if (count > 0) {
            throw new ApplicationException(RetStubDetail.VALUE_ALREADY_EXIST);
        }

        LookupParentT lookupParentT = new LookupParentT();
        BeanUtils.copyProperties(lookupParentForm, lookupParentT);
        lookupParentT.setCreateTime(LocalDateTime.now());
        lookupParentTMapper.insert(lookupParentT);
    }

    public void updateLookupParent(LookupParentForm lookupParentForm) {

        // 校验value值
        int count = lookupParentTMapper.countByValue(lookupParentForm.getValue(), lookupParentForm.getId());
        if (count > 0) {
            throw new ApplicationException(RetStubDetail.VALUE_ALREADY_EXIST);
        }

        LookupParentT lookupParentT = new LookupParentT();
        BeanUtils.copyProperties(lookupParentForm, lookupParentT);
        lookupParentT.setUpdateTime(LocalDateTime.now());
        lookupParentTMapper.updateByPrimaryKeySelective(lookupParentT);
    }

    public PageInfo<LookupParentT> listLookupParent(String value, String name, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<LookupParentT> lookupParentTList = lookupParentTMapper.list(value, name);
        return new PageInfo<>(lookupParentTList);
    }

    public void deleteLookupParent(Integer id) {

        lookupParentTMapper.delete(id);
        lookupChildTMapper.deleteByPid(id);
    }

    public LookupParentT getInfo(String value) {

        return lookupParentTMapper.getInfo(value);
    }
}
