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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Book</title>
<script type="text/javascript">

function issueBook(bookId){
	
	$('#bookId').val(bookId);
	$('#searchBook').submit();
	
}

</script>
</head>
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
			
				<h1>Issue Book</h1>
			</section>
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- general form elements disabled -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">Search Book</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body" style="width: 100%">
								<div id="errorMessageDiv">
									<s:if test="hasActionErrors()">
										<s:actionerror />
									</s:if>
									<s:if test="hasActionMessages()">
										<s:actionmessage />
									</s:if>

								</div>

								<s:form action="searchBook" 
									theme="bootstrap" cssClass="form-horizontal">
									<s:hidden id="studentId" name="student.studentId"></s:hidden>
									<div class="form-group">
										<div class="col-md-6">
											<s:textfield placeholder="first name"  readonly="true"
												name="student.firstName" 
												id="firstName" label="First Name"
												maxlength="50" theme="bootstrap" />
										</div>
										<div class="col-md-6">
											<s:textfield placeholder="last name" readonly="true"
												name="student.lastName"
												id="lastName" label="Last Name"
												maxlength="50" theme="bootstrap" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-6">
										<s:hidden name="book.bookId" id="bookId"></s:hidden>
											<s:textfield placeholder="Book Name"  requiredLabel="true"
												name="book.bookName" 
												id="firstName" label="First Name"
												maxlength="50" theme="bootstrap" />
										</div>
										
										<div class="col-md-6">
										<s:submit cssClass="btn btn-primary" value="Search" />
										</div>
									</div>
								</s:form>
								<s:if test="bookList.size() >0">
							<div class="box-body table-responsive">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											
											<th>Book Name</th>
											<th>Book Description</th>
											<th>Action</th>
											</tr>
									</thead>
									<tbody>
								
										<s:iterator value="bookList" var="book" status="incr" >
											<tr>
											
											
												<td><s:property value="#book.bookName" /></td>
												<td><s:property value="#book.bookDesc" /></td>
										    <td align="center">
												<span class="glyphicon glyphicon-log-in">
												<s:a href="#"
														onclick="issueBook('%{#book.bookId}')"
														 >SELECT</s:a>
												</span>
												
														</td>
										    
											</tr>
										</s:iterator>									
									</tbody>
								</table>
							</div>
							</s:if>
							
							</div>
						</div>
					</div>
				</div>
			</section>
		</aside>
	</div>
	<!-- ./wrapper -->
	<s:include value="../include/footer.jsp"></s:include>
	<s:include value="../include/jsIncludes.jsp"></s:include>
</body>
</html>