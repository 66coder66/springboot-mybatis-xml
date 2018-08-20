package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/sysusers")
@RestController
public class SysUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);
    private String clazzName = "com.example.demo.controller.SysUserController.";

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        return "Get all User";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object detail(@PathVariable Integer id) {
        return "Get a user";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(HttpServletRequest request) {
        return "POST a user";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Object update(HttpServletRequest request) {
        return "PUT a user";
    }

}
