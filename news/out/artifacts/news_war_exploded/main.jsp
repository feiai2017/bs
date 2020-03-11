<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/17 0017
  Time: 下午 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js" charset="utf-8"></script>
    <title>新闻管系统 </title>
    <style>
        body {
            margin: 0px;
            overflow: hidden;}
    </style>
</head>
<body class="layui-layout-body" >
<div class="layui-layout layui-layout-admin">
<%@include file="top.jsp"%>
<%@include file="left.jsp"%>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
        <iframe  src="html/welcome.html" id="myiframe" onload="changeFrameHeight()" width="100%" frameborder="0" name="Left" scrolling="no" ></iframe>
        </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        &reg; 2019 <span style="color: red">&hearts;</span>  <a href="https://wxy97.com">WXY</a>
    </div>
</div>
<script>
    function changeFrameHeight(){
        var ifm= document.getElementById("myiframe");
        ifm.height=document.documentElement.clientHeight+36;

    }
    window.onresize=function(){
        changeFrameHeight();

    }
    //执行获取新闻类型select
    $.ajax({
        url:"news?method=getTypeSelect",
        type:"get"
    })
    $(window.parent.document).find("#myiframe").load(function(){
        var main = $(window.parent.document).find("#myiframe");
        var thisheight = $(document).height()+300;
        main.height(thisheight);
    });
</script>
</body>
</html>
