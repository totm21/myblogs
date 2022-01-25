<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
	Future Imperfect by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(function () {
	var user = '<%=session.getAttribute("user")%>';
	if(user=="null")
	{
		$("#LogOut").hide();
		$("#LogIn").show();
		$("#SignIn").show();
	}
	else
	{
		$("#LogOut").show();
		$("#LogIn").hide();
		$("#SignIn").hide();
	}
});
function binding()
{
	$('#file').click();
}
function show(f) {
    var rd = new FileReader();//创建文件读取对象
    var files = f.files[0];//获取file组件中的文件
    rd.readAsDataURL(files);//文件读取装换为base64类型
    rd.onloadend = function(e) {
        //加载完毕之后获取结果赋值给img
        document.getElementById("pho").src = this.result;
    }
    
}
</script>
<html>
	<head>
		<title>Met Wonderful!</title>
				<link href="${pageContext.request.contextPath}/page2/images/title.ico" rel="icon" type="image/x-ico">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/page2/assets/css/main.css" />
	</head>
	<body class="is-preload" style="background: rgb(255 255 255);">
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="${pageContext.request.contextPath}/main.action">Home</a></h1>
						<nav class="links">
							<ul>
								<c:forEach items="${list_cate}" var="i">
									<li><a href="${pageContext.request.contextPath}/main_kinds.action?id=${i.id}">${i.content}</a></li>
								</c:forEach>
							</ul>
						</nav>
						<nav class="main">
							<ul>
								<li class="search">
									<a class="fa-search" href="#search">Search</a>
									<form id="search" method="get" action="#" >
										<input type="text" name="query" placeholder="Search" />
									</form>
								</li>
								<li class="menu">
									<a class="fa-bars" href="#menu">Menu</a>
								</li>
							</ul>
						</nav>
					</header>

				<%@include  file="/WEB-INF/jsp/base_jsp/sidebar.jsp"%>




				<!-- Sidebar -->
					<section id="main" style="text-align:center;">

						<!-- Intro -->
							<section id="intro" style="text-align:center; margin: 0px;  background: rgb(255 255 255);">
								<span class="image featured" style="margin: 0px;background: rgb(255 255 255);" onclick="binding()"><a class="logo" style="background: rgb(255 255 255);"><img id="pho" style="background: rgb(255 255 255);" src="${pageContext.request.contextPath}${user.photo}" alt="" /></a></span>
								<header>
								<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/master/saveuser.action">
									<input type="file" id="file" name="photo2" onchange="show(this)" multiple="multiple" style="display:none;">
									<input type="text" style="text-align:center; font-size: 2em;margin: 0px;background: rgb(255 255 255); border:0px; font-weight:bold" name="name" value="${user.name}">
									<input type="text" style="text-align:center; font-size: 1.5em;margin: 0px;background: rgb(255 255 255);border:0px;" name="motto" value="${user.motto}">
									<input type="text" style="text-align:center; font-size: 1.5em;margin: 0px;background: rgb(255 255 255);border:0px; display:none;"  name="id" value="${user.id}">
									<input type="text" style="text-align:center; font-size: 1.5em;margin: 0px;background: rgb(255 255 255);border:0px;" name="password" value="${user.password}">
									<input type="text" style="text-align:center; font-size: 1.5em;margin: 0px;background: rgb(255 255 255);border:0px;" name="password2" placeholder="confirm password" >
									
									<input type="submit" value="SAVE" style="margin: 20px"/>
								</form>
								</header>
							</section>



					</section>

			</div>
			<%@include  file="/WEB-INF/jsp/base_jsp/Information_bottom.jsp"%>
		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/page2/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/page2/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/page2/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/page2/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/page2/assets/js/main.js"></script>

	</body>
</html>