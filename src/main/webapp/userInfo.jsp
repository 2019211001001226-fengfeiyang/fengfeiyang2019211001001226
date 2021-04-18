<%@ page import="com.fengfeiyang.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 28353
  Date: 2021/4/11
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>


<%@page  contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="header.jsp" %>
<%
    User user = (User)request.getAttribute("user");
%>
<h2>User Info</h2>

<table border="1" >
    <tr>
    <td>Username</td><td><%=request.getAttribute("Username")%></td>
    </tr><tr>
    <td>Password</td><td><%=request.getAttribute("Password")%></td>
    </tr><tr>
    <td>Email</td> <td><%=request.getAttribute("Email")%></td>
    </tr><tr>
    <td>Gender</td><td><%=request.getAttribute("Gender")%></td>
    </tr><tr>
    <td>Birthdate</td> <td><%=request.getAttribute("Birthdate")%></td>
    </tr>
</table>

<%@include file="footer.jsp" %>