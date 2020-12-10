<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程管理</title>
	<link rel="shortcut icon" href="http://39.99.129.224:8080/student/static/img/logo.ico" type="image/x-icon">
	<link type="text/css" rel="stylesheet" href="http://39.99.129.224:8080/student/static/css/style.css" >
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
			// 给删除的a标签绑定单击事件，用于删除的确认提示操作
			$("a.deleteClass").click(function () {
				// 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
				/**
				 * confirm是确认提示框函数
				 * 参数是它的提示内容
				 * 它有两个按钮，一个确认，一个是取消。
				 * 返回true表示点击了，确认，返回false表示点击取消。
				 */
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
				// return false// 阻止元素的默认行为===不提交请求
			});
		});
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="/static/img/logo1.gif" >
			<span class="wel_word">学生管理</span>
		<a href="/student/pages/manager/login_success.jsp">返回</a>
	</div>
	
	<div id="main">
		<div id = search>
			<%--<from action="http://39.99.129.224:8080/student/managerServlet" method="post">
				<input type="hidden" name="action" value="searchUser"/>
				<input type="text" placeholder="姓名" autocomplete="off" tabindex="1" name="username"/>
				<input type="text" placeholder="学号" autocomplete="off" tabindex="1" name="id"/>
				<input type="submit" value="确定"/>
			</from>--%>
				<form action="http://39.99.129.224:8080/student/managerServlet" method="post">
					<input type="hidden" name="action" value="searchUser"/>
					<input class="itxt" type="text" placeholder="用户名" autocomplete="off" tabindex="1" name="username"
						   value="${requestScope.username}"/>
					<input class="itxt" type="text" placeholder="学号" autocomplete="off" tabindex="1" name="id" />
					<input type="submit" value="确定" />
				</form>
		</div>
		<table>
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>专业</td>
				<td>年纪</td>
				<td>电话</td>
				<td>已选课程</td>
				<td colspan="2">操作</td>
			</tr>		

			<c:forEach items="${requestScope.users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.gender}</td>
					<td>${user.major}</td>
					<td>${user.grade}</td>
					<td>${user.tel}</td>
					<td>${user.course}</td>
					<td><a href="managerServlet?action=updateStudent&id=${user.id}">修改</a></td>
					<td><a class="deleteClass" href="managerServlet?action=deleteStudent&id=${user.id}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/student_edit.jsp">添加学生</a></td>
			</tr>	
		</table>


	</div>

</body>
</html>