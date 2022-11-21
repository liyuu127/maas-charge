package com.haylion.charge.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.DepartmentT;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.constant.CommonConstant;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.repository.mapper.DepartmentTMapper;
import com.haylion.charge.user.constant.RetStubDetail;
import com.haylion.charge.user.pojo.form.DepartmentForm;
import com.haylion.charge.user.utils.convert.DepartmentConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/4/12 15:50
 * description
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentTMapper departmentTMapper;
    @Autowired
    PositionService positionService;

    public PageInfo<DepartmentT> selectList(String name, Integer cId, String resName, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(departmentTMapper.selectList(name, cId, resName));
    }

    public DepartmentT info(Integer id) {
        return departmentTMapper.selectByPrimaryKey(id);
    }

    public void add(DepartmentForm departmentForm) {
        var departmentT = departmentTMapper.selectByNameAndCId(departmentForm.getName(), departmentForm.getCId());
        if (departmentT != null) {
            throw new ApplicationException(RetStubDetail.DEPARTMENT_NAME_EXIST_ERROR);
        }
        departmentT = DepartmentConvert.INSTANCE.formToEntity(departmentForm);
        departmentT.setCreateBy(SecurityUtil.getUsername());
        departmentT.setCreateTime(LocalDateTime.now());
        departmentTMapper.insertSelective(departmentT);
    }

    public void update(DepartmentForm departmentForm) {
        DepartmentT departmentT = null;
        if (departmentForm.getName() != null) {
            departmentT = departmentTMapper.selectByNameAndCId(departmentForm.getName(), departmentForm.getCId());
        }
        if (departmentT != null && !departmentT.getId().equals(departmentForm.getId())) {
            throw new ApplicationException(RetStubDetail.DEPARTMENT_NAME_EXIST_ERROR);
        }
        departmentT = DepartmentConvert.INSTANCE.formToEntity(departmentForm);
        departmentT.setUpdateBy(SecurityUtil.getUsername());
        departmentT.setUpdateTime(LocalDateTime.now());
        departmentTMapper.updateByPrimaryKeySelective(departmentT);
    }

    public void delete(DepartmentForm departmentForm) {
        if (positionService.selectPositionExitByDId(departmentForm.getId())) {
            throw new ApplicationException(RetStubDetail.POSITION_ON_DEPARTMENT_NOT_NULL);
        }
        DepartmentT departmentT = new DepartmentT();
        departmentT.setId(departmentForm.getId());
        departmentT.setDeleted(CommonConstant.DELETED_YES);
        departmentTMapper.updateByPrimaryKeySelective(departmentT);
    }

    public Boolean selectDepartmentExitByCId(Integer cId) {
        return departmentTMapper.selectExistByCId(cId);
    }
}
