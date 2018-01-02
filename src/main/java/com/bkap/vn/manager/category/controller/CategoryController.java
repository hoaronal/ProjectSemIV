package com.bkap.vn.manager.category.controller;

import com.bkap.vn.common.entity.Admin;
import com.bkap.vn.common.entity.Category;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.admin.service.AdminService;
import com.bkap.vn.manager.category.service.CategoryService;
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
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("quan-tri/danh-muc")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/{page}", "/danh-sach-danh-muc/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("category") Category category,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = categoryService.generateQuerySearchCategory(keySearch);
        int totalRecord = categoryService.countAll(filter);
        paggingResult = categoryService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("category-list");
        return view;
    }

    @RequestMapping(value = "/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable(value = "id", required = false) int id, @ModelAttribute("category") Category category, Model model, RedirectAttributes attributes, Locale locale) {
        category = categoryService.getById(id);
        if (category != null) {
            List<Category> listCategory = categoryService.listCategory();
            model.addAttribute("listCategory", listCategory);
            model.addAttribute("category", category);
            return "category-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Category not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Danh mục không tồn tại!");
            }
            return "redirect:/quan-tri/danh-muc/1";
        }
    }

    @RequestMapping(value = "/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@RequestParam(value = "re_password",required = false) String rePassword,
                             @ModelAttribute("category") @Valid Category category,
                            RedirectAttributes attributes) {
        Category categoryUpdate = categoryService.getById(category.getId());
        try {
            if (categoryUpdate != null) {

                    category.setUpdateDate(new Date());
                    category.setCreateDate(categoryUpdate.getCreateDate());
                    boolean check = categoryService.update(category);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật danh mục thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật danh mục thất bại!");
                    }
            } else {
                return view("redirect:/quan-tri/danh-muc/danh-sach-danh-muc/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/danh-muc/danh-sach-danh-muc/1");
    }

    @RequestMapping(value = "/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        List<Category> listCategory = categoryService.listCategory();
        model.addAttribute("category", new Category());
        model.addAttribute("listCategory", listCategory);
        return "category-add";
    }

    @RequestMapping(value = "/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute("category") @Valid Category category, RedirectAttributes attributes) {
        if (category != null) {
                category.setUpdateDate(new Date());
                category.setCreateDate(new Date());
                int check = categoryService.add(category);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới danh mục thành công");
                    return view("redirect:/quan-tri/danh-muc/danh-sach-danh-muc/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới danh mục thất bại");
                    return view("redirect:/quan-tri/danh-muc/danh-sach-danh-muc/1");
                }
        } else {
            return view("redirect:/quan-tri/danh-muc/danh-sach-danh-muc/1");
        }
    }

    @RequestMapping(value = "/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Category category = categoryService.getById(id);
            if (category != null) {
                boolean check = categoryService.delete(category);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa danh mục thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa danh mục thất bại, danh mục không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa danh mục thất bại, danh mục không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/danh-muc/1");
        return view;
    }

    public boolean validateAdd(Category category) {
        boolean check = true;
        if (category != null) {

        } else {
            check = false;
        }
        return check;
    }

    public boolean validateUpdate(Category category) {
        boolean check = true;
        if (category != null) {

        } else {
            check = false;
        }
        return check;
    }
}