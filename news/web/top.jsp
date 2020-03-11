<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/17 0017
  Time: 下午 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="layui/css/layui.css"  media="all">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">新闻管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="main.jsp">控制台</a></li>
            <li class="layui-nav-item"><a href="news?method=newsList" target="Left">新闻管理</a></li>
            <li class="layui-nav-item"><a href="user?method=userList" target="Left">用户列表</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="https://q2.qlogo.cn/headimg_dl?bs=%20473989356&dst_uin=473989356&dst_uin=
                    473989356&;dst_uin=473989356&spec=100&url_enc=0&referer=bu_interface&term_type=PC" class="layui-nav-img">
                    WXY
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="" class="my">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath }/user?method=loginOut">退了</a></li>
        </ul>
    </div>
    </div>