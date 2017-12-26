package com.bkap.vn.manager.report.controller;

import net.sf.jett.transform.ExcelTransformer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class ReportController  {


    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String report_doanh_so(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> beans = new HashMap<String, Object>();

        try {
            beans.put("tongSoToChuc", 12);
            beans.put("tongPhiCongChung", 10000);
            beans.put("tongThuLaoCongChung", 1000000);
            beans.put("tongSoCongChungVien", 32);
            beans.put("tongSoCongChungVienHopDanh", 15);
            beans.put("tongSoHopDong", 1445);
            beans.put("tongSoCongChungHopGiaoDich", 345);
            beans.put("tongSoCongChungHopDongKhac", 56);

            beans.put("report", "report");
            beans.put("total", "total");
            beans.put("fromdate", "fromdate");
            beans.put("todate", "todate");
            beans.put("agency", "Agecy");
            Date date = new Date(); // your date
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            beans.put("year", year);
            beans.put("month", month);
            beans.put("day", day);

            String realPathOfFolder=request.getServletContext().getRealPath("/WEB-INF/report/");
            InputStream fileIn = null;
            fileIn = new BufferedInputStream(new FileInputStream(realPathOfFolder+"BaoCaoTT04.xlsx"));
            ExcelTransformer transformer = new ExcelTransformer();
            Workbook workbook = transformer.transform(fileIn, beans);
            response.setContentType("application/vnd.ms-excel");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String dateDownload = dateFormat.format(new Date());
            response.setHeader("Content-Disposition", "attachment; filename=" + dateDownload+"_BaoCaoTT04.xlsx");
            ServletOutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return "admin-list";
    }
}
