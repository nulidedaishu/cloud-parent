package com.itany.service;

import com.github.pagehelper.PageInfo;

public interface ITestService {

    public PageInfo<User> findUserAll(Integer page, Integer rows);
}
