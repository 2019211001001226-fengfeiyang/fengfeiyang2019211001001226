<%--
  Created by IntelliJ IDEA.
  User: 28353
  Date: 2021/3/14
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<form method="post" action="register">
    UserName :<input type="text" name="username"><br/>
    password :<input type="text" name="password"><br/>
    Email :<input type="text" name="email"><br/>
    Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br/>
    Date of Birth :<input type="text" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>

<%@include file="footer.jsp"