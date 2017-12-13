package com.bkap.vn.manager.orderdetail.controller;

import com.bkap.vn.manager.orderdetail.service.OrderDetailService;
import com.bkap.vn.manager.orderdetail.service.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chi-tiet-don-hang")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService = new OrderDetailServiceImpl();
}
