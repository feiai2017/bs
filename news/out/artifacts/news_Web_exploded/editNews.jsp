<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/21 0021
  Time: 下午 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻管理系统-编辑新闻</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
                <legend>修改新闻</legend>
            </fieldset>
            <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/news?method=editNews" method="post">
                <input type="hidden" value="${news.news_id}" name="news_id">
                <div class="layui-form-item">
                    <label class="layui-form-label">新闻标题</label>
                    <div class="layui-input-block">
                        <input value="${news.news_title}" type="text" name="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新闻类别</label>
                    <div class="layui-input-block">
                        <select name="news_type" lay-filter="aihao">
                            <option value=""></option>
                            <c:forEach items="${typeList}" var="type">
                                <option value="${type.type_name}">${type.type_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">关键字</label>
                    <div class="layui-input-inline">
                        <input type="text" value="${news.news_keyword}" name="keyword" lay-verify="required" placeholder="请输入关键字" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" pane="">
                    <label class="layui-form-label">是否审核</label>
                    <div class="layui-input-block">
                        <input type="radio" name="check" value="1" title="审核通过" checked="">
                        <input type="radio" name="check" value="0" title="待审核">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">日期选择</label>
                        <div class="layui-input-block">
                            <input type="text" name="date" id="date1" value="${news.news_date}" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <!--富文本编辑器-->
                <textarea id="demo" name="content" style="display: none;" >${news.news_content}</textarea><br>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-submit="" lay-filter="demo2">确认修改</button>
                </div>
            </form>
            <script src="layui/layui.js" charset="utf-8"></script>
            <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
            <script>
                layui.use('layedit', function(){
                    var layedit = layui.layedit;
                    layedit.build('demo'); //建立编辑器
                });
                layui.use(['form', 'layedit', 'laydate'], function(){
                    var form = layui.form
                        ,layer = layui.layer
                        ,layedit = layui.layedit
                        ,laydate = layui.laydate;
                    //日期
                    laydate.render({
                        elem: '#date'
                    });
                    laydate.render({
                        elem: '#date1'
                    });
                    //创建一个编辑器
                    var editIndex = layedit.build('LAY_demo_editor');

                    //自定义验证规则
                    form.verify({
                        title: function(value){
                            if(value.length < 5){
                                return '标题至少得5个字符啊';
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
</div>
</body>
</html>

