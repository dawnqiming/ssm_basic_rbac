package com.basic.rbac.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description
 * @Author T480
 * @Version
 * @Date 2021/11/22
 */
public class ServerStartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String path = servletContext.getContextPath();

        String projectName = "/basicrbac";
        String realPath = path + projectName;
        // 将web应用名称（路径）保存到application范围中
        servletContext.setAttribute("APP_PATH", realPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
