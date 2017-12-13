package com.bkap.vn.web.cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class CartController {


    @RequestMapping(value = {"/gio-hang"},method = RequestMethod.GET)
    public String cart(Model model){
        System.out.println("cart");
        return "cart";
    }
}
