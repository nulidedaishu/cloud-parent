package com.itany.controllers;

import com.itany.constant.DictConstant;
import com.itany.entity.ServerCompany;
import com.itany.exception.ServiceException;
import com.itany.service.ServerCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/serverLife")
public class ServerLifeController {

    @Autowired
    private ServerCompanyService serverCompanyService;

    @RequestMapping("/show")
    public String show() {
        return "server_life";
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String, Object> selectServerLife(
            @RequestParam(defaultValue = DictConstant.SERVERCOMPANYLIFE_DEFAULT_NO) String page,
            @RequestParam(defaultValue = DictConstant.SERVERCOMPANYLIFE_DEFAULT_PAGE) String rows,
            @ModelAttribute ServerCompany serverCompany,
            @RequestParam(required = false) String level) {
        System.out.println("用户" + serverCompany + "等级" + level);
        Map<String, Object> result = new HashMap<>();
        try {
            PageInfo<ServerCompany> pageInfo = serverCompanyService.selectServerLife(page, rows, serverCompany, level);
            result.put("rows", pageInfo.getList());
            result.put("total", pageInfo.getTotal());
        } catch (ServiceException e) {
            result.put("success", false);
            result.put("message", "查询失败，" + e.getMessage());
        }
        return result;
    }
}
