package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.entity.Examine;
import com.itany.entity.ServerCompany;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServerCompanyExistException;
import com.itany.exception.ServiceException;

public interface ServerCompanyService {

    /**
     * 条件查询服务商方法
     */
    PageInfo<ServerCompany> selectServerLife(String page, String rows, ServerCompany serverCompany, String level) throws ServiceException;

    /**
     * 查询单服务商方法
     */
    ServerCompany selectServerCompanyById(String id) throws RequestParameterErrorException;

    /**
     * 修改服务商方法
     */
    void modifyServerCompany(ServerCompany serverCompany) throws RequestParameterErrorException, ServerCompanyExistException;

    /**
     * 禁用服务商状态方法
     */
    void updateServerCompanyFlag0(String id) throws RequestParameterErrorException;

    /**
     * 启用服务商状态方法
     */
    void updateServerCompanyFlag1(String id) throws RequestParameterErrorException;

    /**
     * 添加服务商方法
     */
    void addServerCompany(Examine examine) throws RequestParameterErrorException, ServiceException, ServerCompanyExistException;
}
