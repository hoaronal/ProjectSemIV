package com.bkap.vn.manager.transaction.controller;


import com.bkap.vn.common.entity.Transaction;
import com.bkap.vn.common.entity.Transaction;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.transaction.service.TransactionService;
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
@RequestMapping("quan-tri/giao-dich")
public class TransactionController extends BaseController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = {"/{page}", "/danh-sach-giao-dich/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("transaction") Transaction transaction,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = transactionService.generateQuerySearchTransaction(keySearch);
        int totalRecord = transactionService.countAll();
        paggingResult = transactionService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("transaction-list");
        return view;
    }

}
