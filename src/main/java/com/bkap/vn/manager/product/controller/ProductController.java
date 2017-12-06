package com.bkap.vn.manager.product.controller;


import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.product.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("quan-tri")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/san-pham/{page}", "/san-pham/danh-sach-san-pham/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("product") Product product, String clickSearch, @PathVariable("page") int page, PaggingResult paggingResult, String keySearch, Model model, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        String path = request.getServletPath();
        String contextPath = request.getContextPath();
        String queryString = request.getQueryString();
        keySearch = request.getParameter("keySearch");
        if (page <= 1) {
            page = 1;
        }
        paging(paggingResult, page, keySearch);
        view.addObject("keySearch", keySearch);
        view.addObject("clickSearch", clickSearch);
        view.addObject("searchUrl", contextPath + path + "?" + queryString);
        view.addObject("listItem", paggingResult);
        view.setViewName("product-list");
        return view;
    }


    @RequestMapping(value = "/san-pham/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("product") Product product, Model model, RedirectAttributes attributes, Locale locale) {
        product = productService.getById(id);
        /*System.out.println(locale.getLanguage());*/
        if (product != null) {
            model.addAttribute("product", product);
            return "product-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Product not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Sản phẩm không tồn tại!");
            }
            return "redirect:/quan-tri/san-pham/1";
        }
    }

    @RequestMapping(value = "/san-pham/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("product") @Valid Product product, BindingResult result, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes) {
        Product productUpdate = productService.getById(product.getId());
        try{
            if (productUpdate != null) {
                if (result.hasErrors() && !validateUpdate(product)) {
                    return view("product-edit", product, "product");
                } else {
                    /*if(StringUtils.isBlank(user.getPassword())){
                        product.setPassword(userUpdate.getPassword());
                    }else{
                        product.setPassword(user.getPassword());
                    }*/
                    product.setUpdateDate(new Date());
                    product.setCreateDate(productUpdate.getCreateDate());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = productService.update(product);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Thất bại");
                    }
                }
            } else {
                return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/nguoi-dung/danh-sach-nguoi-dung/1");
    }

    @RequestMapping(value = "/san-pham/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("user", new Users());
        return "user-add";
    }

    @RequestMapping(value = "/san-pham/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute("product") @Valid Product product, BindingResult result, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes) {
        if (product != null) {
            if (result.hasErrors() && !validateUpdate(product)) {
                return view("product-add", product, "product");
            } else {
                product.setUpdateDate(new Date());
                product.setCreateDate(new Date());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(new Admin());*/
                product.setStatus((byte) 1);
                int check = productService.add(product);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới sản phẩm thành công");
                    return view("redirect:/quan-tri/san-pham/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới sản phẩm thất bại");
                    return view("redirect:/quan-tri/san-pham/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/san-pham/1");
        }
    }

    @RequestMapping(value = "/san-pham/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            Product product = productService.getById(id);
            if (product != null) {
                boolean check = productService.delete(product);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa sản phẩm thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa sản phẩm thất bại, sản phẩm không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa sản phẩm thất bại, sản phẩm không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/san-pham/1");
        return view;
    }


    public PaggingResult paging(PaggingResult paggingResult, int page, String keySearch) {
        try {
            if (StringUtils.isBlank(keySearch)) {
                int totalRecord = productService.countAll();
                int totalPages = (totalRecord / paggingResult.getRowsPerPage()) + ((totalRecord % paggingResult.getRowsPerPage() != 0) ? 1 : 0);
                paggingResult.setCurrentPage(page);
                paggingResult.setTotalRecord(totalRecord);
                int firstRecord = (page - 1) * paggingResult.getRowsPerPage();
                int maxRecord = paggingResult.getRowsPerPage();
                List<Product> userList = productService.findRange(firstRecord, maxRecord, generateQuerySearchProduct(keySearch));
                paggingResult.setItem(userList);
                paggingResult.paging(page, totalPages, totalRecord, paggingResult.getRowsPerPage(), firstRecord, paggingResult.getPageRange());
            } else {
                int totalRecord = productService.countAllByKeySearch(generateQuerySearchProduct(keySearch));
                int totalPages = (totalRecord / paggingResult.getRowsPerPage()) + ((totalRecord % paggingResult.getRowsPerPage() != 0) ? 1 : 0);
                paggingResult.setCurrentPage(page);
                paggingResult.setTotalRecord(totalRecord);
                int firstRecord = (page - 1) * paggingResult.getRowsPerPage();
                int maxRecord = paggingResult.getRowsPerPage();
                List<Product> userList = productService.findRange(firstRecord, maxRecord, generateQuerySearchProduct(keySearch));
                paggingResult.setItem(userList);
                paggingResult.paging(page, totalPages, totalRecord, paggingResult.getRowsPerPage(), firstRecord, paggingResult.getPageRange());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paggingResult;
    }

    public boolean validateUpdate(Product product) {
        boolean check = true;

        return check;
    }

    public String generateQuerySearchProduct(String keySearch) {
        StringBuilder sql = new StringBuilder(" where 1=1");
        /*if (!StringUtils.isBlank(keySearch)) {
            sql.append(" and username like N'%" + keySearch + "%'")
                    .append(" or email like N'%" + keySearch + "%'")
                    .append(" or phone like N'%" + keySearch + "%'")
                    .append(" or address like N'%" + keySearch + "%'");
            return sql.toString();
        } else {
            return " where 1=1";
        }*/
        return " where 1=1";
    }
}
