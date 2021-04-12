package com.fengfeiyang.week5.demo;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public Connection dbConn = null;
    public void init() {
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//       String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb;";
//        String username="sa";
//        String password="123456";
//
//
//        try {
//            Class.forName(driver);
//            dbConn= DriverManager.getConnection(url,username,password);
//            System.out.println("init()-->"+dbConn);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            System.out.println("连接数据库失败！");
//        }
        dbConn = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        String password= request.getParameter("password");

        PrintWriter writer = response.getWriter();
        try {
            if( dbConn != null){


                String sql = "SELECT * FROM usertable WHERE username=? AND password=?;";
                PreparedStatement ps = dbConn.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
//                    writer.println("Login Success!!!");
//                    writer.println("Welcome "+name+".");
                    request.setAttribute("ID",rs.getInt("id"));
                    request.setAttribute("Username",rs.getString("name"));
                    request.setAttribute("Password",rs.getString("password"));
                    request.setAttribute("Email",rs.getString("email"));
                    request.setAttribute("Gender",rs.getString("gender"));
                    request.setAttribute("Birthdate",rs.getDate("birthdate"));
                    request.getRequestDispatcher("userinfo.jsp").forward(request, response);
                }else{
//                    writer.print("Username or Password Error!!!");
                    request.setAttribute("msg" ,"username or password Error");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
