package com.bkap.vn.manager.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quan-tri")
public class HomeController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String home(Model model){
        return "home-administrator";
    }
}
