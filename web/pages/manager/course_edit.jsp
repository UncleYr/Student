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
			<span class="wel_word">编辑课程</span>
			<div>
				<span>test<span class="um_span"></span></span>
				<a href="/student/pages/manager/student.jsp">学生管理</a>
				<a href="/student/pages/manager/login_success.jsp">返回</a>
			</div>

		</div>
		
		<div id="main">
			<form action="/student/managerServlet" method="get">
				<input type="hidden" name="action" value="${empty param.id ? "addCourse" : "updateCourse"}" />
				<input type="hidden" name="id" value="${requestScope.course.id}" />
				<table>
					<tr>
						<td>课程名</td>
						<td>授课老师</td>
						<td>授课时间</td>
						<td>授课地点</td>
						<td>上课人数</td>
						<td>剩余人数</td>
						<td>操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.course.name}"/></td>
						<td><input name="teacher" type="text" value="${requestScope.course.teacher}"/></td>
						<td><input name="time" type="text" value="${requestScope.course.time}"/></td>
						<td><input name="place" type="text" value="${requestScope.course.place}"/></td>
						<td><input name="count" type="text" value="${requestScope.course.count}"/></td>
						<td><input name="remainCount" type="text" value="${requestScope.course.remainCount}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
		</div>

</body>
</html>