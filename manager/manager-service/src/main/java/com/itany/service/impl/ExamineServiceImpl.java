package com.itany.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.Examine;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServerCompanyExistException;
import com.itany.exception.ServiceException;
import com.itany.exception.UserCompanyExistException;
import com.itany.mapper.ExamineMapper;
import com.itany.service.ExamineService;
import com.itany.service.ServerCompanyService;
import com.itany.utils.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ExamineServiceImpl implements ExamineService {

    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ServerCompanyService serverCompanyService;

    @Override
    public PageInfo<Examine> selectExamine(String page, String rows, Examine examine) throws ServiceException {
        if (examine.getId() != null) {
            throw new ServiceException("id应为空");
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Examine> examines = examineMapper.selectExamineWithUser(examine);
        return new PageInfo<>(examines);
    }

    @Override
    public Examine selectExamineById(Examine examine) throws RequestParameterErrorException {
        if (examine.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        return examineMapper.selectExamineWithUser(examine).get(0);
    }

    @Override
    public void updateExamine(Examine examine) throws RequestParameterErrorException, ServiceException, ServerCompanyExistException, UserCompanyExistException {
        if (examine.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        if (examine.getFlag() == null) {
            throw new RequestParameterErrorException("审核状态不能为空");
        }
        switch (examine.getFlag()) {
            case DictConstant.EXAMINE_SUCCESS:

                Examine examine2 = examineMapper.selectByPrimaryKey(examine.getId());
                if (examine2 == null) {
                    throw new RequestParameterErrorException("审核记录不存在");
                }
                if (!Objects.equals(examine2.getFlag(), DictConstant.EXAMINE_NO)) {
                    throw new RequestParameterErrorException("已审核");
                }
                examine2.setFlag(examine.getFlag());
                examine2.setExamineInfo(examine.getExamineInfo());
                int affected = examineMapper.updateByPrimaryKeySelective(examine2);
                if (affected == 0) {
                    throw new ServiceException("审核状态更新失败");
                }
                if (Objects.equals(examine2.getExaminetype(), DictConstant.COMPANY_EXAMINE)) {
                    serverCompanyService.addServerCompany(examine2);
//              } else if (Objects.equals(examine.getExaminetype(), DictConstant.SERVER_EXAMINE)){
//              serverInfoService.addServerInfo(examine);
                } else {
                    throw new RequestParameterErrorException("审核种类有误");
                }
                break;

            case DictConstant.EXAMINE_FAIL:
                System.out.println("审核不成功");
                break;

            default:
                throw new RequestParameterErrorException("非法的审核状态码");
        }

    }
}
