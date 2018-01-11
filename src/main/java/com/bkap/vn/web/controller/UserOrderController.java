package com.bkap.vn.web.controller;


import com.bkap.vn.common.entity.*;
import com.bkap.vn.manager.order.service.OrderService;
import com.bkap.vn.manager.province.service.ProvinceService;
import com.bkap.vn.manager.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "dat-hang")
public class UserOrderController {
    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET)
    public String orderview(Model model, @ModelAttribute("transaction") Transaction transaction, HttpServletRequest request, HttpServletResponse response) {
        List<Province> provinceList = provinceService.listProvince();
        Map<String, List<Product>> map = (Map<String, List<Product>>) request.getSession().getAttribute("CART");
        List<Product> products = new ArrayList<>();
        int subtotal = 0;
        if (map != null) {
            for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
                products.add(entry.getValue().get(0));
                subtotal += entry.getValue().size() * Integer.parseInt(entry.getValue().get(0).getPrice());
            }
        }
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("listProduct", products);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("map", map);
        return "checkout";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doOrder(Model model, @ModelAttribute("transaction") Transaction transaction,
                          @RequestParam(required = false, defaultValue = "0") int province,
                          @RequestParam(required = false) String firstname,
                          @RequestParam(required = false) String lastname,
                          @RequestParam(required = false) String address,
                          @RequestParam(required = false) String email,
                          @RequestParam(required = false) String phone,
                          @RequestParam(required = false) String message,
                          @RequestParam(required = false) String payment_method,
                          HttpServletRequest request, HttpServletResponse response) {
        List<Province> provinceList = provinceService.listProvince();
        Map<String, List<Product>> map = (Map<String, List<Product>>) request.getSession().getAttribute("CART");
        Integer transactionId= null;
        Users users = (Users) request.getSession().getAttribute(request.getSession().getId());
        List<Product> products = new ArrayList<>();
        Order order = new Order();
        int subtotal = 0;
        try {
            if (map != null) {
                for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
                    products.add(entry.getValue().get(0));
                    subtotal += entry.getValue().size() * Integer.parseInt(entry.getValue().get(0).getPrice());
                }
                if(users != null){
                    transaction.setUserId(users.getId());
                }
                transaction.setUserEmail(email);
                transaction.setUserPhone(phone);
                transaction.setMessage(message);
                transaction.setUserName(firstname + " " + lastname);
                transaction.setCreateDate(new Date());
                transaction.setUpdateDate(new Date());
                transaction.setAmount(subtotal);
                transaction.setPayment(payment_method);
                transactionId = transactionService.add(transaction);
                transaction.setId(transactionId);
            }
            if (map != null) {
                for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
                    order.setProduct(entry.getValue().get(0));
                    order.setQty(entry.getValue().size());
                    order.setQty(entry.getValue().size());
                    order.setAmount(entry.getValue().size() * Integer.parseInt(entry.getValue().get(0).getPrice()));
                    order.setStatus(0);
                    order.setTransaction(transaction);
                    order.setCreateDate(new Date());
                    order.setUpdateDate(new Date());
                    orderService.add(order);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg","Có lỗi, không thể thực hiện đặt hàng!");
            model.addAttribute("transaction", new Transaction());
            model.addAttribute("provinceList", provinceList);
            model.addAttribute("listProduct", products);
            model.addAttribute("subtotal", subtotal);
            model.addAttribute("map", map);
            return "checkout";
        }

        request.getSession().removeAttribute("CART");
        request.getSession().setAttribute("NUM_IN_CART", 0);
        return "checkoutResult";
    }

    @RequestMapping(value = "/lich-su-dat-hang",method = RequestMethod.GET)
    public String orderhistory(Model model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute(session.getId());
        if(users != null){
            List<Transaction> transactions = transactionService.getTransactionByUserId(users.getId());
            model.addAttribute("transactions",transactions);
        }
        return "orderHistory";
    }
}
