<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 左侧显示列表部分 start-->
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="查询内容...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search" style="padding: 3px 0 3px 0;"></i>
							</button>
						</span>
					</div> 
				</li>
				<li>
				      <a href="${pageContext.request.contextPath }/category/list.action" class="active">
				        <i class="fa fa-dashboard fa-fw" ></i> 商品分类管理
				      </a>
				</li>				
				<li>
				    <a href="${pageContext.request.contextPath }/goods/list.action">
				      <i class="fa fa-edit fa-fw"></i> 商品管理
				    </a>
				</li>
				
				<li>
				    <a href="${pageContext.request.contextPath }/user/userlist.action">
				      <i class="fa fa-user fa-fw" ></i> 用户管理
				    </a>
				</li>			
				<li>
				    <a href="${pageContext.request.contextPath }/user/ulist.action">
				      <i class="fa fa-user fa-fw" ></i> 用户管理1111
				    </a>
				</li>
				<li>
				    <a href="${pageContext.request.contextPath }/user/userlist2.action">
				      <i class="fa fa-id-badge fa-fw" ></i> 用户管理2
				      
				    </a>
				</li>	
				<li>
				    <a href="${pageContext.request.contextPath }/user/userlist3.action">
				      <i class="fa fa-id-badge fa-fw" ></i> 用户管理3				      
				    </a>
				</li>	
				<li>
				    <a href="${pageContext.request.contextPath }/user/userlist4.action">
				      <i class="fa fa-id-badge fa-fw" ></i> 用户管理4				      
				    </a>
				</li>	
				<li>
				    <a href="${pageContext.request.contextPath }/user/userlist5.action">
				      <i class="fa fa-id-badge fa-fw" ></i> 用户管理5				      
				    </a>
				</li>									
			</ul>
		</div>
	</div>
	<!-- 左侧显示列表部分 end--> 
