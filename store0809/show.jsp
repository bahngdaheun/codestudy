<%@ page import="kr.go.practice.StoreService" %><%--
  Created by IntelliJ IDEA.
  User: repar
  Date: 2021-08-08
  Time: 오후 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SHOW</title>
</head>
<body>
<%
    String area=request.getParameter("area");
%>
<h1><%=StoreService.INSTANCE.getDtoList(area)%></h1>
</body>
</html>
