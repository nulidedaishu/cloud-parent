package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.entity.User;
import com.itany.exception.RequestParameterErrorException;

public interface UserService {

    /**
     * 条件查询用户方法
     */
    PageInfo<User> getUserList(String page,String rows,User user,String userType);

    /**
     * 查询单用户方法
     */
    User selectUserById(String id)  throws RequestParameterErrorException;

    /**
     * 禁用用户状态方法
     */
    void updateUserFlag0(String id) throws RequestParameterErrorException;

    /**
     * 启用用户状态方法
     */
    void updateUserFlag1(String id) throws RequestParameterErrorException ;
}
