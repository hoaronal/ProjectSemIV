package com.bkap.vn.web.home.controller;


import com.bkap.vn.common.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class HomeWebController {

    @RequestMapping(value = {"","/trang-chu"},method = RequestMethod.GET)
    public String home(Model model){
        return "home-web";
    }

    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    public String login(Model model, HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = new Users();

        session.setAttribute("userLogin" , user);
        return "home-web";
    }

}
