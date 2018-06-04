package com.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by zk on 18/6/4.
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String userName,
                        @RequestParam(value = "password") String password,
                        Map<String,Object> message,
                        HttpSession session){
        if (!StringUtils.isEmpty(userName) && "aa".equals(password)){
            session.setAttribute("loginUser",userName);
            //防止表单重新提交使用重定向的方式
            return "redirect:/dashboard.html";
        }else {
            message.put("msg","用户名密码错误!!!");
            return "login";
        }
    }
}
