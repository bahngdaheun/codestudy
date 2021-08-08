<%@ page import="kr.go.practice.StoreDTO" %>
<%@ page import="kr.go.practice.StoreService" %>
<%--
  Created by IntelliJ IDEA.
  User: repar
  Date: 2021-08-08
  Time: 오후 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String area = request.getParameter("area");
    String desc = request.getParameter("desc");
    String link = request.getParameter("link");

    StoreDTO dto= StoreDTO.builder().name(name).area(area).desc(desc).link(link).build();
    StoreService.INSTANCE.add(dto);

    response.sendRedirect("show.jsp");
%>