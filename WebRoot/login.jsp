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
    <form action="${base}/a/login" method="post" class="form">
        <div class="form-head">
            <h2>用户登录</h2>
        </div>
        <div class="form-body">
            <div class="ui-input">
                <input class="abc" type="text" placeholder="请输入账号" name="username" value="${username}" onfocus="inputFocus(this)">
            </div>
            <div class="ui-input">
                <input type="password" placeholder="请输入密码" name="password" value="${password}" onfocus="inputFocus(this)">
            </div>
            <div class="ui-input" style="border:none">
                <input type="text" placeholder="请输入验证码" name="captcha" style="float:left;width:75%" onfocus="inputFocus(this)"/>
                <img src="${base}/captchaServlet"  id="refresh-code" style="float:right"/>
            </div>
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
