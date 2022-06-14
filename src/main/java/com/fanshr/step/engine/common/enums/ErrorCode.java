package com.fanshr.step.engine.common.enums;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/16 14:11
 * @date : Modified at 2021/11/16 14:11
 */

public enum ErrorCode {

    /**
     * -1***，身份及权限类型异常
     * -2***，
     * -3***，
     * -4***，web层参数校验异常
     * -5***，网络链接类型异常
     * -6***，数据库操作异常
     * -7***，
     * -8***,
     * -9***,
     *
     * 1000-1999 参数错误
     * 2000-2999 用户错误
     * 3000-3999 接口异常
     * 4000-4999 客户端问题
     * 5000-5999 服务端问题
     *
     */
   

    SUCCESS("1","操作成功"),
    ERROR("-1","未知错误"),
    /*参数错误 1001-1999*/
    PARAM_IS_INVALID("1001","参数无效"),
    PARAM_IS_BLANK("1002","参数为空"),
    PARAM_IS_EMPTY("-4001", "参数存在空字符串"),
    PARAM_TYPE_BIND_ERROR("1003","参数类型错误"),
    PARAM_NOT_COMPLETE("1004","参数缺失异常"),
    PARAM_FORMAT_ERROR("1005","参数格式异常"),
    PARAM_VALIDATION_ERROR("1005","参数校验异常"),
    DUPLICATE_KEY_CODE("2010","数据主键重复"),
    PATH_NOT_EXIST("404", "资源路径不存在"),
    UNSUPPORTED_METHOD("1006","请求类型不支持"),
    REQUEST_ERROR("1007", "入参异常,请检查入参后再次调用"),
    PAGE_NUM_IS_NULL("1008","页码不能为空"),
    PAGE_SIZE_IS_NULL("1009","页数不能为空"),
    ID_IS_NULL("1010","ID不能为空"),
    SEARCH_IS_NULL("1011","搜索条件不能为空"),
    DELETE_REFUSED("1009","不允许删除"),
    /*用户错误 2001-2999*/
    USER_NOT_LOGGED_IN("2001","用户未登录，访问的路径需要验证，请登录"),
    USER_LOGIN_ERROR("2002","账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN("2003","账号已被禁用"),
    USER_NOT_EXIST("2004","用户不存在"),
    USER_HAS_EXISTED("2005","用户已存在"),

    INNER_ERROR("-6000", "数据库操作失败"),
    UNSPECIFIED("5001", "网络异常，请稍后再试"),
    NO_SERVICE("5002", "网络异常, 服务器熔断");

    private String code;
    private String msg;


    private ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static ErrorCode codeOf(String index) {
        for (ErrorCode state : values()) {
            if (state.code().equals(index)) {
                return state;
            }
        }
        return null;
    }
}
