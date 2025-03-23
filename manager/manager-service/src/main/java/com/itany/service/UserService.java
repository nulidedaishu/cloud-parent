package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.entity.User;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServiceException;
import com.itany.exception.UserCompanyExistException;

public interface UserService {

    /**
     * 条件查询用户方法
     */
    PageInfo<User> getUserList(String page,String rows,User user,String userType) throws RequestParameterErrorException, ServiceException;
    /**
     * 查询单用户方法
     */
    User selectUserById(User user)  throws RequestParameterErrorException;
    /**
     * 禁用用户状态方法
     */
    void disableUser(User user) throws RequestParameterErrorException;
    /**
     * 启用用户状态方法
     */
    void enableUser(User user) throws RequestParameterErrorException;
    /**
     * 添加用户公司
     */
    void addUserCompany(User user) throws RequestParameterErrorException, UserCompanyExistException;
}
