package com.bkap.vn.manager.user.controller;


import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.common.util.PatternUtil;
import com.bkap.vn.manager.user.service.UserService;
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
@RequestMapping("quan-tri/nguoi-dung")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/{page}", "/danh-sach-nguoi-dung/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("user") Users user,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = userService.generateQuerySearchUser(keySearch);
        int totalRecord = userService.countAll(filter);
        paggingResult = userService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("user-list");
        return view;
    }

    @RequestMapping(value = "/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable(value = "id", required = false) int id, @ModelAttribute("user") Users user, Model model, RedirectAttributes attributes, Locale locale) {
        user = userService.getById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "user-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "User not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Người dùng không tồn tại!");
            }
            return "redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1";
        }
    }

    @RequestMapping(value = "/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("user") @Valid Users user, RedirectAttributes attributes) {
        Users userUpdate = userService.getById(user.getId());
        try {
            if (userUpdate != null && validateUpdate(user)) {
                user.setUpdateDate(new Date());
                user.setCreateDate(userUpdate.getCreateDate());
                boolean check = userService.update(user);
                if (check) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Cập nhật người dùng thành công");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Cập nhật người dùng thất bại!");
                }
            } else {
                return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
    }

    @RequestMapping(value = "/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("user", new Users());
        return "user-add";
    }

    @RequestMapping(value = "/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute("user") @Valid Users user, RedirectAttributes attributes) {
        if (user != null && validateAdd(user)) {
                if (!StringUtils.isBlank(user.getPassword())) {
                    user.setPassword(user.getPassword());
                }
                user.setUpdateDate(new Date());
                user.setCreateDate(new Date());
                user.setActiveStatus((byte) 1);
                user.setStatus((byte) 1);
                int check = userService.add(user);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới người dùng thành công");
                    return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới người dùng thất bại");
                    return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
                }
        } else {
            return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
        }
    }

    @RequestMapping(value = "/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Users user = userService.getById(id);
            if (user != null) {
                boolean check = userService.delete(user);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa người dùng thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa người dùng thất bại, người dùng không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa người dùng thất bại, người dùng không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/nguoi-dung/1");
        return view;
    }

    public boolean validateAdd(Users user) {
        boolean check = true;
        if (user != null) {
            if (StringUtils.isBlank(user.getUsername())) {
                check = false;
            } else if (user.getUsername().trim().length() <= 5) {
                check = false;
            } else if (user.getUsername().trim().length() >= 20) {
                check = false;
            }
            if (!StringUtils.isBlank(user.getPassword())) {
                if (user.getPassword().trim().length() < 8) {
                    check = false;
                } else if (user.getPassword().trim().length() > 20) {
                    check = false;
                }
            } else {
                check = false;
            }
            if (!StringUtils.isBlank(user.getPhone())) {
                if (user.getPhone().trim().length() < 10) {
                    check = false;
                } else if (user.getPassword().trim().length() > 20) {
                    check = false;
                }
            }
            if (!StringUtils.isBlank(user.getEmail())) {
                if (user.getEmail().trim().length() > 200) {
                    check = false;
                }
                if (!BaseController.checkPattern(PatternUtil.EMAIL, user.getEmail())) {
                    check = false;
                }
            } else {
                check = false;
            }
            if (!StringUtils.isBlank(user.getAddress())) {
                if (user.getAddress().trim().length() > 500) {
                    check = false;
                }
            }
        } else {
            check = false;
        }
        return check;
    }

    public boolean validateUpdate(Users user) {
        boolean check = true;
        if (user != null) {
            if (StringUtils.isBlank(user.getUsername())) {
                check = false;
            } else if (user.getUsername().trim().length() < 5) {
                check = false;
            } else if (user.getUsername().trim().length() >= 20) {
                check = false;
            }
            if (!StringUtils.isBlank(user.getPassword())) {
                if (user.getPassword().trim().length() < 8) {
                    check = false;
                } else if (user.getPassword().trim().length() > 20) {
                    check = false;
                }
            }
            if (!StringUtils.isBlank(user.getPhone())) {
                if (user.getPhone().trim().length() < 10) {
                    check = false;
                } else if (user.getPassword().trim().length() > 20) {
                    check = false;
                }
            }
            if (!StringUtils.isBlank(user.getEmail())) {
                if (user.getEmail().trim().length() > 200) {
                    check = false;
                }
                if (!BaseController.checkPattern(PatternUtil.EMAIL, user.getEmail())) {
                    check = false;
                }
            } else {
                check = false;
            }
            if (!StringUtils.isBlank(user.getAddress())) {
                if (user.getAddress().trim().length() > 500) {
                    check = false;
                }
            }
        } else {
            check = false;
        }
        return check;
    }
}
