package com.itany.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.Examine;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServiceException;
import com.itany.mapper.ExamineMapper;
import com.itany.service.ExamineService;
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

    @Override
    public PageInfo<Examine> selectExamine(String page, String rows, Examine examine) throws ServiceException {
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
    public void updateExamine(Examine examine) throws RequestParameterErrorException,ServiceException {
        if (examine.getId() == null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        if (examine.getFlag() == null) {
            throw new RequestParameterErrorException("审核状态不能为空");
        }
        if(!ParameterUtil.isValidFlag(examine.getFlag())) {
            throw new RequestParameterErrorException("非法的审核状态码");
        }
        Examine existing = examineMapper.selectByPrimaryKey(examine.getId());
        if (existing == null) {
            throw new RequestParameterErrorException("审核记录不存在");
        }
        if(!Objects.equals(existing.getFlag(), DictConstant.EXAMINE_NO)){
            throw new RequestParameterErrorException("已审核");
        }
        int affected = examineMapper.updateByPrimaryKeySelective(examine);
        if (affected == 0) {
            throw new ServiceException("审核状态更新失败");
        }

    }
}
