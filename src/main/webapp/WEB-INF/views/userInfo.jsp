<%@ page import="com.fengfeiyang.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 28353
  Date: 2021/4/11
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>



<%@include file="header.jsp" %>
<%
    User user = (User)request.getAttribute("user");
%>
<h2>User Info</h2>

<table border=1 >
    <tr>
    <td>Username</td><td><%=user.getUsername()%></td> </tr>
    <td>Password</td><td><%=user.getPassword()%></td> </tr>
    <td>Email</td> <td><%=user.getEmail()%></td> </tr>
    <td>Gender</td><td><%=user.getGender()%></td> </tr>
    <td>Birthdate</td> <td><%=user.getBirthDate()%></td>
    </tr>
</table>

<%@include file="footer.jsp" %>