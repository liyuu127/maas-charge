package com.haylion.charge.user.utils.convert;

import com.haylion.common.entity.entity.UserT;
import com.haylion.charge.user.pojo.form.UserForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyu
 * date 2021/1/13 15:01
 * description
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserT formToEntity(UserForm userForm);
}
