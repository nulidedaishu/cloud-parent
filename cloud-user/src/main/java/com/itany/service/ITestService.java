package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.entity.User;

public interface ITestService {

    public PageInfo<User> findUserAll(Integer page, Integer rows);
}
