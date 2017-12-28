package com.bkap.vn.manager.gift.controller;


import com.bkap.vn.common.entity.Gift;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.gift.service.GiftService;
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
public class GiftController extends BaseController {

    @Autowired
    private GiftService giftService;

    @RequestMapping(value = {"/qua-tang/{page}", "/qua-tang/danh-sach-qua-tang/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("Role") Role Role,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult, HttpServletRequest request, HttpServletResponse response) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = giftService.generateQuerySearchRole(keySearch);
        int totalRecord = giftService.countAll(filter);
        paggingResult = giftService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("gift-list");
        return view;
    }


    @RequestMapping(value = "/qua-tang/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("gift") Gift gift, Model model, RedirectAttributes attributes, Locale locale) {
        gift = giftService.getById(id);
        if (gift != null) {
            model.addAttribute("gift", gift);
            return "gift-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Role not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Quyền không tồn tại!");
            }
            return "redirect:/quan-tri/qua-tang/1";
        }
    }

    @RequestMapping(value = "/qua-tang/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("gift") @Valid Gift gift,
                             BindingResult result, RedirectAttributes attributes) {
        Gift giftUpdate = giftService.getById(gift.getId());
        try {
            if (giftUpdate != null) {
                if (result.hasErrors()) {
                    return view("gift-edit", gift, "gift", "Cập nhật thông tin quà tặng thất bại!", "danger");
                } else {
                    gift.setUpdateDate(new Date());
                    gift.setCreateDate(giftUpdate.getCreateDate());
                /*role.setAdminByAdminUpdate(new Admin());
                role.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = giftService.update(gift);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật thông tin quà tặng thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật thông tin quà tặng thất bại!");
                    }
                }
            } else {
                return view("redirect:/quan-tri/qua-tang/danh-sach-qua-tang/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/qua-tang/danh-sach-qua-tang/1");
    }

    @RequestMapping(value = "/qua-tang/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("gift", new Gift());
        return "gift-add";
    }

    @RequestMapping(value = "/qua-tang/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute(value = "gift") @Valid Gift gift,
                            BindingResult result, HttpServletRequest request,
                            HttpServletResponse response, RedirectAttributes attributes) {
        if (gift != null) {
            if (result.hasErrors()) {
                return view("gift-add", gift, "gift", "Thêm mới quà tặng thất bại!", "danger");
            } else {
                gift.setUpdateDate(new Date());
                gift.setCreateDate(new Date());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(new Admin());*/
                int check = giftService.add(gift);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới quà tặng thành công");
                    return view("redirect:/quan-tri/qua-tang/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới quà tặng thất bại");
                    return view("redirect:/quan-tri/qua-tang/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/qua-tang/1");
        }
    }

    @RequestMapping(value = "/qua-tang/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Gift gift = giftService.getById(id);
            if (gift != null) {
                boolean check = giftService.delete(gift);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa quà tặng thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa quà tặng thất bại, quà tặng không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa quà tặng thất bại,  quà tặng không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/qua-tang/1");
        return view;
    }


}
