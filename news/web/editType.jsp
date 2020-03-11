<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/21 0021
  Time: 上午 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>新闻管理系统-编辑新闻类型</title>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>编辑新闻类别</legend>
            </fieldset>
            <form class="layui-form layui-form-pane" action="news?method=editType" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">新闻类别</label>
                    <div class="layui-input-inline">
                        <input type="hidden" value="${type.type_id}" name="type_id">
                        <input value="${type.type_name}" type="text" name="type_name" lay-verify="required" placeholder="请输入新闻类别" autocomplete="off" class="layui-input">
                    </div>
                </div>


                <div class="layui-form-item">
                    <button class="layui-btn" lay-submit="" lay-filter="demo2">确认修改</button>
                </div>
            </form>

</div>

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
                if(value.length <2){
                    return '新闻类别至少得2个字符啊';
                }
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
</body>
