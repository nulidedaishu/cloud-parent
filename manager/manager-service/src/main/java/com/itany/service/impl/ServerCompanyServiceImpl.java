package com.itany.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.ServerCompany;
import com.itany.entity.ServerCompanyExample;
import com.itany.entity.User;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServerCompanyExistException;
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
        List<ServerCompany> companies = serverCompanyMapper.selectServerCompanyWithUsersAndMembers(null, serverCompany.getName(), serverCompany.getPhone(), serverCompany.getFlag(), serverCompany.getType(), level, currentDate);
        return new PageInfo<>(companies);
    }

    @Override
    public ServerCompany selectServerCompanyById(String id) throws RequestParameterErrorException {
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        Date currentDate = new Date();
        return serverCompanyMapper.selectServerCompanyWithUsersAndMembers(Integer.parseInt(id), null, null, null, null, null, currentDate).get(0);
    }

    @Override
    public void modifyServerCompany(ServerCompany serverCompany) throws RequestParameterErrorException, ServerCompanyExistException {
        if (serverCompany.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }

        ServerCompanyExample example = new ServerCompanyExample();
        ServerCompanyExample.Criteria criteriaName = example.createCriteria();
        criteriaName.andNameEqualTo(serverCompany.getName())
                .andIdNotEqualTo(serverCompany.getId());
        ServerCompanyExample.Criteria criteriaPhone = example.createCriteria();
        criteriaPhone.andPhoneEqualTo(serverCompany.getPhone())
                .andIdNotEqualTo(serverCompany.getId());
        example.or(criteriaPhone);

        long count = serverCompanyMapper.countByExample(example);
        if (count > 0) {
            throw new ServerCompanyExistException("公司名称或联系电话已被其他服务商使用");
        }

        serverCompanyMapper.updateByPrimaryKeySelective(serverCompany);
    }


    @Override
    public void updateServerCompanyFlag0(String id) throws RequestParameterErrorException {
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        serverCompanyMapper.updateServerCompanyFlag0(Integer.parseInt(id));
    }

    @Override
    public void updateServerCompanyFlag1(String id) throws RequestParameterErrorException {
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        serverCompanyMapper.updateServerCompanyFlag1(Integer.parseInt(id));
    }
}
