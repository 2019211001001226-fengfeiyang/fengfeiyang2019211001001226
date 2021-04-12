<%--
  Created by IntelliJ IDEA.
  User: 28353
  Date: 2021/4/12
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>ID</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%@page import="java.sql.*" %>
    <%
        ResultSet rs = (ResultSet)request.getAttribute("rsname");
        if(rs==null){
            %>
    <tr>
        <td>NO Data!!!</td>
    </tr>
    <%}else{
        while(rs.next()){
            out.println("<tr>" );
            out.println("<td>"+rs.getInt("id")+"</td>");
            out.println("<td>"+rs.getString("username")+"</td>" );
            out.println("<td>"+rs.getString("password")+"</td>" );
            out.println("<td>"+rs.getString("email")+"</td>" );
            out.println("<td>"+rs.getString("gender")+"</td>" );
            out.println("<td>"+rs.getString("birthdate")+"</td>" );
            out.println("</tr>" );
        }}
    %>

</table>

<%@include file="footer.jsp" %>
