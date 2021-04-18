<%--
  Created by IntelliJ IDEA.
  User: 28353
  Date: 2021/4/5
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1> Login</h1>
<%
    if(!(request.getAttribute("message") == null))
    {
        out.println("<h3 style = 'color:yellow'>"+request.getAttribute("message")+"</h3>");
    }
%>
    <form method="post" action="login">
        Name :<input type="text" name="username"><br>
        Password:<input type="text" name="password"><br>
        <input type="submit" value="Login"/>
    </form>

<%@include file="footer.jsp"%>
