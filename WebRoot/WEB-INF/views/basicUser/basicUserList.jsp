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
                        <el-breadcrumb-item><a style="text-decoration: none" href="${base}/a/user/tolist">用户管理</a></el-breadcrumb-item>
                        <el-breadcrumb-item><a style="text-decoration: none" href="${base}/a/user/tolist">用户列表</a></el-breadcrumb-item>
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
                                    <el-button icon="el-icon-search" type="primary" @click="onSearch()">查询</el-button>
                                </el-form-item>
                                <el-form-item>
                                    <el-button icon="el-icon-plus" type="primary" @click="onEdit()">新增</el-button>
                                </el-form-item>
                            </el-form>
                        </div>
                        <!-- 检索条件end -->

                        <%-- 列表start --%>
                        <template>
                            <el-table ref="multipleTable" border stripe  :data="datas.tableData"
                                      tooltip-effect="dark" style="width: 100%">

                                <el-table-column prop="username" label="用户名称" align="center"></el-table-column>

                                <el-table-column prop="headimg" label="用户头像" align="center">
                                    <template slot-scope="scope">
                                        <img v-bind:src="scope.row.headimg" style="width:45px;height:45px;border-radius: 5px;">
                                    </template>
                                </el-table-column>

                                <el-table-column prop="realname" label="真实姓名" align="center"></el-table-column>

                                <el-table-column prop="sex" label="性别" align="center">
                                    <template slot-scope="scope">
                                        <el-tag type="success" v-if="scope.row.sex == 1">男</el-tag>
                                        <el-tag type="danger" v-else-if="scope.row.sex == 0">女</el-tag>
                                        <el-tag type="warning" v-else>--</el-tag>
                                    </template>
                                </el-table-column>

                                <el-table-column prop="age" label="年龄" align="center"></el-table-column>

                                <el-table-column prop="mobile" label="联系方式" align="center"></el-table-column>

                                <el-table-column prop="credate" label="创建时间" align="center"></el-table-column>

                                <el-table-column prop="sex" label="状态" align="center">
                                    <template slot-scope="scope">
                                        <el-tag type="success" v-if="scope.row.status == 1">启用</el-tag>
                                        <el-tag type="danger" v-else-if="scope.row.status == 0">禁用</el-tag>
                                        <el-tag type="warning" v-else>--</el-tag>
                                    </template>
                                </el-table-column>

                                <el-table-column fixed="right" label="操作" align="center" width="250">
                                    <template slot-scope="scope">
                                        <el-button @click="onView(scope.row.id)" type="text" size="small" icon="el-icon-view">详细</el-button>
                                        <el-button @click="onEdit(scope.row.id)" type="text" size="small" icon="el-icon-edit">编辑</el-button>
                                        <el-button @click="onDelete(scope.row.id)" type="text" size="small" icon="el-icon-delete">删除</el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </template>
                        <%-- 列表end --%>

                        <%--分页start--%>
                        <div class="block" style="margin-top:20px">
                            <el-pagination
                                    @size-change="handleSizeChange"
                                    @current-change="handleCurrentChange"
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

    <%--详细弹框页start--%>
    <%@include file="basicUserDetail.jsp"%>
    <%--详细弹框页end--%>

    <%--详细弹框页start--%>
    <%@include file="basicUserAddOrUpdate.jsp"%>
    <%--详细弹框页end--%>
    
    <!--编辑动态元素弹框start-->
    <%--<%@ include file="/a/codepool/apply.jsp"%>--%>
    <!-- 编辑动态元素弹框end -->
    
</div>


