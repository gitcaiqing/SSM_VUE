<%--
  Created by IntelliJ IDEA.
  User: CQ
  Date: 2018/7/17
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%----%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" rel="stylesheet" href="${base}/static/css/jht-custom.css" />
    <link rel="stylesheet" rel="stylesheet" href="${base}/static/iconfont/iconfont.css"/>
    <jsp:include page="/WEB-INF/common/common.jsp"/>
    <style>
        .member-count{
            background-color: #409EFF;
            height: 120px;
            border-radius: 3px;
        }
        .order-count{
            background-color: #67C23A;
            height: 120px;
            border-radius: 3px;
        }
        .express-count{
            background-color: #E6A23C;
            height: 120px;
            border-radius: 3px;
        }
        .listing-count{
            background-color: #F56C6C;
            height: 120px;
            border-radius: 3px;
        }

    </style>
</head>
<body style="margin:0px;padding:0px;">
<div id="app" style="height:100%;display:none" v-bind:style="{display: appdisplay}">
    <el-container>
        <!-- 左侧菜单开始 -->
        <jsp:include page="/WEB-INF/common/leftmenu.jsp"/>
        <!-- 左侧菜单结束 -->
        <el-container>
            <!-- 头部开始 -->
            <jsp:include page="/WEB-INF/common/header.jsp"/>
            <!-- 头部结束 -->
            <el-main v-bind:style="{height: wheight - 60 + 'px'}">

                <!-- 主内容区开始 -->
                <div style="padding:10px 15px">
                    <h3 style="color:#999999">欢迎使用</h3>
                </div>
                <!-- 主内容区结束 -->
            </el-main>
        </el-container>
    </el-container>
</div>


</body>
<script>
    new Vue({
        el: '#app',
        data: {

        },
        methods: {

        }
    })
</script>
</html>
