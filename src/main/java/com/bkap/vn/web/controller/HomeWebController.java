package com.bkap.vn.web.controller;


import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.entity.Users;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.Constant;
import com.bkap.vn.manager.category.service.CategoryService;
import com.bkap.vn.manager.product.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class HomeWebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"", "/trang-chu"}, method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request) {
        List<Product> newProductList = productService.getNewProduct();
        List<Product> saleProductList = productService.getProductByFilter(" where discount != '' ORDER BY id OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY ");
        List<Product> newProductList1 = productService.getProductByFilter(" ORDER BY id DESC OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY ");
        List<Product> viewMostProductList = productService.getProductByFilter(" ORDER BY count_view DESC OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY ");
        model.addAttribute("newProductList", newProductList);
        model.addAttribute("newProductList1", newProductList1);
        model.addAttribute("saleProductList", saleProductList);
        model.addAttribute("viewMostProductList", viewMostProductList);
        model.addAttribute("category", "trang-chu");
        Integer numProductInCart = (Integer) request.getSession().getAttribute("NUM_IN_CART");
        if(numProductInCart != null){
            request.getSession().setAttribute("NUM_IN_CART", numProductInCart);
        }else{
            request.getSession().setAttribute("NUM_IN_CART", 0);
        }
        return "home-web";
    }



    @RequestMapping(value = {"/tim-kiem"}, method = RequestMethod.POST)
    public String search(Model model,@RequestParam(required = false) int page, @RequestParam(required = false) String keySearch, @RequestParam(required = false) int categoryId, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users user = new Users();
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = 0;
        StringBuilder filter = new StringBuilder(" WHERE 1=1");
        if(categoryId > 0){
            totalRecord = productService.countAllByCategory(categoryId);
            filter.append(" AND category_id = " + categoryId);
        }else{
            totalRecord = productService.countAll("");
        }
        if(!StringUtils.isBlank(keySearch)){
            filter.append(" AND product_name like N'%" + keySearch + "%'");
        }
        filter.append(" ORDER BY id DESC ");
        PaggingResult paggingResult = productService.findRange(page, 12, filter.toString());
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("keySearch", keySearch);
        model.addAttribute("page", page);
        model.addAttribute("productList", paggingResult);
        model.addAttribute("category", arrUrl[1]);
        return "search-list";
    }

    @RequestMapping(value = {"/san-pham/dien-thoai/{page}"}, method = RequestMethod.GET)
    public String listPhone(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_PHONE);
        PaggingResult paggingResult = productService.findRange(page, 12, " WHERE category_id = " + Constant.CATEGORY.TYPE_PHONE + " ORDER BY id DESC ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList", paggingResult);
        model.addAttribute("category", arrUrl[3]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/may-tinh/{page}"}, method = RequestMethod.GET)
    public String listPC(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_PC);
        PaggingResult paggingResult = productService.findRange(page, 12, " WHERE category_id = " + Constant.CATEGORY.TYPE_PC + " ORDER BY id DESC ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList", paggingResult);
        model.addAttribute("category", arrUrl[3]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/phu-kien/{page}"}, method = RequestMethod.GET)
    public String listAccessories(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_ACCESSORIES);
        PaggingResult paggingResult = productService.findRange(page, 12, " WHERE category_id = " + Constant.CATEGORY.TYPE_ACCESSORIES + " ORDER BY id DESC ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList", paggingResult);
        model.addAttribute("category", arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/lap-top/{page}"}, method = RequestMethod.GET)
    public String listLaptop(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_LAPTOP);
        PaggingResult paggingResult = productService.findRange(page, 12, " WHERE category_id = " + Constant.CATEGORY.TYPE_LAPTOP + " ORDER BY id DESC ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList", paggingResult);
        model.addAttribute("category", arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/giam-gia/{page}"}, method = RequestMethod.GET)
    public String listSale(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        int totalRecord = productService.countAllByCategory(Constant.CATEGORY.TYPE_LAPTOP);
        PaggingResult paggingResult = productService.findRange(page, 12, " WHERE discount != '' ORDER BY id DESC ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList", paggingResult);
        model.addAttribute("category", arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/xem-nhieu/{page}"}, method = RequestMethod.GET)
    public String viewMore(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        String filter = productService.generateQuerySearchProduct("");
        int totalRecord = productService.countAll(filter);
        PaggingResult paggingResult = productService.findRange(page, 12, filter + " ORDER BY count_view DESC ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList", paggingResult);
        model.addAttribute("category", arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = {"/san-pham/hang-moi/{page}"}, method = RequestMethod.GET)
    public String newProduct(@PathVariable("page") int page, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrUrl = request.getRequestURI().split("/");
        String filter = productService.generateQuerySearchProduct("");
        int totalRecord = productService.countAll(filter);
        PaggingResult paggingResult = productService.findRange(page, 12, filter + " ORDER BY id DESC ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(page);
        paggingResult.paging();
        model.addAttribute("productList", paggingResult);
        model.addAttribute("category", arrUrl[2]);
        return "product-web-list";
    }

    @RequestMapping(value = "/san-pham/chi-tiet/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") int id, Model model, RedirectAttributes attributes) {
        Product product = productService.getById(id);
        PaggingResult paggingResult = productService.findRange(1, 10, " WHERE category_id = " + product.getCategory().getId() + " ORDER BY id DESC ");
        if (product != null) {
            product.setCountView(product.getCountView() + 1);
            productService.update(product);
            if (!StringUtils.isBlank(product.getImageList())) {
                String[] listImg = product.getImageList().split(",");
                model.addAttribute("listImg", listImg);
            }
        }else{
            attributes.addFlashAttribute("style","error");
            attributes.addFlashAttribute("msg","Không tìm thấy sản phẩm!");
            return "redirect:/trang-chu";
        }
        model.addAttribute("productList", paggingResult);
        model.addAttribute("product", product);
        return "product-web-detail";
    }
}