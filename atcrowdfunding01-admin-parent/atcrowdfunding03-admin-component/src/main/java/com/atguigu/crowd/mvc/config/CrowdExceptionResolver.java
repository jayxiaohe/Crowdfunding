package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import com.atguigu.crowd.util.Constant.CrowdConstant;
import com.google.gson.Gson;

/**
 * @ControllerAdvice表示当前类是一个基于注解的异常处理器类
 * @author HePengTao
 */
@ControllerAdvice
public class CrowdExceptionResolver {

    /**
     * ExceptionHandler 将一个具体的异常和一个方法关联起来
     * @param exception 实际捕获到的异常对象
     * @param request 当前请求对象
     * @return
     * @throws IOException 
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointException(NullPointerException exception, HttpServletRequest request
            , HttpServletResponse response) throws IOException {
        
        String viewName = "system-error";
        
        return commonResolve(viewName, exception, request, response);
    }
    
    
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveMathException(ArithmeticException exception, HttpServletRequest request
            , HttpServletResponse response) throws IOException  {
        
        String viewName = "system-error";
        
        return commonResolve(viewName, exception, request, response);
    }
    
    /**
     * @param viewName 视图名。异常处理完成后要去的页面
     * @param exception 传入的异常
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public ModelAndView commonResolve(String viewName,Exception exception, HttpServletRequest request
            , HttpServletResponse response) throws IOException  {
        
        boolean isAjax = CrowdUtil.judgeRequestType(request);
        
        // 如果是ajax请求。
        if (isAjax) {
            // 创建 ResultEntity 对象。
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage()); 
            // 创建gson对象
            Gson gson = new Gson();
            // 将 ResultEntity 对象转化为JSON字符串
            String json = gson.toJson(resultEntity);
            // 将json字符串作为响应体返回
            response.getWriter().write(json);
            // 上面已经通过原生的response对象返回了响应，所以不再提供ModelAndView对象
            return null;
        }
        
        // 不是ajax请求
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(CrowdConstant.ARRT_NAME_EXCEPTION, exception);
        modelAndView.setViewName(viewName);
        
        return modelAndView;
    }
}
