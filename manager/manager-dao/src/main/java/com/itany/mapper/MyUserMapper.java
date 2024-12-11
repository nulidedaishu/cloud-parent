package com.itany.mapper;


import com.itany.entity.User;
import java.util.List;

public interface MyUserMapper {

    public List<User> findUserAll();
}