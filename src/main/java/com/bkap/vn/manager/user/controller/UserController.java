package com.bkap.vn.manager.user.controller;


import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.user.service.UserService;
import com.bkap.vn.manager.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("quan-tri")
public class UserController extends BaseController {

    @Autowired
    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = {"/nguoi-dung/{page}","/nguoi-dung/danh-sach-nguoi-dung/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@PathVariable("page") int page, PaggingResult paggingResult, Model model, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        if (page <= 1) {
            page = 1;
        }
        int totalRecord = userService.countAll();
        int totalPages = (totalRecord / paggingResult.getRowsPerPage()) + ((totalRecord % paggingResult.getRowsPerPage() != 0) ? 1 : 0);
        paggingResult.setCurrentPage(page);
        paggingResult.setTotalRecord(totalRecord);
        int firstRecord = (page - 1) * paggingResult.getRowsPerPage();
        int maxRecord = paggingResult.getRowsPerPage();
        List<Users> userList = userService.findRange(firstRecord, maxRecord);
        paggingResult.setItem(userList);
        paggingResult.paging(page, totalPages, totalRecord, paggingResult.getRowsPerPage(), firstRecord, paggingResult.getPageRange());
        view.addObject("userList", paggingResult);
        view.setViewName("user-list");
        return view;
    }

    @RequestMapping(value = "/nguoi-dung/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("user", new Users());
        return "user-add";
    }

    @RequestMapping(value = "/nguoi-dung/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute("user") @Valid Users user, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        if(result.hasErrors()){

            return view("user-add",user,"user");
        }
        user.setActiveStatus((byte) 1);
        user.setStatus((byte) 1);
        userService.add(user);

        return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
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


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(Locale lang){
        ModelAndView view = new ModelAndView();


        view.setViewName("test");
        return view;
    }

}
