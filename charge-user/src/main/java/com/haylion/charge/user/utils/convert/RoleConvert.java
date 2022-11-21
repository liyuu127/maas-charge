package com.haylion.charge.user.utils.convert;

import com.haylion.common.entity.entity.RoleT;
import com.haylion.charge.user.pojo.form.RoleForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyu
 * date 2021/1/13 15:01
 * description
 */
@Mapper
public interface RoleConvert {
    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);

    RoleT formToEntity(RoleForm roleForm);
}
