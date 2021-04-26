<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sản phẩm theo danh mục</title>
<jsp:include page="header.jsp" />
</head>
<div id="header-detail" class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
		<a class="navbar-brand" href="#"> <img
			src="../../medium-shop/resources/Image/iconYame.jpg" width="60"
			height="30" class="d-inline-block align-top" alt="">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav nav-center">
				<li class="nav-item active"><a class="nav-link"
					href="/medium-shop/">TRANG CHỦ <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Danh mục </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<c:forEach var="danhmuc" items="${listDanhMuc}">
						
						<a class="dropdown-item" href='<c:url value='/sanphamtheodanhmuc/${danhmuc.getMadanhmuc()}'/>'>${danhmuc.getTendanhmuc()}</a> 
						</c:forEach>
							
						</div> 
					</li>
				<li class="nav-item"><a class="nav-link" href="#">DỊCH VỤ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">LIÊN HỆ</a></li>

			</ul>
			<ul class="navbar-nav nav-right">


				<li class="nav-item"><a class="navbar-brand"
					href="/medium-shop/giohang"> <i class="fa fa-shopping-cart"></i>
						<c:choose>
							<c:when test="${soluongsanpham!=null && soluongsanpham>0 }">
								<div id="soluong" class="soluongmathang">
									<span>${soluongsanpham}</span>
								</div>
							</c:when>

							<c:otherwise>
								<div id="soluong">
									<span></span>
								</div>
							</c:otherwise>

						</c:choose>

				</a></li>
			</ul>
		</div>
	</nav>

</div>

<div class="container-fluid body-detail">
	<div class="row">
		<div class="col-md-2 col-sm-2 catagory">
			<h4>Danh mục sản phẩm</h4>
			<ul>
				<c:forEach var="danhmuc" items="${listDanhMuc}">
					<li>${danhmuc.getTendanhmuc()}</li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-md-10 col-sm-10 product-detail">
			<div class="row">
				<div class="col-md-12">
				
				<c:set var="count" value="0"/>
		<c:forEach begin="1" end="3" step="1">
		
			<div class="row">
				<c:forEach var="product" items="${listSanPham}" begin="${count+0}" end="${count+3}" step="1">
					
					<div class="col-md-3 wow bounceIn" data-wow-duration="4s">
					<a class="product-show" href='<c:url value="/chitiet/${product.getDanhmucsanpham().getMadanhmuc()}"/>'>
						<div class="specific">
						
							<img alt="" src='<c:url value="/resources/Image/Sanpham/${product.getHinhsanpham()}"/>'" height="256"
								width="240"><br /> <span style="font-size: 22px">${product.getTensanpham()}</span><br /> <span style="color: red; font-size: 20px">${product.getGiatien()}
								VND</span>
								
						</div>
		</a>
					</div>
				
				</c:forEach>
			<c:set var="count" value="${count+4}"/>

			</div>
		</c:forEach>
					
					
					
					
				</div>
			</div>
		</div>



	</div>

</div>


<div id="footer" class="container-fluid">
	<div class="row">
		<div class="col-md-4 wow tada">
			<p style="font-size: 32px">THÔNG TIN SHOP</p>
			<p class="about">Yame là một thương hiệu thời trang đầy uy tín
				luôn đảm bảo chất lượng cho khách hàng</p>
		</div>
		<div class="col-md-4 wow tada">
			<p style="font-size: 32px">LIÊN HỆ</p>
			<p class="about">Địa chỉ: 97 Man Thiện, phường Hiệp Phú, quận 9,
				thành phố Thủ Đức, thành phố Hồ Chí Minh</p>
			<p class="about">Số điện thoại: 0933545121</p>
		</div>
		<div class="col-md-4 wow tada">
			<p style="font-size: 32px">GÓP Ý</p>
			<form action="" method="post">
				<input name="ten" class="about input" type="text"
					placeholder="Email" /><br />
				<textarea name="tuoi" class="about input" placeholder="Nội dung"
					style="margin-top: 8px" rows="4" cols="18"></textarea>
				<button class="button" style="margin-top: 10px">ĐỒNG Ý</button>
			</form>

		</div>
	</div>
	<body>

		<jsp:include page="footer.jsp" />
	</body>
</html>



