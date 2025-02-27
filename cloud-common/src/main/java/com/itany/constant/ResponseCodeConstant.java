package com.itany.constant;

public interface ResponseCodeConstant {

    /**
     * 业务逻辑状态码:成功
     */
    String RESPONSE_CODE_SUCCESS = "2001";

    /**
     * 业务逻辑状态码:失败
     */
    String RESPONSE_CODE_FAIL = "2002";

    /**
     * 业务逻辑状态码:请求参数有误
     */
    String RESPONSE_CODE_REQUEST_PARAMETER_ERROR = "2003";

    /**
     * 业务逻辑信息：用户名错误
     */
    String RESPONSE_MESSAGE_USERNAME_ERROR = "该用户不存在";

    /**
     * 业务逻辑信息:密码错误
     */
    String RESPONSE_MESSAGE_PASSWORD_ERROR = "密码不正确";

}
