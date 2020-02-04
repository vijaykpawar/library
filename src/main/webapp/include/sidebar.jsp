
<%@ taglib prefix="s" uri="/struts-tags"%>
<aside class="left-side sidebar-offcanvas">
	<section class="sidebar">
		<ul class="sidebar-menu">
		<!--  <img src="img/ic_launcher.jpg" style="width:220px;height:50px" style="PADDING-LEFT: 5px">-->
			<li class="active"><s:a action="dashboard">
					<i class="fa fa-dashboard"></i>
					<span>Dashboard</span>
				</s:a></li>
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-laptop"></i>
					<span>Students </span> 
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					
						<li><a href="listStudents"><i
								class="fa fa-angle-double-right"></i> List-Students </a></li>
					
					<li><a href="prepareAddStudent"><i
							class="fa fa-angle-double-right"></i> Add New Student</a></li>
				</ul>
			</li>
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-laptop"></i>
					<span>Books</span> 
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li><a href="listBooks"><i
							class="fa fa-angle-double-right"></i>All Book List</a></li>
					<li><a href="addBook"><i
							class="fa fa-angle-double-right"></i> Add New Book</a></li>
					
				</ul>
			</li>
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-laptop"></i>
					<span>Issue Book</span> 
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li><a href="prepareIssue"><i
							class="fa fa-angle-double-right"></i>Issue Book to Student</a></li>
					<li><a href="issedBooks"><i
							class="fa fa-angle-double-right"></i>Issued Books</a></li>
				</ul>
			</li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
