package com.bkap.vn.manager.history_action.controller;


import com.bkap.vn.common.entity.HistoryAction;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.history_action.service.HistoryActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("quan-tri/lich-su-he-thong")
public class HistoryActionController extends BaseController {

    @Autowired
    private HistoryActionService historyActionService;

    @RequestMapping(value = {"/{page}", "/danh-sach-lich-su-he-thong/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("historyAction") HistoryAction historyAction,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult, HttpServletRequest request, HttpServletResponse response) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = historyActionService.generateQuerySearchHistoryAction(keySearch);
        int totalRecord = historyActionService.countAll(filter);
        paggingResult = historyActionService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("historyAction-list");
        return view;
    }

    @RequestMapping(value = "/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            HistoryAction historyAction = historyActionService.getById(id);
            if (historyAction != null) {
                boolean check = historyActionService.delete(historyAction);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa lịch sử thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa lịch sử thất bại, lịch sử không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa lịch sử thất bại, lịch sử không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/lich-su-he-thong/1");
        return view;
    }


}
