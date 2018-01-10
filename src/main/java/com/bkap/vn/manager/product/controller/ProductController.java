package com.bkap.vn.manager.product.controller;


import com.bkap.vn.common.entity.Category;
import com.bkap.vn.common.entity.Product;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.category.service.CategoryService;
import com.bkap.vn.manager.product.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("quan-tri/san-pham")
@PropertySource("classpath:system.properties")
public class ProductController extends BaseController {

    @Autowired
    protected Environment env;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = {"/{page}", "/danh-sach-san-pham/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("product") Product product,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = productService.generateQuerySearchProduct(keySearch);
        int totalRecord = productService.countAll(filter);
        paggingResult = productService.findRange(currentPage, 10, filter + " ORDER BY id ");
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("product-list");
        return view;
    }


    @RequestMapping(value = "/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("product") Product product, Model model, RedirectAttributes attributes, Locale locale) {
        product = productService.getById(id);
        List<Category> listCategory = categoryService.listCategory();
        if (product != null) {
            model.addAttribute("listCategory", listCategory);
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

    @RequestMapping(value = "/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@RequestParam("categoryId") String categoryId,
                             @ModelAttribute("product") @Valid Product product,
                             BindingResult result, @RequestParam(value = "upload", required = false) MultipartFile file, RedirectAttributes attributes, HttpServletRequest request) {
        Product productUpdate = productService.getById(product.getId());
        try {
            if (productUpdate != null) {
                if (result.hasErrors() && !validateUpdate(product)) {
                    return view("product-edit", product, "product", "Cập nhật sản phẩm thất bại!", "danger");
                } else {
                    Category category = categoryService.getById(Integer.parseInt(categoryId));
                    if (file != null && !file.isEmpty()) {
                        String fileName = new Date().getTime() + ".png";
                        String phyPath = request.getSession().getServletContext().getRealPath("/");
                        String filepath = phyPath + "resources/img/" + fileName;
                        File files = new File(filepath);
                        if (!files.exists()) {
                            files.createNewFile();
                        }
                        file.transferTo(files);
                        product.setImageLink(fileName);

                    } else {
                        product.setImageLink(productUpdate.getImageLink());
                    }
                    product.setUpdateDate(new Date());
                    product.setCreateDate(productUpdate.getCreateDate());
                    product.setCategory(category);
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = productService.update(product);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật sản phẩm thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật sản phẩm thất bại!");
                    }
                }
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Cập nhật sản phẩm thất bại, sản phẩm không tồn tại!");
                return view("redirect:/quan-tri/san-pham/danh-sach-san-pham/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/san-pham/danh-sach-san-pham/1");
    }

    @RequestMapping(value = "/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        List<Category> listCategory = categoryService.listCategory();
        model.addAttribute("product", new Product());
        model.addAttribute("listCategory", listCategory);
        return "product-add";
    }

    @RequestMapping(value = "/them-moi/luu", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam(value = "categoryId", required = false) String categoryId,
                            @RequestParam(value = "imgData", required = false) String imgData,
                            @ModelAttribute(value = "product") Product product,
                            @RequestParam(value = "upload", required = false) MultipartFile file,HttpServletRequest request, RedirectAttributes attributes) {
            try {
                String base64 = imgData.substring(imgData.indexOf("base64,") + 7);
                String rootPath = env.getRequiredProperty("system_upload_folder");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                String fileName = new Date().getTime() + ".png";
                String phyPath = request.getSession().getServletContext().getRealPath("/");
                String filepath = phyPath + "resources/img/" + fileName;
                File serverFile = new File(filepath);
                /*File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + fileName);*/
                FileOutputStream outThumbnail = new FileOutputStream(serverFile);
                outThumbnail.write(DatatypeConverter.parseBase64Binary(base64));
                outThumbnail.close();
                product.setImageLink(fileName);
                /*// Create the file on server




                if (!files.exists()) {
                    files.createNewFile();
                }
                file.transferTo(files);
                */
                //file.transferTo(resourceLoader.getResource("resources/upload/images/"+).getFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        Category category = categoryService.getById(Integer.parseInt(categoryId));
        if (product != null && category != null) {
                product.setUpdateDate(new Date());
                product.setCategory(category);
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
        } else {
            return view("redirect:/quan-tri/san-pham/1");
        }
    }

    @RequestMapping(value = "/xoa/{id}", method = RequestMethod.GET)
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

    public boolean validateUpdate(Product product) {
        boolean check = true;

        return check;
    }

}
