<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/17 0017
  Time: 下午 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻管系统-添加用户 </title>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>添加新用户</legend>
            </fieldset>
            <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/user?method=addUser" method="post">

                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" lay-verify="required" placeholder="请输入不少于3位的用户名" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" placeholder="请输入6到12位密码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请务必填写用户名</div>
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
                        <textarea placeholder="请输入内容" class="layui-textarea" name="content"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-submit="" lay-filter="demo2">确认添加</button>
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
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });
    });



</script>
</html>