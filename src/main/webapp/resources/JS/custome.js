

$("#btLogin").click(function() {
	var email = $("#email").val();
	var password = $("#password").val();

	$.ajax({
		url: "/medium-shop/api/checkForLogin",
		type: "GET",
		data: {
			email: email,
			password: password
		},
		success: function(value) {
			if (value == "true") {
				window.location.replace("/medium-shop/");
			} else {
				$("#result").text("Tên đăng nhập hoặc mật khẩu không đúng!")
			}
		}

	})
})

$("#label-sign-up").click(function() {
	$(this).addClass("label-actived");
	$("#label-sign-in").removeClass("label-actived");
	$("#sign-up-block").show();
	$("#sign-in-block").hide();
})

$("#label-sign-in").click(function() {
	$(this).addClass("label-actived");
	$("#label-sign-up").removeClass("label-actived");
	$("#sign-in-block").show();
	$("#sign-up-block").hide();
})

$(".btn-mua").click(function() {
	var tensanpham = $("#ten-sanpham").text();
	var masanpham = $("#ma-sanpham").text();

	var tenmau = $(this).closest("tr").find(".mau").text();
	var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");

	var tensize = $(this).closest("tr").find(".size").text();
	var masize = $(this).closest("tr").find(".size").attr("data-masize");

	var soluong = $(this).closest("tr").find(".soluong").text();

	var giatien = $("#giatien").text();

	var machitietsanpham = $(this).attr("data-machitietsanpham");


	$.ajax({
		url: "/medium-shop/api/addCart",
		type: "GET",
		data: {
			tensanpham: tensanpham,
			masanpham: masanpham,
			tenmau: tenmau,
			mamau: mamau,
			tensize: tensize,
			masize: masize,
			soluong: soluong,
			giatien: giatien,
			machitietsanpham: machitietsanpham
		},
		success: function(value) {
			$("#soluong").addClass("soluongmathang")
			$("#soluong").text(value);

		}




	})
})

calTongTien();
$(".soluong").change(function() {
	calTongTien();
	var masanpham = parseInt($(this).parent("tr").find(".sanpham").attr("data-masp"));
	var masize = parseInt($(this).parent("tr").find(".size").attr("data-masize"));
	var mamau = parseInt($(this).parent("tr").find(".mau").attr("data-mamau"));
	var soluong = parseInt($(this).find(".soluong-giohang").val());
	$.ajax({
		url: "/medium-shop/api/updateCart",
		type: "GET",
		data: {
			masanpham: masanpham,
			mamau: mamau,
			masize: masize,
			soluong: soluong
		},
		success: function(value) {

		}
	})
})
function calTongTien() {
	var tongtien = 0;
	$(".giatien").each(function() {
		var soluong = $(this).closest("tr").find(".soluong").find(".soluong-giohang").val();
		var giatien = parseInt($(this).attr("data-value"));

		var giatienmotsanpham = soluong * parseInt(giatien);
		var giatienmotsanphamFormat = giatienmotsanpham.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		$(this).html(giatienmotsanphamFormat);

		tongtien = tongtien + giatienmotsanpham;


	})
	var tongtienFormat = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
	$("#tongtien").html(tongtienFormat + " VND");
}

$(".btn-xoa").click(function() {
	var masanpham = $(this).closest("tr").find(".sanpham").attr("data-masp");
	var masize = $(this).closest("tr").find(".size").attr("data-masize");
	var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
	var This = $(this).closest("tr");
	$.ajax({
		url: "/medium-shop/api/deleteProduct",
		type: "GET",
		data: {
			masanpham: masanpham,
			mamau: mamau,
			masize: masize
		},
		success: function(value) {
			This.remove();
			calTongTien();
		}
	})


})


$("body").on("click", ".page-item", function() {
	var pageIndex = $(this).find(".page-link").attr("data-pageIndex");
	var This = $(this);
	$(".page-item").each(function() {
		$(this).removeClass("active");

	})
	This.addClass("active");

	if ($("#check-all").is(":checked")) {
		$("#check-all").prop("checked", false);
	}

	$.ajax({
		url: "/medium-shop/api/showProductViaPage",
		type: "GET",
		data: {
			pageIndex: pageIndex
		},
		success: function(value) {
			$("#table-product-page").find("#body-table-product-page").empty();
			$("#table-product-page").find("#body-table-product-page").append(value);

		}
	})
})


$("#check-all").click(function() {

	if ($("#check-all").is(":checked")) {
		$(".check-product").each(function() {
			$(this).prop("checked", true);

		})

	} else {
		$(".check-product").each(function() {
			$(this).prop("checked", false);
		})

	}

})


$("body").on("click", ".btn-xoa-san-pham-admin", function() {


	var masanpham = $(this).attr("data-masanpham");
	var This = $(this).closest("tr");
	$.ajax({
		url: "/medium-shop/api/deleteProduct",
		type: "POST",
		data: {
			masanpham: masanpham
		},
		success: function(value) {
			This.remove();

		}
	})


})


var files = [];
$("#hinhsanpham").change(function(event) {
	files = event.target.files;
	form = new FormData();
	form.append("file", files[0]);
	$.ajax({
		url: "/medium-shop/api/uploadFile",
		type: "POST",
		data: form,
		contentType: false,
		processData: false,
		enctype: "multipart/form-data",
		success: function(value) {

		}
	})
})

