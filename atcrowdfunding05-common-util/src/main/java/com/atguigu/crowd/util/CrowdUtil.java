package com.atguigu.crowd.util;

import java.net.HttpRetryException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class CrowdUtil {
    
    /**
     * 判断请求是普通请求还是ajax请求。如果是，返回true。
     * @param request
     * @return
     */
    public static boolean judgeRequestType(HttpServletRequest request) {
        
        String acceptHeader = request.getHeader("Accept");
        String xRequested = request.getHeader("X-Requested-With");
        
        return (acceptHeader != null && acceptHeader.contains("application/json") 
                || (xRequested != null && xRequested.equals("XMLHttpRequest")));
    }
}
