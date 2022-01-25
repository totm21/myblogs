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
		<title>Write Article</title>
		<link href="${pageContext.request.contextPath}/page2/images/title.ico" rel="icon" type="image/x-ico">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/page2/assets/css/main.css" />
		<style>
		#textarea {
    display: block;

    margin:30px auto;

    overflow: hidden;

    font-size: 24px;

    height: 18px;

    line-height: 34px;

    padding:2px;

}

textarea {
    outline: 0 none;

    border-color: rgba(82, 168, 236, 0.8);

    box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1), 0 0 8px rgba(82, 168, 236, 0.6);
		
		}
		</style>
		
		<script>
		
		function save()
		{
			var txt = document.getElementById("textarea").value; 
		    document.getElementById("saveinput").value = txt;
		}
		
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

				<!-- Menu -->
					<%@include  file="/WEB-INF/jsp/base_jsp/sidebar.jsp"%>
				<!-- Main -->
				<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/master/savetext.action" >
					<div id="main">

						<!-- Post -->
							<article class="post">
								<header>
									<div class="title" style="padding: 2em 3em 2.5em 3em; ">
										<h2><input type="text" name="title" style="font-size:25px; background: #ffffff; border:0px; text-align:center;" placeholder="Title"></h2>
										<p><input type="text" name="intro" style="font-size:15px; background: #ffffff; border:0px; text-align:center;" placeholder="Introduction"></p>
									</div>
									<div class="meta">
										<time class="published" style="font-family:Sans-serif; font-size:1em;">${time}</time>
										<input type="text" style="display:none;">
										<a href="#" class="author"><span class="name">${user.name}</span><img src="${pageContext.request.contextPath}${user.photo}" alt="" /></a>
										<input type="text" style="display:none;">
										
									</div>
								</header>
								<span class="image featured" onclick="binding()"><img id="pho" src="${pageContext.request.contextPath}/page2/images/pic01.jpg" alt="" /></span>
								<input type="file" id="file" name="photo2" onchange="show(this)" multiple="multiple" style="display:none;">
								<textarea id="textarea" style="min-height:300px;" placeholder="message..."></textarea>
								<input id="saveinput" name="text" type="hidden" name="filecontent" value="">
								<script>

       								 var text = document.getElementById("textarea");

       								 autoTextarea(text);// 调用

   								 </script>
								
								<div style="height:4em;">
									<input type="submit" style="float:right;" value="SAVE" onclick="save()"/>
								</div>
							</article>

					</div>
				</form>

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