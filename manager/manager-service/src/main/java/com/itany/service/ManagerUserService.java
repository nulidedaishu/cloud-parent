package com.itany.service;

import com.itany.entity.ManagerUser;
import com.itany.exception.*;

public interface ManagerUserService {
    /**
     * 用户登录方法
     */
    ManagerUser login(String username, String password) throws RequestParameterErrorException, ManagerUserNotExistException, PasswordErrorException, ServiceException;

    /**
     * 用户修改密码方法
     */
    void modifyPassword(Integer id, String password1, String password2) throws RequestParameterErrorException, PasswordConfirmationException, ServiceException;

}
