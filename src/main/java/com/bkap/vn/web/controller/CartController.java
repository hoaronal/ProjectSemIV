package com.bkap.vn.web.controller;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.manager.product.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class CartController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/gio-hang"}, method = RequestMethod.GET)
    public String cart(Model model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, List<Product>> map = (Map<String, List<Product>>) request.getSession().getAttribute("CART");
        List<Product> products = new ArrayList<>();
        int subtotal = 0;
        if (map != null) {
            for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
                products.add(entry.getValue().get(0));
                subtotal += entry.getValue().size() * Integer.parseInt(entry.getValue().get(0).getPrice());
            }
        }

        model.addAttribute("listProduct", products);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("map", map);
        return "cart";
    }

    @RequestMapping(value = {"/gio-hang/xoa/{code}"}, method = RequestMethod.GET)
    public String cartRemove(@PathVariable String code, Model model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, List<Product>> map = (Map<String, List<Product>>) request.getSession().getAttribute("CART");
        map.remove(code);
        List<Product> products = new ArrayList<>();
        int numProductInCart = 0;
        if (map != null) {
            for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
                products.add(entry.getValue().get(0));
                numProductInCart += entry.getValue().size();
            }
        }

        request.getSession().removeAttribute("CART");
        request.getSession().setAttribute("CART", map);
        request.getSession().setAttribute("NUM_IN_CART", numProductInCart);
        model.addAttribute("listProduct", products);
        model.addAttribute("map", map);
        return "cart";
    }

    @RequestMapping(value = {"/cap-nhat-gio-hang"}, method = {RequestMethod.POST})
    public String addcart(@RequestParam(required = false) String value, Model model, HttpServletRequest request, HttpServletResponse response) {
        String[] arrValue = value.split(",");
        Map<String, List<Product>> map = (Map<String, List<Product>>) request.getSession().getAttribute("CART");
        List<List<Product>> list = new ArrayList<>();
        Map<String, List<Product>> map1 = new HashMap<>();
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        for (int i = 0; i < arrValue.length; i++) {
            int sizelist = list.get(i).size();
            int sizearr = Integer.parseInt(arrValue[i]);
            if (sizelist > sizearr) {
                int range = sizelist - sizearr;
                for (int j = 0; j < range; j++) {
                    list.get(i).remove(list.size() - 1);
                }
            } else {
                int range =  sizearr - sizelist;
                for (int j = 0; j < range; j++) {
                    list.get(j).add(list.get(j).get(j));
                }
            }
        }
        for (int i = 0;i < list.size();i ++){
            map1.put(list.get(i).get(i).getCode(),list.get(i));
        }
        int numProductInCart = 0;
        List<Product> products = new ArrayList<>();
        for (Map.Entry<String, List<Product>> entry : map1.entrySet()) {
            numProductInCart += entry.getValue().size();
        }
        request.getSession().setAttribute("NUM_IN_CART", numProductInCart);
        request.getSession().removeAttribute("CART");
        request.getSession().setAttribute("CART", map1);
        return "redirect:/gio-hang";
    }

    @RequestMapping(value = {"/them-vao-gio-hang/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String addcart(@PathVariable int id, Model model, HttpServletRequest request, HttpServletResponse response) {
        String quanlity = request.getParameter("quantity");
        //HashMap<String, String> newMap = new HashMap<String, String>();
        //newMap.put("my_code", "shhh_secret");
        //String value = newMap.get("my_code");
        List<Product> productList = new ArrayList<>();
        int subtotal = 0;
        Product product = productService.getById(id);
        Map<String, List<Product>> map = (Map<String, List<Product>>) request.getSession().getAttribute("CART");
        if (map != null) {
            productList = map.get(product.getCode());
            if (productList != null) {
                if (!StringUtils.isBlank(quanlity)) {
                    productList.clear();
                    for (int i = 0; i < Integer.parseInt(quanlity); i++) {
                        productList.add(product);
                    }
                } else {
                    productList.add(product);
                }

            } else {
                productList = new ArrayList<>();
                if (!StringUtils.isBlank(quanlity)) {
                    for (int i = 0; i < Integer.parseInt(quanlity); i++) {
                        productList.add(product);
                    }
                } else {
                    productList.add(product);
                }
                map.put(product.getCode(), productList);
            }
        } else {
            map = new HashMap<>();
            if (!StringUtils.isBlank(quanlity)) {
                for (int i = 0; i < Integer.parseInt(quanlity); i++) {
                    productList.add(product);
                }
            } else {
                productList.add(product);
            }
            map.put(product.getCode(), productList);
        }
        int numProductInCart = 0;
        List<Product> products = new ArrayList<>();
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            numProductInCart += entry.getValue().size();
            products.add(entry.getValue().get(0));
            subtotal += entry.getValue().size() * Integer.parseInt(entry.getValue().get(0).getPrice());
        }

        request.getSession().removeAttribute("CART");
        request.getSession().setAttribute("CART", map);
        model.addAttribute("subtotal", subtotal);
        request.getSession().setAttribute("NUM_IN_CART", numProductInCart);
        model.addAttribute("listProduct", products);
        model.addAttribute("map", map);
        return "cart";
    }
}
