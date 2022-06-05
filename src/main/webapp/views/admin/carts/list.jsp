<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
<body>
	<div class="border border-primary bg-light text-center mt-2 ">
		<h1>SHOPPING CART</h1>
		<table
			class="table table-success table-striped table-bordered border-primary text-center">
			<tr>
				<td>No</td>
				<td>Name</td>
				<td>Image</td>
				<td>Quantity</td>
				<td>Price</td>
				<td>Thao Tác</td>
			</tr>
			<c:set var="no" value="1"></c:set>
			<c:forEach var="item" items="${cartItems}">
				<form action="${ pageContext.request.contextPath }/admin/cart/update">
					<tr>
						<td>${no}</td>
						<td>${item.name}</td>
						<td><img class="logo" alt=""
							src="${pageContext.request.contextPath}/storage/${ item.image }"
							style="height: 90px; width: 130px"></td>
						<td><input type="number" value="${item.available}"
							name="quantity" onblur="this.form.submit()"></td>
						<td>${item.price}</td>
						<td><a
							href="${ pageContext.request.contextPath }/admin/cart/remove/${item.id}">Remove</a>
						</td>
					</tr>
				</form>
				<c:set var="no" value="${ no + 1 }"></c:set>
			</c:forEach>
		</table>
	</div>
</body>
</html>