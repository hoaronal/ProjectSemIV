package com.bkap.vn.common.util;

public class BaseController {

    public String trimspace(String str) {
        str = str.replaceAll("\\s+", " ");
        str = str.replaceAll("(^\\s+|\\s+$)", "");
        return str;
    }

}
