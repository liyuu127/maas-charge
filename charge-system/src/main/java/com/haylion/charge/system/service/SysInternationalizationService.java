package com.haylion.charge.system.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.SysInternationalization;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.repository.mapper.SysInternationalizationMapper;
import com.haylion.charge.system.constant.RetStubDetail;
import com.haylion.charge.system.model.form.SysInternationalizationAddForm;
import com.haylion.charge.system.model.form.SysInternationalizationDeleteForm;
import com.haylion.charge.system.model.form.SysInternationalizationEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @Description
 * @Author hqf
 * @Date 2022/3/1
 */
@Service
public class SysInternationalizationService {

    @Autowired
    private SysInternationalizationMapper sysInternationalizationMapper;

    public List<SysInternationalization> selectInternationalization() {
        return sysInternationalizationMapper.selectAllInUse();
    }

    public PageInfo<SysInternationalization> getList(Integer page, Integer size, String code, String value) {
        PageHelper.startPage(page,size);
        List<SysInternationalization> list = sysInternationalizationMapper.selectListByConditions(code, value);
        return new PageInfo<>(list);
    }

    public void addSysInternationalization(SysInternationalizationAddForm sysInternationalizationAddForm) {
        String code = sysInternationalizationAddForm.getCode();
        validCode(null,code);
        SysInternationalization sysInternationalization = new SysInternationalization()
                .setCode(code)
                .setValue(sysInternationalizationAddForm.getValue())
                .setCreateTime(LocalDateTime.now());
        sysInternationalizationMapper.insertSelective(sysInternationalization);
    }


    public void editSysInternationalization(SysInternationalizationEditForm sysInternationalizationEditForm) {
        String code = sysInternationalizationEditForm.getCode();
        Integer id = sysInternationalizationEditForm.getId();
        validCode(id,code);
        String value = sysInternationalizationEditForm.getValue();
        Integer status = sysInternationalizationEditForm.getStatus();
        SysInternationalization UpdateSysInternationalization= new SysInternationalization().setId(id)
                .setCode(code)
                .setValue(value)
                .setStatus(status)
                .setUpdateTime(LocalDateTime.now());
        sysInternationalizationMapper.updateByPrimaryKeySelective(UpdateSysInternationalization);
    }

    private void validCode(Integer id, String code) {
        List<SysInternationalization> list = sysInternationalizationMapper.varyIdAndCode(id,code);
        if(!list.isEmpty()){
            throw new ApplicationException(RetStubDetail.SYS_INTERNATIONALIZATION_CODE_ALREADY_EXIST);
        }
    }

    public void deleteSysInternationalization(SysInternationalizationDeleteForm sysInternationalizationDeleteForm) {
        sysInternationalizationMapper.deleteById(sysInternationalizationDeleteForm.getId());
    }
}
