package com.bkap.vn.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@PropertySource("classpath:system.properties")
public class BaseController {

    @Autowired
    protected Environment env;



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


    public String generateMessageJson(BindingResult result) {
        StringBuilder sb = new StringBuilder("{");
        if (result.hasErrors()) {
            List<FieldError> fieldErrorList = result.getFieldErrors();
            int size = fieldErrorList.size();
            for (int i = 0; i < size; i++) {
                FieldError fieldError = fieldErrorList.get(i);
                String field = fieldError.getField();
                String msg = fieldError.getDefaultMessage();
                if (i != size - 1) {
                    sb.append(field + "=").append(msg + ",").append('\'');
                } else {
                    sb.append(field + "=").append(msg).append('\'');
                }
            }
            sb.append('}');
        }
        return sb.toString();
    }

    public Map<String, String> generateMessageMap(BindingResult result) {
        Map<String, String> map = new HashMap<String, String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrorList = result.getFieldErrors();
            int size = fieldErrorList.size();
            for (int i = 0; i < size; i++) {
                FieldError fieldError = fieldErrorList.get(i);
                String field = fieldError.getField();
                String msg = fieldError.getDefaultMessage();
                map.put(field, msg);
            }
        }
        return map;
    }
    public static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }

    public static String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
