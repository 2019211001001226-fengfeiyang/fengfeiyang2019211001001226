<%--
  Created by IntelliJ IDEA.
  User: 28353
  Date: 2021/3/14
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script>
        function isPasswordValid() {
            var password=document.getElementById("password").value;
            if(password.length<8) {
                alert("Password length should not less than 8!");
                return false;
            }
            return true;
        }
        function isMailValid(){
            var x=document.getElementById("email").value;
            var atpos = -1, dotpos = -1;
            for (var i = 0; i < x.length; i++) {
                if (x[i] == '@' && atpos == -1) {
                    atpos = i+1;
                } else if (x[i] == '@' && ~atpos){
                    alert("Wrong email!");
                    return false;
                }
                if (x[i] == '.') {
                    dotpos = i+1;
                }
            }
            if (atpos<=1 || dotpos<atpos+2 || dotpos == -1) {
                alert("Wrong email!");
                return false;
            }
            return true;
        }
        function isDateValid() {
            var date = document.getElementById("birth").value;
            if (date.length == 10 && date[4] == date[7] && date[4] == '-') return true;
            alert("Wrong date!");
            return false;
        }
        function AC() {
            if (document.getElementById("username").value.length == 0) {
                alert("Username should not empty!");
                return false;
            } else if (isPasswordValid() == false) {
                return false;
            } else if (isMailValid() == false) {
                return false;
            } else if (isDateValid() == false) {
                return false;
            }
            alert("Accepted");
            return true;
        }
    </script>
</head>

<%@include file="header.jsp"%>
<form method="post" action="${pageContext.request.contextPath}/register">
    Username:<input type="text" id="username" name="username"><br/>
    Password:<input id="password" name="password" type="password"><br/>
    E-mail:<input id="email" name="email" type="email"><br/>
    Gender:<input name="sex" type="radio" value="male">mal
    <input type="radio" name="sex" value="female">female<br/>
    Birth:<input type="text" id="birth" name="birth"><br/>
    <input type="submit" value="Register" onclick="AC()">
</form>
<%@include file="footer.jsp"%>