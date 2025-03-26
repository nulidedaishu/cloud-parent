package com.itany.controllers;

import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.ServerCompany;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServiceException;
import com.itany.service.ServerCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/serverCompany")
public class ServerCompanyListController {

    @Autowired
    private ServerCompanyService serverCompanyService;

    @RequestMapping("/showLife")
    public String showLife() {
        return "server_life";
    }

    @RequestMapping("/showCommerce")
    public String showCommerce() {
        return "server_commerce";
    }

    @RequestMapping("/selectAllLife")
    @ResponseBody
    public Map<String, Object> selectServerLife(
            @RequestParam(defaultValue = DictConstant.COMPANY_LIFE_DEFAULT_NO) String page,
            @RequestParam(defaultValue = DictConstant.COMPANY_LIFE_DEFAULT_PAGE) String rows,
            @ModelAttribute ServerCompany serverCompany,
            @RequestParam(required = false) String level) {
        serverCompany.setType(DictConstant.SERVER_LIFE);
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

    @RequestMapping("/selectAllCommerce")
    @ResponseBody
    public Map<String, Object> selectServerCommerce(
            @RequestParam(defaultValue = DictConstant.COMPANY_COMMERCE_DEFAULT_NO) String page,
            @RequestParam(defaultValue = DictConstant.COMPANY_COMMERCE_DEFAULT_PAGE) String rows,
            @ModelAttribute ServerCompany serverCompany,
            @RequestParam(required = false) String level) {
        serverCompany.setType(DictConstant.SERVER_COMMERCE);
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

    @RequestMapping("/showDetail")
    @ResponseBody
    public Map<String, Object> selectServerCompanyById(@ModelAttribute ServerCompany serverCompany) {
        Map<String, Object> result = new HashMap<>();
        try {
            serverCompany = serverCompanyService.selectServerCompanyById(serverCompany);
            result.put("serverCompany", serverCompany);
            result.put("success", true);
            result.put("message", "查询成功");
        } catch (RequestParameterErrorException e) {
            result.put("success", false);
            result.put("message", "查询失败，" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("服务器内部异常", false);
        }
        return result;
    }

    @RequestMapping("/modifyServerCompany")
    @ResponseBody
    public Map<String, Object> modifyServerCompany(@ModelAttribute ServerCompany serverCompany) {
        Map<String, Object> result = new HashMap<>();
        try {
            serverCompanyService.modifyServerCompany(serverCompany);
            result.put("success", true);
            result.put("message", "修改成功");
        } catch (RequestParameterErrorException e) {
            result.put("success", false);
            result.put("message", "修改失败，" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("服务器内部异常", false);
        }
        return result;
    }

    @RequestMapping("/disableServerCompany")
    @ResponseBody
    public Map<String, Object> disableServerCompany(@ModelAttribute ServerCompany serverCompany) {
        Map<String, Object> result = new HashMap<>();
        try {
            serverCompanyService.disableServerCompany(serverCompany);
            result.put("success", true);
            result.put("message", "修改成功");
        } catch (RequestParameterErrorException e) {
            result.put("success", false);
            result.put("message", "修改失败，" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("服务器内部异常", false);
        }
        return result;
    }

    @RequestMapping("/enableServerCompany")
    @ResponseBody
    public Map<String, Object> enableServerCompany(@ModelAttribute ServerCompany serverCompany) {
        Map<String, Object> result = new HashMap<>();
        try {
            serverCompanyService.enableServerCompany(serverCompany);
            result.put("success", true);
            result.put("message", "修改成功");
        } catch (RequestParameterErrorException e) {
            result.put("success", false);
            result.put("message", "修改失败，" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("服务器内部异常", false);
        }
        return result;
    }


}
