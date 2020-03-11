<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/18 0018
  Time: 下午 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻管理系统-编辑用户信息</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>修改用户信息</legend>
            </fieldset>
            <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/user?method=editUser" method="post">
                <input type="hidden" value="${user.user_id}" name="user_id">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" lay-verify="required" value="${user.user_name}" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="password"   value="${user.user_password}" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item" pane="">
                    <label class="layui-form-label">用户身份</label>
                    <div class="layui-input-block">
                        <input class="flag" type="checkbox" name="superFlag"  lay-skin="switch"  lay-text="超管|普通用户">
                    </div>
                </div>


                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注</label>
                    <div class="layui-input-block">
                        <textarea  class="layui-textarea" name="content">${user.comment}</textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-submit="" lay-filter="demo2">确认修改</button>
                </div>
            </form>

</div>
</body>
<script src="layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length <3){
                    return '标题至少得3个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });


        //监听提交
        form.on('submit(demo1)', function(data){
            alert(11)
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });
    });



</script></html>