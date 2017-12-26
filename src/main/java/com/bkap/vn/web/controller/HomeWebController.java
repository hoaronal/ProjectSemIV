package com.bkap.vn.web.controller;


import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.Constant;
import com.bkap.vn.manager.category.service.CategoryService;
import com.bkap.vn.manager.gift.service.GiftService;
import com.bkap.vn.manager.product.service.ProductService;
import com.bkap.vn.manager.product_gift.service.ProductGiftService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeWebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GiftService giftService;

    @Autowired
    private ProductGiftService productGiftService;

    @RequestMapping(value = {"", "/trang-chu"}, method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {
        model.addAttribute("category","trang-chu");
        List<Product> newProductList = productService.getNewProduct();
        List<Product> saleProductList = productService.getSaleProduct(" where discount != '' ORDER BY id OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY ");
        model.addAttribute("newProductList", newProductList);
        model.addAttribute("saleProductList", saleProductList);
        model.addAttribute("newProductList", newProductList);
        return "home-web";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(Model model, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users user = new Users();

        session.setAttribute("userLogin", user);
        return "home-web";
    }

    @RequestMapping(value = {"/san-pham/dien-thoai/{page}"}, method = RequestMethod.GET)
    public String listPhone(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_PHONE);
        PaggingResult paggingResult = productService.findRange(page, 10, " WHERE category_id = " + Constant.CATEGORY.TYPE_PHONE);
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList",paggingResult);
        model.addAttribute("category",arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/may-tinh/{page}"}, method = RequestMethod.GET)
    public String listPC(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_PC);
        PaggingResult paggingResult = productService.findRange(page, 10, " WHERE category_id = " + Constant.CATEGORY.TYPE_PC);
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList",paggingResult);
        model.addAttribute("category",arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/phu-kien/{page}"}, method = RequestMethod.GET)
    public String listAccessories(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_ACCESSORIES);
        PaggingResult paggingResult = productService.findRange(page, 10, " WHERE category_id = " + Constant.CATEGORY.TYPE_ACCESSORIES);
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList",paggingResult);
        model.addAttribute("category",arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/lap-top/{page}"}, method = RequestMethod.GET)
    public String listLaptop(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_LAPTOP);
        PaggingResult paggingResult = productService.findRange(page, 10, " WHERE category_id = " + Constant.CATEGORY.TYPE_LAPTOP);
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList",paggingResult);
        model.addAttribute("category",arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = "/san-pham/chi-tiet/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") int id, Model model) {
        Product product = productService.getById(id);
        if (!StringUtils.isBlank(product.getImageList())) {
            String[] listImg = product.getImageList().split(",");
            model.addAttribute("listImg", listImg);
        }
        model.addAttribute("product", product);
        return "product-web-detail";
    }
}