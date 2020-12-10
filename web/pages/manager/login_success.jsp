<%@ page import="com.nsu.lister.SessionCounter" %><%--
  Created by IntelliJ IDEA.
  User: 15181
  Date: 2020/11/13
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="http://39.99.129.224:8080/student/static/img/logo.ico" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="http://39.99.129.224:8080/student/static/css/style.css" >
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <title>管理员首页</title>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="http://39.99.129.224:8080/student/static/img/logo.gif" >
    <div>
        <span>当前在线人数：<span class="um_span"><%=SessionCounter.getActiveSessions() %></span></span>
        <a href="/student/managerServlet?action=list">学生管理</a>
        <a href="/student/courseServlet?action=list">课程管理</a>
        <a href="/student/userServlet?action=logout">注销</a>&nbsp;&nbsp;
    </div>
    <div>

    </div>
</div>

<div id="main">
</div>

<div id="bottom">
			<span>
				选课.Copyright &copy;2015
			</span>
</div>
</body>
</html>