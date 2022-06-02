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
				href="${ pageContext.request.contextPath }/admin/orders/create">Create</a>
		</div>
		<table class="table table-strip table-hover table-bordered mt-3">
			<thead>
				<tr>
					<td>Id</td>
					<td>Create Date</td>
					<td>Address</td>
					<td>User</td>
					<td colspan="2" class="text-center">Thao tác</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ listorder}" var="order">
					<tr>
						<td>${order.id}</td>
						<td>${order.createDate}</td>
						<td>${order.address}</td>
						<td>${order.user.username}</td>
						<td><a class="btn btn-primary"
							href="${ pageContext.request.contextPath }/admin/orders/edit/${cate.id}">Update</a>
						</td>
						<td>
							<form
								action="${ pageContext.request.contextPath }/admin/orders/delete/${cate.id}"
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