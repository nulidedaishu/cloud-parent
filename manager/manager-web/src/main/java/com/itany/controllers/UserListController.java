package com.itany.controllers;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.itany.constant.DictConstant;
import com.itany.entity.User;
import com.itany.exception.RequestParameterErrorException;
import com.itany.exception.ServiceException;
import com.itany.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/userList")
public class UserListController {

    private static final Logger logger = LoggerFactory.getLogger(UserListController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/show")
    public String showUserList() {
        return "userlist";
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public Map<String, Object> getUserList(
            @RequestParam(defaultValue = DictConstant.USER_DEFAULT_NO) String page,
            @RequestParam(defaultValue = DictConstant.USER_DEFAULT_PAGE) String rows,
            @ModelAttribute User user,
            @RequestParam(required = false) String userType) {
        Map<String, Object> result = new HashMap<>();
        try {
            PageInfo<User> pageInfo;
            pageInfo = userService.getUserList(page, rows, user, userType);
            result.put("total", pageInfo.getTotal());
            result.put("rows", pageInfo.getList());
            logger.info("返回数据: {}", JSON.toJSONString(result));
        } catch (RequestParameterErrorException e) {
            result.put("success", false);
            result.put("message", "查询失败，" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("服务器内部异常", false);
        }
        return result;
    }

    @RequestMapping("/selectUserById")
    @ResponseBody
    public Map<String, Object> selectUserById(@ModelAttribute User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            user = userService.selectUserById(user);
            result.put("user", user);
            result.put("success", true);
            result.put("message", "查询成功");
            logger.info("返回数据: {}", JSON.toJSONString(result));
        } catch (RequestParameterErrorException e) {
            result.put("success", false);
            result.put("message", "查询失败，" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("服务器内部异常", false);
        }
        return result;
    }

    //禁用user中的flag属性
    @RequestMapping("/disableUser")
    @ResponseBody
    public Map<String, Object> disableUser(@ModelAttribute User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.disableUser(user);
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

    //启用user中的flag属性
    @RequestMapping("/enableUser")
    @ResponseBody
    public Map<String, Object> enableUser(@ModelAttribute User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.enableUser(user);
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
