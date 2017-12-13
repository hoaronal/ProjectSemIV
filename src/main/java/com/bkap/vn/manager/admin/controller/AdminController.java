package com.bkap.vn.manager.admin.controller;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("quan-tri")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/quan-tri-vien/danh-sach-quan-tri-vien/{page}", method = RequestMethod.GET)
    public String list(@ModelAttribute("admin") Admin admin, String clickSearch, @PathVariable("page") int page, PaggingResult paggingResult, String keySearch, Model model, HttpServletRequest request, HttpServletResponse response) {
        /*List<Admin> adminList = adminService.findRange(1,3);
        model.addAttribute("adminList", adminList);*/
        return "admin-list";
    }

    @RequestMapping(value = "/quan-tri-vien/them-moi-quan-tri-vien", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Admin> adminList = adminService.findRange(1,3);
        model.addAttribute("adminList", adminList);
        return "admin-add";
    }

    @RequestMapping(value = "/quan-tri-vien/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        Admin admin = adminService.getById(id);
        adminService.delete(admin);
        view.setViewName("redirect:/quan-tri/quan-tri-vien/danh-sach-quan-tri-vien/1");
        return view;
    }
}