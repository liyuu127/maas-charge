package com.haylion.charge.user.utils;

/**
 * @author liyu
 * date 2022/4/18 9:18
 * description
 */
public class Permission {

    public static int AGENT_APP_USER = 0x01 << 1;
    public static int AGENT_WEB = 0x01 << 2;
    public static int AGENT_APP_MAINTENANCE = 0x01 << 3;
    private static int flag = 0x00;

    public int add(int permission) {
        flag |= permission;
        return flag;
    }

    public int rest(int permission) {
        flag = permission;
        return flag;
    }

    public int delete(int permission) {
        flag &= ~permission;
        return flag;
    }

    private static boolean hasPermission(int permission) {
        return (flag & permission) != 0;
    }

    public static void main(String[] args) {
        //是否具有app权限
        boolean permission = hasPermission(AGENT_APP_USER);
    }
}
