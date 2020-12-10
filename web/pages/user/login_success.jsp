<%@ page import="com.nsu.lister.SessionCounter" %><%--
  Created by IntelliJ IDEA.
  User: 15181
  Date: 2020/11/14
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登陆成功页面</title>

    <link rel="shortcut icon" href="http://39.99.129.224:8080/student/static/img/logo.ico" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="http://39.99.129.224:8080/student/static/css/style.css" >
    <script type="text/javascript" src="/static/script/jquery-1.7.2.js"></script>



    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >

    <div>
        <span>当前在线人数：<span class="um_span"><%=SessionCounter.getActiveSessions() %></span></span>
        <a href="/student/userServlet?action=show">查看个人信息</a>
        <a href="/student/pages/user/user_changePassword.jsp">修改密码</a>
        <a href="/student/userServlet?action=showCourse">选择课程</a>
        <a href="/student/index.jsp">注销</a>
    </div>
</div>

<div id="main">
    <h1>${requestScope.upCourse}</h1>
    <h1>${requestScope.upPassword}</h1>
</div>

</body>
</html>