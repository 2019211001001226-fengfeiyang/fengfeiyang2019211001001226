
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fengfeiyang.model.User" %>
<%@ page import="java.net.CookieHandler" %>
<%@include file="header.jsp"%>
<%--
    Cookie []  allCookies = request.getCookies();
    for(Cookie c:allCookies) {
        out.println("<br/>" + c.getName() + " --- " + c.getValue());
    }
--%>
<%

    if(!(request.getAttribute("message") == null)) {
        out.println(request.getAttribute("message"));
    }
%>
<%
    User u = (User)session.getAttribute("user");
%>
<h1>UserInfo</h1>
<table>

    <tr><td>Username:</td>  <td><%=u.getUsername()%> </td></tr>
    <tr><td>Password:</td>  <td><%=u.getPassword()%> </td></tr>
    <tr><td>Email:</td>     <td><%=u.getEmail()%>    </td></tr>
    <tr><td>Gender:</td>    <td><%=u.getGender()%>   </td></tr>
    <tr><td>BirthDate:</td> <td><%=u.getBirthDate()%></td></tr>
</table>
<tr>
    <a href="updateUser.jsp">Update</a>
</tr>

<%@include file="footer.jsp"%>