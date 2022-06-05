<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table
		class="table table-success table-striped table-bordered border-primary text-center">
		<tr>
			<td>No</td>
			<td>Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Thao Tác</td>
		</tr>
		<c:set var="no" value="1"></c:set>
		<c:forEach var="item" items="${cartItems}">
			<form action="/lab4_hoangVietDucPh17480_IT16308/shoppingCart/update">
				<tr>
					<td>${no}</td>
					<td>${item.name}</td>
					<td><input type="number" value="${item.name}"
						name="quantity" onblur="this.form.submit()"></td>
					<td>${item.price}</td>
					<td><a
						href="/lab4_hoangVietDucPh17480_IT16308/shoppingCart/remove/${item.productID}">Remove</a>
					</td>
				</tr>
			</form>
			<c:set var="no" value="${ no + 1 }"></c:set>
		</c:forEach>
	</table>
</body>
</html>