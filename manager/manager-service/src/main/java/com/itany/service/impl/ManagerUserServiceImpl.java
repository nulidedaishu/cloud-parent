package com.itany.service.impl;


import com.itany.constant.ResponseCodeConstant;
import com.itany.entity.ManagerUser;
import com.itany.entity.ManagerUserExample;
import com.itany.exception.*;
import com.itany.mapper.ManagerUserMapper;
import com.itany.service.ManagerUserService;
import com.itany.utils.ParameterUtil;
import com.itany.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ManagerUserServiceImpl implements ManagerUserService {

    @Autowired
    private ManagerUserMapper managerUserMapper;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

    @Override
    public ManagerUser login(String userName, String password) throws RequestParameterErrorException, ManagerUserNotExistException, PasswordErrorException, ServiceException {

        if (Stream.of(userName, password).anyMatch(ParameterUtil::isNull)) {
            throw new RequestParameterErrorException("请求参数有误");
        }

        System.out.println(PasswordUtil.encryptPassword(password));
        ManagerUserExample example = new ManagerUserExample();
        example.or()
                .andUsernameEqualTo(userName);
        List<ManagerUser> managerUsers = managerUserMapper.selectByExample(example);

        if (managerUsers.isEmpty()) {
            throw new ManagerUserNotExistException(ResponseCodeConstant.RESPONSE_MESSAGE_USERNAME_ERROR);
        }

        ManagerUser managerUser = managerUsers.get(0);

        boolean isMatch = PasswordUtil.verifyPassword(password, managerUser.getPassword());
        if (!isMatch) {
            throw new PasswordErrorException(ResponseCodeConstant.RESPONSE_MESSAGE_PASSWORD_ERROR);
        }

        return managerUser;
    }

    @Override
    public void modifyPassword(Integer id, String password1, String password2) throws RequestParameterErrorException, PasswordConfirmationException, ServiceException {

        if (Stream.of(password1, password2).anyMatch(ParameterUtil::isNull)) {
            throw new RequestParameterErrorException("请求参数有误");
        }

        if (!password1.equals(password2)){
            throw new PasswordConfirmationException("两次密码不一致");
        }

        ManagerUser managerUser = new ManagerUser();
        managerUser.setId(id);
        managerUser.setPassword(PasswordUtil.encryptPassword(password1));
        managerUserMapper.updateByPrimaryKeySelective(managerUser);

    }
}
