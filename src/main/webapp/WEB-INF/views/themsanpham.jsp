<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

	<!--/content-inner-->

	<div class="container-fluid" style="margin-top: 100px">
		<div class="row">


			<div class="col-md-6 col-sm-12">
				<h1 style="color: red;">THÊM SẢN PHẨM MỚI</h1>
				<form id="form-themsanpham-admin" action="">

					<div id="container-themsanpham-admin">


						<div class="form-group">
							<h3>Tên sản phẩm</h3>
							
							<input type="text" class="form-control hide-block" id="masanpham-admin"
							data-masanpham=""	name="tensanpham" aria-describedby="emailHelp"
								placeholder="Điền tên sản phẩm">
								
							<input type="text" class="form-control" id="tensanpham"
							data-masanpham=""	name="tensanpham" aria-describedby="emailHelp"
								placeholder="Điền tên sản phẩm">
						</div>

						<div class="form-group">
							<h3>Giá tiền</h3>
							<input type="text" class="form-control" id="giatien"
								name="giatien" aria-describedby="emailHelp"
								placeholder="Giá tiền sản phẩm">
						</div>
						<h3>Danh mục</h3>

						<select class="form-control" name="danhmucsanpham"
							id="danhmucsanpham">
							<c:forEach var="danhmuc" items="${listdanhmucsanpham}">
								<option value="${danhmuc.getMadanhmuc()}">${danhmuc.getTendanhmuc() }</option>
							</c:forEach>
						</select> <br />


						<h3>Dành cho</h3>
						<label class="radio-inline" id="gianhcho"><input
							type="radio" name="gianhcho" checked value="Nam">Nam</label> <label
							class="radio-inline"><input type="radio" name="gianhcho"
							value="Nữ"> Nữ</label>


						<div class="form-group">
							<h3>Chọn hình sản phẩm</h3>
							<input type="file" name="hinhsanpham" id="hinhsanpham"
								class="form-control-file">
						</div>



						<div class="form-group">
							<h3>Mô tả</h3>
							<textarea class="form-control" id="mota" rows="3" name="mota"
								placeholder="Mô tả sản phẩm"></textarea>
						</div>
						
						
						
						<div class="themchitietsanpham-admin contain-data show-block" id="show-first">
							
							
							<h3>Màu sản phẩm</h3>
							<select class="form-control" name="mausanpham" >
								<c:forEach var="mausanpham" items="${listMauSanPham}">
									<option value="${mausanpham.getMamau() }">${mausanpham.getTenmau() }</option>
								</c:forEach>
							</select> <br />

							<h3>Size sản phẩm</h3>
							<select class="form-control" name="sizesanpham">
								<c:forEach var="sizesanpham" items="${listSizeSanPham}">
									<option value="${sizesanpham.getMasize() }">${sizesanpham.getTensize() }</option>
								</c:forEach>
							</select> <br />

							<h3>Số lượng sản phẩm</h3>
							<input type="number" min="1" name="soluongsanpham" value="1">
							<br />
							<button type="button"
								class="btn btn-primary btn-themchitiet-admin"
								style="float: right;">Thêm chi tiết</button>
							<br /> <br />

						</div>
					</div>
					<button type="button" class="btn btn-primary"
							id="btn-themsanpham-admin" style="float: left;">Thêm sản
							phẩm</button>
							
					<button type="button" class="btn btn-primary hide-block"
							id="btn-capnhatsanpham-admin" style="float: left;">Cập nhật sản phẩm</button>
						<br />
				</form>

				<div class="hide-block"
					id="clone-block-themchitietsanphamadmin">
					<input type="text" class="form-control hide-block" name="machitietsanpham-admin">
					<h3>Màu sản phẩm</h3>
					<select class="form-control" name="mausanpham" >
						<c:forEach var="mausanpham" items="${listMauSanPham}">
							<option value="${mausanpham.getMamau() }">${mausanpham.getTenmau() }</option>
						</c:forEach>
					</select> <br />

					<h3>Size sản phẩm</h3>
					<select class="form-control" name="sizesanpham" >
						<c:forEach var="sizesanpham" items="${listSizeSanPham}">
							<option value="${sizesanpham.getMasize() }">${sizesanpham.getTensize() }</option>
						</c:forEach>
					</select> <br />

					<h3>Số lượng sản phẩm</h3>
					<input type="number" min="1" name="soluongsanpham" value="1" class="soluongsanpham">
					<br />
					<button type="button" class="btn btn-primary btn-themchitiet-admin"
						style="float: right;">Thêm chi tiết</button>
					<br /> <br />

				</div>




			</div>
			<div class="col-md-6 col-sm-12"">
				<h1 style="color: red;">SẢN PHẨM ĐANG KINH DOANH</h1>
				<table class="table" id="table-product-page">
					<thead>

						<tr>
							<th><div class="form-check">
									<input class="form-check-input" type="checkbox" value=""
										id="check-all"> <label class="form-check-label"
										for="flexCheckDefault"> Chọn tất cả</label>
								</div></th>
							<th>Tên sản phẩm</th>
							<th>Giá tiền</th>
							<th>Giành cho</th>
						</tr>
					</thead>
					<tbody id="body-table-product-page">
						<c:forEach var="sanpham" items="${listSanPham}">
							<tr>
								<td><div class="form-check">
										<input class="form-check-input check-product" type="checkbox"
											value="" id="flexCheckDefault"> <label
											class="form-check-label" for="flexCheckDefault"> Chọn
										</label>
									</div></td>
								<td>${sanpham.getTensanpham() }</td>
								<td>${sanpham.getGiatien() }</td>
								<td>${sanpham.getGianhcho() }</td>
								<td><button type="button"
										class="btn btn-warning btn-xoa-san-pham-admin"
										data-masanpham='${sanpham.getMasanpham()}'>Xóa</button></td>
										<td><button type="button"
										class="btn btn-primary btn-capnhat-san-pham-admin"
										data-masanpham='${sanpham.getMasanpham()}'>Cập nhật</button></td>
							</tr>


						</c:forEach>


					</tbody>

				</table>

				<nav>
					<ul class="pagination pagination-lg">
						<c:forEach var="i" begin="1" end="${sotrang}" step="1">
							<c:if test="${i==1 }">
								<li class="page-item active" aria-current="page"><a
									class="page-link " href="#" data-pageIndex="${i}">${i}</a></li>
							</c:if>
							<c:if test="${i!=1}">
								<li class="page-item"><a class="page-link" href="#"
									data-pageIndex="${i}">${i}</a></li>
							</c:if>

						</c:forEach>

					</ul>
				</nav>



			</div>



		</div>


	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>