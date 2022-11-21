package com.haylion.charge.user.utils.convert;

import com.haylion.common.entity.entity.DepartmentT;
import com.haylion.charge.user.pojo.form.DepartmentForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyu
 * date 2021/1/13 15:01
 * description
 */
@Mapper
public interface DepartmentConvert {
    DepartmentConvert INSTANCE = Mappers.getMapper(DepartmentConvert.class);

    DepartmentT formToEntity(DepartmentForm departmentForm);
}
