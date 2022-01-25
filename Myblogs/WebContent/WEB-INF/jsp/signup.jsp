<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
	Twenty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Sign In</title>
		<link href="${pageContext.request.contextPath}/page3/images/title.ico" rel="icon" type="image/x-ico">
		
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/page3/assets/css/main.css" />
		<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
		<noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/page3/assets/css/noscript.css" /></noscript>
		<style>
			.file_me
			{	
    			opacity:0;
    		}
		</style>
		<script type="text/javascript">
			function check()
			{
				var re=/[^\u4E00-\u9FA5]/;
			    
				var id = $("#id").val();
				
				if (re.test(id)){
					element.innerHTML="Id Cannot be entered in Chinese!";
					return false ;
				}
				
			    var password = $("#password").val();
			    var password2 = $("#password2").val();
			    var element=document.getElementById("message");  
			    if(id=="" || password==""){
			    	element.innerHTML="The account or password cannot be empty!";
			    	return false;
			    }
			    else if(password!=password2)
			    {
			    	element.innerHTML="The passwords are different!";
			    	return false;
			    }
			    return true;
			}
			
		</script>
	</head>
	<body class="contact is-preload">
		<div id="page-wrapper">
		
			<!-- Header -->
			<!-- Main -->
				<article id="main">
					<!-- One -->
					<header class="special container">
						<span class="icon solid fa-paw"></span>
						<h2 id="message">${SIGN}</h2>
					</header>
				<section class="wrapper style4 special container medium">
							<!-- Content -->
								<div class="content">
									<form method="post" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/user/signup.action" onsubmit="return check()">
										<div class="row gtr-50">
											<div class="col-12">
												<input type="text" name="id" id="id" placeholder="id" />
											</div>
											<div class="col-12">
												<input type="password" name="password" id="password" placeholder="password" />
											</div>
											<div class="col-12">
												<input type="password" name="password2" id="password2" placeholder="Re-enter password" />
											</div>
											<div class="col-12">
												<input type="text" name="name" placeholder="name" />
											</div>
											<div class="col-12">
												<input type="text" name="motto" placeholder="motto" />
											</div>
											<div class="col-12">
												profile photo:
												<input type="file" name="photo2" id="file"  value="profile photo" multiple="multiple"/>
											</div>
											<div class="col-12">
												<ul class="buttons">
													<li><input type="submit" class="special" value="SIGN IN"/></li>
												</ul>
											</div>
											
										</div>
									</form>
								</div>

						</section>

				</article>

			<!-- Footer -->
				<footer id="footer">
					<ul class="copyright">
						<li>&copy; Untitled</li><li>Design: <a href="http://html5up.net">HTML5 UP</a>.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@administrator:<a href="tencent://AddContact/?fromId=45&fromSubId=1&subcmd=all&uin=2781343172&website=www.oicqzone.com">CZ</a>.</li>
					</ul>
				</footer>

		</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/page3/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/page3/assets/js/jquery.dropotron.min.js"></script>
			<script src="${pageContext.request.contextPath}/page3/assets/js/jquery.scrolly.min.js"></script>
			<script src="${pageContext.request.contextPath}/page3/assets/js/jquery.scrollgress.min.js"></script>
			<script src="${pageContext.request.contextPath}/page3/assets/js/jquery.scrollex.min.js"></script>
			<script src="${pageContext.request.contextPath}/page3/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/page3/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/page3/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/page3/assets/js/main.js"></script>

	</body>
</html>
