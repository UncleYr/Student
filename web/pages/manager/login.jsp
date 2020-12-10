<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员登录页面</title>
    <link rel="shortcut icon" href="http://39.99.129.224:8080/student/static/img/logo.ico" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="http://39.99.129.224:8080/student/static/css/style.css" >
    <script type="text/javascript">
        $(function () {
            $("#sub_btn").click(function () {
                let usernameTest = $("#username").val();
                let usernamePatt = /^[a-z0-9_-]{3,16}$/;
                if (!usernamePatt.test(usernameTest)){
                    $("span.errorMsg").text("用户名不合法!");
                    return false;
                }

                let passwordTest = $("#password").val();
                let passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(passwordTest)) {
                    $("span.errorMsg").text("密码不合法!");
                    return false;
                }


                $("span.errorMsg").text("");

            });
        });

    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="http://39.99.129.224:8080/book/static/img/logo.gif" >
    <h1>欢迎来到成都东软学院在线选课系统</h1>
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎管理员登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>管理员登陆</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
<%--									<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
									${empty requestScope.msg ? "请输入用户名和密码" :requestScope.msg}
								</span>
                </div>
                <div class="form">
                    <form action="http://39.99.129.224:8080/student/managerServlet" method="post">
                        <input type="hidden" name="action" value="login"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
                               value="${requestScope.username}"/>

                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="bottom">
			<span>
				成都东软学院.Copyright &copy;2020
			</span>
</div>
</body>
</html>
