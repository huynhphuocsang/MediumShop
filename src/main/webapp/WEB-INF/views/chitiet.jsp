<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chi tiết sản phẩm ${masanpham }</title>
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
		<div class="col-md-7 col-sm-7 product-detail">
			<div class="row">
				<div class="col-md-4 " id="product-image" style="margin-left: 100px;">
					<img alt=""
						src='<c:url value="../../medium-shop/resources/Image/Sanpham/${sanpham.getHinhsanpham()}"/>'>
				</div>
				<div class="col-md-3 table" style="padding-left: 25px;margin-left:25px;">
					<h5 style="max-width: 100%; font-weight: bold" id="ten-sanpham">
						${sanpham.getTensanpham()}</h5>
					<h5 style="max-width: 100%; font-weight: bold" id="giatien">
						${sanpham.getGiatien()}</h5>
					<span style="display: none;" id="ma-sanpham">${sanpham.getMasanpham() }</span>
					<table class="table">
						<thead>
							<tr>
								<th>Màu</th>
								<th>Size</th>
								<th>Số lượng</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="chitiet" items="${chitietsanpham}">
								<tr>
									<td class="mau"
										data-mamau="${chitiet.getMausanpham().getMamau()}">${chitiet.getMausanpham().getTenmau() }</td>
									<td class="size"
										data-masize="${chitiet.getSizesanpham().getMasize() }">${chitiet.getSizesanpham().getTensize() }</td>
									<td class="soluong">${chitiet.getSoluong()}</td>
									<td>
										<button type="button" data-machitietsanpham="${chitiet.getMachitietsanpham()}" class="btn btn-success btn-mua">Mua</button>
									</td>
								</tr>

							</c:forEach>



						</tbody>




					</table>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-3 describe">
			<p>${sanpham.getMota()}</p>
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



