package com.bkap.vn.manager.role.controller;


import com.bkap.vn.common.entity.Category;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.category.service.CategoryService;
import com.bkap.vn.manager.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("quan-tri")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"/quyen/{page}", "/quyen/danh-sach-quyen/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("role") Role role,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult, HttpServletRequest request, HttpServletResponse response) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = roleService.generateQuerySearchRole(keySearch);
        int totalRecord = roleService.countAll(filter);
        paggingResult = roleService.findRange(currentPage, 10, filter);
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("role-list");
        return view;
    }


    @RequestMapping(value = "/quyen/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("Role") Role role, Model model, RedirectAttributes attributes, Locale locale) {
        role = roleService.getById(id);
        if (role != null) {
            model.addAttribute("role", role);
            return "role-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Role not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Quyền không tồn tại!");
            }
            return "redirect:/quan-tri/quyen/1";
        }
    }

    @RequestMapping(value = "/quyen/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("Role") @Valid Role role,
                             BindingResult result, RedirectAttributes attributes) {
        Role RoleUpdate = roleService.getById(role.getId());
        try {
            if (RoleUpdate != null) {
                if (result.hasErrors()) {
                    return view("role-edit", role, "role", "Cập nhật quyền thất bại!", "danger");
                } else {
                    role.setUpdateDate(new Date());
                    role.setCreateDate(RoleUpdate.getCreateDate());
                /*role.setAdminByAdminUpdate(new Admin());
                role.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = roleService.update(role);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật quyền thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật quyền thất bại!");
                    }
                }
            } else {
                return view("redirect:/quan-tri/quyen/danh-sach-quyen/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/quyen/danh-sach-quyen/1");
    }

    @RequestMapping(value = "/quyen/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("role", new Role());
        return "role-add";
    }

    @RequestMapping(value = "/quyen/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute(value = "role") @Valid Role role,
                            BindingResult result, HttpServletRequest request,
                            HttpServletResponse response, RedirectAttributes attributes) {
        if (role != null) {
            if (result.hasErrors()) {
                return view("role-add", role, "Role", "Thêm mới quyền thất bại!", "danger");
            } else {
                role.setUpdateDate(new Date());
                role.setCreateDate(new Date());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(new Admin());*/
                int check = roleService.add(role);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới quyền thành công");
                    return view("redirect:/quan-tri/quyen/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới quyền thất bại");
                    return view("redirect:/quan-tri/quyen/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/quyen/1");
        }
    }

    @RequestMapping(value = "/quyen/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Role Role = roleService.getById(id);
            if (Role != null) {
                boolean check = roleService.delete(Role);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa quyền thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa quyền thất bại, quyền không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa quyền thất bại, quyền không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/quyen/1");
        return view;
    }


}
