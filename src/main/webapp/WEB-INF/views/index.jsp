<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<h2>Welcome to my Home page!</h2> <br>
<form method= "get" target='_bLank' action="search">
    <input type= "text" name="txt" size=30/>
    <select name= "search">
        <option value= "baidu">Baidu</option>
        <option value= "bing">Bing</option>
        <option value= "google">Google</option>
        <option value= "sogou">sogou</option>
        </select>
            <input type="submit" value="Search"/>
    <br/>
    <a href="hello-servlet">HelloServlet</a>
    <br/>

</form>
<%@include file="footer.jsp" %>
