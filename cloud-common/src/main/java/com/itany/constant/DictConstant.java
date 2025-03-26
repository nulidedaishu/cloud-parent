package com.itany.constant;

public interface DictConstant {
    /**
     * 用户分页
     */
    String USER_DEFAULT_NO = "1";
    String USER_DEFAULT_PAGE = "10";
    /**
     * 生活服务商分页
     */
    String COMPANY_LIFE_DEFAULT_NO = "1";
    String COMPANY_LIFE_DEFAULT_PAGE = "10";
    /**
     * 商务服务商分页
     */
    String COMPANY_COMMERCE_DEFAULT_NO = "1";
    String COMPANY_COMMERCE_DEFAULT_PAGE = "10";
    /**
     * 服务分页
     */
    String SERVER_INFO_DEFAULT_NO = "1";
    String SERVER_INFO_DEFAULT_PAGE = "10";
    /**
     * 服务商审核分页
     */
    String EXAMINE_COMPANY_DEFAULT_NO = "1";
    String EXAMINE_COMPANY_DEFAULT_PAGE = "10";
    /**
     * 服务审核分页
     */
    String EXAMINE_SERVER_DEFAULT_NO = "1";
    String EXAMINE_SERVER_DEFAULT_PAGE = "10";


    /**
     * 用户启用
     */
    Integer USER_ENABLED=1;
    /**
     * 用户禁用
     */
    Integer USER_DISABLED=0;
    /**
     * 服务商启用
     */
    Integer COMPANY_ENABLED=1;
    /**
     * 服务商禁用
     */
    Integer COMPANY_DISABLED=0;
    /**
     * 服务上线
     */
    Integer SERVER_ENABLED=1;
    /**
     * 服务下线
     */
    Integer SERVER_DISABLED=0;


    /**
     * 生活服务商种类
     */
    Integer SERVER_LIFE = 1;
    /**
     * 商务服务商种类
     */
    Integer SERVER_COMMERCE = 2;
    /**
     * 服务商审核种类
     */
    Integer COMPANY_EXAMINE = 1;
    /**
     * 服务审核种类
     */
    Integer SERVER_EXAMINE = 2;

    /**
     * 审核成功
     */
    int EXAMINE_SUCCESS=1;
    /**
     * 未审核
     */
    Integer EXAMINE_NO=0;
    /**
     * 审核失败
     */
    int EXAMINE_FAIL=-1;
}
