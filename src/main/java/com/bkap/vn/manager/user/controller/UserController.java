package com.bkap.vn.manager.user.controller;


import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.user.service.UserService;
import com.bkap.vn.manager.user.service.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("quan-tri")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/nguoi-dung/{page}", "/nguoi-dung/danh-sach-nguoi-dung/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("user") Users user, String clickSearch, @PathVariable("page") int page, PaggingResult paggingResult, String keySearch, Model model, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        String path = request.getServletPath();
        String contextPath = request.getContextPath();
        String queryString = request.getQueryString();
        keySearch = request.getParameter("keySearch");
        if (page <= 1) {
            page = 1;
        }
        paging(paggingResult, page, keySearch);
        view.addObject("keySearch", keySearch);
        view.addObject("clickSearch", clickSearch);
        view.addObject("searchUrl", contextPath + path + "?" + queryString);
        view.addObject("listItem", paggingResult);
        view.setViewName("user-list");
        return view;
    }

    @RequestMapping(value = "/nguoi-dung/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("user") Users user, Model model, RedirectAttributes attributes, Locale locale) {
        user = userService.getById(id);
        /*System.out.println(locale.getLanguage());*/
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

    @RequestMapping(value = "/nguoi-dung/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("user") @Valid Users user, BindingResult result, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes) {
        Users userUpdate = userService.getById(user.getId());
        try{
            if (userUpdate != null) {
                if (result.hasErrors() && !validateUpdate(user)) {
                    return view("user-edit", user, "user");
                } else {
                    if(StringUtils.isBlank(user.getPassword())){
                        user.setPassword(userUpdate.getPassword());
                    }else{
                        user.setPassword(user.getPassword());
                    }
                    user.setUpdateDate(new Date());
                    user.setCreateDate(userUpdate.getCreateDate());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = userService.update(user);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Thất bại");
                    }
                }
            } else {
                return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
    }

    @RequestMapping(value = "/nguoi-dung/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("user", new Users());
        return "user-add";
    }

    @RequestMapping(value = "/nguoi-dung/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute("user") @Valid Users user, BindingResult result, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes) {
        if (user != null) {
            if (result.hasErrors() && !validateUpdate(user)) {
                return view("user-add", user, "user");
            } else {
                if(!StringUtils.isBlank(user.getPassword())){
                    user.setPassword(user.getPassword());
                }
                user.setUpdateDate(new Date());
                user.setCreateDate(new Date());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(new Admin());*/
                user.setActiveStatus((byte) 1);
                user.setStatus((byte) 1);
                int check = userService.add(user);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới thành công");
                    return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới thất bại");
                    return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
        }
    }

    @RequestMapping(value = "/nguoi-dung/xoa/{id}", method = RequestMethod.GET)
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
        view.setViewName("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
        return view;
    }

    public PaggingResult paging(PaggingResult paggingResult, int page, String keySearch) {
        try {
            if (StringUtils.isBlank(keySearch)) {
                int totalRecord = userService.countAll();
                int totalPages = (totalRecord / paggingResult.getRowsPerPage()) + ((totalRecord % paggingResult.getRowsPerPage() != 0) ? 1 : 0);
                paggingResult.setCurrentPage(page);
                paggingResult.setTotalRecord(totalRecord);
                int firstRecord = (page - 1) * paggingResult.getRowsPerPage();
                int maxRecord = paggingResult.getRowsPerPage();
                List<Users> userList = userService.findRange(firstRecord, maxRecord, generateQuerySearchUser(keySearch));
                paggingResult.setItem(userList);
                paggingResult.paging(page, totalPages, totalRecord, paggingResult.getRowsPerPage(), firstRecord, paggingResult.getPageRange());
            } else {
                int totalRecord = userService.countAllByKeySearch(generateQuerySearchUser(keySearch));
                int totalPages = (totalRecord / paggingResult.getRowsPerPage()) + ((totalRecord % paggingResult.getRowsPerPage() != 0) ? 1 : 0);
                paggingResult.setCurrentPage(page);
                paggingResult.setTotalRecord(totalRecord);
                int firstRecord = (page - 1) * paggingResult.getRowsPerPage();
                int maxRecord = paggingResult.getRowsPerPage();
                List<Users> userList = userService.findRange(firstRecord, maxRecord, generateQuerySearchUser(keySearch));
                paggingResult.setItem(userList);
                paggingResult.paging(page, totalPages, totalRecord, paggingResult.getRowsPerPage(), firstRecord, paggingResult.getPageRange());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paggingResult;
    }

    public String generateQuerySearchUser(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and username like N'%" + keySearch + "%'")
                    .append(" or email like N'%" + keySearch + "%'")
                    .append(" or phone like N'%" + keySearch + "%'")
                    .append(" or address like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return " where 1=1";
        }
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
