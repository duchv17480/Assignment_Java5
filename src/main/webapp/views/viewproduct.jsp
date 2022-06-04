<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="row text-center">
		<c:forEach items="${ listpro }" var="product">
			<div class="card col-4 " style="width: 18rem; margin-left: 60px; margin-top: 10px">
				<img
					src="${pageContext.request.contextPath}/storage/${ product.image }"
					class="img-thumbnail" style="height: 200px; width: 330px">
				<div class="card-body">
					<h5 class="card-title">${ product.name }</h5>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Price : ${ product.price }</li>
					<li class="list-group-item">Còn : ${ product.available }</li>
				</ul>
				<div class="card-body">
					<a href="#" class="card-link">Add to Cart</a> 
					<a href="${ pageContext.request.contextPath }/admin/products/${ product.id }"class="card-link">Detail</a>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>