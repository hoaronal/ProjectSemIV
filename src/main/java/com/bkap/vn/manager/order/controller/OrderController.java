package com.bkap.vn.manager.order.controller;

import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.order.service.OrderService;
import com.bkap.vn.manager.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("don-hang")
public class OrderController extends BaseController {
    @Autowired
    OrderService orderService = new OrderServiceImpl();
}
