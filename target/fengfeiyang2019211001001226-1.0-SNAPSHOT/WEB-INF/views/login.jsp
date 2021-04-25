<%--
  Created by IntelliJ IDEA.
  User: 28353
  Date: 2021/4/5
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.net.CookieHandler" %>
<%@include file="header.jsp"%>
<h1> Login</h1>
<%
    if(!(request.getAttribute("message") == null)) {
        out.println("<h3 style = 'color:blue'>"+request.getAttribute("message")+"</h3>");
    }
%>
<%
    Cookie[] allCookies = request.getCookies();
    String username="",password="",rememberMevalue="";
    if(allCookies!=null) {
        for(Cookie c:allCookies) {
            if(c.getName().equals("cUsername")) {
                username = c.getValue();
            }
            if(c.getName().equals("cPassword")) {
                password = c.getValue();
            }
            if(c.getName().equals("cRememberMe")) {
                rememberMevalue = c.getValue();
            }
        }
    }
%>
<form method="post" action="${pageContext.request.contextPath}/login">
    Username:<input type="text" id="username" name="username" value="<%=username%>"><br/>
    Password:<input id="password" name="password" type="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMevalue.equals("1")?"checked":""%>/>Remember Me<br/>
    <input type="submit" value="login"/>
</form>
<%@include file="footer.jsp"%>
