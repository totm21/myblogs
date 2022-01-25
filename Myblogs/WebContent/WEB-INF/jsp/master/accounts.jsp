<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
	Future Imperfect by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
		<!-- Wrapper -->
	<head>
		<link href="${pageContext.request.contextPath}/page2/images/title.ico" rel="icon" type="image/x-ico">
		<title>Account Management</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/page2/assets/css/main.css" />
	</head>
	<body class="single is-preload">
		<!-- Wrapper -->
			<div id="wrapper" style="padding: 0em;width: 100%; min-height: 100%;">

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

				<!-- Menu -->
					<%@include  file="/WEB-INF/jsp/base_jsp/sidebar.jsp"%>

<div id="main" style="padding: 0em; width: 100%; ">	
<table style="background:#f4f4f4;">			
<thead>
	<form method="post" action="${pageContext.request.contextPath}/master/find_user_see.action" >
    		<div style="margin-top:20px; margin-bottom: 15px;">
    		<input type="submit" class="special"  style="float:right; margin-right: 30px;" value="Search User"/>
    		<input type="text" style="background:#f4f4f4; border:0px; padding:0em; width:300px; float:right;" name="id"  placeholder="User ID">
      		</div>
	</form>	
    <tr>
      <th>id</th>
      <th>密码</th>
      <th>昵称</th>
      <th>权限</th>
      <th>操作</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${user_list}" var="u">
  		<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/master/change.action" >
    		<input type="text" style="background:#f4f4f4; border:0px; padding:0em; display: none;" name="id" value="${u.id}"/>
    		<tr style="background:#f4f4f4;">
    		<td>${u.id}</td>
    		<td><input type="text" style="background:#f4f4f4; border:0px; padding:0em" name="password" value="${u.password}"></td>
      		<td><input type="text" style="background:#f4f4f4; border:0px; padding:0em" name="name" value="${u.name}"></td>
      		<td><input type="text" style="background:#f4f4f4; border:0px; padding:0em" name="value" value="${u.value}"></td>
      		<td>
      			<input type="submit" class="special" value="修改"/>
      			<a href="${pageContext.request.contextPath}/master/delete.action?id=${u.id}" style="border:0px;"><input type="button" class="special" value="删除" onclick="javascript:return confirm('确实要删除该用户吗?')"/></a>
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