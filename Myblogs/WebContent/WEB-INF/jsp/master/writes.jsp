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
		<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
		
		<style>
		#textarea {
    display: block;

    margin:15px auto;

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
		
		var refreshss=setInterval(refresh_session, 1200000);

			
			function refresh_session() {
			$.ajax({
			type: "post",
			contentType: "application/json",
			url: "WebBlock.aspx"
				})
			}		
		
		var times=0;  //异步进程记录
		
		function refresh()
		{
			 $("#little_div").load(location.href+" #little_div>*",""); 
		}
		
		function check_ajax()
		{
			if(times==0)
			{
				return true;
			}
			else
			{
				alert("当前网络拥堵,重新尝试保存!"+times);
				var len=${art.contents.size()};
				return false;
			}
		}
		
		function list_add(index)
		{
			times++;
			$.ajax({
                url:"${pageContext.request.contextPath}/ajax/list_add.action",//请求路径
                type:"POST",  //请求方式
                // data:"username=Tim&age=20", //请求参数 ，方式一
                data:{"index":index},//请求参数 ，方式二,JSON格式，推荐使用
                success:function (data) { //响应成功后的回调函数,data为接收的响应值
                	if(data=="true")
                		times--;
                	refresh();
                },
                error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);

                }
            })
		}
		
		function list_delete(index)
		{
			times++;
			$.ajax({
                url:"${pageContext.request.contextPath}/ajax/list_delete.action",//请求路径
                type:"POST",  //请求方式
                // data:"username=Tim&age=20", //请求参数 ，方式一
                data:{"index":index},//请求参数 ，方式二,JSON格式，推荐使用
                success:function (data) { //响应成功后的回调函数,data为接收的响应值
                	if(data=="true")
                		times--;
                	refresh();
                },
                error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);

                }
            })
		}
		
		function save_title(e)
		{
			times++;
			var t=$(e).val();
			$.ajax({
                url:"${pageContext.request.contextPath}/ajax/save_title.action",//请求路径
                type:"POST",  //请求方式
                // data:"username=Tim&age=20", //请求参数 ，方式一
                data:{"title":t},//请求参数 ，方式二,JSON格式，推荐使用
                success:function (data) { //响应成功后的回调函数,data为接收的响应值
                	if(data=="true")
                		times--;
                },
                error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);

                }
            })
			
		}
		
		
		function save_intro(e)
		{
			times++;
			var t=$(e).val();
			$.ajax({
                url:"${pageContext.request.contextPath}/ajax/save_intro.action",//请求路径
                type:"POST",  //请求方式
                // data:"username=Tim&age=20", //请求参数 ，方式一
                data:{"intro":t},//请求参数 ，方式二,JSON格式，推荐使用
                success:function (data) { //响应成功后的回调函数,data为接收的响应值
                    if(data=="true")
                		times--;
                },
                error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);

                }
            })
			
		}
		
		function save_text_main(text)
		{
			times++;
			$.ajax({
                url:"${pageContext.request.contextPath}/ajax/save_text_main.action",//请求路径
                type:"POST",  //请求方式
                // data:"username=Tim&age=20", //请求参数 ，方式一
                data:{"text":text},//请求参数 ，方式二,JSON格式，推荐使用
                success:function (data) { //响应成功后的回调函数,data为接收的响应值
                    if(data=="true")
                		times--;
                },
                error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);

                }
            })
			
		}
		
		function save_text_mains(text,index)
		{
			times++;
			$.ajax({
                url:"${pageContext.request.contextPath}/ajax/save_text_mains.action",//请求路径
                type:"POST",  //请求方式
                // data:"username=Tim&age=20", //请求参数 ，方式一
                data:{"text":text,"index":index},//请求参数 ，方式二,JSON格式，推荐使用
                success:function (data) { //响应成功后的回调函数,data为接收的响应值
                    if(data=="true")
                		times--;
                },
                error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);

                }
            })
			
		}
		
		

		
		
		function save_image_main()
		{
	        var files = document.getElementById("file").files[0];
	        var form = new FormData();
	        times++;
	        form.append("file",files);
	        $.ajax({
	            //url:"${pageContext.request.contextPath}/master/save_image_main.action",        //后台url
	            url:"${pageContext.request.contextPath}/ajax/save_image_main.action",//请求路径
	            data: form,
	            cache: false,
	            async: true,
	            type: "POST",                  
	            dataType: 'json',              //数据返回类型，可以是xml、json等
	            processData: false,
	            contentType: false,
	            success: function (data) {      //成功，回调传来的success方法
	            	if(data=="error")
	            	{
	            		alert("图片储存失败,请重新选择");	
	            	}
	            	times--;
	            },
	            error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);
                }
	        });
		}
		
		function save_image_mains(index)
		{
	        var files = document.getElementById("files"+index).files[0];
	        var form = new FormData();
	        times++;
	        form.append("file",files);
	        form.append("index",index);
	        $.ajax({
	            //url:"${pageContext.request.contextPath}/master/save_image_main.action",        //后台url
	            url:"${pageContext.request.contextPath}/ajax/save_image_mains.action",//请求路径
	            data: form,
	            cache: false,
	            async: true,
	            type: "POST",                  
	            dataType: 'json',              //数据返回类型，可以是xml、json等
	            processData: false,
	            contentType: false,
	            success: function (data) {      //成功，回调传来的success方法
	            	if(data=="error")
	            	{
	            		alert("图片储存失败,请重新选择");	
	            	}
	            	times--;
	            },
	            error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);
                }
	        });
		}
		

		
		function ajax_up()
		{
			times++;
			$.ajax({
                url:"${pageContext.request.contextPath}/ajax.action",//请求路径
                type:"POST",  //请求方式
                // data:"username=Tim&age=20", //请求参数 ，方式一
                data:{"query":"ajax"},//请求参数 ，方式二,JSON格式，推荐使用
                success:function (data) { //响应成功后的回调函数,data为接收的响应值
                    //alert(data);
                    times--;
                },
                error: function (xhr,textStatus,err) {
                    /*错误信息处理*/
                    console.log("readyState: " + xhr.readyState);
            		console.log("responseText: "+ xhr.responseText);
            		console.log("status: " + xhr.status);
            		console.log("text status: " + textStatus);
            		console.log("error: " + err);

                }
            })
		}
		
		function ajax_check()
		{
			if(times==0)
			{
				alert("测试成功!")	
			}
			else
			{
				alert(times);
			}
		}
		
		

		
		function save()
		{
			var txt = document.getElementById("textarea").value; 
		    document.getElementById("saveinput").value = txt;
		    
		    save_text_main(txt);
		    
		}
		
		function saves(text,index)
		{
			var txt = $(text).val();
		    document.getElementById("saveinput"+index).value = txt;
		    save_text_mains(txt,index);
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
	        save_image_main();
	        //document.getElementById("form_main").submit();
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
	
	
	function binding2(val)
	{
		vall='file'+val;
		$('#files'+val).click();
	}
	
	function show1(f,val) {
        var rd = new FileReader();//创建文件读取对象
        var files = f.files[0];//获取file组件中的文件
        rd.readAsDataURL(files);//文件读取装换为base64类型
        rd.onloadend = function(e) {
            //加载完毕之后获取结果赋值给img
            document.getElementById("pho"+val).src = this.result;
        }
        save_image_mains(val);
        //document.getElementById("form_"+val).submit();
        
    }
	function ceshi() {
        alert("uuu");
        
    }
	
	
		</script>
	</head>
	<body class="single is-preload">
		<!-- Wrapper -->
		
			<div id="wrapper" style="">
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

		<form id="form_main" method="post" enctype="multipart/form-data" style="margin: 0;" action="${pageContext.request.contextPath}/master/save_art_main.action" >
					
					<input name="id" style="display:none;" value="${art.id}">
					<div id="main">

						<!-- Post -->
							<article class="post" style="margin: 0; border-bottom: 0;">
								<header>
									<div class="title" style="padding: 2em 3em 2.5em 3em; ">
										<h2><input type="text" name="title" onchange="save_title(this)" style="font-size:25px; background: #ffffff; border:0px; text-align:center;" placeholder="Title" value="${art.title}"></h2>
										<p><input type="text" name="intro" onchange="save_intro(this)" style="font-size:15px; background: #ffffff; border:0px; text-align:center;" placeholder="Introduction" value="${art.intro}"></p>
									</div>
									<div class="meta">
										<time class="published" style="font-family:Sans-serif; font-size:1em;">${art.tti}</time>
										<input type="text" style="display:none;">
										<a href="#" class="author"><span class="name">${user.name}</span><img src="${pageContext.request.contextPath}${user.photo}" alt="" /></a>
										<input type="text" style="display:none;">
										
									</div>
								</header>
								<span class="image featured" style="margin:0;" onclick="binding()"><img id="pho" src="${pageContext.request.contextPath}${art.photo}" alt="" /></span>
								<input type="file" id="file" name="photo2" onchange="show(this)" multiple="multiple" style="display:none;">
								<textarea id="textarea" style="min-height:300px; resize: none;" onchange="save()" placeholder="message...">${art.txt}</textarea>
								<input id="saveinput" name="text" type="hidden" name="filecontent" value="">
								<script>

       								 var text = document.getElementById("textarea");

       								 autoTextarea(text);// 调用
       								 
       								 

   								 </script>
								
								<div style="height:4em; display:none;">
									<input type="submit" style="float:right; display:none;" value="SAVE" onclick="save()"/>
								</div>
						<ul class="icons" style="margin: 5px; text-align:right;">
							<li><a class="fa fa-plus-square" style="font-size:30px" onclick="list_add(0)"><span class="label">Instagram</span></a></li>
						</ul>
					</article>
					</div>
								
		</form>		
				
	<div id="little_div">					
		<c:forEach items="${art.contents}" var="data" varStatus="vs">
		
		<!-- Main -->
				
				
				<form id="form_${vs.index}" method="post" enctype="multipart/form-data" style="text-align: center; margin:0 auto;" action="${pageContext.request.contextPath}/master/save_art_mains.action" >
					
						<!-- Post -->
						<div id="main" style="box-sizing: inherit;">
							<input name="index" style="display:none;" value="${vs.index}"/>
							<article class="post" style="margin: 0; border-top: 0;border-bottom: 0;padding-top: 0em;">
								<span class="image featured" style="text-align: center; margin:0 auto;" onclick="binding2(${vs.index})"><img id="pho${vs.index}" src="${pageContext.request.contextPath}${data.image}" alt="" /></span>
								<input type="file" id="files${vs.index}" name="photo2" onchange="show1(this,${vs.index})" multiple="multiple" style="display:none;">
								<textarea id="textarea${vs.index}" style="display: block;margin:30px auto;  overflow: hidden; font-size: 24px;
    							height: 18px;line-height: 34px;padding:2px;min-height:300px; resize: none;" placeholder="message..." onchange="saves(this,${vs.index})" oninput="autoTextarea(this)">${data.art}</textarea>
								<input id="saveinput${vs.index}" name="text" type="hidden" name="filecontent" value="">
								<div style="height:4em; display:none;">
									<input type="submit" style="float:right; display:none;" value="SAVE" onclick="save()"/>
								</div>
						<ul class="icons" style="margin: 5px; text-align:right;">
							<li><a class="fa fa-minus-square" style="font-size:30px"  onclick="list_delete(${vs.index})"><span class="label">Facebook</span></a></li>
							<li><a class="fa fa-plus-square" style="font-size:30px" onclick="list_add(${vs.index}+1)"><span class="label">Instagram</span></a></li>
						</ul>
							</article>
						</div>

				</form>
	
	
		</c:forEach>		
	</div>
	
		<form method="post" style="text-align: right; margin:0 auto;" action="${pageContext.request.contextPath}/ajax/save_alls.action" onsubmit="return check_ajax()" >
					
						<!-- Post -->
			<div>
				<article class="post" style=" margin: 0; border-top: 0;border-bottom: 0;padding-top: 0em;">
					<input type="submit" value="SAVE"/>
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