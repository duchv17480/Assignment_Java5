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
		<c:forEach items="${ pageData.content }" var="product">
			<div class="card col-4 "
				style="width: 18rem; margin-left: 60px; margin-top: 10px">
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
					<a
						href="${ pageContext.request.contextPath }/admin/cart/add/${ product.id }">
						Add to cart</a>
					<3
					<a href="${ pageContext.request.contextPath }/admin/products/${ product.id }"
						class="card-link">Detail</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="mt-2">
		<c:if test="${not empty pageData.content }">
			<ul class="pagination">
				<c:forEach begin="0" end="${ pageData.totalPages - 1 }"
					varStatus="page">
					<li class="page-item"><a class="page-link"
						href="${ pageContext.request.contextPath }/trangchu?page=${ page.index }">${ page.index + 1 }</a>
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</div>

</body>
</html>