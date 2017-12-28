package com.bkap.vn.manager.news.controller;


import com.bkap.vn.common.entity.News;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.common.util.StringUtil;
import com.bkap.vn.manager.news.service.NewsService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("quan-tri")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/tin-tuc/{page}", "/tin-tuc/danh-sach-tin-tuc/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("news") News news,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult, HttpServletRequest request, HttpServletResponse response) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        List<News> newList = new ArrayList<>();
        ModelAndView view = new ModelAndView();
        String filter = newsService.generateQuerySearchNews(keySearch);
        int totalRecord = newsService.countAll(filter);
        paggingResult = newsService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        List<News> newsList = (List<News>) paggingResult.getItem();
        for(News n : newsList){
            n.setDescription(StringUtil.html2text(n.getDescription()));
            newList.add(n);
        }
        paggingResult.setItem(newList);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("news-list");
        return view;
    }


    @RequestMapping(value = "/tin-tuc/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("news") News news, Model model, RedirectAttributes attributes, Locale locale) {
        news = newsService.getById(id);
        if (news != null) {
            model.addAttribute("news", news);
            return "news-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "News not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Tin không tồn tại!");
            }
            return "redirect:/quan-tri/tin-tuc/1";
        }
    }

    @RequestMapping(value = "/tin-tuc/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("news") @Valid News news,
                             BindingResult result, RedirectAttributes attributes) {
        News NewsUpdate = newsService.getById(news.getId());
        try {
            if (NewsUpdate != null) {
                if (result.hasErrors()) {
                    return view("news-edit", news, "news", "Cập nhật Tin thất bại!", "danger");
                } else {
                    news.setUpdateDate(new Date());
                    news.setCreateDate(NewsUpdate.getCreateDate());
                /*News.setAdminByAdminUpdate(new Admin());
                News.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = newsService.update(news);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật Tin thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật Tin thất bại!");
                    }
                }
            } else {
                return view("redirect:/quan-tri/tin-tuc/danh-sach-tin-tuc/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/tin-tuc/danh-sach-tin-tuc/1");
    }

    @RequestMapping(value = "/tin-tuc/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("news", new News());
        return "news-add";
    }

    @RequestMapping(value = "/tin-tuc/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute(value = "news") @Valid News news,
                            BindingResult result, HttpServletRequest request,
                            HttpServletResponse response, RedirectAttributes attributes) {
        if (news != null) {
            if (result.hasErrors()) {
                return view("news-add", news, "news", "Thêm mới Tin thất bại!", "danger");
            } else {
                news.setUpdateDate(new Date());
                news.setCreateDate(new Date());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(new Admin());*/
                int check = newsService.add(news);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới Tin thành công");
                    return view("redirect:/quan-tri/tin-tuc/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới Tin thất bại");
                    return view("redirect:/quan-tri/tin-tuc/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/tin-tuc/1");
        }
    }

    @RequestMapping(value = "/tin-tuc/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            News news = newsService.getById(id);
            if (news != null) {
                boolean check = newsService.delete(news);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa Tin thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa Tin thất bại, Tin không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa Tin thất bại, Tin không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/tin-tuc/1");
        return view;
    }


}
