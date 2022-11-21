package com.haylion.common.core.model;

import lombok.Data;

@Data
public class Condition {

    private String key;
    /**
     * new Condition("account","like","%" + account + "%") new Condition("account","!=","account")
     */
    private String opt = "=";
    private Object value;

    public Condition(String key, String opt, Object value) {
        this.key = key;
        this.opt = opt;
        this.value = value;
    }

    public Condition(String key, Object value) {
        this(key, "=", value);
    }
}
