

<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1>User List</h1>
<table border=3>
    <tr>
        <th>ID</th><th>UserName</th><th>PassWord</th><th>Email</th><th>Gender</th><th>Birth</th>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
        if(rs==null) {
    %>
    <tr><td>No Data!!!</td></tr>
    <%
        } else {
            while (rs.next()) {
                out.print("<tr>");
                out.print("<td>"+rs.getInt("id")+"</td>");
                out.print("<td>"+rs.getString("username")+"</td>");
                out.print("<td>"+rs.getString("password")+"</td>");
                out.print("<td>"+rs.getString("email")+"</td>");
                out.print("<td>"+rs.getString("gender")+"</td>");
                out.print("<td>"+rs.getDate("birthdate")+"</td>");
                out.print("<tr>");
            }
        }
    %>

</table>
<%@include file="footer.jsp"%>