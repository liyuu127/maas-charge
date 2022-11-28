package com.haylion.charge.user.utils.convert;

import com.haylion.common.entity.entity.ChargeMerchantUser;
import com.haylion.common.entity.entity.ChargeTerminalUser;
import com.haylion.common.entity.entity.UserT;
import com.haylion.charge.user.pojo.form.UserForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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

    @Mappings(
            {
                    @Mapping(source = "id", target = "userId"),
                    @Mapping(target = "status", ignore = true)
            }
    )
    ChargeTerminalUser fromToTerminalUser(UserForm userForm);

    @Mappings(
            {
                    @Mapping(source = "id", target = "userId"),
            }
    )
    ChargeMerchantUser fromToMerchantUser(UserForm userForm);
}
