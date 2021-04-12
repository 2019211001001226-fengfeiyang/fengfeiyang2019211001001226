package com.fengfeiyang.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebListener()
public class JDBCServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection Con;
        ServletContext context = sce.getServletContext();
        System.out.println("i am in contextInitialized()");
        try {
            Class.forName(context.getInitParameter("driver"));
            Con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("Username"),
                    context.getInitParameter("Password"));
            context.setAttribute("Con",Con);
context.setAttribute("Con",Con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
sce.getServletContext().removeAttribute("Con");
    }
}