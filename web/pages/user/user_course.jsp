<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程管理</title>
	<link rel="shortcut icon" href="http://39.99.129.224:8080/student/static/img/logo.ico" type="image/x-icon">
	<link type="text/css" rel="stylesheet" href="http://39.99.129.224:8080/student/static/css/style.css" >
	<script type="text/javascript" src="/static/script/jquery-1.7.2.js"></script>
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
			<span class="wel_word">选课</span>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>课程名</td>
				<td>授课老师</td>
				<td>上课时间</td>
				<td>上课地点</td>
				<td>人数</td>
				<td>操作</td>
			</tr>		

			<c:forEach items="${requestScope.courses}" var="course">
				<tr>
					<td>${course.name}</td>
					<td>${course.teacher}</td>
					<td>${course.time}</td>
					<td>${course.place}</td>
					<td>${course.remainCount}/${course.count}</td>
					<td><a id="sub" href="/student/userServlet?action=addCourse&courseName=${course.name}&id=${course.id}&remainCount=${course.remainCount}">确定</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>


</body>
</html>