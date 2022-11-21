package com.haylion.charge.user.utils.convert;

import com.haylion.common.entity.entity.CompanyT;
import com.haylion.charge.user.pojo.form.CompanyForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyu
 * date 2021/1/13 15:01
 * description
 */
@Mapper
public interface CompanyConvert {
    CompanyConvert INSTANCE = Mappers.getMapper(CompanyConvert.class);

    CompanyT formToEntity(CompanyForm companyForm);
}
