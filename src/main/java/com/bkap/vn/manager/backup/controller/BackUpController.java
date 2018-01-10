package com.bkap.vn.manager.backup.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

@Controller
@RequestMapping("quan-tri")
public class BackUpController {

    @Value("${backup.root}")
    private String BACKUP_ROOT;

    @Value("${backup.url}")
    private String URL;

    @Value("${backup.user}")
    private String USER;

    @Value("${backup.password}")
    private String PASSWORD;

    @RequestMapping(value = "/sao-luu-du-lieu", method = RequestMethod.GET)
    public String backup() {
        return "backup";
    }

    @RequestMapping(value = "/sao-luu", method = RequestMethod.POST)
    public String doBackUp(Model model, HttpServletRequest request) {
        Connection conn = null;
        String path = request.getPathInfo();
        String path1 = request.getServletPath();
        String path2 = request.getContextPath();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            String strSelect = "BACKUP DATABASE shop_online  \n" +
                    " TO DISK = '" + BACKUP_ROOT + new Date().getTime()+".Bak'" + "  \n" +
                    "   WITH FORMAT,  \n" +
                    "      MEDIANAME = 'Z_SQLServerBackups',  \n" +
                    "      NAME = 'Full Backup of shop_online';";
            stmt.execute(strSelect);
            model.addAttribute("style", "info");
            model.addAttribute("msg", "Sao lưu dữ liệu thành công.");
        } catch (SQLException e) {
            model.addAttribute("style", "danger");
            model.addAttribute("msg", "Sao lưu dữ liệu thất bại.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            model.addAttribute("style", "danger");
            model.addAttribute("msg", "Sao lưu dữ liệu thất bại.");
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "backup";
    }

}
