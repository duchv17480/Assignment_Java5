<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 class="text-center" style="color: red">Thông Tin Sản Phẩm Chi
		Tiết</h1>
	<div class="border border-info text-center bg-light">
		<h3>Tên Sản Phẩm : ${ product.name }</h3>
		<div class="border border-info "
			style="width: 400px; margin-left: 370px">
			<img
				src="${pageContext.request.contextPath}/storage/${ product.image }"
				class="img-thumbnail" style="height: 200px; width: 330px">
		</div>
		<p>Giá: ${ product.price }</p>
		<p>Danh Mục: ${ product.category.name }</p>
		<p>Ngày Nhập: ${ product.createDate }</p>
		<p>Bảo hành 2 năm chính hãng Tặng PMH 165.000đ</p>
		<hr>
		mua eSim Mobifone Big Data Thu cũ đổi mới trợ giá 15% 
		<hr>
		<a href="https://www.facebook.com/ducfptpoly/">Liên Hệ</a>
	</div>
	<a href="/Assignment_Java5/trangchu" class="btn btn-info m-2">Back</a>
</body>
</html>