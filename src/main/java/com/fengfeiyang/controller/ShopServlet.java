package com.fengfeiyang.controller;

import com.fengfeiyang.dao.ProductDao;
import com.fengfeiyang.model.Category;
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

@WebServlet(name = "ShopServlet", value="/shop")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        Connection con = null;
        try {
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb;";
            String username="sa";
            String password="123456";
            con= DriverManager.getConnection(url,username,password);
            List<Category> categoryList=category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            ProductDao productDao =new ProductDao();
            List<Product> productList=null;
            if(request.getParameter("categoryId")==null) {
                productList=productDao.findAll(con);
            }
            else {
                int categoryId= Integer.parseInt(request.getParameter("categoryId"));
                productList=productDao.findByCategoryId(categoryId,(con));

            }
            request.setAttribute("productList",productList);
            String path="/WEB-INF/views/shop.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}