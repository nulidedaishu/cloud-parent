package com.itany.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.itany.ApplicationHold;
import com.itany.utils.JWTUtil;
import com.itany.vo.ActionResult;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;

        StringRedisTemplate template = ApplicationHold.getBean(StringRedisTemplate.class);
        String token = request.getHeader("Authorization") != null ?
                request.getHeader("Authorization") : request.getParameter("token");
        if (token != null && !"".equals(token)) {
            try {
                DecodedJWT decodedJWT = JWTUtil.decoded(token);
                String obj = template.opsForValue().get("USER_TOKEN::" + decodedJWT.getClaim("token").asString());
                if (obj != null && !"".equals(obj)) {
                    System.out.println(obj + "=======================");
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!flag) {
            StringBuffer httpUrl = request.getRequestURL();
            String xr = request.getHeader("X-Requested-With");
            if ((xr != null && "XMLHttpRequest".equalsIgnoreCase(xr))) {
                PrintWriter out = null;
                try {
                    response.setContentType("application/json;charset=utf-8");
                    response.setCharacterEncoding("UTF-8");
                    ActionResult ar = new ActionResult();
                    ar.setStatus(402);
                    ar.setMsg("请先登录!!!");
                    ar.setData(httpUrl);
                    out = response.getWriter();
                    out.append(JSON.toJSONString(ar));
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (out != null) {
                        out.close();
                    }
                }
            } else {
                String url = "http://localhost:9006/showlogin?server="
                        + URLEncoder.encode(httpUrl.toString(), "utf-8");
                response.sendRedirect(url);
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
