<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
   %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student List</title>
<s:include value="../include/cssIncludes.jsp"></s:include>
<sx:head/>
</head>
<body class="skin-blue">
	<s:include value="../include/header.jsp"></s:include>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
	
		<s:include value="../include/sidebar.jsp"></s:include>
		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>List Students</h1>
			</section>
			<section class="content">
				<div class="row">
					<s:form name="deluserFrm" id="deluserFrm" action="">

					</s:form>
					<div class="col-xs-12">
						<div class="box">
							<!-- /.box-header -->
							<div id="errorMessageDiv">
								<s:if test="hasActionErrors()">
										<s:actionerror />
								</s:if>
								<s:if test="hasActionMessages()">
										<s:actionmessage />
								</s:if>
		
							</div>
		
							<div class="box-body table-responsive">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>Student id</th>
											<th>First Name </th>
											<th>Last Name</th>
											<th>Class</th>
											<th>Address</th>
											<th>Mobile</th>
											<th>Email</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="studentList" var="student" status="incr">
											<tr>
												<td><s:property value="#student.studentId" /></td>
												<td><s:property value="#student.firstName" /></td>
												<td><s:property value="#student.lastName" /></td>
												<td><s:property value="#student.studentClass" /></td>
										       	<td><s:property value="#student.studentAddress" /></td>
												<td><s:property value="#student.mobile" /></td>
												<td><s:property value="#student.email" /></td>
											</tr>
										</s:iterator>									
									</tbody>
								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
				</div>
			</section>
		</aside>
	</div>
	<!-- ./wrapper -->

	<s:include value="../include/footer.jsp"></s:include>
	<s:include value="../include/jsIncludes.jsp"></s:include>
	<script type="text/javascript">
	$(function() {
		$('#example1').dataTable();
	});
</script>
</body>

</html>