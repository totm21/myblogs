<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Future Imperfect by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Reading</title>
				<link href="${pageContext.request.contextPath}/page2/images/title.ico" rel="icon" type="image/x-ico">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/page2/assets/css/main.css" />
		<style type="text/css">
			
		</style>
		<script type="text/javascript">
		var autoTextarea = function (elem, extra, maxHeight) {
			extra = extra || 0;

	        var isFirefox = !!document.getBoxObjectFor || 'mozInnerScreenX' in window,

	        isOpera = !!window.opera && !!window.opera.toString().indexOf('Opera'),

	                addEvent = function (type, callback) {
	                        elem.addEventListener ?

	                                elem.addEventListener(type, callback, false) :

	                                elem.attachEvent('on' + type, callback);

	                },

	                getStyle = elem.currentStyle ? function (name) {
	                        var val = elem.currentStyle[name];

	 

	                        if (name === 'height' && val.search(/px/i) !== 1) {
	                                var rect = elem.getBoundingClientRect();

	                                return rect.bottom - rect.top -

	                                        parseFloat(getStyle('paddingTop')) -

	                                        parseFloat(getStyle('paddingBottom')) + 'px';        

	                        };

	 

	                        return val;

	                } : function (name) {
	                                return getComputedStyle(elem, null)[name];

	                },

	                minHeight = parseFloat(getStyle('height'));

	 

	        elem.style.resize = 'none';

	 

	        var change = function () {
	                var scrollTop, height,

	                        padding = 0,

	                        style = elem.style;

	 

	                if (elem._length === elem.value.length) return;

	                elem._length = elem.value.length;

	 

	                if (!isFirefox && !isOpera) {
	                        padding = parseInt(getStyle('paddingTop')) + parseInt(getStyle('paddingBottom'));

	                };

	                scrollTop = document.body.scrollTop || document.documentElement.scrollTop;

	 

	                elem.style.height = minHeight + 'px';

	                if (elem.scrollHeight > minHeight) {
	                        if (maxHeight && elem.scrollHeight > maxHeight) {
	                                height = maxHeight - padding;

	                                style.overflowY = 'auto';

	                        } else {
	                                height = elem.scrollHeight - padding;

	                                style.overflowY = 'hidden';

	                        };

	                        style.height = height + extra + 'px';

	                        scrollTop += parseInt(style.height) - elem.currHeight;

	                        document.body.scrollTop = scrollTop;

	                        document.documentElement.scrollTop = scrollTop;

	                        elem.currHeight = parseInt(style.height);

	                };

	        };

	 

	        addEvent('propertychange', change);

	        addEvent('input', change);

	        addEvent('focus', change);

	        change();
	        
	};
	</script>
	
	</head>
	<body class="single is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

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
									<form id="search" method="get" action="#" style="padding-top: 0.5em">
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

						<!-- Post -->
							<article class="post">
								<header>
									<div class="title">
										<h2 style="text-align:center;"><a href="#" >${this_mess.title}</a></h2>
										<p style="text-align:center;">${this_mess.intro}</p>
									</div>
									<div class="meta">
										<time class="published">${this_mess.tti}</time>
										<a href="#" class="author"><span class="name">${this_mess.name}</span><img src="${pageContext.request.contextPath}${this_mess.photo_u}" alt="" /></a>
									</div>
								</header>
								<span class="image featured"  style="margin-bottom: 0px;"><a href="${pageContext.request.contextPath}${this_mess.photo}"><img src="${pageContext.request.contextPath}${this_mess.photo}" alt="" /></a></span>
								<p style="white-space: pre-wrap; margin-bottom: 0px; background:rgb(255 255 255); font-size: 24px;">${this_mess.txt}</p>
					
				<c:forEach items="${this_mess.contents}" var="i">
      					<c:if test="${i.image ne '/texts/images/root.jpg'}">
      						<span class="image featured" style="margin-bottom: 0px;"><a href="${pageContext.request.contextPath}${i.image}"><img src="${pageContext.request.contextPath}${i.image}" alt="" /></a></span>
      					</c:if>
						
						<p style="white-space: pre-wrap; margin-bottom: 0px; background:rgb(255 255 255); font-size: 24px;">${i.art}</p>		
				</c:forEach>
				
								
								<footer>
									<ul class="stats">
										<li><a href="#">General</a></li>
										<li><a href="#" class="icon solid fa-heart">28</a></li>
										<li><a href="#" class="icon solid fa-comment">128</a></li>
									</ul>
								</footer>
							</article>

					</div>

				<!-- Footer -->
					

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