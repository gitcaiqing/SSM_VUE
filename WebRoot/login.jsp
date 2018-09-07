<%--
  Created by IntelliJ IDEA.
  User: CQ
  Date: 2018/7/17
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="WEB-INF/common/taglib.jsp"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理系统</title>
    <link rel="stylesheet" href="${base}/static/css/login.css">
    <style>
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0px 1000px white inset;
        }
    </style>
    <script type="text/javascript" src="${base}/static/js/login.js"></script>
</head>
<body>

<div id="main">

    <%--<form action="${base}/a/login" method="post" class="form">--%>
    <%--Spring Security内部定义好的action提交地址
        特别要注意的是form表单的action是提交登陆信息的地址，这是security内部定义好的，
        同时自定义form时，要把form的action设置为/j_spring_security_check。
        注意这里要使用绝对路径，避免登陆页面存放的页面可能带来的问题。
    --%>
    <form action="${pageContext.request.contextPath}/login" method="post" class="form">
        <div class="form-head">
            <h2>用户登录</h2>
        </div>
        <div class="form-body">
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
            <%--
                j_username，输入登陆名的参数名称，j_password，输入密码的参数名称，这两个正常情况下也不会修改
            --%>
            <div class="ui-input">
                <input class="abc" type="text" placeholder="请输入账号" name="username" value="${username}">
            </div>
            <div class="ui-input">
                <input type="password" placeholder="请输入密码" name="password" value="${password}">
            </div>

            <%--<div class="ui-input" style="border:none">
                <input type="text" placeholder="请输入验证码" name="captcha" style="float:left;width:75%" onfocus="inputFocus(this)"/>
                <img src="${base}/captchaServlet"  id="refresh-code" style="float:right"/>
            </div>--%>
            <div style="clear:both"></div>
            <button type="submit" class="ui-button ui-button--primary" style="background-color:#409eff;margin-bottom:20px">登录</button>
            <div style="color:#E6A23C" id="message">${login_message}</div>
        </div>
    </form>
</div>


</body>
<script type="text/javascript" src="${base}/static/js/jquery-1.9.1.js"></script>
<script>
    $("#refresh-code").click(function() {
        $("#refresh-code").attr("src","${base}/captchaServlet?random="+ Math.random());
    });
    function inputFocus(obj) {
        var $this = $(obj);
        //$("#message").html("");
    }
</script>
</html>
