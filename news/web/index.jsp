<%--
  Created by IntelliJ IDEA.
  User: WXY
  Date: 2018/12/17 0017
  Time: 上午 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jq-slideVerify.js"></script>
    <title>新闻管理系统-登录</title>
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>欢迎您！</h1>
            <form class="form" action="${pageContext.request.contextPath }/user?method=checkLogin" method="post">
                <input type="text" placeholder="用户名" name="username">
                <input type="password" placeholder="密码" name="password">
                <div class="verify-wrap" id="verify-wrap"></div>
                <button type="submit" class="btn">登录</button>
                <span style="display: block;color: red;margin-top: 20px"> ${msg}</span>
            </form>
        </div>

        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
    <h1>新闻管理系统</h1>
</div>
</body>

<script>
    $(function(){
        console.log(parseFloat('1px'))
        var SlideVerifyPlug = window.slideVerifyPlug;
        var slideVerify = new SlideVerifyPlug('#verify-wrap',{
            wrapWidth:'250',//设置 容器的宽度 ，默认为 350 ，也可不用设，你自己css 定义好也可以，插件里面会取一次这个 容器的宽度
            initText:'请按住滑块，向右滑动',  //设置  初始的 显示文字
            sucessText:'验证通过',//设置 验证通过 显示的文字
            getSucessState:function(res){
                //当验证完成的时候 会 返回 res 值 true，只留了这个应该够用了
                console.log(res);
            }
        });
           //这个可以拿到 当前验证状态  是否完成
            $(".btn").click(function () {
                if (!slideVerify.slideFinishState){
                    //未验证不提交
                    return false;
                }
            })
    })

</script>
</html>
