<%--
  Created by IntelliJ IDEA.
  User: CQ
  Date: 2018/7/17
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="/WEB-INF/common/common.jsp"/>
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

                <%--主体内容start--%>
                <el-main v-bind:style="{height: wheight - 60 + 'px'}">

                    <%--导航start--%>
                    <el-breadcrumb separator-class="el-icon-arrow-right">
                        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
                        <el-breadcrumb-item>用户列表</el-breadcrumb-item>
                    </el-breadcrumb>
                    <%--导航end--%>

                    <div style="margin-top:30px">
                        <!-- 检索条件start -->
                        <div>
                            <el-form :inline="true" :model="formSearch" class="demo-form-inline">
                                <el-form-item label="用户名称">
                                    <el-input v-model="formSearch.username"  placeholder="请输入用户名称"  onkeydown="if(event.keyCode==13)return false;"></el-input>
                                </el-form-item>

                                <el-form-item label="用户性别">
                                    <el-select v-model="formSearch.sex" placeholder="请选择">
                                        <el-option
                                                v-for="item in datas.options"
                                                :key="item.value"
                                                :label="item.label"
                                                :value="item.value">
                                        </el-option>
                                    </el-select>
                                </el-form-item>


                                <el-form-item>
                                    <el-button icon="el-icon-search" type="primary" >查询</el-button>
                                </el-form-item>
                                <el-form-item>
                                    <el-button icon="el-icon-plus" type="primary" >新增</el-button>
                                </el-form-item>
                            </el-form>
                        </div>
                        <!-- 检索条件end -->

                        <%-- 列表start --%>
                        <template>
                            <el-table ref="multipleTable" border stripe  :data="datas.tableData"
                                      tooltip-effect="dark" style="width: 100%">

                                <el-table-column prop="username" label="用户名称" align="center"></el-table-column>

                                <el-table-column prop="headimg" label="用户头像" align="center"></el-table-column>

                                <el-table-column prop="realname" label="真实姓名" align="center"></el-table-column>

                                <el-table-column prop="sex" label="性别" align="center"></el-table-column>

                                <el-table-column prop="age" label="年龄" align="center"></el-table-column>

                                <el-table-column prop="mobile" label="联系方式" align="center"></el-table-column>

                                <el-table-column prop="credate" label="创建时间" align="center"></el-table-column>

                                <el-table-column fixed="right" label="操作" align="center" width="250">
                                    <template slot-scope="scope">
                                        <el-button @click="onView(scope.row.userId)" type="text" size="small" icon="el-icon-view">详细</el-button>
                                        <el-button @click="onAdd(scope.row.userId)" type="text" size="small" icon="el-icon-edit">编辑</el-button>
                                        <el-button @click="onDelete(scope.row.userId)" type="text" size="small" icon="el-icon-delete">删除</el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </template>
                        <%-- 列表end --%>

                        <%--分页start--%>
                        <div class="block" style="margin-top:20px">
                            <el-pagination
                                    <%--@current-change="handlePageChange"
                                    @size-change="handleSizeChange"--%>
                                    :current-page="datas.page.pageNo"
                                    :page-sizes="[10, 15, 25, 50]"
                                    :page-size="datas.page.pageSize"
                                    layout="total, sizes, prev, pager, next, jumper"
                                    :total="datas.page.totalRows">
                            </el-pagination>
                        </div>
                        <%--分页end--%>

                    </div>

                </el-main>
                <%--主体内容end--%>
            </el-main>
        </el-container>
    </el-container>
</div>


</body>
<script>
    new Vue({
        el: '#app',
        data: {
            //列表页搜索条件
            formSearch: {
                username:null,
                sex: null,
            },
            datas:{
                options: [{
                    value: '0',
                    label: '女'
                }, {
                    value: '1',
                    label: '男'
                }],
                page: {
                    totalRows: 0,
                    pageSize: 10,
                    pageNo: 1
                },
                tableData:[{
                    id:"1",
                    username:"君奉天",
                    sex:"1",
                    age:11
                },{
                    id:"2",
                    username:"墨倾池",
                    age:12
                },{
                    id:"3",
                    username:"邃无端",
                    age:13
                }],

            },
        },
        methods: {

        }
    })
</script>
</html>
