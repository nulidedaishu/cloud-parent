package com.itany.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.User;
import com.itany.exception.RequestParameterErrorException;
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
    public PageInfo<User> getUserList(String page, String rows, User user, String userType) {
        System.out.println("用户" + user);
        Integer userType2 = null;
        if (userType != null && !userType.trim().isEmpty()) {
            try {
                userType2 = Integer.valueOf(userType);
            } catch (NumberFormatException e) {
                System.out.println("无效的userType值: " + userType);
            }
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<User> users = userMapper.selectUsersWithCompany(user, userType2);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public User selectUserById(String id) throws RequestParameterErrorException {
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        User user = new User();
        user.setId(Integer.valueOf(id));

        return userMapper.selectUsersWithCompany(user, null).get(0);
    }


    @Override
    public void updateUserFlag0(String id) throws RequestParameterErrorException {
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        userMapper.updateUserFlag0(Integer.parseInt(id));
    }

    @Override
    public void updateUserFlag1(String id) throws RequestParameterErrorException {
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        userMapper.updateUserFlag1(Integer.parseInt(id));
    }
}
