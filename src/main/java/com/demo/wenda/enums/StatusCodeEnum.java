package com.demo.wenda.enums;

import lombok.Getter;

@Getter
public enum StatusCodeEnum {
    OK(200,"成功"),
    SUCCESS(0,"请求成功"),
    error(900,"服务器异常"),
    NOT_LOGIN(999,"未登录"),

    COLLECTION_FAIL(111,"收藏失败"),
    EMAIL_EXIST(301,"该邮箱已被注册"),
    PHONE_EXIST(302,"该手机号已被注册")
    ;


    private Integer code;
    private String massage;


    StatusCodeEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }
}
