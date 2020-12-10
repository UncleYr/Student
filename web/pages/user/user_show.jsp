<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>

	<link rel="shortcut icon" href="http://39.99.129.224:8080/student/static/img/logo.ico" type="image/x-icon">
	<link type="text/css" rel="stylesheet" href="http://39.99.129.224:8080/student/static/css/style.css" >
	<script type="text/javascript" src="http://39.99.129.224:8080/student/static/script/jquery-1.7.2.js"></script>



	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>

		<div id="header">
			<img class="logo_img" alt="" src="http://39.99.129.224:8080/student/static/img/logo.gif" >
			<span class="wel_word">个人信息</span>
			<a href="/student/pages/user/login_success.jsp">返回</a>
		</div>
		
		<div id="main">
				<input type="hidden" name="action" value="show" />
				<%--<input type="hidden" name="id" value="${ requestScope.book.id }" />--%>
				<table>
					<tr>
						<td>学号</td>
						<td>${sessionScope.user.id}</td>
					</tr>
					<tr>
					<td>姓名</td>
						<td>${sessionScope.user.username}</td>
					</tr>
					<tr>
						<td>密码</td>
						<td>${sessionScope.user.password}</td>
					</tr>
					<tr>
						<td>性别</td>
						<td>${sessionScope.user.gender}</td>
					</tr>
					<tr>
						<td>专业</td>
						<td>${sessionScope.user.major}</td>
					</tr>
					<tr>
						<td>年纪</td>
						<td>${sessionScope.user.grade}</td>
					</tr>
					<tr>
						<td>电话</td>
					<td>${sessionScope.user.tel}</td>
					</tr>
					<tr>
						<td>已选课程</td>
					<td>${sessionScope.user.course}</td>
					</tr>
				</table>
		</div>


</body>
</html>