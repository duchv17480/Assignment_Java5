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
		action="${ pageContext.request.contextPath }/admin/orders/update/${ order.id }"
		modelAttribute="order">
		<div class="form-group mt-3">
			<label>Create Date</label>
			<form:input path="createDate" class="form-control" readonly="true" />
			<form:errors path="createDate" element="span" cssClass="text-danger" />
		</div>
		<div class="form-group mt-3">
			<label>Address</label>
			<form:input path="address" class="form-control" />
			<form:errors path="address" element="span" cssClass="text-danger" />
		</div>
		<div class="form-group mt-3">
			<label>User</label>
			<form:select path="user" class="form-control">
				<c:forEach items="${ listaccount }" var="account">
					<form:option value="${account.id}">${account.username}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<button class="btn btn-info mt-4">Update</button>
	</form:form>
</body>
</html>