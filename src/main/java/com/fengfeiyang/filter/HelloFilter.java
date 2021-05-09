package com.fengfeiyang.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebFilter(filterName = "HelloFilter",urlPatterns = {"/home","/login","/Register.jsp"})
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am in HelloFilter-->init()");
    }

    public void destroy() {
        System.out.println("I am in HelloFilter-->destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am in HelloFilter-->doFilter()- before servlet(request come here)");
        chain.doFilter(req, resp);
        System.out.println("I am in HelloFilter-->doFilter()- after servlet(response come here)");
    }

}