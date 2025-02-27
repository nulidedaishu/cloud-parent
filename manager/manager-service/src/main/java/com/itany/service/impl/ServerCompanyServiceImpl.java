package com.itany.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.ServerCompany;
import com.itany.exception.ServiceException;
import com.itany.utils.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itany.mapper.ServerCompanyMapper;
import com.itany.service.ServerCompanyService;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ServerCompanyServiceImpl implements ServerCompanyService {

    @Autowired
    private ServerCompanyMapper serverCompanyMapper;

    @Override
    public PageInfo<ServerCompany> selectServerLife(String page, String rows, ServerCompany serverCompany, String level) throws ServiceException {
        Date currentDate = new Date();
        System.out.println("用户" + serverCompany + "等级" + level + "时间" + currentDate);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<ServerCompany> companies = serverCompanyMapper.selectServerCompanyWithUsersAndMembers(serverCompany.getName(), serverCompany.getPhone(), serverCompany.getFlag(), DictConstant.SERVER_LIFE, level, currentDate);
        return new PageInfo<>(companies);
    }
}
