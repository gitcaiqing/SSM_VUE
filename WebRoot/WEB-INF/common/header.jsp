<%--
  Created by IntelliJ IDEA.
  User: CQ
  Date: 2018/7/17
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<el-header style="padding:0px">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" >
        <el-menu-item index="3" style="float:left;">
            <svg v-on:click="showOrColl" data-v-1421db87="" t="1492500959545" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1691" xmlns:xlink="http://www.w3.org/1999/xlink" width="26" height="26" class="wscn-icon hamburger is-active"><path data-v-1421db87="" d="M966.8023 568.849776 57.196677 568.849776c-31.397081 0-56.850799-25.452695-56.850799-56.850799l0 0c0-31.397081 25.452695-56.849776 56.850799-56.849776l909.605623 0c31.397081 0 56.849776 25.452695 56.849776 56.849776l0 0C1023.653099 543.397081 998.200404 568.849776 966.8023 568.849776z" p-id="1692"></path> <path data-v-1421db87="" d="M966.8023 881.527125 57.196677 881.527125c-31.397081 0-56.850799-25.452695-56.850799-56.849776l0 0c0-31.397081 25.452695-56.849776 56.850799-56.849776l909.605623 0c31.397081 0 56.849776 25.452695 56.849776 56.849776l0 0C1023.653099 856.07443 998.200404 881.527125 966.8023 881.527125z" p-id="1693"></path> <path data-v-1421db87="" d="M966.8023 256.17345 57.196677 256.17345c-31.397081 0-56.850799-25.452695-56.850799-56.849776l0 0c0-31.397081 25.452695-56.850799 56.850799-56.850799l909.605623 0c31.397081 0 56.849776 25.452695 56.849776 56.850799l0 0C1023.653099 230.720755 998.200404 256.17345 966.8023 256.17345z" p-id="1694"></path></svg>
        </el-menu-item>
        <el-menu-item index="3" style="float:left;" @click="toIndex">
            <el-button type="primary" size="small" round>首页</el-button>
        </el-menu-item>
        <el-submenu index="2" style="float:right;min-width:100px">
            <template slot="title">
                <img src="${base}/static/img/header.jpg" style="width:45px;height:45px;border-radius: 22.5px;margin-right:10px"> 蔡清
            </template>
            <el-menu-item index="2-1" style="min-width:100px" @click="accountset">账户设置</el-menu-item>
            <el-menu-item index="2-2" style="min-width:100px" @click="logout">安全退出</el-menu-item>
        </el-submenu>
        <el-menu-item index="1" style="float:right">
        </el-menu-item>
    </el-menu>
</el-header>
