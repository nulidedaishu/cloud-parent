package com.itany.mapper;


import com.itany.entity.ManagerUser;
import com.itany.entity.ManagerUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer countByExample(ManagerUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer deleteByExample(ManagerUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer insert(ManagerUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer insertSelective(ManagerUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    List<ManagerUser> selectByExample(ManagerUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    ManagerUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer updateByExampleSelective(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer updateByExample(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer updateByPrimaryKeySelective(ManagerUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_manager_user
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    Integer updateByPrimaryKey(ManagerUser record);
}