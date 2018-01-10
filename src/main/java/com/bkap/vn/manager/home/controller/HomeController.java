package com.bkap.vn.manager.home.controller;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.HistoryAction;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.admin.service.AdminService;
import com.bkap.vn.manager.history_action.service.HistoryActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("quan-tri")
public class HomeController extends BaseController {

    @Autowired
    HistoryActionService historyActionService;

    @Autowired
    private AdminService adminService;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String home(Model model,Authentication authentication){
        authentication.getPrincipal();
        model.addAttribute("loggedinuser", getPrincipal());
        return "home-administrator";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        HistoryAction historyAction = new HistoryAction();
        Admin adminLogin = adminService.getByAcount(getPrincipal());
        try {
            if (isCurrentAuthenticationAnonymous()) {
                return "login";
            } else {
                return "redirect:/quan-tri";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "login";
        }
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Admin adminLogin = adminService.getByAcount(getPrincipal());
        if (auth != null){
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        HistoryAction historyAction = new HistoryAction();
        historyAction.setClientInfo(BaseController.getClientIp(request));
        historyAction.setAccessType("LOGOUT");
        historyAction.setExecuteDate(new Date());
        historyAction.setDescription("Đăng Xuất");
        historyAction.setAdmin(adminLogin);
        historyActionService.add(historyAction);
        return "redirect:/quan-tri/login?logout";
    }


    @RequestMapping(value="/chat", method = RequestMethod.GET)
    public String chat(HttpServletRequest request, HttpServletResponse response){
        return "chat";
    }
    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}
