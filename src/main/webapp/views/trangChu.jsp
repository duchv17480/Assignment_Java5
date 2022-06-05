<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/Assignment_Java5/css/bootstrap.min.css"></link>
<body>
	<div class="container-fluid">
		<header class="row">
			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="https://fptshop.com.vn/uploads/originals/2022/2/8/637799149033502315_nf_1200x628_1644214085.png"class="d-block w-100" alt="..." height="400px">
					</div>
					<div class="carousel-item">
						<img src="https://fptshop.com.vn/uploads/originals/2018/12/10/636800515041963456_giam-bat-ngo.png"class="d-block w-100" alt="..." height="400px">
					</div>
					<div class="carousel-item">
						<img src="https://images.fpt.shop/unsafe/filters:quality(5)/fptshop.com.vn/uploads/images/tin-tuc/125136/Originals/NF%2CNE%2CRC(1200x628)%20(7).png"class="d-block w-100" alt="..." height="400px">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="/Assignment_Java5/trangchu">Trang Chủ</a>
		 		<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/Assignment_Java5/admin/accounts">Account</a></li>
						<li class="nav-item"><a class="nav-link" href="/Assignment_Java5/admin/categories">Category</a></li>
						<li class="nav-item"><a class="nav-link" href="/Assignment_Java5/admin/products">Product</a></li>
						<li class="nav-item"><a class="nav-link" href="/Assignment_Java5/admin/orders">Order</a></li>
						<li class="nav-item"><a class="nav-link" href="/Assignment_Java5/admin/details">Order Detail</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
		<div class="row m-0">
			<aside class="col-md-3">
				<div class="card mt-2">
					<div class="card-body">
						<div class="row">
							<div class="row text-center">
								<h4>HOÀNG VIỆT ĐỨC</h4>
							</div>
						</div>
					</div>
				</div>
				<div class="card mt-1">
					<div class="card-header">SẢN PHẨM</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a href="">Lap Top</a><span
							data-bs-toggle="tooltip" data-bs-placement="top" title="Giảm 90%"
							class="badge bg-danger">Sale up to 100%</span></li>
						<li class="list-group-item"><a href="">Hoàng Việt Đức</a></li>
						<li class="list-group-item"><a href="">Hoàng Việt Đức</a></li>
						<li class="list-group-item"><a href="">Hoàng Việt Đức</a></li>
						<li class="list-group-item"><a href="">Hoàng Việt Đức</a></li>
						<li class="list-group-item"><a href="">Hoàng Việt Đức</a></li>
						<li class="list-group-item"><a href="">Hoàng Việt Đức</a></li>
						<li class="list-group-item"><a href="">Hoàng Việt Đức</a></li>
						<li class="list-group-item"><a href="">Hoàng Việt Đức</a></li>
						<li class="list-group-item"><a href="https://www.facebook.com/ducfptpoly/">click to fb </a></li>
					</ul>
				</div>
			</aside>
			<article class="col-md-9 " style="background-color: pink" >
				<jsp:include page="${ view }"></jsp:include>
			</article>
		</div>
		<footer class="row col-md text-center p-3 bg-info" style="margin: 0;">
			<marquee behavior="" direction="">HOÀNG VIỆT ĐỨC - PH17480</marquee>
			<div class="row"></div>
		</footer>
	</div>
</body>
<script src="/Assignment_Java5/js/jquery.min.js"></script>
<script src="/Assignment_Java5/js/popper.min.js"></script>
<script src="/Assignment_Java5/js/bootstrap.min.js"></script>
</html>