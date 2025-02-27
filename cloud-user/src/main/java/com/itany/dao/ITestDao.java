package com.itany.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ITestDao {

    public List<User> selectUserAll();
}
