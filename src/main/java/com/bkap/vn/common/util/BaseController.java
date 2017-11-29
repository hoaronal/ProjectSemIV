package com.bkap.vn.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;


public class BaseController {
    @Autowired
    private Validator validator;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    public String trimspace(String str) {
        str = str.replaceAll("\\s+", " ");
        str = str.replaceAll("(^\\s+|\\s+$)", "");
        return str;
    }

    public ModelAndView view(String viewName, Object o, String nameItem){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject(nameItem,o);
        return modelAndView;
    }

    public ModelAndView view(String viewName){
        return new ModelAndView("viewName");
    }

    public String getValidationErrorMessage(BindingResult result, String field) {
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError(field);
            return messageSourceAccessor.getMessage(fieldError);
        }
        return "";
    }
}
