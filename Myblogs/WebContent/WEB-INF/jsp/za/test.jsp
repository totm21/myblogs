<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="/WEB-INF/jsp/base_jsp/include.jsp"%>
<script type="text/javascript">
function delUser(id,name){	
	if(confirm('确实要删除该用户吗?'+name)) {
		$.post("${pageContext.request.contextPath}/delUser.action",{"id":id},
				function(){
				     location.reload();		
		}
		);
	}
}
function addUser(id,name,password,value){
	//alert(userid+name+pass+age+sex+email);
	$("#id").val(id);
	$("#name").val(name);
	$("#password").val(password);
	$("#value").val(value);
}
</script>
<div id="page-wrapper">
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">新增</button>
<table class="table table-condensed">
  <caption>用户信息列表</caption>
  <thead>
    <tr>
    <th>id</th>
      <th>用户名</th>
      <th>密码</th>
      <th>操作</th>
      <th>权限等级</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${userlist}" var="l">
      <tr class="success">
      <td>${l.id}</td>
      <td>${l.name}</td>
      <td>${l.password}</td>
      <td>${l.value}</td>
      <td>
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editModal" onclick="addUser('${l.id}','${l.name}','${l.password}',${l.value})">修改</button>
		<a href="#" class="btn btn-danger btn-xs" onclick="delUser('${l.id}','${l.name}')">删除</a>						
      </td>
    </tr>
  </c:forEach>
    
  </tbody>
</table>
</div>

<form action="${pageContext.request.contextPath }/addUser.action" method="post" class="form-horizontal" role="form">
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					添加一个新用户
				</h4>
			</div>
			<div class="modal-body">
	<div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">账户</label>
    <div class="col-sm-10">
      <input type="text" name="id" class="form-control" id="firstname" placeholder="请输入用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" name="name" class="form-control" id="firstname" placeholder="请输入用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="text" name="password" class="form-control" id="lastname" placeholder="请输入密码">
    </div>
  </div>
<div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">权限</label>
    <div class="col-sm-10">
      <input type="text" name="value" class="form-control" id="lastname" placeholder="请输入密码">
    </div>
  </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-bs-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary">
					确认添加
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>	
</form>


<form action="${pageContext.request.contextPath }/editUser.action" method="post" class="form-horizontal" role="form">
<!-- 模态框（Modal） -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="editModalLabel">
					修改信息
				</h4>
			</div>
			<div class="modal-body">
	<div class="form-group">
    <div class="col-sm-10">
      <input type="text" name="id" class="form-control" id="id" >
    </div>
  </div>
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" name="name" class="form-control" id="name" >
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="text" name="password" class="form-control" id="password" >
    </div>
  </div>
<div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">权限</label>
    <div class="col-sm-10">
      <input type="text" name="value" class="form-control" id="value" >
    </div>
  </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-bs-dismiss="modal">关闭
				</button>
				<button type="submit" class="btn btn-primary">
					确认修改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>	
</form>
