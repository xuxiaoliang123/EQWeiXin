<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>测试页面</title>
<head>

    <script type="text/javascript" src="js/config.js">
    </script>
    <script type="text/javascript">
        <% String extLocation= "http://127.1.1.1/ext-4.2.1/";%>
        var context="<%=request.getContextPath()%>";
        context=context==''?'':context+'/';
        /*session全局变量*/
        var username="xx";
        var loginname="yy";
        var extLocation="<%=extLocation%>";
    </script>
    <script type="text/javascript"  src="<%=extLocation%>ext-all.js"></script>
    <script type="text/javascript"  src="<%=extLocation%>locale/ext-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=extLocation%>resources/css/ext-all.css" />
    <link rel="stylesheet" type="text/css" href="css/main.css" />


    <%--<script type="text/javascript" src="app-all.js"></script>--%>
    <script type="text/javascript" src="js/app.js"></script>
    <%--<script type="text/javascript" src="js/app/commonfunc.js"></script>--%>
</head>
<body style="background-color:#e6f4fc;">
</body>
</html>
<%--
<script type="text/javascript" src="js/base/md5.js"></script>
<script type="text/javascript" src="js/base/enc-base64-min.js"></script>--%>
