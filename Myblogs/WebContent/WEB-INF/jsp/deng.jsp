<!DOCTYPE HTML>
<html>
<head>
<title>Welcome!</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!--[if lt IE 9]>
     <script src="js/html5shiv.js"></script>
     <script src="js/respond.min.js"></script>
<![endif]-->

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="js/jquery.min.js"></script>
	<script>
		$(function() {
			var pull 		= $('#pull');
				menu 		= $('nav ul');
				menuHeight	= menu.height();
			$(pull).on('click', function(e) {
				e.preventDefault();
				menu.slideToggle();
			});
			$(window).resize(function(){
        		var w = $(window).width();
        		if(w > 320 && menu.is(':hidden')) {
        			menu.removeAttr('style');
        		}
    		});
		});
	</script>
<!----font-Awesome----->
   	<link rel="stylesheet" href="fonts/css/font-awesome.min.css">
<!----font-Awesome----->
</head>
<body>
<div class="header_bg" id="home"><!-- start header -->
<div class="container">
	<div class="row header text-center specials">
		<nav class="top-nav">
			<ul class="top-nav nav_list">
				<li class="logo page-scroll"><form action="${pageContext.request.contextPath}/get_main.action"><a title="enter blog"><img src="images/logo.png" alt="" class="responsive"/></a></form></li>
			</ul>
			<a href="#" id="pull"><img src="images/nav-icon.png" title="menu" /></a>
		</nav>
		<div class="clearfix"></div>
	</div>
</div>
</div>
<div class="slider_bg"><!-- start slider -->
<div class="container">
		<div class="row slider">
		<div class="wmuSlider example1"><!-- start wmuSlider example1 -->
			   	<div class="wmuSliderWrapper">
				   <article style="position: absolute; width: 100%; opacity: 0;"> 
				  	 	<div class="slider_img text-center">
				   			<ul class="list-unstyled list_imgs">
				   				<li><a title="enter blog" href="/Myblogs/page/main.action"><img src="images/slider.jpg" alt="" class="responsive"/></a></li>
				   			</ul>
			           	</div>
				   </article>
				   <article style="position: relative; width: 100%; opacity: 1;"> 
				  	 	<div class="slider_img text-center">
				   			<ul class="list-unstyled list_imgs">
				   				<li><a title="enter blog" href="/Myblogs/page/main.action"><img src="images/slider1.jpg" alt="" class="responsive"/></a></li>
				   			</ul>
			           	</div>
				   </article>
				 </div>
                <ul class="wmuSliderPagination">
                	<li><a href="#" class="">0</a></li>
                	<li><a href="#" class="">1</a></li>
                </ul>
			<script src="js/jquery.wmuSlider.js"></script> 
		     <script>
				 $('.example1').wmuSlider();         
			</script>
        </div><!-- end wmuSlider example1 -->
        <div class="clearfix"></div>
      </div>
</div>
</div>

<div class="footer1_bg"><!-- start footer1 -->
	<div class="container">
		<div class="row  footer">
			<div class="copy text-center">
				<p class="link"><span>Copyright &copy; 2021.CZ.</span></p>
				<a href="#home" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"> </span></a>
			</div>
		</div>
		<script type="text/javascript">
				$(function() {
				  $('a[href*=#]:not([href=#])').click(function() {
				    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
			
				      var target = $(this.hash);
				      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
				      if (target.length) {
				        $('html,body').animate({
				          scrollTop: target.offset().top
				        }, 1000);
				        return false;
				      }
				    }
				  });
				});
		</script>
		<!---- start-smoth-scrolling---->		
	</div>
</div>

</body>
</html>