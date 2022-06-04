<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		action="${ pageContext.request.contextPath }/admin/categories/store"
		modelAttribute="cate">
		<div class="border border-info m-3 bg-light">
		<h2 class="text-center">Create new Category</h2>
			<div class="form-group m-3">
				<label>ID</label>
				<form:input path="id" type="id" class="form-control"
					placeholder="cái này tự sinh id rồi không cần nhập đâu ạ"
					readonly="true" />
			</div>
			<div class="form-group m-3">
				<label>Category Name</label>
				<form:input path="name" type="name" class="form-control" />
				<form:errors path="name" element="span" cssClass="text-danger" />
			</div>
			<button class="btn btn-info">save</button>
		</div>
	</form:form>
</body>
</html>