package com.bkap.vn.manager.role.controller;

import com.bkap.vn.manager.role.service.RoleService;
import com.bkap.vn.manager.role.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("phan-quyen")
public class RoleController {
    @Autowired
    private RoleService roleService = new RoleServiceImpl();
}
