package com.itany.constant;

public interface DictConstant {
    /**
     * 用户
     */
    String USER_DEFAULT_NO = "1";
    String USER_DEFAULT_PAGE = "10";
    /**
     * 生活服务商
     */
    String SERVERCOMPANYLIFE_DEFAULT_NO = "1";
    String SERVERCOMPANYLIFE_DEFAULT_PAGE = "10";
    /**
     * 商务服务商
     */
    String SERVERCOMPANYCOMMERCE_DEFAULT_NO = "1";
    String SERVERCOMPANYCOMMERCE_DEFAULT_PAGE = "10";
    /**
     * 服务商审核
     */
    String COMPANYEXAMINE_DEFAULT_NO = "1";
    String COMPANYEXAMINE_DEFAULT_PAGE = "10";
    /**
     * 服务审核
     */
    String SERVEREXAMINE_DEFAULT_NO = "1";
    String SERVEREXAMINE_DEFAULT_PAGE = "10";


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
    Integer EXAMINE_SUCCESS=1;
    /**
     * 未审核
     */
    Integer EXAMINE_NO=0;
    /**
     * 审核失败
     */
    Integer EXAMINE_FAIL=-1;
}
