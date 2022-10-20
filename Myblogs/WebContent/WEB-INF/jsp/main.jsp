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
</script>
<html>
	<head>
		<title>Met Wonderful!</title>
		<link href="${pageContext.request.contextPath}/page2/images/title.ico" rel="icon" type="image/x-ico">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/page2/assets/css/main.css" />
	</head>
	<body class="is-preload">
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="${pageContext.request.contextPath}/main.action">Home</a></h1>
						<nav class="links">
							<ul style="height: 100%;" >
								<c:forEach items="${list_cate}" var="i">
									<li><a href="${pageContext.request.contextPath}/main_kinds.action?id=${i.id}">${i.content}</a></li>
								</c:forEach>
							</ul>
						</nav>
						<nav class="main">
							<ul>
								<li class="search">
									<a class="fa-search" href="#search">Search</a>
									<form id="search" style="padding-top: 0.5em;" method="get" action="${pageContext.request.contextPath}/find_art_like.action" >
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
				
				<!-- Main -->
					<div id="main">

					<c:forEach items="${LIST_1}" var="i">
						<!-- Post -->
							<article class="post">
								<header>
									<div class="title">
										<h2><a href="${pageContext.request.contextPath}/reads.action?id=${i.id}">${i.title}</a></h2>
										<p>${i.intro}</p>
									</div>
									<div class="meta">
										<time class="published">${i.tti}</time>
										<a href="#" class="author"><span class="name">${i.name}</span><img src="${pageContext.request.contextPath}${i.photo_u}" alt="" /></a>
									</div>
								</header>
								<a href="${pageContext.request.contextPath}/reads.action?id=${i.id}" class="image featured"><img src="${pageContext.request.contextPath}${i.photo}" alt="" /></a>
								
								<footer style="padding-top: 15px;">
									<ul class="actions">
										<li><a href="${pageContext.request.contextPath}/reads.action?id=${i.id}" class="button large">Continue Reading</a></li>
									</ul>
									<ul class="stats">
										<li><a href="#">General</a></li>
										<li><a href="#" class="icon solid fa-heart">28</a></li>
										<li><a href="#" class="icon solid fa-comment">128</a></li>
									</ul>
								</footer>
							</article>
					</c:forEach>
						
						<!-- Pagination -->
							<ul class="actions pagination">
								<li><a href="${pageContext.request.contextPath}/previous.action" class="button large previous">Previous Page</a></li>
								<li><a href="${pageContext.request.contextPath}/next.action" class="button large next">Next Page</a></li>
							</ul>

					</div>

				<!-- Sidebar -->
					<section id="sidebar">

						<!-- Intro -->
							<section id="intro">
								<a href="${pageContext.request.contextPath}/login.action" class="logo"><img src="${pageContext.request.contextPath}${IMAGE}" alt="" /></a>
								<header>
									<h2><a href="${pageContext.request.contextPath}/login.action">${LOG_IN}</a></h2>
									<p>${MOTTO}</p>
								</header>
							</section>

						<!-- Mini Posts -->
							<section>
								<div class="mini-posts">
								<c:forEach items="${LIST_2}" var="i">
									<!-- Mini Post -->
										<article class="mini-post">
											<header>
												<h3><a href="${pageContext.request.contextPath}/reads.action?id=${i.id}">${i.title}</a></h3>
												<time class="published" datetime="2015-10-20">${i.tti}</time>
												<a href="#" class="author"><img src="${pageContext.request.contextPath}${i.photo_u}" alt="" /></a>
											</header>
											<a href="${pageContext.request.contextPath}/reads.action?id=${i.id}" class="image"><img src="${pageContext.request.contextPath}${i.photo}" alt="" /></a>
										</article>
								</c:forEach>
								</div>
							</section>

						<!-- Posts List -->
							<section>
								<ul class="posts">
								<c:forEach items="${LIST_3}" var="i">
									<li>
										<article>
											<header>
												<h3><a href="${pageContext.request.contextPath}/reads.action?id=${i.id}">${i.title}</a></h3>
												<time class="published" datetime="2015-10-20">${i.tti}</time>
											</header>
											<a href="${pageContext.request.contextPath}/reads.action?id=${i.id}" class="image"><img src="${pageContext.request.contextPath}${i.photo}" alt="" /></a>
										</article>
									</li>
								</c:forEach>
								</ul>
							</section>

						<!-- About -->
							<section class="blurb">
								<h2>About</h2>
								<p>Mauris neque quam, fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem euismod amet placerat. Vivamus porttitor magna enim, ac accumsan tortor cursus at phasellus sed ultricies.</p>
								<ul class="actions">
									<li><a href="#" class="button">Learn More</a></li>
								</ul>
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