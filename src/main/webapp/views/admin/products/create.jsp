<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>
	<form:form method="POST"
		action="${ pageContext.request.contextPath }/admin/products/store"
		modelAttribute="product" enctype="multipart/form-data">
		<div class="row">
			<div class="col-7">
				<div class="form-group mt-3">
					<label>Product name</label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" element="span" cssClass="text-danger" />
				</div>
				<div class="form-group mt-3">
					<label>Price</label>
					<form:input path="price" class="form-control" />
					<form:errors path="price" element="span" cssClass="text-danger" />
				</div>
				<div class="form-group mt-3">
					<label>createDate</label>
					<form:input path="createDate" type="date" class="form-control" />
					<form:errors path="createDate" element="span"
						cssClass="text-danger" />
				</div>
				<div class="form-group mt-3">
					<label>Available</label>
					<form:input path="Available" class="form-control" />
					<form:errors path="Available" element="span" cssClass="text-danger" />
				</div>
				<div class="form-group mt-4">
					<label>Danh mục</label>
					<form:select path="category" class="form-control">
						<c:forEach items="${listCate}" var="category">
							<form:option value="${category.id}">${category.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="col-5">
				<div class="form-group mt-3">
					<label>Image</label> 
					<input name ="imageFile" type="file" class="form-control" />
				</div>
			</div>

		</div>
		<button>save</button>
	</form:form>
</body>
<script src="/Assignment_Java5/js/jquery.min.js"></script>
<script src="/Assignment_Java5/js/popper.min.js"></script>
<script src="/Assignment_Java5/js/bootstrap.min.js"></script>
</html>