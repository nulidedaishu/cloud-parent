package com.itany.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.Examine;
import com.itany.entity.ServerCompany;
import com.itany.entity.ServerCompanyExample;
import com.itany.entity.User;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServerCompanyExistException;
import com.itany.exception.ServiceException;
import com.itany.exception.UserCompanyExistException;
import com.itany.mapper.ServerCompanyMapper;
import com.itany.service.ServerCompanyService;
import com.itany.service.UserService;
import com.itany.utils.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ServerCompanyServiceImpl implements ServerCompanyService {

    @Autowired
    private ServerCompanyMapper serverCompanyMapper;
    @Autowired
    private UserService userService;

    @Override
    public PageInfo<ServerCompany> selectServerLife(String page, String rows, ServerCompany serverCompany, String level) {
        Date currentDate = new Date();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<ServerCompany> companies = serverCompanyMapper.selectServerCompanyWithUsersAndMembers(null, serverCompany.getName(), serverCompany.getPhone(), serverCompany.getFlag(), serverCompany.getType(), level, currentDate);
        return new PageInfo<>(companies);
    }

    @Override
    public ServerCompany selectServerCompanyById(ServerCompany serverCompany) throws RequestParameterErrorException {
        if (serverCompany.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        Date currentDate = new Date();
        return serverCompanyMapper.selectServerCompanyWithUsersAndMembers(serverCompany.getId(), null, null, null, null, null, currentDate).get(0);
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
        System.out.println("=============================");
        System.out.println(serverCompany);
        serverCompanyMapper.updateByPrimaryKeySelective(serverCompany);
    }


    @Override
    public void disableServerCompany(ServerCompany serverCompany) throws RequestParameterErrorException {
        if (serverCompany.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        serverCompany.setFlag(DictConstant.COMPANY_DISABLED);
        serverCompanyMapper.updateServerCompanyFlag(serverCompany);
    }

    @Override
    public void enableServerCompany(ServerCompany serverCompany) throws RequestParameterErrorException {
        if (serverCompany.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        serverCompany.setFlag(DictConstant.COMPANY_ENABLED);
        serverCompanyMapper.updateServerCompanyFlag(serverCompany);
    }

    @Override
    public void addServerCompany(Examine examine) throws RequestParameterErrorException, ServiceException, ServerCompanyExistException, UserCompanyExistException {
        if (examine == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        ServerCompany serverCompany = convertExamineToServerCompany(examine);
        ServerCompanyExample example = new ServerCompanyExample();
        example.createCriteria().andNameEqualTo(serverCompany.getName());
        List<ServerCompany> companies = serverCompanyMapper.selectByExample(example);
        if (companies != null && !companies.isEmpty()) {
            throw new ServerCompanyExistException("服务商名称重复");
        }
        serverCompany.setJoindate(new Date());
        serverCompany.setFlag(DictConstant.COMPANY_ENABLED);
        int affected = serverCompanyMapper.insertSelective(serverCompany);
        if (affected == 0) {
            throw new ServiceException("添加服务商失败");
        }
        User user = new User();
        if (examine.getUserid() == null || serverCompany.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        user.setId(examine.getUserid());
        user.setCompanyid(serverCompany.getId());
        userService.addUserCompany(user);
    }

    private ServerCompany convertExamineToServerCompany(Examine examine) throws RequestParameterErrorException {
        if (examine == null) {
            return null;
        }
        ServerCompany serverCompany = new ServerCompany();

        if (examine.getName() != null && !examine.getName().trim().isEmpty()) {
            serverCompany.setName(examine.getName());
        } else {
            throw new RequestParameterErrorException("名称不能为空");
        }

        if (examine.getInfo() != null && !examine.getInfo().trim().isEmpty()) {
            serverCompany.setInfo(examine.getInfo());
        }

        if (examine.getAddress() != null && !examine.getAddress().trim().isEmpty()) {
            serverCompany.setAddress(examine.getAddress());
        }

        if (examine.getGps() != null && !examine.getGps().trim().isEmpty()) {
            serverCompany.setGps(examine.getGps());
        }

        if (examine.getScale() != null && !examine.getScale().trim().isEmpty()) {
            serverCompany.setScale(examine.getScale());
        }

        if (examine.getCommpanycreatedate() != null) {
            serverCompany.setCreatedate(examine.getCommpanycreatedate());
        }

        if (examine.getTypeid() != null) {
            serverCompany.setType(examine.getTypeid());
        } else {
            throw new RequestParameterErrorException("种类不能为空");
        }

        if (examine.getLinkman() != null && !examine.getLinkman().trim().isEmpty()) {
            serverCompany.setLinkman(examine.getLinkman());
        }

        if (examine.getPhone() != null && !examine.getPhone().trim().isEmpty()) {
            serverCompany.setPhone(examine.getPhone());
        }

        return serverCompany;
    }

}
