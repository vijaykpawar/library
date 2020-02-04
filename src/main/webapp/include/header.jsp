<%@ page language="java" import="java.util.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<header class="header">
	
	<!-- <a href="../img/logo.png" class="logo"> Landson Realty </a> -->
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" role="navigation">
		<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span> <span
			class="icon-bar"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span>
		</a>
		<div class="navbar-right">
			<ul class="nav navbar-nav">
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown notifications-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="glyphicon glyphicon-user"></i>
						<span>
							<s:property value="#session['user']"/> 
							<i class="caret"></i>
						</span>
				</a>
					<ul class="dropdown-menu">
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
								<li><a href="#"> <i class="ion ion-key info"></i>
										Change Password
								</a></li>
								<!-- <li><a href="#"> <i class="fa fa-user info"></i> My
										Profile
								</a></li> -->
								<li><a href="#"> <i class="fa fa-sign-out warning"></i>
										Logout
								</a></li>
							</ul>
						</li>
					</ul></li>
			</ul>
		</div>
	</nav>
</header>