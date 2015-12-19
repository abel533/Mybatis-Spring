<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>国家(地区)信息</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body style="margin-top:50px;overflow: hidden;">
<form action="${pageContext.request.contextPath}/save" method="post">
    <input type="hidden" name="id" value="${country.id}"/>
    <table class="gridtable" style="width:800px;">
        <tr>
            <th colspan="5">国家(地区)信息 - [<a href="${pageContext.request.contextPath}/list">返回</a>]</th>
        </tr>
        <tr>
            <th>国家(地区)名称：</th>
            <td><input type="text" name="countryname" value="${country.countryname}"/></td>
            <th>国家(地区)代码：</th>
            <td><input type="text" name="countrycode" value="${country.countrycode}"/></td>
            <td><input type="submit" value="保存"/></td>
        </tr>
    </table>
</form>
</body>
</html>
