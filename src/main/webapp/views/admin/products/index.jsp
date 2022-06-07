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

	<div class="col-10 offset-1 mt-5 border border-primary p-2 bg-light">
		<form method="GET"
			action="${ pageContext.request.contextPath }/admin/products">
			<div class="row col-12 mt-2">
				<div class="col-6">
					<label>Sắp xếp theo</label> <select name="sort_by"
						class="form-control">
						<option value="id">Mặc định</option>
						<option value="name">Tên Sản Phẩm</option>
						<option value="price">Giá</option>
						
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
				<a href="${ pageContext.request.contextPath }/admin/products"
					class="btn btn-danger mt-4" type="reset"> Reset </a>
			</div>
		</form>
	</div>

	<div class="mt-5 col-10 offset-1 border border-primary p-2 bg-light">
		<h1 class="text-center pt-2">Quản Lý Product</h1>
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
				<c:forEach items="${ pageData.content }" var="product">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td><img class="logo" alt=""
							src="${pageContext.request.contextPath}/storage/${ product.image }"
							style="height: 90px; width: 130px"></td>
						<td>${product.price}</td>
						<td>${product.createDate}</td>
						<td>${product.available}</td>
						<td>${product.category.name}</td>
						<td><a class="btn btn-primary"
							href="${ pageContext.request.contextPath }/admin/products/edit/${product.id}">Update</a>
						</td>
						<td><button type="button" class="btn btn-danger"
								data-bs-toggle="modal" data-bs-target="#p${product.id}">Xóa</button>
							<!-- Modal -->
							<div class="modal fade" id="p${product.id }" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">Bạn có chắc chắn muốn xóa không?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Hủy</button>
											<a class="btn btn-danger"
												href="${ pageContext.request.contextPath }/admin/products/delete/${product.id}">Xóa</a>
										</div>
									</div>
								</div>
							</div></td>

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
							href="${ pageContext.request.contextPath }/admin/products?page=${ page.index }">${ page.index + 1 }</a>
						</li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
</body>
</html>