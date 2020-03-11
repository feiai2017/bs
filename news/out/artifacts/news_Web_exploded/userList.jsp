<%@ page import="com.news.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/18 0018
  Time: 上午 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻管理系统-用户列表</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
            <table class="layui-table" lay-data="{page:true, id:'idTest'}" lay-filter="demo">
                <thead>
                <tr>
                    <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
                    <th lay-data="{field:'image', width:80}">头像</th>
                    <th lay-data="{field:'username', width:150, }">用户名</th>
                    <th lay-data="{field:'superFlag', width:100}">权限</th>
                    <th lay-data="{field:'comment'}">备注</th>
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
</div>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('table', function(){
        var table = layui.table;


    });
</script>
</html>
