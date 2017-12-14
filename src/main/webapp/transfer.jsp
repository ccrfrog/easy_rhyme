<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%>


<%

    String enIds = request.getParameter("enIds");
    String callback = request.getParameter("callback");

    String url = "http://l-djb2c4.vc.dev.cn6.qunar.com:8888/acl/api/seckill/status.json";
    //url = "http://l-p.tuan.qunar.com/acl/api/seckill/status.json";
    url += "?enIds=" + enIds;
    
    URL dujia = new URL(url);
    URLConnection yc = dujia.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
    
    StringBuilder recordsStr = new StringBuilder();
    String t = null;
    try {
        while (( t = in.readLine() )!= null ) {
            recordsStr.append(t);
        }
        System.out.println(recordsStr.toString());        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        in.close();
    }
    
    out.print(callback);
    out.print("([" + recordsStr.toString() + ", " + " {\"time\":" + System.currentTimeMillis() + "}])");
    
%>









