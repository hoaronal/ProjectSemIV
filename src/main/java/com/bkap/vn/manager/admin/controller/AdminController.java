package com.bkap.vn.manager.admin.controller;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.common.util.PatternUtil;
import com.bkap.vn.manager.admin.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("quan-tri")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/quan-tri-vien/{page}", "/quan-tri-vien/danh-sach-quan-tri-vien/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("admin") Admin admin,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult, HttpServletRequest request, HttpServletResponse response) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = adminService.generateQuerySearchAdmin(keySearch);
        int totalRecord = adminService.countAll(filter);
        paggingResult = adminService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("admin-list");
        return view;
    }

    @RequestMapping(value = "/quan-tri-vien/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable(value = "id", required = false) int id, @ModelAttribute("admin") Admin admin, Model model, RedirectAttributes attributes, Locale locale) {
        admin = adminService.getById(id);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "admin-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "admin not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Quản trị viên không tồn tại!");
            }
            return "redirect:/quan-tri/quan-tri-vien/1";
        }
    }

    @RequestMapping(value = "/quan-tri-vien/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@RequestParam(value = "re_password",required = false) String rePassword,
                             @ModelAttribute("admin") @Valid Admin admin,
                             BindingResult result, RedirectAttributes attributes) {
        Admin adminUpdate = adminService.getById(admin.getId());
        try {
            if (adminUpdate != null) {
                if (result.hasErrors() && !validateUpdate(admin)) {
                    return view("admin-edit", admin, "admin","Cập nhật quản trị viên thất bại!","danger");
                } else {
                    if (StringUtils.isBlank(admin.getPassword())) {
                        admin.setPassword(adminUpdate.getPassword());
                    } else {
                        admin.setPassword(admin.getPassword());
                    }
                    admin.setUpdateDate(new Date());
                    admin.setCreateDate(adminUpdate.getCreateDate());
                /*admin.setAdminByAdminUpdate(new Admin());
                admin.setAdminByAdminCreate(adminUpdate.getAdminByAdminCreate());*/
                    boolean check = adminService.update(admin);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật quản trị viên thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật quản trị viên thất bại!");
                    }
                }
            } else {
                return view("redirect:/quan-tri/quan-tri-vien/danh-sach-quan-tri-vien/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/quan-tri-vien/danh-sach-quan-tri-vien/1");
    }

    @RequestMapping(value = "/quan-tri-vien/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin-add";
    }

    @RequestMapping(value = "/quan-tri-vien/thong-tin", method = RequestMethod.GET)
    public String info(Model model, HttpServletRequest request, @ModelAttribute("admin") Admin admin, HttpServletResponse response, RedirectAttributes attributes, Locale locale) {
        admin = adminService.getById(1);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "admin-info";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Admin not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Quản trị viên không tồn tại!");
            }
            return "redirect:/quan-tri/quan-tri-vien/1";
        }
    }

    @RequestMapping(value = "/quan-tri-vien/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute("admin") @Valid Admin admin, BindingResult result, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes) {
        if (admin != null) {
            if (result.hasErrors() || !validateUpdate(admin)) {
                return view("admin-add", admin, "admin","Thêm mới quản trị viên thất bại!","danger");
            } else {
                if (!StringUtils.isBlank(admin.getPassword())) {
                    admin.setPassword(admin.getPassword());
                }
                admin.setUpdateDate(new Date());
                admin.setCreateDate(new Date());
                /*admin.setAdminByAdminUpdate(new Admin());
                admin.setAdminByAdminCreate(new Admin());*/
                admin.setActiveStatus((byte) 1);
                admin.setStatus((byte) 1);
                int check = adminService.add(admin);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới quản trị viên thành công");
                    return view("redirect:/quan-tri/quan-tri-vien/danh-sach-quan-tri-vien/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới quản trị viên thất bại");
                    return view("redirect:/quan-tri/quan-tri-vien/danh-sach-quan-tri-vien/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/quan-tri-vien/danh-sach-quan-tri-vien/1");
        }
    }

    @RequestMapping(value = "/quan-tri-vien/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Admin admin = adminService.getById(id);
            if (admin != null) {
                boolean check = adminService.delete(admin);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa quản trị viên thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa quản trị viên thất bại, quản trị viên không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa quản trị viên thất bại,quản trị viên không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/quan-tri-vien/1");
        return view;
    }

    public boolean validateAdd(Admin admin) {
        boolean check = true;
        if (admin != null) {
            if (StringUtils.isBlank(admin.getAccount())) {
                check = false;
            } else if (admin.getAccount().trim().length() <= 5) {
                check = false;
            } else if (admin.getAccount().trim().length() >= 20) {
                check = false;
            }
            if (!StringUtils.isBlank(admin.getPassword())) {
                if (admin.getPassword().trim().length() < 8) {
                    check = false;
                } else if (admin.getPassword().trim().length() > 20) {
                    check = false;
                }
            } else {
                check = false;
            }
            if (!StringUtils.isBlank(admin.getPhone())) {
                if (admin.getPhone().trim().length() < 10) {
                    check = false;
                } else if (admin.getPassword().trim().length() > 20) {
                    check = false;
                }
            }
            if (!StringUtils.isBlank(admin.getEmail())) {
                if (admin.getEmail().trim().length() > 200) {
                    check = false;
                }
                if(!BaseController.checkPattern(PatternUtil.EMAIL,admin.getEmail())){
                    check = false;
                }
            }else{
                check = false;
            }
            if (!StringUtils.isBlank(admin.getAddress())) {
                if (admin.getAddress().trim().length() > 500) {
                    check = false;
                }
            }
        } else {
            check = false;
        }
        return check;
    }

    public boolean validateUpdate(Admin admin) {
        boolean check = true;
        if (admin != null) {
            if (StringUtils.isBlank(admin.getAccount())) {
                check = false;
            } else if (admin.getAccount().trim().length() < 5) {
                check = false;
            } else if (admin.getAccount().trim().length() >= 20) {
                check = false;
            }
            if (!StringUtils.isBlank(admin.getPassword())) {
                if (admin.getPassword().trim().length() < 8) {
                    check = false;
                } else if (admin.getPassword().trim().length() > 20) {
                    check = false;
                }
            }
            if (!StringUtils.isBlank(admin.getPhone())) {
                if (admin.getPhone().trim().length() < 10) {
                    check = false;
                } else if (admin.getPassword().trim().length() > 20) {
                    check = false;
                }
            }
            if (!StringUtils.isBlank(admin.getEmail())) {
                if (admin.getEmail().trim().length() > 200) {
                    check = false;
                }
                if(!BaseController.checkPattern(PatternUtil.EMAIL,admin.getEmail())){
                    check = false;
                }
            }else{
                check = false;
            }
            if (!StringUtils.isBlank(admin.getAddress())) {
                if (admin.getAddress().trim().length() > 500) {
                    check = false;
                }
            }
        } else {
            check = false;
        }
        return check;
    }
}