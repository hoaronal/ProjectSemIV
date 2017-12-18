package com.bkap.vn.manager.province.controller;


import com.bkap.vn.common.entity.Province;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.province.service.ProvinceService;
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
public class ProvinceController extends BaseController {

    @Autowired
    private ProvinceService ProvinceService;

    @RequestMapping(value = {"/tinh-thanh/{page}", "/tinh-thanh/danh-sach-tinh-thanh/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("Province") Province Province,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult, HttpServletRequest request, HttpServletResponse response) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = ProvinceService.generateQuerySearchProvince(keySearch);
        int totalRecord = ProvinceService.countAll(filter);
        paggingResult = ProvinceService.findRange(currentPage, 10, filter);
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("province-list");
        return view;
    }


    @RequestMapping(value = "/tinh-thanh/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("province") Province province, Model model, RedirectAttributes attributes, Locale locale) {
        province = ProvinceService.getById(id);
        if (province != null) {
            model.addAttribute("province", province);
            return "province-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Province not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Tỉnh thành không tồn tại!");
            }
            return "redirect:/quan-tri/tinh-thanh/1";
        }
    }

    @RequestMapping(value = "/tinh-thanh/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("province") @Valid Province province,
                             BindingResult result, RedirectAttributes attributes) {
        Province ProvinceUpdate = ProvinceService.getById(province.getId());
        try {
            if (ProvinceUpdate != null) {
                if (result.hasErrors()) {
                    return view("province-edit", province, "province", "Cập nhật Tỉnh thành thất bại!", "danger");
                } else {
                    province.setUpdateDate(new Date());
                    province.setCreateDate(ProvinceUpdate.getCreateDate());
                /*Province.setAdminByAdminUpdate(new Admin());
                Province.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = ProvinceService.update(province);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật Tỉnh thành thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật Tỉnh thành thất bại!");
                    }
                }
            } else {
                return view("redirect:/quan-tri/tinh-thanh/danh-sach-tinh-thanh/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/tinh-thanh/danh-sach-tinh-thanh/1");
    }

    @RequestMapping(value = "/tinh-thanh/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("province", new Province());
        return "province-add";
    }

    @RequestMapping(value = "/tinh-thanh/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute(value = "province") @Valid Province province,
                            BindingResult result, HttpServletRequest request,
                            HttpServletResponse response, RedirectAttributes attributes) {
        if (province != null) {
            if (result.hasErrors()) {
                return view("province-add", province, "province", "Thêm mới Tỉnh thành thất bại!", "danger");
            } else {
                province.setUpdateDate(new Date());
                province.setCreateDate(new Date());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(new Admin());*/
                int check = ProvinceService.add(province);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới Tỉnh thành thành công");
                    return view("redirect:/quan-tri/tinh-thanh/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới Tỉnh thành thất bại");
                    return view("redirect:/quan-tri/tinh-thanh/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/tinh-thanh/1");
        }
    }

    @RequestMapping(value = "/tinh-thanh/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Province province = ProvinceService.getById(id);
            if (province != null) {
                boolean check = ProvinceService.delete(province);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa Tỉnh thành thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa Tỉnh thành thất bại, Tỉnh thành không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa Tỉnh thành thất bại, Tỉnh thành không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/tinh-thanh/1");
        return view;
    }


}
