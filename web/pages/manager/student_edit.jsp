<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<link rel="shortcut icon" href="http://39.99.129.224:8080/student/static/img/logo.ico" type="image/x-icon">
	<link type="text/css" rel="stylesheet" href="http://39.99.129.224:8080/student/static/css/style.css" >
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
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
			<img class="logo_img" alt="" src="/static/img/logo1.gif" >
			<span class="wel_word">编辑学生</span>


		</div>
		
		<div id="main">
			<form action="/student/managerServlet" method="get">
				<input type="hidden" name="action" value="${empty param.id ?"addStudent":"getStudent"}" />
				<%--<input type="hidden" name="id" value="${ requestScope.user.id }" />--%>
				<table>
					<tr>
						<td>学号</td>
						<td>姓名</td>
						<td>密码</td>
						<td>性别</td>
						<td>专业</td>
						<td>年纪</td>
						<td>电话</td>
						<td>课程</td>
					</tr>
					<tr>
						<td><input name="id" type="text" value="${requestScope.user.id}"/></td>
						<td><input name="username" type="text" value="${requestScope.user.username}"/></td>
						<td><input name="password" type="text" value="${requestScope.user.password}"/></td>
						<td><input name="gender" type="text" value="${requestScope.user.gender}"/></td>
						<td><input name="major" type="text" value="${requestScope.user.major}"/></td>
						<td><input name="grade" type="text" value="${requestScope.user.grade}"/></td>
						<td><input name="tel" type="text" value="${requestScope.user.tel}"/></td>
						<td><input name="course" type="text" value="${requestScope.user.course}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
		</div>

</body>
</html>