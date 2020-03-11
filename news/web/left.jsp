<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/17 0017
  Time: 下午 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="layui/css/layui.css"  media="all">
<div class="layui-side layui-bg-black">
<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
    <li class="layui-nav-item ">
        <a href="javascript:;">新闻类别管理</a>
        <dl class="layui-nav-child ">
            <dd><a href="addType.jsp" target="Left">添加新闻类别</a></dd>
            <dd><a href="news?method=typeList" target="Left">编辑新闻类别</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:;">新闻管理</a>
        <dl class="layui-nav-child">
            <dd id="add"><a href="addNews.jsp" target="Left" >添加新闻</a></dd>
            <dd><a href="news?method=newsList" target="Left">编辑新闻</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="javascript:;">广告管理</a></li>
    <li class="layui-nav-item"><a href="javascript:;">用户管理</a>
        <dl class="layui-nav-child">
            <dd><a href="addUser.jsp" target="Left">添加用户</a></dd>
            <dd><a href="user?method=editUserList" target="Left">编辑用户</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="javascript:;">采编管理</a>
        <dl class="layui-nav-child">
            <dd><a href="addActivity.jsp" target="Left">添加采集</a></dd>
            <dd><a href="activity?method=activityList" target="Left">采编记录</a></dd>
        </dl>
    </li>
</ul>

</div>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

    });
</script>