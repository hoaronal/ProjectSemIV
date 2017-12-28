package com.bkap.vn.manager.accessories.controller;


import com.bkap.vn.common.entity.Accessories;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.accessories.service.AccessoriesService;
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
public class AccessoriesController extends BaseController {

    @Autowired
    private AccessoriesService accessoriesService;


    @RequestMapping(value = {"/phu-kien/{page}", "/phu-kien/danh-sach-phu-kien/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("accessories") Accessories accessories,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult, HttpServletRequest request, HttpServletResponse response) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = accessoriesService.generateQuerySearchAccessories(keySearch);
        int totalRecord = accessoriesService.countAll(filter);
        paggingResult = accessoriesService.findRange(currentPage, 10, filter);
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("accessories-list");
        return view;
    }


    @RequestMapping(value = "/phu-kien/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("accessories") Accessories accessories, Model model, RedirectAttributes attributes, Locale locale) {
        accessories = accessoriesService.getById(id);
        if (accessories != null) {
            model.addAttribute("accessories", accessories);
            return "accessories-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Accessories not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Phụ kiện không tồn tại!");
            }
            return "redirect:/quan-tri/phu-kien/1";
        }
    }

    @RequestMapping(value = "/phu-kien/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("accessories") @Valid Accessories accessories,
                             BindingResult result, RedirectAttributes attributes) {
        Accessories AccessoriesUpdate = accessoriesService.getById(accessories.getId());
        try {
            if (AccessoriesUpdate != null) {
                if (result.hasErrors()) {
                    return view("accessories-edit", accessories, "accessories", "Cập nhật Phụ kiện thất bại!", "danger");
                } else {
                    accessories.setUpdateDate(new Date());
                    accessories.setCreateDate(AccessoriesUpdate.getCreateDate());
                /*Accessories.setAdminByAdminUpdate(new Admin());
                Accessories.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = accessoriesService.update(accessories);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật Phụ kiện thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật Phụ kiện thất bại!");
                    }
                }
            } else {
                return view("redirect:/quan-tri/phu-kien/danh-sach-phu-kien/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/phu-kien/danh-sach-phu-kien/1");
    }

    @RequestMapping(value = "/phu-kien/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("accessories", new Accessories());
        return "accessories-add";
    }

    @RequestMapping(value = "/phu-kien/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute(value = "accessories") @Valid Accessories accessories,
                            BindingResult result, HttpServletRequest request,
                            HttpServletResponse response, RedirectAttributes attributes) {
        if (accessories != null) {
            if (result.hasErrors()) {
                return view("accessories-add", accessories, "accessories", "Thêm mới Phụ kiện thất bại!", "danger");
            } else {
                accessories.setUpdateDate(new Date());
                accessories.setCreateDate(new Date());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(new Admin());*/
                int check = accessoriesService.add(accessories);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới Phụ kiện thành công");
                    return view("redirect:/quan-tri/phu-kien/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới Phụ kiện thất bại");
                    return view("redirect:/quan-tri/phu-kien/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/phu-kien/1");
        }
    }

    @RequestMapping(value = "/phu-kien/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Accessories Accessories = accessoriesService.getById(id);
            if (Accessories != null) {
                boolean check = accessoriesService.delete(Accessories);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa Phụ kiện thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa Phụ kiện thất bại, Phụ kiện không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa Phụ kiện thất bại, Phụ kiện không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/phu-kien/1");
        return view;
    }


}
