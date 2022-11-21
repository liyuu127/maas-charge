package com.haylion.charge.system.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.LookupChildT;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.repository.mapper.LookupChildTMapper;
import com.haylion.charge.system.constant.RetStubDetail;
import com.haylion.charge.system.model.form.LookupChildForm;
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
public class LookupChildTService {

    @Autowired
    LookupChildTMapper lookupChildTMapper;

    public void addLookupChild(LookupChildForm lookupChildForm) {

        int count = lookupChildTMapper.countByValueAndPid(lookupChildForm.getValue(), lookupChildForm.getPid(), null);
        if (count > 0) {
            throw new ApplicationException(RetStubDetail.VALUE_ALREADY_EXIST);
        }

        LookupChildT lookupChildT = new LookupChildT();
        BeanUtils.copyProperties(lookupChildForm, lookupChildT);
        lookupChildT.setCreateTime(LocalDateTime.now());
        lookupChildTMapper.insert(lookupChildT);
    }

    public void updateLookupChild(LookupChildForm lookupChildForm) {

        int count = lookupChildTMapper.countByValueAndPid(
                lookupChildForm.getValue(), lookupChildForm.getPid(), lookupChildForm.getId());
        if (count > 0) {
            throw new ApplicationException(RetStubDetail.VALUE_ALREADY_EXIST);
        }

        LookupChildT lookupChildT = new LookupChildT();
        BeanUtils.copyProperties(lookupChildForm, lookupChildT);
        lookupChildT.setUpdateTime(LocalDateTime.now());
        lookupChildTMapper.updateByPrimaryKey(lookupChildT);
    }

    public void deleteLookupChild(Integer id) {

        lookupChildTMapper.delete(id);
    }

    public PageInfo<LookupChildT> listLookupChildByPid(Integer pid, Integer page, Integer size) {

        PageHelper.startPage(page, size);
        List<LookupChildT> lookupChildTList = lookupChildTMapper.listLookupChildByPid(pid);
        return new PageInfo<>(lookupChildTList);
    }

    public List<LookupChildT> listLookupChildByPValue(String value) {
        return lookupChildTMapper.listLookupChildByPvalue(value);
    }
}
