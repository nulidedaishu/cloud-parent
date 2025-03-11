package com.itany.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.itany.client.ITestClient;
import com.itany.entity.User;
import com.itany.service.IWebTestService;
import com.itany.utils.JWTUtil;
import com.itany.vo.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/web")
public class WebTestController {

    @Autowired
    private ITestClient testClient;

    @Autowired
    private IWebTestService webTestService;

    @Autowired
    StringRedisTemplate template;


    @RequestMapping("/findUsers")
    public ModelAndView findUsers(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                  @RequestParam(name = "rows", defaultValue = "10") Integer rows) {
        PageInfo<User> info = testClient.findUsers(page, rows);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo", info);
        ModelAndView mv = new ModelAndView("userlist", map);
        return mv;
    }

    /**
     * 1. 动态的跳转路径(完善)
     * 2. 超时续时
     * 3. 解析校验,login界面只能处理从sso服务重定向过来的URL
     * 4. 不可重复登录
     *
     *
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ActionResult login(User user) {
        ActionResult actionResult = new ActionResult();
        User u = webTestService.findUser(user);
        String token = UUID.randomUUID().toString();
        template.opsForValue().set("USER_TOKEN::" + token, JSON.toJSONString(u), 1800, TimeUnit.SECONDS);
        Map<String, String> payload = new HashMap<>();
        payload.put("userId", u.getId() + "");
        payload.put("name", u.getName());
//        payload.put("date", String.valueOf(new Date()));
        payload.put("token", token);
        actionResult.setStatus(200);
        actionResult.setMsg(JWTUtil.getToken(payload));
        actionResult.setData("http://localhost:9006/web/findUsers");
        return actionResult;
    }

    @RequestMapping("/getToken")
    @ResponseBody
    public String getToken() {
        return "ok";
    }


}
