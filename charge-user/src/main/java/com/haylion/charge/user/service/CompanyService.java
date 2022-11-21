package com.haylion.charge.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.entity.CompanyT;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.constant.CommonConstant;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.repository.mapper.CompanyTMapper;
import com.haylion.charge.user.constant.RetStubDetail;
import com.haylion.charge.user.pojo.form.CompanyForm;
import com.haylion.charge.user.utils.convert.CompanyConvert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/4/12 15:50
 * description
 */
@Service
public class CompanyService {
    @Autowired
    CompanyTMapper companyTMapper;
    @Autowired
    DepartmentService departmentService;

    public PageInfo<CompanyT> selectList(String name, Integer[] type, String resName, String supplierCode, Integer innerCompany, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(companyTMapper.selectList(name, type, resName, supplierCode, innerCompany));
    }

    public CompanyT info(Integer id) {
        return companyTMapper.selectByPrimaryKey(id);
    }

    public void add(CompanyForm companyForm) {
        checkCompanyUniqueField(companyForm);

        var companyT = CompanyConvert.INSTANCE.formToEntity(companyForm);
        companyT.setCreateBy(SecurityUtil.getUsername());
        companyT.setCreateTime(LocalDateTime.now());
        companyTMapper.insertSelective(companyT);
    }

    public void update(CompanyForm companyForm) {

        checkCompanyUniqueField(companyForm);

        var companyT = CompanyConvert.INSTANCE.formToEntity(companyForm);
        companyT.setUpdateBy(SecurityUtil.getUsername());
        companyT.setUpdateTime(LocalDateTime.now());
        companyTMapper.updateByPrimaryKeySelective(companyT);
    }


    public void delete(CompanyForm companyForm) {
        if (departmentService.selectDepartmentExitByCId(companyForm.getId())) {
            throw new ApplicationException(RetStubDetail.DEPARTMENT_ON_COMPANY_NOT_NULL);
        }
        var companyT = new CompanyT();
        companyT.setId(companyForm.getId());
        companyT.setDeleted(CommonConstant.DELETED_YES);
        companyTMapper.updateByPrimaryKeySelective(companyT);
    }


    /**
     * 检查公司唯一字段是否
     *
     * @param companyForm 待添加或更新信息
     */
    private void checkCompanyUniqueField(CompanyForm companyForm) {
        if (StringUtils.isNotBlank(companyForm.getName())) {
            var companyT = companyTMapper.selectByName(companyForm.getName());
            if (companyT != null && !companyT.getId().equals(companyForm.getId())) {
                throw new ApplicationException(RetStubDetail.COMPANY_NAME_EXIST_ERROR);
            }
        }

        if (StringUtils.isNotBlank(companyForm.getSupplierCode())) {
            var companyT = companyTMapper.selectBySupplierCode(companyForm.getSupplierCode());
            if (companyT != null && !companyT.getId().equals(companyForm.getId())) {
                throw new ApplicationException(RetStubDetail.COMPANY_CODE_EXIST_ERROR);
            }
        }

    }
}
