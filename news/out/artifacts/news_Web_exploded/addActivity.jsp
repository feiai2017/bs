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
    <title>新闻管系统-添加采编</title>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>添加新采编</legend>
    </fieldset>
    <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/activity?method=addActivity"
          method="post">

        <div class="layui-form-item">
            <label class="layui-form-label">活动标题</label>
            <div class="layui-input-inline">
                <input type="text" name="activity_name" lay-verify="activiy_name" placeholder="请输入标题" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">采访对象</label>
            <div class="layui-input-inline">
                <input type="text" name="interviewee" placeholder="请输入被采访者姓名" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" pane="">
            <label class="layui-form-label">采编状态</label>
            <div class="layui-input-block">
                <input class="flag" type="checkbox" name="superFlag"  lay-skin="switch"  lay-text="已采集|待采">
            </div>
        </div>


        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">采编内容</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" class="layui-textarea" name="comment"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="demo2" >确认添加</button>
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
            activity_name: function(value){
                if(value.length <3){
                    return '标题至少得3个字符啊';
                }
            }
            ,comment: function(value){
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