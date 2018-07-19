<%--
  Created by IntelliJ IDEA.
  User: CQ
  Date: 2018/7/18
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<el-dialog title="用户详细" :visible.sync="detailDialogFormVisible">
    <el-form :model="detailForm">
        <el-form-item label="用户名称" :label-width="dialogformLabelWidth">
            <el-input v-model="detailForm.username" :disabled="true" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="真实姓名" :label-width="dialogformLabelWidth">
            <el-input v-model="detailForm.realname" :disabled="true" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="用户头像" :label-width="dialogformLabelWidth">
            <el-upload
                    action="https://jsonplaceholder.typicode.com/posts/"
                    list-type="picture-card"
                    :disabled="true"
                    :file-list="detailForm.headimgs">

                <i class="el-icon-plus"></i>
            </el-upload>
        </el-form-item>

        <el-form-item label="用户性别" :label-width="dialogformLabelWidth">
            <template>
                <el-radio :disabled="true" v-model="detailForm.sex" :label="0">女</el-radio>
                <el-radio :disabled="true" v-model="detailForm.sex" :label="1">男</el-radio>
            </template>
        </el-form-item>

        <el-form-item label="年龄" :label-width="dialogformLabelWidth">
            <el-input v-model="detailForm.age" :disabled="true" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="联系方式" :label-width="dialogformLabelWidth">
            <el-input v-model="detailForm.mobile" :disabled="true" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="邮箱地址" :label-width="dialogformLabelWidth">
            <el-input v-model="detailForm.email" :disabled="true" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="备注" :label-width="dialogformLabelWidth">
            <el-input v-model="detailForm.memo" :disabled="true" auto-complete="off" type="textarea"></el-input>
        </el-form-item>

        <el-form-item label="创建时间" :label-width="dialogformLabelWidth">
            <el-input v-model="detailForm.credate" :disabled="true" auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="更新时间" :label-width="dialogformLabelWidth">
            <el-input v-model="detailForm.upddate" :disabled="true" auto-complete="off"></el-input>
        </el-form-item>

    </el-form>
    <div slot="footer" class="dialog-footer">
        <el-button @click="detailDialogFormVisible = false">关闭</el-button>
    </div>
</el-dialog>
