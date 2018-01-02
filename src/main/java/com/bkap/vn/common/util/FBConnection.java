package com.bkap.vn.common.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.List;

public class FBConnection {
    public FBConnection(){}

    public String getFBAuthUrl() {
        String fbLoginUrl = "";
        try {
            fbLoginUrl = "http://www.facebook.com/dialog/oauth?" + "client_id=" + Constant.MY_APP_ID
                    + "&redirect_uri=" + URLEncoder.encode("localhost:8888/shop-online/login-facebook", "UTF-8")
                    + "&scope=email";

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fbLoginUrl;
    }

    /**
     * Get User data
     *
     * @param accessToken
     */
    public void getUserData(String accessToken) {
        String graph = null;
        try {
            String g = "https://graph.facebook.com/me?fields=id,name,picture,birthday,email,first_name,last_name,gender,location,locale,link&"
                    + accessToken;
            // System.out.println("g=============:" + g);
            URL u = new URL(g);

            URLConnection c = u.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuffer b = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                b.append(inputLine + "\n");
            }
            in.close();
            graph = b.toString();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(graph);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR URL invalid: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("I/O ERROR reading Stream: " + e);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
