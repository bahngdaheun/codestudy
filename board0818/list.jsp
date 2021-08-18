<%--
  Created by IntelliJ IDEA.
  User: repar
  Date: 2021-08-17
  Time: 오후 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp"%>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach items="${Board}" var="dto">
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">${dto.title}</h5>
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/board/read?bno=${dto.bno}">${dto.bno}</a></div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
        <div>
            <button type="button" class="btn btn-outline-success">
                <a href="/board/write" style="text-decoration: none">REGISTER</a></button>
        </div>
    </div>
</section>
<%@include file="../includes/footer.jsp"%>