package com.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zk on 18/5/25.
 */

@Controller
@RequestMapping("/zk")
public class SuccessController {
    @RequestMapping("/success")
    //thymeleaf默认扫描classpath:/templates/下的.html页面.classpath就是指类路径,也就是resources下面的路径.
    public String success(){
        return "success";
    }
}
