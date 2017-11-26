package com.bkap.vn.manager.user.controller;


import com.bkap.vn.common.entity.User;
import com.bkap.vn.manager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/quan-tri")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/nguoi-dung/danh-sach-nguoi-dung", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.findRange(1,3);
        model.addAttribute("userList", userList);
        return "user-list";
    }

    @RequestMapping(value = "/nguoi-dung/them-moi", method = RequestMethod.GET)
    public String add() {
        return "user-list";
    }

}
