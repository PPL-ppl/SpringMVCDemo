package com.kp.springweb.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/*拦截器*/
public class DemoInterceptor extends HandlerInterceptorAdapter {
    @Override //执行前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + new Date());
        request.setAttribute("starTime", startTime);
        return true;//返回true才能执行
    }

    @Override //执行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        System.out.println("结束时间：" + new Date());
        long starTime = (Long) request.getAttribute("starTime");
        System.out.println("过程时间:" + (endTime - starTime));
        request.setAttribute("time", (endTime - starTime));
    }
}
