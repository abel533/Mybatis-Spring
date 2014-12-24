<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  ~ The MIT License (MIT)
  ~
  ~ Copyright (c) 2014 abel533@gmail.com
  ~
  ~ Permission is hereby granted, free of charge, to any person obtaining a copy
  ~ of this software and associated documentation files (the "Software"), to deal
  ~ in the Software without restriction, including without limitation the rights
  ~ to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  ~ copies of the Software, and to permit persons to whom the Software is
  ~ furnished to do so, subject to the following conditions:
  ~
  ~ The above copyright notice and this permission notice shall be included in
  ~ all copies or substantial portions of the Software.
  ~
  ~ THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  ~ IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  ~ FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  ~ AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  ~ LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  ~ OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  ~ THE SOFTWARE.
  --%>

<!DOCTYPE HTML>
<html lang="zh">
<head>
    <title><spring:message code="helloWorld"/></title>
    <script src="${pageContext.request.contextPath}/static/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/ajax.js"></script>
    <style>
        html, body {
            margin: 0;
            padding: 0;
        }

        .formtable {
            width: 100%
        }

        .formtable th {
            width: 150px;
            text-align: right;
            padding: 0 10px;
        }

        .formtable td {
            text-align: left;
        }
    </style>
    <script>
        function setResult(result) {
            $('#result').text(result);
        }

        function setStatus(status) {
            $('#status').css('backgroundColor', status ? 'lime' : 'red');
        }

        $(function () {
            $('#language_zh').click(function () {
                changeLanguage('zh');
            });

            $('#language_en').click(function () {
                changeLanguage('en');
            });

            $('#send').click(function () {
                var url = $('#url option:selected').val();
                var contentType = $('#contentType option:selected').val();
                var accept = $('#accept option:selected').val();
                var method = $('#method option:selected').val();
                ajaxOptions({
                    url: url,
                    method: method,
                    async: true,
                    datas: {
                        "username": "test",
                        "pwd": "test"
                    },
                    headers: {
                        Accept: accept,
                        "Content-Type": contentType
                    },
                    success: function (data) {
                        setStatus(true);
                        setResult(data);
                    },
                    failure: function (data) {
                        setStatus(false);
                        setResult(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
<div style="text-align: right;border-bottom:black solid 1px;font-size:8px;">
    <a href="http://git.oschina.net/free/Mybatis_PageHelper" target="_blank">Mybatis分页插件</a>
</div>
<div style="text-align: center;">
    <h2><spring:message code="helloWorld"/></h2>

    <div style="width:400px;text-align: center;padding:10px;margin: 0 auto;">
        <h3><spring:message code="springrequesttest"/></h3>
        <table class="formtable">
            <tr>
                <th><spring:message code="request.url"/></th>
                <td>
                    <select name="url" id="url">
                        <option value="test3">test3 - Mybatis分页插件PageHelper</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><spring:message code="request.ContentType"/></th>
                <td>
                    <select name="contentType" id="contentType">
                        <option value="text/plain">text/plain</option>
                        <option value="text/html">text/html</option>
                        <option value="application/xml">application/xml</option>
                        <option value="application/json">application/json</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><spring:message code="request.Accept"/></th>
                <td>
                    <select name="accept" id="accept">
                        <option value="text/plain">text/plain</option>
                        <option value="text/html">text/html</option>
                        <option value="application/xml">application/xml</option>
                        <option value="application/json">application/json</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><spring:message code="request.method"/></th>
                <td><select name="method" id="method">
                    <option value="GET">GET</option>
                    <option value="POST">POST</option>
                    <option value="DELETE">DELETE</option>
                    <option value="PUT">PUT</option>
                    <option value="HEAD">HEAD</option>
                    <option value="OPTIONS">OPTIONS</option>
                    <option value="TRACE">TRACE</option>
                    <option value="CONNECT">CONNECT</option>
                </select></td>
            </tr>
            <tr>
                <th></th>
                <td><input type="button" id="send" value="<spring:message code='request.send'/>"/></td>
            </tr>
            <tr>
                <th><spring:message code="request.status"/></th>
                <td>
                    <div style="height: 20px;width: 50px;border:1px solid black;" id="status"></div>
                </td>
            </tr>
            <tr>
                <th><spring:message code="request.result"/></th>
                <td>
                    <textarea style="width:100%;" rows="16" id="result"></textarea>
                </td>
            </tr>
        </table>
    </div>
    <div>
        <pre>
        ===============================================================================================
        推荐使用Mybatis分页插件
        ===============================================================================================

        Mybatis分页插件oschub的项目地址：<a href="http://git.oschina.net/free/Mybatis_PageHelper" target="_blank">http://git.oschina.net/free/Mybatis_PageHelper</a>

        Mybatis分页插件github的项目地址：<a href="https://github.com/pagehelper/Mybatis-PageHelper" target="_blank">https://github.com/pagehelper/Mybatis-PageHelper</a>

        分页插件文档地址：<a href="http://git.oschina.net/free/Mybatis_PageHelper/wikis/home" target="_blank">http://git.oschina.net/free/Mybatis_PageHelper/wikis/home</a>

        Mybatis-Sample（分页插件测试项目）：<a href="http://git.oschina.net/free/Mybatis-Sample" target="_blank">http://git.oschina.net/free/Mybatis-Sample</a>

        Mybatis项目：<a href="https://github.com/mybatis/mybatis-3" target="_blank">https://github.com/mybatis/mybatis-3</a>

        Mybatis文档：<a href="http://mybatis.github.io/mybatis-3/zh/index.html" target="_blank">http://mybatis.github.io/mybatis-3/zh/index.html</a>

        Mybatis专栏：
        Mybatis示例：<a href="http://blog.csdn.net/column/details/mybatis-sample.html" target="_blank">http://blog.csdn.net/column/details/mybatis-sample.html</a>
        Mybatis问题集：<a href="http://blog.csdn.net/column/details/mybatisqa.html" target="_blank">http://blog.csdn.net/column/details/mybatisqa.html</a>

        作者博客：
        <a href="http://my.oschina.net/flags/blog" target="_blank">http://my.oschina.net/flags/blog</a>
        <a href="http://blog.csdn.net/isea533" target="_blank">http://blog.csdn.net/isea533</a>

        作者QQ： 120807756

        作者邮箱： abel533@gmail.com

        推荐一个Mybatis的QQ群： 146127540
            </pre>
    </div>
</div>
</body>
</html>