</body>
<script>
    new Vue({
        el: '#app',
        data: {
            //详细页弹框
            detailDialogFormVisible:false,
            //新增或修改页弹框
            editDialogFormVisible:false,
            detailDialogImgVisible:false,
            editTitle:'新增用户',
            dialogformLabelWidth:'120px',
            //列表页搜索条件
            formSearch: {
                username:null,
                sex: null,
            },

            detailForm:{},
            editForm:{},
            datas:{
                options: [{
                    value: null,
                    label: '请选择性别'
                },{
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
                tableData:[{}],
            },
        },
        mounted:function(){
            var that = this;
            //调用获取列表数据的方法
            that.listBasicuser(that.datas.page.pageNo, that.datas.page.pageSize);
        },
        methods: {
            onSearch:function(){
                var that = this;
                that.listBasicuser(that.datas.page.pageNo, that.datas.page.pageSize);
            },
            //页面记录数更改
            handleSizeChange:function (pageSize) {
                console.log("每页记录数："+pageSize);
                var that = this;
                that.listBasicuser(that.datas.page.pageNo, pageSize)
            },
            //点击页码当前页更改
            handleCurrentChange:function (pageNo) {
                console.log("当前页:"+pageNo);
                var that = this;
                that.listBasicuser(pageNo, that.datas.page.pageSize)
            },
            listBasicuser:function (pageNo, pageSize) {
                var that = this;
                axios.get('${base}/a/user/users',{
                    params:{
                        'pageNo':pageNo, 'pageSize':pageSize,
                        'username':this.formSearch.username, 'sex':this.formSearch.sex
                    },
                }).then(function(response){
                    console.log('response:'+response);
                    var _data = response.data;
                    that.datas.tableData = _data.list;
                    that.datas.page.totalRows = _data.totalRows;

                }).catch(function (error) {
                    console.log('error:'+error);
                    that.$message({
                        message: '系统服务繁忙，请稍后重试！',
                        type: 'warning'
                    });
                });
            },
            //详细
            onView:function(id){
                var that = this;
                //获取用户信息
                axios.get('${base}/a/user/'+id).then(function (response) {
                    that.detailForm = response.data;
                    var imgs = [];
                    var imgmap = {};
                    imgmap.name = 'head1';
                    imgmap.url = response.data.headimg;
                    imgs.push(imgmap);
                    that.detailForm.headimgs = (imgs);
                }).catch(function (error) {
                    console.log('error:'+error);
                    that.$message({
                        message: '系统服务繁忙，请稍后重试！',
                        type: 'warning'
                    });
                });
                that.detailDialogFormVisible = true;
            },
            //新增编辑
            onEdit:function(id){
                var that = this;
                if(id != null){
                    that.editTitle = "编辑用户";
                    //获取用户信息
                    axios.get('${base}/a/user/'+id).then(function (response) {
                        that.editForm = response.data;
                        that.editForm.credate = new Date(response.data.credate);
                        that.editForm.upddate = new Date(response.data.upddate);

                        //图片集合
                        var imgs = [];
                        var imgmap = {};
                        imgmap.name = 'head1';
                        imgmap.url = response.data.headimg;
                        imgs.push(imgmap);
                        that.detailForm.headimgs = imgs;

                    }).catch(function (error) {
                        console.log('error:'+error);
                        that.$message({
                            message: '系统服务繁忙，请稍后重试！',
                            type: 'warning'
                        });
                    });
                }else{
                    that.editTitle = "新增用户";
                    that.editForm.status = 1;
                    that.editForm.sex = 0;
                }
                that.editDialogFormVisible = true;
            },
            onDelete:function(id){
                var that = this;
                that.$confirm('确定删除用户?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(function() {
                    axios({
                        method: 'post',
                        url: base+"/a/user/"+id,
                        data: { '_method': "DELETE"},
                        transformRequest: [function (data) {
                            var ret = ''
                            for (var it in data) {ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'}
                            return ret
                        }],
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    }).then(function (response) {
                        var issuccess = response.data.success;
                        if(issuccess){
                            that.$message({
                                message: '删除成功！',
                                type: 'success'
                            });
                            that.listBasicuser(that.datas.page.pageNo, that.datas.page.pageSize);
                        }else{
                            that.$message({
                                message: '系统服务繁忙，请稍后重试！',
                                type: 'warning'
                            });
                        }
                    }).catch(function () {
                        that.$message({
                            message: '系统服务繁忙，请稍后重试！',
                            type: 'warning'
                        });
                    });
                }).catch(function() {

                });
            },
            //保存
            onSave:function(){
                var that = this;
                var data = that.editForm;
                //新增
                if(!data.id){
                    data._method = "PUT";
                    //启用
                    data.status = 1;
                }
                if(data.age){
                    data.age = parseInt(data.age);
                }else{
                    data.age = null;
                }

                axios({
                    method: 'post',
                    url: base+"/a/user",
                    data:data,
                    transformRequest: [function (data) {
                        var ret = ''
                        for (var it in data) {ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'}
                        return ret
                    }],
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function (response) {
                    var issuccess = response.data.success;
                    if(issuccess){
                        that.$message({
                            message: '保存成功！',
                            type: 'success'
                        });
                        that.editDialogFormVisible = false;
                        that.listBasicuser(that.datas.page.pageNo, that.datas.page.pageSize);
                    }else{
                        that.$message({
                            message: '系统服务繁忙，请稍后重试！',
                            type: 'warning'
                        });
                    }
                }).catch(function () {
                    that.$message({
                        message: '系统服务繁忙，请稍后重试！',
                        type: 'warning'
                    });
                });
            },
            //图片上传之前
            handleBeforeImgUpload:function (file) {
                console.log("file:"+file);
                var that = this;
                const isJPG = file.type === 'image/jpeg';
                if(!isJPG){
                    that.$message.error('上传头像图片只能是JPG格式！');
                }
                return isJPG;
            },
            //图片上传成功之后
            handleSuccessImgUpload:function (res, file) {
                //显示上传的图片
                const imageUrl = res.content;
                var that = this;
                //图片集合
                var imgs = [];
                var imgmap = {};
                imgmap.name = 'head1';
                imgmap.url = imageUrl;
                imgs.push(imgmap);
                that.editForm.headimgs = imgs;
                that.editForm.headimg = imageUrl;
            },
            handleExceed:function () {
                this.$message.error('只能上传1张头像图片！');
            }

        }
    })
</script>
</html>




























