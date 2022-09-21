<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">상품 목록</h2>
		</div>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품코드</th>
						<th>모델명</th>
						<th>가격</th>
					</tr>			
				</thead>
				<tbody>
				
				<c:choose>
					<c:when test="${empty productList}">	
						<tr> <td colspan="4">등록된 상품정보가 없습니다.</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.productList}" 
							var="product" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td><a href="${root}/product/read.do?code=${product.code}">${product.code}</a></td>
								<td>${product.model}</td>
								<td>${product.price}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			
				</tbody>
			</table>
		</div>	
	</div>
</body>
</html>