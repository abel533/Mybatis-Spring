<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mybatis分页插件 - 测试页面</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .pageDetail {
            display: none;
        }

        .show {
            display: table-row;
        }
    </style>
    <script>
        $(function () {
            $('#list').click(function () {
                $('.pageDetail').toggleClass('show');
            });
        });

    </script>
</head>
<body>
<div class="wrapper">
    <div class="middle">
        <h1 style="padding: 50px 0 20px;">国家(地区)列表</h1>

        <form action="${pageContext.request.contextPath}/list" method="post">
            <table class="gridtable" style="width:100%;">
                <tr>
                    <th>国家(地区)名称：</th>
                    <td><input type="text" name="countryname" value="${queryParam.countryname}"/></td>
                    <th>国家(地区)代码：</th>
                    <td><input type="text" name="countrycode" value="${queryParam.countrycode}"/></td>
                    <td rowspan="2"><input type="submit" value="查询"/></td>
                </tr>
                <tr>
                    <th>页码：</th>
                    <td><input type="text" name="page" value="${page}"/></td>
                    <th>页面大小：</th>
                    <td><input type="text" name="rows" value="${rows}"/></td>
                </tr>
            </table>
        </form>
        <c:if test="${page!=null}">
            <table class="gridtable" style="width:100%;">
                <tr>
                    <th colspan="2">分页信息 - [<a href="javascript:;" id="list">展开/收缩</a>]</th>
                </tr>
                <tr class="pageDetail">
                    <th style="width: 300px;">当前页号</th>
                    <td>${pageInfo.pageNum}</td>
                </tr>
                <tr class="pageDetail">
                    <th>页面大小</th>
                    <td>${pageInfo.pageSize}</td>
                </tr>
                <tr class="pageDetail">
                    <th>起始行号(>=)</th>
                    <td>${pageInfo.startRow}</td>
                </tr>
                <tr class="pageDetail">
                    <th>终止行号(<=)</th>
                    <td>${pageInfo.endRow}</td>
                </tr>
                <tr class="pageDetail">
                    <th>总结果数</th>
                    <td>${pageInfo.total}</td>
                </tr>
                <tr class="pageDetail">
                    <th>总页数</th>
                    <td>${pageInfo.pages}</td>
                </tr>
                <tr class="pageDetail">
                    <th>第一页</th>
                    <td>${pageInfo.firstPage}</td>
                </tr>
                <tr class="pageDetail">
                    <th>前一页</th>
                    <td>${pageInfo.prePage}</td>
                </tr>
                <tr class="pageDetail">
                    <th>下一页</th>
                    <td>${pageInfo.nextPage}</td>
                </tr>
                <tr class="pageDetail">
                    <th>最后一页</th>
                    <td>${pageInfo.lastPage}</td>
                </tr>
                <tr class="pageDetail">
                    <th>是否为第一页</th>
                    <td>${pageInfo.isFirstPage}</td>
                </tr>
                <tr class="pageDetail">
                    <th>是否为最后一页</th>
                    <td>${pageInfo.isLastPage}</td>
                </tr>
                <tr class="pageDetail">
                    <th>是否有前一页</th>
                    <td>${pageInfo.hasPreviousPage}</td>
                </tr>
                <tr class="pageDetail">
                    <th>是否有下一页</th>
                    <td>${pageInfo.hasNextPage}</td>
                </tr>
            </table>
            <table class="gridtable" style="width:100%;">
                <thead>
                <tr>
                    <th colspan="4">查询结果 - [<a href="${pageContext.request.contextPath}/view">新增国家(地区)</a>]</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>国家(地区)名</th>
                    <th>国家(地区)代码</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="country">
                    <tr>
                        <td>${country.id}</td>
                        <td>${country.countryname}</td>
                        <td>${country.countrycode}</td>
                        <td style="text-align:center;">[<a
                                href="${pageContext.request.contextPath}/view?id=${country.id}">修改</a>] -
                            [<a href="${pageContext.request.contextPath}/delete?id=${country.id}">删除</a>]
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="gridtable" style="width:100%;text-align: center;">
                <tr>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <td>
                            <a href="${pageContext.request.contextPath}/list?page=${pageInfo.prePage}&rows=${pageInfo.pageSize}&countryname=${queryParam.countryname}&countrycode=${queryParam.countrycode}">前一页</a>
                        </td>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="nav">
                        <c:if test="${nav == pageInfo.pageNum}">
                            <td style="font-weight: bold;">${nav}</td>
                        </c:if>
                        <c:if test="${nav != pageInfo.pageNum}">
                            <td>
                                <a href="${pageContext.request.contextPath}/list?page=${nav}&rows=${pageInfo.pageSize}&countryname=${queryParam.countryname}&countrycode=${queryParam.countrycode}">${nav}</a>
                            </td>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <td>
                            <a href="${pageContext.request.contextPath}/list?page=${pageInfo.nextPage}&rows=${pageInfo.pageSize}&countryname=${queryParam.countryname}&countrycode=${queryParam.countrycode}">下一页</a>
                        </td>
                    </c:if>
                </tr>
            </table>
        </c:if>
    </div>
    <div class="push"></div>
</div>
</body>
</html>