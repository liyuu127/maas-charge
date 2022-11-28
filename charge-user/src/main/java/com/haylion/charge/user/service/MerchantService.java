package com.haylion.charge.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.charge.user.constant.RetStubDetail;
import com.haylion.charge.user.pojo.form.MerchantForm;
import com.haylion.charge.user.utils.convert.MerchantConvert;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.constant.CommonConstant;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.entity.entity.ChargeMerchant;
import com.haylion.common.repository.mapper.ChargeMerchantMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.haylion.charge.user.constant.RetStubDetail.MERCHANT_DELETE_ERROR;

/**
 * @author liyu
 * date 2022/4/12 15:50
 * description
 */
@Service
public class MerchantService {
    @Autowired
    ChargeMerchantMapper merchantMapper;
    @Autowired
    MerchantUserService merchantUserService;

    public PageInfo<ChargeMerchant> selectList(String name, Integer[] type, String code, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(merchantMapper.selectList(name, type, code));
    }

    public ChargeMerchant info(Integer id) {
        return merchantMapper.selectByPrimaryKey(id);
    }

    public void add(MerchantForm merchantForm) {
        checkMerchantSUniqueField(merchantForm);

        var chargeMerchant = MerchantConvert.INSTANCE.formToEntity(merchantForm);
        chargeMerchant.setCreateUser(SecurityUtil.getUsername());
        chargeMerchant.setCreateTime(LocalDateTime.now());
        merchantMapper.insertSelective(chargeMerchant);
    }

    public void update(MerchantForm merchantForm) {

        checkMerchantSUniqueField(merchantForm);

        var chargeMerchant = MerchantConvert.INSTANCE.formToEntity(merchantForm);
        chargeMerchant.setUpdateUser(SecurityUtil.getUsername());
        chargeMerchant.setUpdateTime(LocalDateTime.now());
        merchantMapper.updateByPrimaryKeySelective(chargeMerchant);
    }


    public void delete(MerchantForm merchantForm) {
        var chargeMerchant = new ChargeMerchant();
        if (merchantUserService.existByMerchantId(merchantForm.getId())) {
            throw new ApplicationException(MERCHANT_DELETE_ERROR);
        }
        chargeMerchant.setId(merchantForm.getId());
        chargeMerchant.setDeleted(CommonConstant.DELETED_YES);
        merchantMapper.updateByPrimaryKeySelective(chargeMerchant);
    }


    /**
     * 检查公司唯一字段是否
     *
     * @param merchantForm 待添加或更新信息
     */
    private void checkMerchantSUniqueField(MerchantForm merchantForm) {
        Integer id = merchantForm.getId();
        if (StringUtils.isNotBlank(merchantForm.getName())) {
            merchantMapper.selectByName(merchantForm.getName())
                    .ifPresent(chargeMerchant -> {
                        if (id != null && !chargeMerchant.getId().equals(id)) {
                            throw new ApplicationException(RetStubDetail.COMPANY_NAME_EXIST_ERROR);
                        }
                    });

        }

        if (StringUtils.isNotBlank(merchantForm.getCode())) {
            merchantMapper.selectByCode(merchantForm.getCode())
                    .ifPresent(chargeMerchant -> {
                        if (id != null && !chargeMerchant.getId().equals(id)) {
                            throw new ApplicationException(RetStubDetail.COMPANY_CODE_EXIST_ERROR);
                        }
                    });
        }

    }
}
