<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/18 0018
  Time: 上午 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻管理系统-用户列表</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
            <div class="layui-btn-group demoTable">
            <button class="layui-btn" data-type="getCheckData">编辑用户</button>
        </div>

        <table class="layui-table" lay-data="{page:true, id:'idTest'}" lay-filter="demo">
            <thead>
            <tr>

                <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
                <th lay-data="{field:'image', width:80}">头像</th>
                <th lay-data="{field:'username', width:150, }">用户名</th>
                <th lay-data="{field:'superFlag', width:100}">权限</th>
                <th lay-data="{field:'comment', width:300}">备注</th>
                <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
            </tr>
            </thead>

            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.user_id}</td>
                    <td><img src="favicon.ico" style="width:35px"height="32px "></td>
                    <td>${user.user_name}</td>
                    <td>
                        <c:if test="${user.superFlag==1}"><span style="color: red; ">${"超级管理员"}</span></c:if>
                        <c:if test="${user.superFlag==0}"><span style="color: #3a70ff">${"普通用户"}</span></c:if>
                    </td>
                    <td>${user.comment}</td>
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
                    var userid=data.id;
                    obj.del();
                    layer.close(index);
                    //确定删除
                    $.ajax({
                        url : "${pageContext.request.contextPath }/user?method=deleteUser",
                        type : "post",
                        data : {user_id:userid},
                        success : function (data) {
                        }
                    })
                });
            } else if(obj.event === 'edit'){
                var userid=data.id;
               //编辑数据的id传到后台
               $.ajax({
                   url : "${pageContext.request.contextPath }/user?method=userInfo",
                   type : "post",
                   data : {user_id:userid},
                   success : function (data) {
                       location.href="bianji.jsp";
                   }
               })
           }
        });
    });
</script>

</html>