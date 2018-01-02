package com.bkap.vn.manager.order.controller;


import com.bkap.vn.common.entity.Order;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.order.service.OrderService;
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
@RequestMapping("quan-tri/don-hang")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = {"/{page}", "/danh-sach-don-hang/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("order") @Valid Order order,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = orderService.generateQuerySearchOrder(keySearch);
        int totalRecord = orderService.countAll(filter);
        paggingResult = orderService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("order-list");
        return view;
    }


    @RequestMapping(value = "/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("order") Order order, Model model, RedirectAttributes attributes, Locale locale) {
        order = orderService.getById(id);
        if (order != null) {
            model.addAttribute("order", order);
            return "order-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Order not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "đơn hàng không tồn tại!");
            }
            return "redirect:/quan-tri/don-hang/1";
        }
    }

    @RequestMapping(value = "/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("order") @Valid Order order,
                             RedirectAttributes attributes) {
        Order OrderUpdate = orderService.getById(order.getId());
        try {
            if (OrderUpdate != null) {
                order.setUpdateDate(new Date());
                order.setCreateDate(OrderUpdate.getCreateDate());
                boolean check = orderService.update(order);
                if (check) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Cập nhật đơn hàng thành công");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Cập nhật đơn hàng thất bại!");
                }
            } else {
                return view("redirect:/quan-tri/don-hang/danh-sach-don-hang/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/don-hang/danh-sach-don-hang/1");
    }

    @RequestMapping(value = "/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("order", new Order());
        return "order-add";
    }

    @RequestMapping(value = "/don-hang/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute(value = "order") @Valid Order order, RedirectAttributes attributes) {
        if (order != null) {
            order.setUpdateDate(new Date());
            order.setCreateDate(new Date());
            int check = orderService.add(order);
            if (check > 0) {
                attributes.addFlashAttribute("style", "info");
                attributes.addFlashAttribute("msg", "Thêm mới đơn hàng thành công");
                return view("redirect:/quan-tri/don-hang/1");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Thêm mới đơn hàng thất bại");
                return view("redirect:/quan-tri/don-hang/1");
            }
        } else {
            return view("redirect:/quan-tri/don-hang/1");
        }
    }

    @RequestMapping(value = "/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Order Order = orderService.getById(id);
            if (Order != null) {
                boolean check = orderService.delete(Order);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa đơn hàng thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa đơn hàng thất bại, đơn hàng không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa đơn hàng thất bại, đơn hàng không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/don-hang/1");
        return view;
    }
}
