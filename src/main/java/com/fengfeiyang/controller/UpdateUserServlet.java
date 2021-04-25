package com.fengfeiyang.controller;

import com.fengfeiyang.dao.UserDao;
import com.fengfeiyang.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb;";
        String username="sa";
        String password="123456";



        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("2连接数据库失败！");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("sex");
        String birth = request.getParameter("birth");
        java.sql.Date birthD = java.sql.Date.valueOf(birth);

        UserDao userDao = new UserDao();
        User usera = new User();
        int id = Integer.parseInt(ID);
        usera.setId(id);
        usera.setUsername(username);
        usera.setPassword(password);
        usera.setEmail(email);
        usera.setGender(gender);
        usera.setBirthDate(birthD);
        try {
            int update = userDao.updateUser(con,usera);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute("user",usera);
            if(update!=0) {
                request.setAttribute("message","UpdateUser successful!!!");
            } else {
                request.setAttribute("message","UpdateUser failed!!!");
            }
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}