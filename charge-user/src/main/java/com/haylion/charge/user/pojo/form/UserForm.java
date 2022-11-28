package com.haylion.charge.user.pojo.form;

import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import com.haylion.charge.user.pojo.vail.Register;
import com.haylion.charge.user.pojo.vail.UserStateUpdate;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liyu
 * date 2022/4/7 14:27
 * description
 */
@Data
public class UserForm {
    /**
     * 员工信息表ID
     */
    @NotNull(message = "id can not be null", groups = {Update.class, Delete.class, UserStateUpdate.class})
    private Integer id;

    /**
     * 姓名
     */
    @NotBlank(message = "name can not be null", groups = {Add.class})
    private String name;

    /**
     * 登录用户名
     */
    @NotBlank(message = "username can not be null", groups = {Add.class})
    private String username;

    /**
     * 手机号
     */
    @NotBlank(message = "mobile can not be null", groups = {Add.class})
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证
     */
    private String card;

    /**
     * 二维码
     */
    @NotBlank(message = "headIconUrl can not be null", groups = {Add.class})
    private String headIconUrl;

    /**
     * 公司ID
     */
    private Integer cId;

    /**
     * 部门ID
     */
    private Integer dId;

    /**
     * 职位ID
     */
    private Integer pId;

    private Integer roleId;

    /**
     * loginPermission
     */
    private Integer loginPermission;
    @NotNull(message = "state can not be null", groups = {UserStateUpdate.class})
    private Integer state;

    /**
     * 登陆密码
     */
    @NotBlank(message = "password can not be null", groups = {Register.class})
    private String password;

    /**
     * 是否修改密码0：否 1：是
     */
    private Integer passwordModified;

    /**
     * 是否开启短信提醒(0:否,1:是)
     */
    private Integer messageState;


    private String remark;


    /**
     * 注册类型
     */
    @NotNull(message = "user type can not be null")
    private Integer userType;

    /**
     * 申请渠道：{1:安卓app,2:IOSAPP,3:微信小程序,4:支付宝小程序}
     */
    private Integer applyChannel;

    /**
     * 商户id
     */
    private Integer merchantId;

}