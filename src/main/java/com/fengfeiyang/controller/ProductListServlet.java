package com.fengfeiyang.controller;
import com.fengfeiyang.dao.ProductDao;
import com.fengfeiyang.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductListServlet",value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    Connection con = null;

    public void init() throws ServletException {
       /* String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb;";
        String username="sa";
        String password="123456";



        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("3连接数据库失败！");
        }*/
        con =(Connection)getServletContext().getAttribute("dbConn");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDao productDao = new ProductDao();
        try {
            List<Product> productList = productDao.findAll(con);
            request.setAttribute("productList", productList);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        String path = "/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}