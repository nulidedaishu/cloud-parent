package com.itany.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.User;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServiceException;
import com.itany.exception.UserCompanyExistException;
import com.itany.mapper.UserMapper;
import com.itany.service.UserService;
import com.itany.utils.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> getUserList(String page, String rows, User user, String userType) throws RequestParameterErrorException, ServiceException {
        if (user.getId() != null) {
            throw new ServiceException("id应为空");
        }
        Integer userType2 = null;
        if (!ParameterUtil.isNull(userType)) {
            try {
                userType2 = Integer.valueOf(userType);
            } catch (NumberFormatException e) {
                throw new RequestParameterErrorException("用户种类有误");
            }
            if (!userType2.equals(DictConstant.SERVER_LIFE) && !userType2.equals(DictConstant.SERVER_COMMERCE)) {
                throw new RequestParameterErrorException("用户种类有误");
            }
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<User> users = userMapper.selectUsersWithCompany(user, userType2);
        return new PageInfo<>(users);
    }

    @Override
    public User selectUserById(User user) throws RequestParameterErrorException {
        if (user.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        return userMapper.selectUsersWithCompany(user, null).get(0);
    }


    @Override
    public void disableUser(User user) throws RequestParameterErrorException {
        if (user.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        user.setFlag(DictConstant.USER_DISABLED);
        userMapper.updateUserFlag(user);
    }

    @Override
    public void enableUser(User user) throws RequestParameterErrorException {
        if (user.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        user.setFlag(DictConstant.USER_ENABLED);
        userMapper.updateUserFlag(user);
    }

    @Override
    public void addUserCompany(User user) throws RequestParameterErrorException, UserCompanyExistException {
        if (user.getId() == null || user.getCompanyid() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        User user1= userMapper.selectByPrimaryKey(user.getId());
        if (user1.getCompanyid()!=null){
            throw new UserCompanyExistException("用户公司已存在");
        }
        User user2 = new User();
        user2.setId(user.getId());
        user2.setCompanyid(user.getCompanyid());
        userMapper.updateByPrimaryKeySelective(user2);
    }
}
