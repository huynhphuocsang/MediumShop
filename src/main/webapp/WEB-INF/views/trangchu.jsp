<%@page import="javax.sql.rowset.FilteredRowSet"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shop quần áo của Sang đẹp trai</title>

<jsp:include page="header.jsp" />
</head>
<body>
	<div id="header" class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-none ">
			<a class="navbar-brand" href="#"> <img
				src="resources/Image/iconYame.jpg" width="60" height="30"
				class="d-inline-block align-top" alt="">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav nav-center">
					<li class="nav-item active"><a class="nav-link" href="">TRANG
							CHỦ <span class="sr-only">(current)</span>
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
					<li class="nav-item"><a class="nav-link" href="#">DỊCH VỤ</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">LIÊN HỆ</a>
					</li>

				</ul>
				<ul class="navbar-nav nav-right">

					<c:choose>
						<c:when test="${emailsession != null }">
							<%
							String first = (String) request.getAttribute("emailsession");
							first = first.substring(0, 1);
							first = first.toUpperCase();
							%>
							<li class="nav-item"><a id="login-circle" class="nav-link"
								href="login"><%=first%></a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="login">Đăng
									nhập</a></li>
						</c:otherwise>
					</c:choose>

					<li class="nav-item"><a class="navbar-brand" href="/medium-shop/giohang"> <i
							class="fa fa-shopping-cart"></i>
							<c:choose>
							<c:when test="${soluongsanpham!=null && soluongsanpham>0}">
								<div id="soluong"  class="soluongmathang">
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
		<div class="event_header wow bounceInDown">
			<span>Khuyến mãi từ 2/3 -> 8/3/2021</span><br /> <span id="sale_off">Giảm
				giá đến 50%</span><br />
			<button>XEM NGAY</button>
		</div>
	</div>


	<div id="info" class="container wow bounceInRight">
		<div class="row">
			<div class="col-md-4">
				<img src="resources/Image/icon_qualification.png" width="48"
					height="48" alt=""><br /> <span
					style="font-size: 32px; font-weight: 600">CHẤT LƯỢNG</span><br />
				<span>Chúng tôi cam kết với chất lượng sản phẩm tốt nhất</span>
			</div>
			<div class="col-md-4">
				<img src="resources/Image/icon_saveMoney.png" width="48" height="48"
					alt=""><br /> <span
					style="font-size: 32px; font-weight: 600">TIẾT KIỆM CHI PHÍ</span><br />
				<span>Chi phí rẻ nhất Việt Nam đảm bảo các bạn tiết kiệm đến
					20%</span>
			</div>
			<div class="col-md-4">
				<img src="resources/Image/icon_express.png" width="48" height="48"
					alt=""><br /> <span
					style="font-size: 32px; font-weight: 600">GIAO HÀNG</span><br /> <span>Cam
					kết giao hàng tận nơi, chất lượng. Đảm bảo đến tay khách hàng những
					sản phẩm tốt nhất</span>
			</div>
		</div>

	</div>

	<div class="container product">
		<span>SẢN PHẨM HOT</span>
		<c:set var="count" value="0"/>
		<c:forEach begin="1" end="3" step="1">
		
			<div class="row">
				<c:forEach var="product" items="${listProduct}" begin="${count+0}" end="${count+3}" step="1">
					
					<div class="col-md-3 wow bounceIn" data-wow-duration="4s">
					<a class="product-show" href="chitiet/${product.getMasanpham()}">
						<div class="specific">
						
							<img alt="" src="resources/Image/Sanpham/${product.getHinhsanpham()}" height="256"
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


	</div>

	<jsp:include page="footer.jsp" />
</body>

</html>


