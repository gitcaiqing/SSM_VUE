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
            <el-input v-model="editForm.username" auto-complete="off"></el-input>
        </el-form-item>

    </el-form>
    <div slot="footer" class="dialog-footer">
        <el-button @click="editDialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="editDialogFormVisible = false">确 定</el-button>
    </div>
</el-dialog>
