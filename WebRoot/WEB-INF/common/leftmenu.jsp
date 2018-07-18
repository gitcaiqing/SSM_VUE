<%--
  Created by IntelliJ IDEA.
  User: CQ
  Date: 2018/7/17
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<el-aside v-bind:style="{height: wheight + 'px'}" width="{swidth +  'px'}" style="overflow:visible">
    <div style="height:100px;background-color:#545c64;border-right: solid 1px #e6e6e6;">

        <img v-if="!isCollapse" style="width:160px;margin-left:20px;margin-top:20px" src="${base}/static/img/header.jpg" alt="element-logo" class="header-logo">

        <div v-else style="text-align:center;font-size:20px;color:#FFFFFF;padding-top:20px">SSM VUE系统</div>
    </div>
    <el-menu
            class="el-menu-vertical-demo"
            v-bind:style="{height: wheight - 100 + 'px'}"
            background-color="#545c64"
            text-color="#fff"
            @select="menuItemClick"
            <%--active-text-color="#ffd04b"
            :default-active="initPaht"
            @select="menuItemClick"
            :collapse="isCollapse"--%>

    >
        <el-submenu index="0">
            <template slot="title">
                <i class="el-icon-menu"></i>
                <span>基础信息</span>
            </template>
            <el-menu-item index="${base}/a/user/tolist">
                <template>
                    <i class="el-icon-caret-right"></i>
                    <span>用户管理</span>
                </template>
            </el-menu-item>
        </el-submenu>

        <el-submenu index="1">
            <template slot="title">
                <i class="el-icon-menu"></i>
                <span>父菜单</span>
            </template>
            <el-menu-item index="${base}/demo/demo1.jsp">
                <template>
                    <i class="el-icon-caret-right"></i>
                    <span>子菜单</span>
                </template>
            </el-menu-item>
        </el-submenu>

        <el-submenu index="2">
        <template slot="title">
            <i class="el-icon-menu"></i>
            <span>父菜单</span>
        </template>
        <el-menu-item index="${base}/demo/demo2.jsp">
            <template>
                <i class="el-icon-caret-right"></i>
                <span>子菜单</span>
            </template>
        </el-menu-item>
        </el-submenu>

        <%--<el-submenu index="1">
            <template slot="title">
                <i class="el-icon-setting"></i>
                <span>信息管理</span>
            </template>
            <!-- 后台动态获取 -->
            <el-menu-item index="${base}/cmpymodule/cmpymoduleList.jsp?mark=yqdt">园区动态多次</el-menu-item>
            <el-menu-item index="${base}/cmpymodule/cmpymodule.jsp?mark=yqdt">园区动态一次</el-menu-item>
        </el-submenu>


        <el-submenu index="2">
            <template slot="title">
                <i class="el-icon-setting"></i>
                <span>分享记录</span>
            </template>
            <el-menu-item index="${base}/invitedRecords/invitedRecords.jsp">记录列表</el-menu-item>
            <el-menu-item index="${base}/invitedRecords/invitedRecordViewList.jsp">浏览记录</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
            <template slot="title">
                <i class="el-icon-setting"></i>
                <span>商家管理</span>
            </template>
            <el-menu-item index="${base}/cmpyinfo/viewCmpyinfo.jsp">商家信息</el-menu-item>
            <el-submenu index="3-2">
                <template slot="title">经销商管理</template>
                <el-menu-item index="${base}/cmpyinfo/listDealerinfo.jsp">经销商信息</el-menu-item>
                <el-menu-item index="${base}/cmpyinfo/listDealerUser.jsp">经销商用户</el-menu-item>
            </el-submenu>
            <el-menu-item index="${base}/cmpyinfo/listProduct.jsp">商品列表</el-menu-item>
        </el-submenu>

        <el-submenu index="4">
            <template slot="title">
                <i class="el-icon-setting"></i>
                <span>活动管理</span>
            </template>
            <el-menu-item index="${base}/exmarketing/list.jsp">活动中心</el-menu-item>
        </el-submenu>

        <el-submenu index="5">
            <template slot="title">
                <i class="el-icon-setting"></i>
                <span>果树认购</span>
            </template>
            <el-menu-item index="${base}/codepool/list.jsp">标签列表</el-menu-item>
        </el-submenu>

        <el-submenu index="menu-wangdian">
            <template slot="title">
                <i class="el-icon-setting"></i>
                <span>网点管理</span>
            </template>
            <el-menu-item index="${base}/branch/branchList.jsp">网点列表</el-menu-item>
        </el-submenu>

        <!-- 会员管理 -->
        <el-submenu index="menu-member">
            <template slot="title">
                <i class="el-icon-setting"></i>
                <span>会员管理</span>
            </template>
            <el-menu-item index="${base}/member/merchantMemberList.jsp">商家会员</el-menu-item>
            <el-menu-item index="${base}/member/dealerMemberList.jsp">经销商会员</el-menu-item>
        </el-submenu>

        &lt;%&ndash;       <el-menu-item index="3" @click="request('${base}/a/order/memberListPage')"> &ndash;%&gt;
        <!--         <i class="el-icon-setting"></i> -->
        <!--         <span slot="title">会员管理</span> -->
        <!--       </el-menu-item> -->

        <!-- 订单管理 -->
        <el-submenu index="menu-order">
            <template slot="title">
                <i class="el-icon-setting"></i>
                <span>订单管理</span>
            </template>
            <el-menu-item index="${base}/order/merchantOrderList.jsp">商家订单</el-menu-item>
            <el-menu-item index="${base}/order/dealerOrderList.jsp">经销商订单</el-menu-item>
        </el-submenu>--%>
</el-aside>
