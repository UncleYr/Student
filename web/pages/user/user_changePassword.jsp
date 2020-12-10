<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
	<link rel="shortcut icon" href="http://39.99.129.224:8080/student/static/img/logo.ico" type="image/x-icon">
	<link type="text/css" rel="stylesheet" href="http://39.99.129.224:8080/student/static/css/style.css" >
	<script type="text/javascript" src="http://39.99.129.224:8080/student/static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		// 页面加载完成之后
		$(function () {

			//绑定单击事件
			$("#sub_btn").click(function () {
				// 验证确认密码：和密码相同
				//1 获取确认密码内容
				let passwordText = $("#password").val();
				let repwdText = $("#repwd").val();
				//2 和密码相比较
				if (repwdText != passwordText) {
					//3 提示用户
					$(alert("确认密码和密码不一致!"));
					return false;
				}
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="/static/img/logo1.gif" >
<%--			<span class="wel_word">个人信息管理</span>--%>


	</div>
	
	<div id="main">
		<div class="form">
			<form action="/student/userServlet" method="post">
                <input type="hidden" name="action" value="updatePassword"/>
                <table>
				<label>新密码：</label>
				<input class="itxt" type="password" placeholder="请输入新密码" autocomplete="off" name="password" id="password"/>
				<br />
				<br />
				<label>确认密码：</label>
				<input class="itxt" type="password"  autocomplete="off" tabindex="1" name="surePassword" id="repwd" />
				<br />
				<br />
				<input type="submit" value="确定" id="sub_btn" />
                </table>
			</form>

		</div>

	</div>
</body>
</html>