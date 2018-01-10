package com.bkap.vn.web.controller;


import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.common.util.Constant;
import com.bkap.vn.common.util.PatternUtil;
import com.bkap.vn.manager.user.service.UserService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Link;
import com.restfb.types.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String username, @RequestParam String password, RedirectAttributes attributes,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users userLogin = userService.getByUsername(username);
        if (userLogin != null) {
            if (password.equals(userLogin.getPassword())) {
                session.setAttribute(session.getId(), userLogin);
            } else {
                attributes.addFlashAttribute("style","error");
                attributes.addFlashAttribute("msg","Sai mật khẩu!");
            }
        } else {
            attributes.addFlashAttribute("style","error");
            attributes.addFlashAttribute("msg","Người dùng không tồn tại!");
        }
        return "redirect:/trang-chu";
    }

    @RequestMapping(value = "/login-facebook", method = RequestMethod.GET)
    public String loginfacebook(Model model, RedirectAttributes attributes,HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        String accessToken = request.getParameter("accessToken");
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_11);
        User user = facebookClient.fetchObject("me", User.class);
        Users users = new Users();
        users.setUsername(user.getName());
        users.setFacebookId(user.getId());
        users.setFacebooklink("https://facebook.com/"+user.getId());
        Users checkExits = userService.getByProperty("facebookId",user.getId());
        if(checkExits == null){
            userService.add(users);
        }
        attributes.addFlashAttribute("imageLink","https://graph.facebook.com/762694757258295/picture?type=square");
        session.setAttribute(session.getId(), users);
        return "redirect:/trang-chu";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(session.getId());
        return "redirect:/trang-chu";
    }

    @RequestMapping(value = "/quen-mat-khau", method = RequestMethod.GET)
    public String forgotPass(Model model) {
        return "quen-mat-khau";
    }

    @RequestMapping(value = "/dang-ki", method = {RequestMethod.GET})
    public String signup(Model model) {

        return "dang-ki";
    }

    @RequestMapping(value = "/dang-ki", method = {RequestMethod.POST})
    public String signup1(@RequestParam(required = false) String email,
                          @RequestParam(required = false) String username,
                          @RequestParam(required = false) String password,
                          @RequestParam(required = false) String re_password, Model model,RedirectAttributes attributes) {
        Users users = new Users();
        Users user = userService.getByEmail(email);
        boolean check = true;
        if (!StringUtils.isBlank(email)) {
            if (!BaseController.checkPattern(PatternUtil.EMAIL, email)) {
                check = false;
            } else {
                if(user!= null){
                    check = false;
                    model.addAttribute("email", "Email đã được sử dụng!");
                }else{
                    users.setEmail(email);
                }
            }
        } else {
            check = false;
            model.addAttribute("email", "Email không được để trống!");
        }

        if (!StringUtils.isBlank(username)) {
            if (username.length() < 6) {
                check = false;
                model.addAttribute("username", "Tài khoản phải dài trên 6 kí tự!");
            } else {
                user = userService.getByUsername(username);
                if(user!= null){
                    check = false;
                    model.addAttribute("username", "Tài khoản đã được sử dụng!");
                }else{
                    users.setUsername(username);
                }

            }
        } else {
            check = false;
            model.addAttribute("username", "Tài khoản không được để trống!");
        }

        if (!StringUtils.isBlank(password)) {
            if (password.length() < 8) {
                check = false;
                model.addAttribute("password", "Mật khẩu phải dài trên 8 kí tự!");
            } else {
                if (!StringUtils.isBlank(re_password)) {
                    if (!re_password.equals(password)) {
                        check = false;
                        model.addAttribute("re_password", "Mật khẩu nhập lại không khớp với trường mật khẩu!");
                    } else {
                        users.setPassword(password);
                    }
                } else {
                    check = false;
                    model.addAttribute("re_password", "Mật khẩu nhập lại không được để trống!");
                }
            }
        } else {
            check = false;
            model.addAttribute("password", "Mật khẩu không được để trống!");
        }
        if (check) {
            userService.add(users);
            attributes.addFlashAttribute("style","info");
            attributes.addFlashAttribute("msg","Đăng kí thành công.");
            return "redirect:/trang-chu";
        } else {
            return "dang-ki";
        }

    }

    @RequestMapping(value = "/tim-mat-khau", method = RequestMethod.POST)
    public String getPass(@RequestParam String email, Model model) {
        Users user = userService.getByEmail(email);
        if (user != null) {
            String generatedString = RandomStringUtils.random(10, true, true);
            //user.setPassword(passwordEncoder.encode(generatedString));
            user.setPassword(generatedString);
            userService.update(user);
            model.addAttribute("style", "info");
            model.addAttribute("msg", "Mật khẩu mới đã được gửi đến email của bạn!");
            return "quen-mat-khau";
        } else {
            model.addAttribute("style", "error");
            model.addAttribute("msg", "Email không thuộc bất cứ tài khoản nào!");
            return "quen-mat-khau";
        }

    }
}
