package com.bkap.vn.manager.group_role.controller;


import com.bkap.vn.common.entity.GroupRole;
import com.bkap.vn.common.entity.Role;
import com.bkap.vn.common.pagination.PaggingResult;
import com.bkap.vn.common.util.BaseController;
import com.bkap.vn.manager.group_role.service.GroupRoleService;
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
@RequestMapping("quan-tri")
public class GroupRoleController extends BaseController {

    @Autowired
    private GroupRoleService groupRoleService;

    @RequestMapping(value = {"/nhom-quyen/{page}", "/nhom-quyen/danh-sach-nhom-quyen/{page}"}, method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("groupRole") GroupRole groupRole,
                             @RequestParam(value = "keySearch", defaultValue = "") String keySearch,
                             @PathVariable(value = "page") int currentPage,
                             PaggingResult paggingResult, HttpServletRequest request, HttpServletResponse response) {
        if (currentPage <= 1) {
            currentPage = 1;
        }
        ModelAndView view = new ModelAndView();
        String filter = groupRoleService.generateQuerySearchRole(keySearch);
        int totalRecord = groupRoleService.countAll(filter);
        paggingResult = groupRoleService.findRange(currentPage, 10, filter);
        paggingResult.setTotalRecord(totalRecord);
        paggingResult.setCurrentPage(currentPage);
        paggingResult.paging();
        view.addObject("keySearch", keySearch);
        view.addObject("listItem", paggingResult);
        view.setViewName("grouprole-list");
        return view;
    }


    @RequestMapping(value = "/nhom-quyen/cap-nhat/{id}", method = RequestMethod.GET)
    public String editView(@PathVariable("id") int id, @ModelAttribute("groupRole") GroupRole groupRole, Model model, RedirectAttributes attributes, Locale locale) {
        groupRole = groupRoleService.getById(id);
        if (groupRole != null) {
            model.addAttribute("groupRole", groupRole);
            return "grouprole-edit";
        } else {
            if (locale.getLanguage().equals("en")) {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "GroupRole not exits!");
            } else {
                attributes.addFlashAttribute("style", "danger");
                attributes.addFlashAttribute("msg", "Nhóm quyền không tồn tại!");
            }
            return "redirect:/quan-tri/nhom-quyen/1";
        }
    }

    @RequestMapping(value = "/nhom-quyen/cap-nhat/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edit(@ModelAttribute("groupRole") @Valid GroupRole groupRole,
                             BindingResult result, RedirectAttributes attributes) {
        GroupRole groupRoleUpdate = groupRoleService.getById(groupRole.getId());
        try {
            if (groupRoleUpdate != null) {
                if (result.hasErrors()) {
                    return view("grouprole-edit", groupRole, "groupRole", "Cập nhật nhóm quyền thất bại!", "danger");
                } else {
                    groupRole.setUpdateDate(new Date());
                    groupRole.setCreateDate(groupRoleUpdate.getCreateDate());
                /*role.setAdminByAdminUpdate(new Admin());
                role.setAdminByAdminCreate(userUpdate.getAdminByAdminCreate());*/
                    boolean check = groupRoleService.update(groupRole);
                    if (check) {
                        attributes.addFlashAttribute("style", "info");
                        attributes.addFlashAttribute("msg", "Cập nhật nhóm quyền thành công");
                    } else {
                        attributes.addFlashAttribute("style", "danger");
                        attributes.addFlashAttribute("msg", "Cập nhật nhóm quyền thất bại!");
                    }
                }
            } else {
                return view("redirect:/quan-tri/nhom-quyen/danh-sach-nhom-quyen/1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view("redirect:/quan-tri/nhom-quyen/danh-sach-nhom-quyen/1");
    }

    @RequestMapping(value = "/nhom-quyen/them-moi", method = RequestMethod.GET)
    public String addView(Model model) {
        model.addAttribute("groupRole", new GroupRole());
        return "grouprole-add";
    }

    @RequestMapping(value = "/nhom-quyen/them-moi/luu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(@ModelAttribute(value = "groupRole") @Valid GroupRole groupRole,
                            BindingResult result, HttpServletRequest request,
                            HttpServletResponse response, RedirectAttributes attributes) {
        if (groupRole != null) {
            if (result.hasErrors()) {
                return view("grouprole-add", groupRole, "groupRole", "Thêm mới nhóm quyền thất bại!", "danger");
            } else {
                groupRole.setUpdateDate(new Date());
                groupRole.setCreateDate(new Date());
                /*user.setAdminByAdminUpdate(new Admin());
                user.setAdminByAdminCreate(new Admin());*/
                int check = groupRoleService.add(groupRole);
                if (check > 0) {
                    attributes.addFlashAttribute("style", "info");
                    attributes.addFlashAttribute("msg", "Thêm mới quyền thành công");
                    return view("redirect:/quan-tri/nhom-quyen/1");
                } else {
                    attributes.addFlashAttribute("style", "danger");
                    attributes.addFlashAttribute("msg", "Thêm mới quyền thất bại");
                    return view("redirect:/quan-tri/nhom-quyen/1");
                }
            }
        } else {
            return view("redirect:/quan-tri/nhom-quyen/1");
        }
    }

    @RequestMapping(value = "/nhom-quyen/xoa/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        ModelAndView view = new ModelAndView();
        if (id > 0) {
            GroupRole groupRole = groupRoleService.getById(id);
            if (groupRole != null) {
                boolean check = groupRoleService.delete(groupRole);
                if (check) {
                    redirectAttributes.addFlashAttribute("style", "info");
                    redirectAttributes.addFlashAttribute("msg", "Xóa nhóm quyền thành công.");
                }
            } else {
                redirectAttributes.addFlashAttribute("style", "danger");
                redirectAttributes.addFlashAttribute("msg", "Xóa nhóm quyền thất bại, nhóm quyền không tồn tại!");
            }
        } else {
            redirectAttributes.addFlashAttribute("style", "danger");
            redirectAttributes.addFlashAttribute("msg", "Xóa nhóm quyền thất bại, nhóm quyền không tồn tại!");
        }
        view.setViewName("redirect:/quan-tri/nhom-quyen/1");
        return view;
    }


}
