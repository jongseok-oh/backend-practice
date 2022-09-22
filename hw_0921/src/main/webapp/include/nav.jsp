<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/product/readAll.do">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/product/regist.jsp">상품 정보 등록</a></li>
	</ul>
	<div class="d-flex navbar-nav me-2">
        <ul class="navbar-nav order-5 me-2">
            <c:choose>
                <c:when test="${not empty userId}">
                    <li class="nav-item" style ="color: white">${userID}님 환영합니다</li>
                    <li class="nav-item"><a class="nav-link" href="${root}/user/logout.do">로그아웃</a></li>
                </c:when>
                <c:otherwise>
            		<li class="nav-item"><a class="nav-link" href="${root}/user/login.jsp">로그인</a></li>
            	</c:otherwise>
            </c:choose>
            
        </ul>
    </div>
</nav>