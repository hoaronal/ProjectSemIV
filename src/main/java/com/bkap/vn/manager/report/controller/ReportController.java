package com.bkap.vn.manager.report.controller;

import com.bkap.vn.manager.order.service.OrderService;
import net.sf.jett.transform.ExcelTransformer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("quan-tri")
public class ReportController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/bao-cao", method = RequestMethod.GET)
    public String report_doanh_so(HttpServletRequest request, HttpServletResponse response) {
        Integer thang1 = orderService.countByMonth("2018-01-01", "2018-01-31");
        Integer thang2 = orderService.countByMonth("2018-02-01", "2018-02-28");
        Integer thang3 = orderService.countByMonth("2018-03-01", "2018-03-31");
        Integer thang4 = orderService.countByMonth("2018-04-01", "2018-04-30");
        Integer thang5 = orderService.countByMonth("2018-05-01", "2018-05-31");
        Integer thang6 = orderService.countByMonth("2018-06-01", "2018-06-30");
        Integer thang7 = orderService.countByMonth("2018-07-01", "2018-07-31");
        Integer thang8 = orderService.countByMonth("2018-08-01", "2018-08-31");
        Integer thang9 = orderService.countByMonth("2018-09-01", "2018-09-30");
        Integer thang10 = orderService.countByMonth("2018-10-01", "2018-10-31");
        Integer thang11 = orderService.countByMonth("2018-11-01", "2018-11-30");
        Integer thang12 = orderService.countByMonth("2018-12-01", "2018-12-31");
        try {
            Map<String, Object> beans = new HashMap<String, Object>();
            beans.put("thang1", thang1);
            beans.put("thang2", thang2);
            beans.put("thang3", thang3);
            beans.put("thang4", thang4);
            beans.put("thang5", thang5);
            beans.put("thang6", thang6);
            beans.put("thang7", thang7);
            beans.put("thang8", thang8);
            beans.put("thang9", thang9);
            beans.put("thang10", thang10);
            beans.put("thang11", thang11);
            beans.put("thang12", thang12);
            String realPathOfFolder = request.getServletContext().getRealPath("/WEB-INF/report/");
            InputStream fileIn = null;
            fileIn = new BufferedInputStream(new FileInputStream(realPathOfFolder + "BaoCaoDoanhSo.xlsx"));
            ExcelTransformer transformer = new ExcelTransformer();
            Workbook workbook = transformer.transform(fileIn, beans);
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String dateDownload = dateFormat.format(new Date());
            response.setHeader("Content-Disposition", "attachment; filename=" + dateDownload + "_BaoCaoDoanhSo.xlsx");
            ServletOutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin-list";
    }

    @RequestMapping(value = "/thong-ke-doanh-so", method = RequestMethod.GET)
    public String doanh_so(Model model, HttpServletRequest request, HttpServletResponse response) {
        Integer thang1 = orderService.countByMonth("2018-01-01", "2018-01-31");
        Integer thang2 = orderService.countByMonth("2018-02-01", "2018-02-28");
        Integer thang3 = orderService.countByMonth("2018-03-01", "2018-03-31");
        Integer thang4 = orderService.countByMonth("2018-04-01", "2018-04-30");
        Integer thang5 = orderService.countByMonth("2018-05-01", "2018-05-31");
        Integer thang6 = orderService.countByMonth("2018-06-01", "2018-06-30");
        Integer thang7 = orderService.countByMonth("2018-07-01", "2018-07-31");
        Integer thang8 = orderService.countByMonth("2018-08-01", "2018-08-31");
        Integer thang9 = orderService.countByMonth("2018-09-01", "2018-09-30");
        Integer thang10 = orderService.countByMonth("2018-10-01", "2018-10-31");
        Integer thang11 = orderService.countByMonth("2018-11-01", "2018-11-30");
        Integer thang12 = orderService.countByMonth("2018-12-01", "2018-12-31");
        model.addAttribute("thang1", thang1);
        model.addAttribute("thang2", thang2);
        model.addAttribute("thang3", thang3);
        model.addAttribute("thang4", thang4);
        model.addAttribute("thang5", thang5);
        model.addAttribute("thang6", thang6);
        model.addAttribute("thang7", thang7);
        model.addAttribute("thang8", thang8);
        model.addAttribute("thang9", thang9);
        model.addAttribute("thang10", thang10);
        model.addAttribute("thang11", thang11);
        model.addAttribute("thang12", thang12);
        return "report";
    }

    @RequestMapping(value = "/thong-ke-doanh-so-theo-thang", method = RequestMethod.POST)
    public @ResponseBody
    String doanh(Model model, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("sdsdsdsds");
        return "{29, 71, 116, 60, 44, 17, 38, 51, 66, 100,44, 89, 22}";
    }

}
