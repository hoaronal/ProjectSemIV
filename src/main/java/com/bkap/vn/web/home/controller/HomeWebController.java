package com.bkap.vn.web.home.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeWebController {

    @RequestMapping(value = {""},method = RequestMethod.GET)
    public String home(Model model){
        System.out.println("sdsdsdsd");
        return "home-web";
    }
}
