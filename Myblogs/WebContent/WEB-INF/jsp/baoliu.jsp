<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include  file="/WEB-INF/jsp/base_jsp/include.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Myblogs</title>
</head>
<body class="bg-light">
<div class="container">
	<div class="row">
		<%@include  file="/WEB-INF/jsp/base_jsp/Navigation.jsp"%>
		<div class="col-2 bg-primary text-white">边</div>
		<div class="col-8 bg-dark text-white">
			<button type="button" class="btn text-light" onclick="toggle()">按钮</button>
		</div>
		<div class="col-2 bg-primary text-white">边</div>
	</div>
	<form action="${pageContext.request.contextPath }/get_test.action" 
			                       method="post" onsubmit="return check()" class="form-horizontal">
		<input type="submit" value="跳转" class="btn btn-primary" />
			                       </form>
</div>
</body>
</html>



