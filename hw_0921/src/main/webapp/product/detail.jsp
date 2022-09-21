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
			<h2 class="bg-primary text-light text-center">상품 조회</h2>
		</div>
		<form method="post" action="${root}/product/update.do" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="code">상품코드</label></th>
						<td><input type="text" name="code" id="code" 
									value="${product.code}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th><label for="model">부서이름</label></th>
						<td><input type="text" name="model" id="model" 
							value="${product.model}"/></td>
					</tr>
					<tr>
						<th><label for="price">지역</label></th>
						<td><input type="number" name="price" id="price" 
								value="${product.price}" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정"/>
							<input type="submit" value="삭제" 
								formaction="${root}/product/delete.do" formmethod="get"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>





