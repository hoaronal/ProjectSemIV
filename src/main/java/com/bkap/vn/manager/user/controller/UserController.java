package com.bkap.vn.manager.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/administrator")
public class UserController {

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public String list(){
        return "user-list";
    }

}
