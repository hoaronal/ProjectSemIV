package com.bkap.vn.web.controller;

import com.bkap.vn.common.entity.Product;
import com.bkap.vn.manager.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        if(map != null){
            for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
                products.add(entry.getValue().get(0));
            }
        }
        //model.addAttribute("listProduct",map);
        model.addAttribute("listProduct",products);
        model.addAttribute("map",map);
        return "cart";
    }

    @RequestMapping(value = {"/them-vao-gio-hang/{id}"}, method = RequestMethod.GET)
    public String addcart(@PathVariable int id, Model model, HttpServletRequest request, HttpServletResponse response) {

        //HashMap<String, String> newMap = new HashMap<String, String>();
        //newMap.put("my_code", "shhh_secret");
        //String value = newMap.get("my_code");
        List<Product> productList = new ArrayList<>();
        Product product = productService.getById(id);
        Map<String, List<Product>> map = (Map<String, List<Product>>) request.getSession().getAttribute("CART");
        if (map != null) {
            productList = map.get(product.getCode());
            if (productList != null) {
                productList.add(product);
            } else {
                productList = new ArrayList<>();
                productList.add(product);
                map.put(product.getCode(), productList);
            }
        } else {
            map = new HashMap<>();
            productList.add(product);
            map.put(product.getCode(), productList);
        }
        int numProductInCart = 0;
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            numProductInCart += entry.getValue().size();
        }
        request.getSession().removeAttribute("CART");
        request.getSession().setAttribute("CART", map);
        request.getSession().setAttribute("NUM_IN_CART", numProductInCart);
        return "cart";
    }
}
