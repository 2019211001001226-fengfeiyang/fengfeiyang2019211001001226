package com.fengfeiyang.controller;

import com.fengfeiyang.dao.ProductDao;
import com.fengfeiyang.model.Category;
import com.fengfeiyang.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet",value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)//16mb
public class AddProductServlet extends HttpServlet {
    private Connection con = null;
    public void init() {
        con = (Connection) getServletContext().getAttribute("dbConn");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        List<Category> categoryList = category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);
        String path = "/WEB-INF/views/admin/addProduct.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double price = request.getParameter("price")!=null ? Double.parseDouble(request.getParameter("price")) : 0.0;
        int categoryId = request.getParameter("categoryId")!=null ? Integer.parseInt(request.getParameter("categoryId")) : 0;
        categoryId += 28;//
        String productDescription = request.getParameter("productDescription");

        InputStream inputStream = null;
        Part filePart = request.getPart("picture");
        if (filePart != null) {
            System.out.println("file name :"+filePart.getName()+"size"+filePart.getSize()+"file type"+filePart.getContentType());
            inputStream = filePart.getInputStream();
        }

        Product product = new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPrice(price);
        product.setPicture(inputStream);
        product.setCategoryId(categoryId);

        ProductDao dao = new ProductDao();
        try {
            int n = dao.save(product,con);
            if(n>0) {
                response.sendRedirect("productList");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}