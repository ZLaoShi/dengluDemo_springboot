package com.example.utils;

public class Const {
    public static final String JWT_BLACK_LIST = "jwt:blacklist:";//黑名单
    public static final String VERIFY_EMAIL_LIMIT = "verify:email:limit:";
    public static final String VERIFY_EMAIL_DATA = "verify:email:data:";
    public static final int ORDER_LIMIT = -102;//限流器优先级
    public static final int ORDER_CORS = -102;//跨域过滤器优先级

    public static final String FLOW_LIMIT_COUNTER = "flow:counter"; //计数器
    public static final String FLOW_LIMIT_BLOCK = "flow:block"; //封禁

}
