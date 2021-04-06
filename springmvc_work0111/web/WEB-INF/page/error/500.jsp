<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/11
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    $(function(){
        let time = 3;
        window.setInterval(function(){
            time--;
            $("span").text(time+"");
            if(time==0){
                // 跳到登录页面
                location.href = "tologin";
            }
        },1000);
    });
</script>
<body>
<p>系统繁忙，请稍后重试。<span>3</span>后为您跳转登录界面</p>
</body>
</html>
