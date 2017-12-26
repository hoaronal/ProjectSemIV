package com.bkap.vn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/")
public class CartController {


    @RequestMapping(value = {"/gio-hang"},method = RequestMethod.GET)
    public String cart(Model model, HttpServletRequest request, HttpServletResponse response){
        System.out.println("cart");
        return "cart";
    }
}
