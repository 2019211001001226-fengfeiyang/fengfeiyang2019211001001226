package com.lab2;



import javax.servlet.*;
import javax.servlet.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(filterName = "LoginFilter",
urlPatterns = {"/lab2/validation.jsp","/lab2/welcome.jsp"}
)
public class LoginFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("I am in HelloFilter-->init()");
        }


        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
            System.out.println("I am in LoggerFilter-->doFilter()- before servlet(request come here)");
            HttpServletRequest req = (HttpServletRequest)servletRequest;
            HttpServletResponse resp = (HttpServletResponse)servletResponse;



            if (req.getSession()!=null&&req.getSession().isNew()) {
                req.getRequestDispatcher("/lab2/welcome.jsp");

            } else {
                req.getRequestDispatcher("/login.jsp");
            }
            chain.doFilter(servletRequest,servletResponse);
            System.out.println("I am in LoggerFilter-->doFilter()- after servlet(response come here)");
        }


        @Override
        public void destroy() {
            System.out.println("I am in HelloFilter-->destroy()");
        }
    }