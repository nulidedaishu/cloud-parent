package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.entity.ServerCompany;
import com.itany.exception.ServiceException;

public interface ServerCompanyService {
    PageInfo<ServerCompany> selectServerLife(String page, String rows, ServerCompany serverCompany, String level)throws ServiceException;
}
