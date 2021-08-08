<%--
  Created by IntelliJ IDEA.
  User: repar
  Date: 2021-08-05
  Time: 오후 5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int no1=Integer.parseInt(request.getParameter("one"));
    int no2=Integer.parseInt(request.getParameter("two"));
    String operation=request.getParameter("operation");
    int result=0;

    if(operation.equals("+")) {
        result=no1+no2;
    } else if(operation.equals("-")) {
        result=no1-no2;
    } else if(operation.equals("*")) {
        result=no1*no2;
    } else if(operation.equals("/")) {
        result=no1/no2;
    } else if(operation.equals("%")) {
        result=no1%no2;
    }
%>


<html>
<head>
    <title>계산 결과</title>
</head>
<body>
<h1><%=no1%><%=operation%><%=no2%></h1>
<h1>=<%=result%></h1>
<a href="calcInput2.jsp">다시 시도</a>
</body>
</html>
