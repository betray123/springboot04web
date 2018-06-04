package com.zk.component;

/**
 * Created by zk on 18/6/4.
 */

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置拦截器进行登陆检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{

    //目标方法跳转之前执行的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (null == user){
            //未登录,返回登录页面
            request.setAttribute("msg","没有权限,请先登录!!!");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else {
            //已登录,放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
