package com.fengfeiyang.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",value ="/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=  request.getParameter("name");
        String id=  request.getParameter("id");
        PrintWriter writer = response.getWriter();
        writer.println("<br>Name:"+name);
        writer.println("<br>ID:"+id);
        writer.close();
    }
}
