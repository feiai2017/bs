<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/21 0021
  Time: 下午 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻管理系统-采编记录列表</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

            <div class="layui-btn-group demoTable">
                <button class="layui-btn" data-type="getCheckData">采编记录列表</button>
            </div>

            <table class="layui-table" lay-data="{page:true, id:'idTest'}" lay-filter="demo">
                <thead>
                <tr>

                    <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
                    <th lay-data="{field:'activity_name', width:200}">采编标题</th>
                    <th lay-data="{field:'interviewee', width:150}">采访对象</th>
                    <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
                </tr>
                </thead>
                <c:forEach items="${activityList}" var="activity">
                    <tr>
                        <td>${activity.activity_id}</td>
                        <td>${activity.activity_name}</td>
                        <td>${activity.interviewee}</td>
                    </tr>
                </c:forEach>


            </table>
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" id="del">删除</a>
            </script>

</div>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('table', function(){
        var table = layui.table;
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    var newsid=data.id;
                    obj.del();
                    layer.close(index);
                    //确定删除
                    $.ajax({
                        url : "${pageContext.request.contextPath }/activity?method=deleteActivity",
                        type : "post",
                        data : {activity_id:newsid},
                        success : function (data) {
                        }
                    })
                });
            } else if(obj.event === 'edit'){
                var newsid=data.id;
                //编辑数据的id传到后台
                $.ajax({
                    url : "${pageContext.request.contextPath }/activity?method=activityInfo",
                    type : "post",
                    data : {activity_id:newsid},
                    success : function (data) {
                        location.href="editActivity.jsp";
                    }
                })
            }
        });
    });
</script>

</body>
</html>
