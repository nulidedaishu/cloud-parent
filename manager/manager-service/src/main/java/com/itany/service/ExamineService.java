package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.entity.Examine;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServiceException;

public interface ExamineService {

    /**
     * 条件查询审核记录方法
     */
    PageInfo<Examine> selectExamine(String page, String rows, Examine examine) throws ServiceException;

    /**
     * 查询单审核记录方法
     */
    Examine selectExamineById(Examine examine) throws RequestParameterErrorException;

    /**
     * 审核方法
     */
    void updateExamine(Examine examine) throws RequestParameterErrorException,ServiceException;
}
