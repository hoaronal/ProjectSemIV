package com.bkap.vn.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Field;


public class BaseController {

    public static void trimAllFieldOfObject(Object item) {
        if (item == null) {
            return;
        }
        Field[] fields = item.getClass().getDeclaredFields();
        if (fields == null) {
            return;
        }

        for (Field f : fields) {
            if (f.getType().isPrimitive()) {
                continue;
            }
            if (f.getType().equals(String.class)) {
                try {
                    f.setAccessible(true);
                    String value = (String) f.get(item);
                    f.set(item, org.apache.commons.lang3.StringUtils.trimToNull(value));
                } catch (IllegalAccessException e) {
                }

            }
        }
    }

    public String trimspace(String str) {
        str = str.replaceAll("\\s+", " ");
        str = str.replaceAll("(^\\s+|\\s+$)", "");
        return str;
    }

    public ModelAndView view(String viewName, Object o, String nameItem, String msg, String style){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject(nameItem,o);
        modelAndView.addObject("msg",msg);
        modelAndView.addObject("style",style);
        return modelAndView;
    }

    public ModelAndView view(String viewName){
        return new ModelAndView(viewName);
    }

    public static boolean checkPattern(String regex, String input){
        return input.matches(regex);
    }

}
