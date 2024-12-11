package com.itany.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.entity.User;
import com.itany.mapper.MyUserMapper;
import com.itany.service.IMyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class MyServiceImpl implements IMyUserService {


    @Autowired
    private MyUserMapper mapper;



    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageInfo<User> findUserAll(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<User> list = mapper.findUserAll();
        PageInfo<User> info = new PageInfo<User>(list);
        return info;
    }

}
