package com.haylion.charge.user.pojo.vo;

import com.haylion.common.entity.entity.ChargeMerchantUser;
import com.haylion.common.entity.entity.ChargeTerminalUser;
import com.haylion.common.entity.entity.RoleT;
import com.haylion.common.entity.entity.UserT;
import lombok.Data;

import java.util.List;

/**
 * @author liyu
 * date 2022/11/28 16:40
 * description
 */
@Data
public class UserInfoVo {
    private UserT userT;
    private List<RoleT> roleT;
    private List<String> authorities;
    private ChargeTerminalUser chargeTerminalUser;
    private ChargeMerchantUser chargeMerchantUser;
}
