<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="mt-5 col-10 offset-1 border border-primary p-2 bg-light">
		<div class="">
			<a class="btn btn-success col-1"
				href="${ pageContext.request.contextPath }/admin/products/create">Create</a>
		</div>
		<table class="table table-strip table-hover table-bordered mt-3">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Image</td>
					<td>Price</td>
					<td>Date</td>
					<td>Available</td>
					<td>Category</td>
					<td colspan="2" class="text-center">Thao tác</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ listPro }" var="product">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td><img class="logo" alt=""
							src="${pageContext.request.contextPath}/storage/${ product.image }"
							style="height: 90px;width: 130px"></td>
						<td>${product.price}</td>
						<td>${product.createDate}</td>
						<td>${product.available}</td>
						<td>${product.category.name}</td>
						<td><a class="btn btn-primary"
							href="${ pageContext.request.contextPath }/admin/products/edit/${product.id}">Update</a>
						</td>
						<td>
							<form
								action="${ pageContext.request.contextPath }/admin/products/delete/${product.id}"
								method="POST">
								<button class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
</body>
</html>