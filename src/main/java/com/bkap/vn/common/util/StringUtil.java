package com.bkap.vn.common.util;

import org.jsoup.Jsoup;

public class StringUtil {

    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
}
