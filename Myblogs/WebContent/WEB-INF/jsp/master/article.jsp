<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
	Future Imperfect by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Article Management</title>
		<link href="${pageContext.request.contextPath}/page2/images/title.ico" rel="icon" type="image/x-ico">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/page2/assets/css/main.css" />
		<script>
		function add11()
		{
			alert(O);
			
			sessionStorage.setItem("UU_id",u_id);
			
			
		}
		
		function add1()
		{
			
			var i_id=document.getElementById('select').value;
			sessionStorage.setItem("II_id",i_id);
			alert(11);
		}
		
		</script>
	</head>
	<body class="single is-preload">
		<!-- Wrapper -->
			<div id="wrapper" style="padding: 1em 0px; width:100%; min-height: 100%;">

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

					

			
<div id="main" style="padding: 0em; width: 100%;">
<table style="background:#f4f4f4;">			
<thead>
    <tr>
      <th>标题</th>
      <th>简介</th>
      <th>时间</th>
      <th>作者</th>
      <th>分类</th>
      <th>状态</th>
      <th>操作</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${article_list}" var="u">
  		<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/master/cate_allot.action" >
    		<input type="text" style="background:#f4f4f4; border:0px; padding:0em; display: none;" name="id" value="${u.id}"/>
    		<tr style="background:#f4f4f4;">
    		<td>${u.title}</td>
    		<td>${u.intro}</td>
      		<td>${u.tti}</td>
      		<td>${u.name}</td>
     
      		<td >
      			<c:forEach items="${u.categoty}" var="i">
      				<a href="${pageContext.request.contextPath}/master/delete_conn.action?u_id=${u.id}&i_id=${i.id}" style="border:0px; float: left;"><input type="button" class="special" value="${i.content}"/></a>
      			</c:forEach>
      			<div style="float: left;">
      			<select name="cate_id" id="select" style="height:2.9em;">
    				<option  selected="selected">=请选择=</option>
      					<c:forEach items="${list_cate}" var="i">
      						<option value="${i.id}">${i.content}</option>
						</c:forEach>
				</select>
				</div>
				<div>
      			<input type="submit" class="special" value="Add"/>
      			</div>
      		</td>
      		
      		<td>
      		<c:if test="${u.publish eq true}">
      			已发布
      		</c:if>
      		<c:if test="${u.publish eq false}">
      			未发布
      		</c:if>
      		</td>
      		<td>
      			<a href="${pageContext.request.contextPath}/master/publish.action?id=${u.id}" style="border:0px;"><input type="button" class="special" value="发布or撤销">
      			</a>
      			<a href="${pageContext.request.contextPath}/master/changes_art.action?id=${u.id}" style="border:0px;"><input type="button" class="special" value="修改"/>
      			</a>
      			<a href="${pageContext.request.contextPath}/master/delete_art.action?id=${u.id}" style="border:0px;"><input type="button" class="special" value="删除" onclick="javascript:return confirm('确认要删除吗?')"/></a>
      		</td>
    		</tr>
    	</form>
   </c:forEach>
  </tbody>
</table>
</div>
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