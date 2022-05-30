<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST"
		ction="${ pageContext.request.contextPath }/admin/categories/update/${cate.id}"
		modelAttribute="cate">
		<div class="form-group mt-3">
			<label>ID</label>
			<form:input path="id" type="id" class="form-control" />
			<form:errors path="id" element="span" cssClass="text-danger" />
		</div>
		<div class="form-group mt-3">
			<label>Name</label>
			<form:input path="categoryName" type="categoryName"
				class="form-control" />
			<form:errors path="categoryName" element="span"
				cssClass="text-danger" />
		</div>
		<button>save</button>
	</form:form>
</body>
</html>