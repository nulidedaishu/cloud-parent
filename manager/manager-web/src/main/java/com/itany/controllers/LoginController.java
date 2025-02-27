package com.itany.controllers;


import com.itany.entity.ManagerUser;
import com.itany.exception.*;
import com.itany.service.ManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/managerUser")
public class LoginController {

    @Autowired
    private ManagerUserService managerUserService;

    // 用户登录方法
    @PostMapping("/login")
    public ModelAndView login(String username, String password, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        try {
            ManagerUser managerUser = managerUserService.login(username, password);
            // 如果验证成功，将用户信息存储到 Session 中
            session.setAttribute("managerUser", managerUser);
            // 重定向到主页面，表示用户已成功登录
            mav.setViewName("redirect:/manager/showList");
        } catch (RequestParameterErrorException e) {
            mav.addObject("loginMsg", e.getMessage());
            mav.setViewName("login");
        } catch (ManagerUserNotExistException e) {
            mav.addObject("loginMsg", e.getMessage());
            mav.setViewName("login");
        } catch (PasswordErrorException e) {
            mav.addObject("loginMsg", e.getMessage());
            mav.setViewName("login");
        } catch (ServiceException e) {
            mav.addObject("loginMsg", e.getMessage());
            mav.setViewName("login");
        }
        return mav;
    }

    @PostMapping("/modifyPassword")
    @ResponseBody
    public Map<String, Object> modifyPassword(@RequestBody Map<String, String> passwords, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        String password1 = passwords.get("password1");
        String password2 = passwords.get("password2");
        try {
            ManagerUser managerUser = (ManagerUser) session.getAttribute("managerUser");
            managerUserService.modifyPassword(managerUser.getId(), password1, password2);
            result.put("success", true);
            result.put("message", "密码修改成功！");
        } catch (RequestParameterErrorException e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "修改失败，" + e.getMessage());
        } catch (PasswordConfirmationException e) {
            result.put("success", false);
            result.put("message", "修改失败，" + e.getMessage());
        } catch (ServiceException e) {
            e.printStackTrace();
            result.put("服务器内部异常", false);
        }
        return result;
    }

    @RequestMapping("/logoutBack")
    public ModelAndView logoutBack(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.invalidate();
        mav.setViewName("redirect:/manager/showLogin");
        return mav;
    }

}
