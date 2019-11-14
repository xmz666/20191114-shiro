package com.aaa.xmz.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Company AAA软件教育
 * @Author xmz
 * @Date Create in 2019/10/12 11:21
 * @Description
 **/
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String turnLoginPage() {
        return "login";
    }

    @RequestMapping("/")
    public String turnIndexPage() {
        return "index";
    }

}
