package com.zk.controller;

import com.zk.Springboot04webApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by zk on 18/5/25.
 */

@Controller
public class SuccessController {
    @Autowired
    private Springboot04webApplication springboot04webApplication;

    @RequestMapping("/success")
    //thymeleaf默认扫描classpath:/templates/下的.html页面.classpath就是指类路径,也就是resources下面的路径.
    public String success(Map<String,String> map){
        map.put("hello","你好");
        return "success";
    }

//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "index";
//    }
}
