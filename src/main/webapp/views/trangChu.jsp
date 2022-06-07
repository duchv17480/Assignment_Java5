<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/Assignment_Java5/css/bootstrap.min.css"></link>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
	<div class="container-fluid">
		<header class="row">
			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img
							src="https://fptshop.com.vn/uploads/originals/2022/2/8/637799149033502315_nf_1200x628_1644214085.png"
							class="d-block w-100" alt="..." height="400px">
					</div>
					<div class="carousel-item">
						<img
							src="https://fptshop.com.vn/uploads/originals/2018/12/10/636800515041963456_giam-bat-ngo.png"
							class="d-block w-100" alt="..." height="400px">
					</div>
					<div class="carousel-item">
						<img
							src="https://images.fpt.shop/unsafe/filters:quality(5)/fptshop.com.vn/uploads/images/tin-tuc/125136/Originals/NF%2CNE%2CRC(1200x628)%20(7).png"
							class="d-block w-100" alt="..." height="400px">
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
				<a class="navbar-brand" href="/Assignment_Java5/trangchu">Trang
					Chủ</a>
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
						<li class="nav-item"><a class="nav-link"
							href="/Assignment_Java5/admin/categories">Category</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Assignment_Java5/admin/products">Product</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Assignment_Java5/admin/orders">Order</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/Assignment_Java5/admin/details">Order Detail</a></li>
					</ul>
					<form class="d-flex">
						<a class="btn btn-outline-success" href="/Assignment_Java5/admin/cart/list">
							Giỏ Hàng <span data-bs-toggle="tooltip" data-bs-placement="top"
								title="Giảm 90%" class="badge bg-danger">${ NoOfItem }</span>
						</a>
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
						<li class="list-group-item"><a
							href="https://www.facebook.com/ducfptpoly/">click to fb </a></li>
					</ul>
				</div>
			</aside>
			<article class="col-md-9 " style="background-color: pink">
				<jsp:include page="${ view }"></jsp:include>
			</article>
		</div>
		<!-- Remove the container if you want to extend the Footer to full width. -->
		<div class="container-fluid m-0 p-0">
			<!-- Footer -->
			<footer class="text-center text-lg-start text-white"
				style="background-color: #929fba">
				<!-- Grid container -->
				<div class="container p-4 pb-0">
					<!-- Section: Links -->
					<section class="">
						<!--Grid row-->
						<div class="row">
							<!-- Grid column -->
							<div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
								<h6 class="text-uppercase mb-4 font-weight-bold">Company
									name</h6>
								<p>Here you can use rows and columns to organize your footer
									content. Lorem ipsum dolor sit amet, consectetur adipisicing
									elit.</p>
							</div>
							<!-- Grid column -->

							<hr class="w-100 clearfix d-md-none" />

							<!-- Grid column -->
							<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
								<h6 class="text-uppercase mb-4 font-weight-bold">Products</h6>
								<p>
									<a class="text-white">MDBootstrap</a>
								</p>
								<p>
									<a class="text-white">MDWordPress</a>
								</p>
								<p>
									<a class="text-white">BrandFlow</a>
								</p>
								<p>
									<a class="text-white">Bootstrap Angular</a>
								</p>
							</div>
							<!-- Grid column -->

							<hr class="w-100 clearfix d-md-none" />

							<!-- Grid column -->
							<hr class="w-100 clearfix d-md-none" />

							<!-- Grid column -->
							<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
								<h6 class="text-uppercase mb-4 font-weight-bold">Contact</h6>
								<p>
									<i class="fas fa-home mr-3"></i> New York, NY 10012, US
								</p>
								<p>
									<i class="fas fa-envelope mr-3"></i> duchvph17480@fpt.edu.vn
								</p>
								<p>
									<i class="fas fa-phone mr-3"></i> + 84 333 456 196
								</p>
								<p>
									<i class="fas fa-print mr-3"></i> + 84 333 456 196
								</p>
							</div>
							<!-- Grid column -->

							<!-- Grid column -->
							<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
								<h6 class="text-uppercase mb-4 font-weight-bold">Follow us</h6>

								<!-- Facebook -->
								<a class="btn btn-primary btn-floating m-1"
									style="background-color: #3b5998" href="#!" role="button"><i
									class="fab fa-facebook-f"></i></a>

								<!-- Twitter -->
								<a class="btn btn-primary btn-floating m-1"
									style="background-color: #55acee" href="#!" role="button"><i
									class="fab fa-twitter"></i></a>

								<!-- Google -->
								<a class="btn btn-primary btn-floating m-1"
									style="background-color: #dd4b39" href="#!" role="button"><i
									class="fab fa-google"></i></a>

								<!-- Instagram -->
								<a class="btn btn-primary btn-floating m-1"
									style="background-color: #ac2bac" href="#!" role="button"><i
									class="fab fa-instagram"></i></a>

								<!-- Linkedin -->
								<a class="btn btn-primary btn-floating m-1"
									style="background-color: #0082ca" href="#!" role="button"><i
									class="fab fa-linkedin-in"></i></a>
								<!-- Github -->
								<a class="btn btn-primary btn-floating m-1"
									style="background-color: #333333" href="#!" role="button"><i
									class="fab fa-github"></i></a>
							</div>
						</div>
						<!--Grid row-->
					</section>
					<!-- Section: Links -->
				</div>
				<!-- Grid container -->

				<!-- Copyright -->
				<div class="text-center p-3"
					style="background-color: rgba(0, 0, 0, 0.2)">
					@Hoàng Việt Đức <3 <a class="text-white"
						href="https://mdbootstrap.com/">Ứng Dụng Phần Mềm</a>
				</div>
				<!-- Copyright -->
			</footer>
			<!-- Footer -->
		</div>
		<!-- End of .container -->
	</div>
</body>
<script src="/Assignment_Java5/js/jquery.min.js"></script>
<script src="/Assignment_Java5/js/popper.min.js"></script>
<script src="/Assignment_Java5/js/bootstrap.min.js"></script>
</html>