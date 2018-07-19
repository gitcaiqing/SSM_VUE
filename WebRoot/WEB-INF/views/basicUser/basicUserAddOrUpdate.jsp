<%--
  Created by IntelliJ IDEA.
  User: CQ
  Date: 2018/7/18
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<el-dialog :title="editTitle" :visible.sync="editDialogFormVisible">
    <el-form :model="editForm">
        <el-form-item label="用户名称" :label-width="dialogformLabelWidth">
            <el-input v-model="editForm.username"  auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="真实姓名" :label-width="dialogformLabelWidth">
            <el-input v-model="editForm.realname"  auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="用户头像" :label-width="dialogformLabelWidth">
            <el-upload
                    action="${base}/a/user/upload"
                    list-type="picture-card"
                    :limit="1"
                    :on-exceed="handleExceed"
                    :file-list="editForm.headimgs"
                    :before-upload="handleBeforeImgUpload"
                    :on-success="handleSuccessImgUpload"
            >
                <i class="el-icon-plus"></i>
            </el-upload>
        </el-form-item>

        <el-form-item label="用户性别" :label-width="dialogformLabelWidth">
            <template>
                <el-radio v-model="editForm.sex" :label="0">女</el-radio>
                <el-radio v-model="editForm.sex" :label="1">男</el-radio>
            </template>
        </el-form-item>

        <el-form-item label="年龄" :label-width="dialogformLabelWidth">
            <el-input v-model="editForm.age"  auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="联系方式" :label-width="dialogformLabelWidth">
            <el-input v-model="editForm.mobile"  auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="邮箱地址" :label-width="dialogformLabelWidth">
            <el-input v-model="editForm.email"  auto-complete="off"></el-input>
        </el-form-item>

        <el-form-item label="备注" :label-width="dialogformLabelWidth">
            <el-input v-model="editForm.memo" auto-complete="off" type="textarea"></el-input>
        </el-form-item>

        <template v-if="editForm.id">
            <el-form-item label="状态" :label-width="dialogformLabelWidth">
                <template>
                    <el-radio v-model="editForm.status" :label="1">启用</el-radio>
                    <el-radio v-model="editForm.status" :label="0">禁用</el-radio>
                </template>
            </el-form-item>
        </template>

    </el-form>
    <div slot="footer" class="dialog-footer">
        <el-button @click="editDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSave()">保存</el-button>
    </div>
</el-dialog>
