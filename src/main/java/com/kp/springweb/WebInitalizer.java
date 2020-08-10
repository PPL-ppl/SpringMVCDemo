package com.kp.springweb;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//web初始化的类  web容器（tomcat）自动感知
public class WebInitalizer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //初始化spring的容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext);
        //配置dispatcherservlet 配置哪些路径交给springmvc处理
        ServletRegistration.Dynamic dispatcher
                = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.addMapping("/");//所有请求路径都交给springmvc
        dispatcher.setLoadOnStartup(1);//1秒后启动

        /*//添加默认的servlet处理静态资源
        ServletRegistration aDefault =
                servletContext.getServletRegistration("default");
        aDefault.addMapping("/static/**");*/
    }
}
