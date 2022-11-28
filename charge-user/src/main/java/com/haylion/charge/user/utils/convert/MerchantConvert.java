package com.haylion.charge.user.utils.convert;

import com.haylion.charge.user.pojo.form.MerchantForm;
import com.haylion.common.entity.entity.ChargeMerchant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyu
 * date 2021/1/13 15:01
 * description
 */
@Mapper
public interface MerchantConvert {
    MerchantConvert INSTANCE = Mappers.getMapper(MerchantConvert.class);

    ChargeMerchant formToEntity(MerchantForm merchantForm);
}
