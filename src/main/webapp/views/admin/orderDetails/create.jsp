<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/bootstrap.min.css"></link>
</head>
<body>
	<form:form method="POST"
		action="${ pageContext.request.contextPath }/admin/details/store"
		modelAttribute="orderDetail">
		<div class="form-group mt-3">
			<label>Order id</label>
			<form:select path="order_id" class="form-control">
				<c:forEach items="${ listOrder }" var="order">
					<form:option value="${order.id}">${order.id}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group mt-3">
			<label>Product</label>
			<form:select path="product_id" class="form-control">
				<c:forEach items="${ listProduct }" var="product">
					<form:option value="${product.id}">${product.name}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group mt-3">
			<label>Quantity</label>
			<form:input path="quantity" type="name" class="form-control" />
			<form:errors path="quantity" element="span" cssClass="text-danger" />
		</div>
		<div class="form-group mt-3">
			<label>Price</label>
			<form:input path="price" type="name" class="form-control" />
			<form:errors path="price" element="span" cssClass="text-danger" />
		</div>
		<button>save</button>
	</form:form>
</body>
</html>