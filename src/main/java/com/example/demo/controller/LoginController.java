package com.example.demo.controller;

import com.dsh.demo.pojo.SysUserPo;
import com.dsh.demo.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private String clazzName = "com.example.demo.controller.LoginController.";


    @Autowired(required = true)
    SysUserServiceImpl userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@AuthenticationPrincipal SysUserPo loginedUser,
                        @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return null;
        }
        if (loginedUser != null) {
            return "login";
        }
        return null;
    }
}
