<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/21 0021
  Time: 上午 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻管理系统-编辑新闻类型</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
            <div class="layui-btn-group demoTable">
                <button class="layui-btn" data-type="getCheckData">新闻类型</button>
            </div>

            <table class="layui-table" lay-data="{page:true, id:'idTest'}" lay-filter="demo">
                <thead>
                <tr>

                    <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
                    <th lay-data="{field:'image', width:150}">名称</th>
                    <th lay-data="{field:'username', width:150, }">日期</th>
                    <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
                </tr>
                </thead>

                <c:forEach items="${list}" var="type">
                    <tr>
                        <td>${type.type_id}</td>
                        <td>${type.type_name}</td>
                        <td>${type.type_date}</td>
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
                    var typeid=data.id;
                    obj.del();
                    layer.close(index);
                    //确定删除
                    $.ajax({
                        url : "${pageContext.request.contextPath }/news?method=deleteType",
                        type : "post",
                        data : {type_id:typeid},
                        success : function (data) {
                        }
                    })
                });
            } else if(obj.event === 'edit'){
                var typeid=data.id;
                //编辑数据的id传到后台
                $.ajax({
                    url : "${pageContext.request.contextPath }/news?method=typeInfo",
                    type : "post",
                    data : {type_id:typeid},
                    success : function (data) {
                        location.href="editType.jsp";
                    }
                })
            }
        });
    });
</script>

</html>