<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
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
				<h1>List Books</h1>
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
											<th>Book id</th>
											<th>Book Name</th>
											<th>Book Description</th>
											<th>Date Created</th>
											</tr>
									</thead>
									<tbody>
								
										<s:iterator value="bookList" var="book" status="incr" >
											<tr>
											
												<td><s:property value="#book.bookId" /></td>
												<td><s:property value="#book.bookName" /></td>
												<td><s:property value="#book.bookDesc" /></td>
										       		<td><s:property value="#book.bookCreated" /></td>
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