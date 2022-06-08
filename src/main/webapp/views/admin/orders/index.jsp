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
	<h1 class="text-center pt-2">Quản Lý Order </h1>
	<div class="col-10 offset-1 mt-5 border border-primary p-2 bg-light">
		<form method="GET"
			action="${ pageContext.request.contextPath }/admin/orders">
			<div class="row col-12 mt-2">
				<div class="col-6">
					<label>Sắp xếp theo</label> <select name="sort_by"
						class="form-control">
						<option value="id">Mặc định</option>
						<option value="createDate">Ngày Tạo</option>
					</select>
				</div>
				<div class="col-6">
					<label>Thứ tự</label> <select name="sort_direction"
						class="form-control">
						<option value="asc">Tăng dần</option>
						<option value="desc">Giảm dần</option>
					</select>
				</div>
			</div>

			<div>
				<button class="btn btn-primary mt-4">Lọc</button>
				<a href="${ pageContext.request.contextPath }/admin/orders"
					class="btn btn-danger mt-4" type="reset"> Reset </a>
			</div>
		</form>
	</div>
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
					<td colspan="3" class="text-center">Thao tác</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ pageData.content}" var="order">
					<tr>
						<td>${order.id}</td>
						<td>${order.createDate}</td>
						<td>${order.address}</td>
						<td>${order.user.username}</td>
						<td><a class="btn btn-primary"
							href="${ pageContext.request.contextPath }/admin/orders/edit/${order.id}">Update</a>
						</td>
						<td><a class="btn btn-primary"
							href="${ pageContext.request.contextPath }/admin/orders/${order.id}">Detail</a>
						</td>
						<td>
							<form
								action="${ pageContext.request.contextPath }/admin/orders/delete/${order.id}"
								method="POST">
								<button class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="mt-2">
			<c:if test="${not empty pageData.content }">
				<ul class="pagination">
					<c:forEach begin="0" end="${ pageData.totalPages - 1 }"
						varStatus="page">
						<li class="page-item"><a class="page-link"
							href="${ pageContext.request.contextPath }/admin/orders?page=${ page.index }">${ page.index + 1 }</a>
						</li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
</body>
</html>