$("body").on("click", ".btn-themchitiet-admin", function() {

	$(this).remove();

	var cloneBlock = $("#clone-block-themchitietsanphamadmin").clone();
	cloneBlock.removeClass("hide-block");
	cloneBlock.removeAttr("id");

	cloneBlock.appendTo($("#container-themsanpham-admin"));
	cloneBlock.addClass("themchitietsanpham-admin");
	cloneBlock.addClass("contain-data");
})

$("#btn-themsanpham-admin").click(function(event) {
	event.preventDefault();
	var formData = $("#form-themsanpham-admin").serializeArray();
	json = {};
	$.each(formData, function(i, field) {
		if (field.name !== 'mausanpham' && field.name !== 'sizesanpham'
		 && field.name !== 'soluongsanpham') {

			json[field.name] = field.value;
		}
	});


	arrayObjectSanPham = [];
	$("#container-themsanpham-admin > .contain-data").each(function() {
		objectSanPham = {};
		var mausanpham = $(this).find('select[name="mausanpham"]').val();
		var sizesanpham = $(this).find('select[name="sizesanpham"]').val();
		var soluong = $(this).find('input[name="soluongsanpham"]').val();


		objectSanPham["mausanpham"] = mausanpham;
		objectSanPham["sizesanpham"] = sizesanpham;
		objectSanPham["soluong"] = soluong;

		arrayObjectSanPham.push(objectSanPham);

	})
	json["chitietsanpham"] = arrayObjectSanPham;
	$.ajax({
		url: "/medium-shop/api/addProduct",
		type: "POST",
		data: {
			product: JSON.stringify(json)
		},
		success: function(value) {

		}
	})
})
$("body").on("click", ".btn-capnhat-san-pham-admin", function() {


	var masanpham = $(this).attr("data-masanpham");

	$.ajax({
		url: "/medium-shop/api/aboutProduct",
		type: "POST",
		data: {
			id: masanpham
		},
		success: function(value) {
			$("#masanpham-admin").val(value.masanpham);
			$("#tensanpham").val(value.tensanpham);
			$("#giatien").val(value.giatien);
			$("#danhmucsanpham").val(value.danhmucsanpham.madanhmuc);
			if (value.gianhcho == "nam") {
				$('input:radio[name="gianhcho"][value="Nam"]').prop('checked', true);
			} 
			$("#mota").val(value.mota);
		
		
			$("#container-themsanpham-admin > .themchitietsanpham-admin").empty(); 
			$("#container-themsanpham-admin > .themchitietsanpham-admin").removeClass("contain-data"); 
 
			
			for (var i = 0; i < value.danhsachchitietsanpham.length; i++) {
				var cloneBlock = $("#clone-block-themchitietsanphamadmin").clone();
				cloneBlock.removeClass("hide-block");
				cloneBlock.removeAttr("id");
				cloneBlock.appendTo($("#container-themsanpham-admin"));
				cloneBlock.addClass("themchitietsanpham-admin"); 
				cloneBlock.addClass("contain-data"); 
				cloneBlock.find('select[name="mausanpham"]').val(value.danhsachchitietsanpham[i].mausanpham.mamau); 
				cloneBlock.find('select[name="sizesanpham"]').val(value.danhsachchitietsanpham[i].sizesanpham.masize); 
				cloneBlock.find('input[name="soluongsanpham"]').val(value.danhsachchitietsanpham[i].soluong);
				cloneBlock.find('input[name="machitietsanpham-admin"]').val(value.danhsachchitietsanpham[i].machitietsanpham);
				
				if(i != (value.danhsachchitietsanpham.length-1)){
					cloneBlock.find(".btn-themchitiet-admin").addClass("hide-block");
				}
				
				
				cloneBlock.appendTo($("#container-themsanpham-admin"));
			}
			
			$("#btn-themsanpham-admin").addClass("hide-block"); 
			$("#btn-capnhatsanpham-admin").removeClass("hide-block");

		}
	})


})

$("#btn-capnhatsanpham-admin").click(function(){
	 
	event.preventDefault();
	var formData = $("#form-themsanpham-admin").serializeArray();
	json = {};
	
	$.each(formData, function(i, field) {
		if (field.name !== 'mausanpham' && field.name !== 'sizesanpham' && field.name !== 'soluongsanpham') {
			
			json[field.name] = field.value;
			console.log(field.name); 
		}




	});

	json["masanpham"] = $("#masanpham-admin").val();
	arrayObjectSanPham = [];
	var k = 0; 
	$("#container-themsanpham-admin > .contain-data").each(function() { 
		objectSanPham = {};
		var mausanpham = $(this).find('select[name="mausanpham"]').val();
		var sizesanpham = $(this).find('select[name="sizesanpham"]').val();
		var soluong = $(this).find('input[name="soluongsanpham"]').val();
		var machitietsanpham = $(this).find('input[name="machitietsanpham-admin"]').val();

		objectSanPham["mausanpham"] = mausanpham;
		objectSanPham["sizesanpham"] = sizesanpham;
		objectSanPham["soluong"] = soluong;
		objectSanPham["machitietsanpham"] = machitietsanpham;
		arrayObjectSanPham.push(objectSanPham);

	})
	json["chitietsanpham"] = arrayObjectSanPham; 
	$.ajax({
		url: "/medium-shop/api/updateProduct",
		type: "POST",
		data: {
			product: JSON.stringify(json)
		},
		success: function(value) {

		}
	})
	


})





















