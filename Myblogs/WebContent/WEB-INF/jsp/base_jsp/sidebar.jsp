<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Menu -->
					<section id="menu">

						<!-- Search -->
							<section>
								<form class="search" method="get" action="#">
									<input type="text" name="query" placeholder="Search" />
								</form>
							</section>

						<!-- Links -->
							<section>
								<ul class="links">
									<li style="display:${user_root}; border-top:0px; margin:0px; padding:0.5em 0em;">
										<a href="${pageContext.request.contextPath}/master/user.action">
											<h3>Userinfo Management</h3>
											<p>Detailed user information management</p>
										</a>
									</li>
									<li style="display:${account_root}; border-top:0px; margin:0px; padding:0.5em 0em;">
										<a href="${pageContext.request.contextPath}/master/accounts.action">
											<h3>Account Management</h3>
											<p>Manage user accounts carefully</p>
										</a>
									</li>
									<li style="display:${article_root}; border-top:0px; margin:0px; padding:0.5em 0em;">
										<a href="${pageContext.request.contextPath}/master/article.action">
											<h3>Article Management</h3>
											<p>Managing Article Status</p>
										</a>
									</li>
									<li style="display:${cate_root}; border-top:0px; margin:0px; padding:0.5em 0em;">
										<a href="${pageContext.request.contextPath}/master/categoty.action">
											<h3>Classification Management</h3>
											<p>Article classification meticulous management</p>
										</a>
									</li>
									<li style="display:${write_root}; border-top:0px; margin:0px; padding:0.5em 0em;">
										<a href="${pageContext.request.contextPath}/ajax/writes.action">
											<h3>Write Article</h3>
											<p>Edit a new article</p>
										</a>
									</li>
									
									
								</ul>
							</section>

						<!-- Actions -->
							<section>
								<ul class="actions stacked">
									<li><a id="LogIn" href="${pageContext.request.contextPath}/login.action" style="display:${IN};" class="button large fit">Log In</a></li>
									<li><a id="LogOut" href="${pageContext.request.contextPath}/logout.action" style="display:${OUT};"  class="button large fit">Log Out</a></li>
									<li><a id="SignIn" href="${pageContext.request.contextPath}/signup.action" style="display:${UP};"  class="button large fit">Sign Up</a></li>
								</ul>
							</section>

					</section>

