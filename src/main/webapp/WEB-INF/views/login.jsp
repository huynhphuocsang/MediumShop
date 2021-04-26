<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng nhập tài khoản</title>
</head>
<jsp:include page="header.jsp" />
<body>


	<div class="cover-whole">
		<div class="container main-login">
			<div class="row">
				<div class="col-md-8 left-login">
					<img alt="" src="resources/Image/background_login2.jpg" />
					<div id="top">
						<span style="color: white; font-size: 32px; font-weight: 600">SANG'S
							SHOP</span><br /> <span style="color: white">Hãy tạo nên phong
							cách của riêng bạn</span>
					</div>
					<div id="bot">
						<ul>
							<li>Luôn cập nhật xu hướng thời trang mới nhất</li>
							<li>Giảm hơn 50% tất cả các mặt hành dành cho khách VIP</li>
							<li>Tận tình tư vấn để tạo nên phong cách của riêng bạn</li>
						</ul>

					</div>
				</div>

				<div class="col-md-4 right-login">
				<c:choose>
				<c:when test="${signup==1}">
					<%System.out.println("line 90"); %>
					<div id="label-login">
						<span  id="label-sign-in" style=" font-size: 30px">Đăng nhập</span> <span style="color:black;font-size:30px">/</span> <span class="label-actived" id="label-sign-up" style=" font-size: 30px">Đăng
							kí</span>
					</div>
					<div id="sign-in-block" class="hide-block">
						<div class="input-icons">
							<i class="fa fa-envelope icon"></i> <input id="email"
								name="email" class="input-field" type="text" placeholder="Email" /><br />
						</div>
						<div class="input-icons">
							<i class="fa fa-key icon"> </i> <input id="password"
								name="password" type="password" class="input-field"
								placeholder="Mật khẩu" />
						</div>

						<button id="btLogin" class="button"
							style="margin-top: 10px; width: 280px">ĐĂNG NHẬP</button>
						<p style="color: black" id="result"></p>

						<p style="color: white">${emailsession}</p>

					</div>
	
	
		
					<div id="sign-up-block">
					<form action="login" method="post">
					<div class="input-icons">
							<i class="fa fa-envelope icon"></i> <input id="email"
								name="email" class="input-field" type="text" placeholder="Email" /><br />
								<p style="color:black;">${errorEmail}</p>
						</div>
						
						<div class="input-icons">
							<i class="fa fa-key icon"> </i> <input id="password"
								name="password" type="password" class="input-field"
								placeholder="Mật khẩu" />
								<p style="color:black;">${errorPassword}</p>
						</div>
						<div class="input-icons">
							<i class="fa fa-key icon"> </i> <input id="password"
								name="checkPassword" type="password" class="input-field"
								placeholder="Nhập lại mật khẩu" />
								<p style="color:black">${errorCheckPassword}</p>
						</div>

						<button id="sign-up" class="button"
							style="margin-top: 10px; width: 280px">ĐĂNG KÝ</button>
						<p style="color: black" id="result">${success } </p>
					</form>
		</c:when>	
		<c:otherwise>
					<div id="label-login">
						<span class="label-actived" id="label-sign-in" style=" font-size: 30px">Đăng nhập</span> <span style="color:black;font-size:30px">/</span> <span id="label-sign-up" style=" font-size: 30px">Đăng
							kí</span>
					</div>
					<div id="sign-in-block">
						<div class="input-icons">
							<i class="fa fa-envelope icon"></i> <input id="email"
								name="email" class="input-field" type="text" placeholder="Email" /><br />
						</div>
						<div class="input-icons">
							<i class="fa fa-key icon"> </i> <input id="password"
								name="password" type="password" class="input-field"
								placeholder="Mật khẩu" />
						</div>

						<button id="btLogin" class="button"
							style="margin-top: 10px; width: 280px">ĐĂNG NHẬP</button>
						<p style="color: black" id="result"></p>

						<p style="color: white">${emailsession}</p>

					</div>
	
	
		
					<div id="sign-up-block" class="hide-block">
					<form action="login" method="post">
					<div class="input-icons">
							<i class="fa fa-envelope icon"></i> <input id="email"
								name="email" class="input-field" type="text" placeholder="Email" /><br />
								<p style="color:black;">${errorEmail}</p>
						</div>
						
						<div class="input-icons">
							<i class="fa fa-key icon"> </i> <input id="password"
								name="password" type="password" class="input-field"
								placeholder="Mật khẩu" />
								<p style="color:black;">${errorPassword}</p>
						</div>
						<div class="input-icons">
							<i class="fa fa-key icon"> </i> <input id="password"
								name="checkPassword" type="password" class="input-field"
								placeholder="Nhập lại mật khẩu" />
								<p style="color:black">${errorCheckPassword}</p>
						</div>

						<button id="sign-up" class="button"
							style="margin-top: 10px; width: 280px">ĐĂNG KÝ</button>
						<p style="color: black" id="result">${success } </p>
					</form>
		
				
		</c:otherwise>
				
				</c:choose>
						
						
					
					
						
					
					
					
					</div>
				</div>
			</div>

		</div>
	</div>



	<jsp:include page="footer.jsp" />
</body>
</html>