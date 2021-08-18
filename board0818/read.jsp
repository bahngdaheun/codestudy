<%--
  Created by IntelliJ IDEA.
  User: repar
  Date: 2021-08-17
  Time: 오후 7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div>
            <h2>NUM</h2>
            <h3>${dto.bno}</h3>
        </div>
        <div>
            <h2>TITLE</h2>
              <h3>${dto.title}</h3>
        </div>
        <div>
            <h2>CONTENT</h2>
            <h3>${dto.content}</h3>
        </div>
        <div>
            <h2>WRITER</h2>
             <h3>${dto.writer}</h3>
        </div>
        <div>
            <h2>REGDATE</h2>
            <h3>${dto.regdate}</h3>
        </div>
    </div>
    <div>
    <button type="button" class="btn btn-outline-success">
        <a href="/board/modify" style="text-decoration: none">MODIFY/DELETE</a></button>
    <button type="button" class="btn btn-outline-success">
        <a href="/board/list" style="text-decoration: none">LIST</a></button>
    </div>
</section>
<%@include file="../includes/footer.jsp"%>