package com.itany.controllers;


import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.Examine;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServiceException;
import com.itany.exception.UserCompanyExistException;
import com.itany.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/examine")
public class ExamineListController {

    @Autowired
    private ExamineService examineService;

    @RequestMapping("/showCompany")
    public String showCompany() {
        return "commpany_examinelist";
    }

//    @RequestMapping("/showServer")
//    public String showServer() {
//        return "server_examinelist";
//    }

    @RequestMapping("/selectAllCompany")
    @ResponseBody
    public Map<String, Object> selectAllCompany(
            @RequestParam(defaultValue = DictConstant.EXAMINE_COMPANY_DEFAULT_NO) String page,
            @RequestParam(defaultValue = DictConstant.EXAMINE_COMPANY_DEFAULT_PAGE) String rows,
            @ModelAttribute Examine examine) {
        examine.setExaminetype(DictConstant.COMPANY_EXAMINE);
        Map<String, Object> result = new HashMap<>();
        try {
            PageInfo<Examine> pageInfo = examineService.selectExamine(page, rows, examine);
            result.put("rows", pageInfo.getList());
            result.put("total", pageInfo.getTotal());
        } catch (ServiceException e) {
            result.put("success", false);
            result.put("message", "查询失败，" + e.getMessage());
        }
        return result;
    }

    @RequestMapping("/selectAllServer")
    @ResponseBody
    public Map<String, Object> selectAllServer(
            @RequestParam(defaultValue = DictConstant.EXAMINE_SERVER_DEFAULT_NO) String page,
            @RequestParam(defaultValue = DictConstant.EXAMINE_SERVER_DEFAULT_PAGE) String rows,
            @ModelAttribute Examine examine) {
        examine.setExaminetype(DictConstant.SERVER_EXAMINE);
        Map<String, Object> result = new HashMap<>();
        try {
            PageInfo<Examine> pageInfo = examineService.selectExamine(page, rows, examine);
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
    public Map<String, Object> selectExamineById(@ModelAttribute Examine examine) {
        Map<String, Object> result = new HashMap<>();
        try {
            examine = examineService.selectExamineById(examine);
            result.put("examine", examine);
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

    @RequestMapping("/updateExamineFlag")
    @ResponseBody
    public Map<String, Object> updateExamineFlag(@ModelAttribute Examine examine) {
        Map<String, Object> result = new HashMap<>();
        try {
            examineService.updateExamine(examine);
            result.put("success", true);
            result.put("message", "修改成功");
        } catch (RequestParameterErrorException e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "修改失败，" + e.getMessage());
        } catch (UserCompanyExistException e) {
            result.put("success", false);
            result.put("message", "修改失败，" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("服务器内部异常", false);
        }
        return result;
    }
}
