<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Giỏ hàng</title>
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


				<li class="nav-item"><a class="navbar-brand" href="#"> <i
						class="fa fa-shopping-cart"></i> <c:choose>
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
		<div class="col-md-6 col-sm-12">
		
		<h2>DANH SÁCH SẢN PHẨM ĐẶT MUA</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Tên sản phẩm</th>
						<th>Màu</th>
						<th>Size</th>
						<th>Số lượng</th>
						<th>Giá tiền </th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="sanpham" items="${danhsachgiohang}">
						<tr>
							<td class="sanpham" data-masp="${sanpham.getMasanpham()}">${sanpham.getTensanpham()}</td>
							<td class="mau" data-mamau="${sanpham.getMamau()}">${sanpham.getTenmau() }</td>
							<td class="size" data-masize="${sanpham.getMasize()}">${sanpham.getTensize() }</td>
							<td class="soluong"> <input class="soluong-giohang" type="number" value="${sanpham.getSoluong()}" min="1"></td>
							<td class="giatien" data-value="${sanpham.getGiatien()}">${sanpham.getGiatien()}</td>
							
							<td class="btn-xoa btn btn-danger">Xóa</td>
						</tr>

					</c:forEach>


				</tbody>
	


			</table>
<h3>Tổng tiền: <span style="color:red" id="tongtien">0 VND</span> </h3>
		</div>

		<div class="col-md-6 col-sm-12">
		<form action="luuhoadon" method="post">
		
		
		
			<div class="form-group">
			<h4>   	<label for="tenkhachhang">Họ và tên khách hàng</label></h4> <input type="text"
					class="form-control" id="tenkhachhang" placeholder="Họ tên của khách hàng" name="tenkhachhang">
			</div>
			
			<div class="form-group">
			
			<h4> <label for="sodt">Số điện thoại</label> </h4>
				<input
					type="text" class="form-control" id="sodt"
					placeholder="Số điện thoại" name="sodt">
			</div>
			
			<h4><label> Chọn hình thức giao hàng </label>  </h4>
			
			<div class="form-check">
				<input class="form-check-input" type="radio" name="hinhthucgiaohang"
					value="Giao hàng tận nơi miễn phí" id="giaohangtannoi"> <label
					class="form-check-label" for="giaohangtannoi"> Giao hàng
					tận nơi miễn phí </label>
			</div>

			<div class="form-check">
				<input class="form-check-input" type="radio" name="hinhthucgiaohang"
					value="Nhận tại cửa hàng" id="nhanhangcuahang"> <label
					class="form-check-label" for="nhanhangcuahang"> Nhận hàng
					tại shop </label>
			</div>
			
			<br/>
			
			<div class="form-group">
			
			<h4> <label for="diachigiaohang">Nhập vào địa chỉ giao hàng</label> </h4>
				<input
					type="text" class="form-control" id="diachigiaohang" name="diachigiaohang"
					placeholder="Địa chỉ giao hàng">
			</div>

	
			<div class="form-group">
				<h4> <label for="ghichu">Ghi chú</label> </h4>
				<textarea class="form-control" id="ghichu" name="ghichu" placeholder="Ghi chú riêng cho shop"
					rows="5"></textarea>
			</div>
		<button type="submit" class="btn btn-success">Đặt hàng</button>
		
		</form>
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



