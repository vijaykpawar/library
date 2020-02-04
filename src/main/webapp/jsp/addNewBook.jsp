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
<title>Add New Book</title>
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
			
				<h1>Add New Book</h1>
			</section>
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- general form elements disabled -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">Book Info</h3>
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

								<s:form action="addNewBook" 
									theme="bootstrap" cssClass="form-horizontal">
									<div class="form-group">
										<div class="col-md-6">
											<s:textfield placeholder="Name "  requiredLabel="true"
												name="book.bookName" 
												id="name" label="Name"
												maxlength="50" theme="bootstrap" />
										</div>
										<div class="col-md-6">
											<s:textfield placeholder="Desc "
												name="book.bookDesc"
												id="Desc" label="Desc"
												maxlength="50" theme="bootstrap" />
										</div>
										
										
									</div>
									
																
									<div class="box-footer text-center">
										<s:submit cssClass="btn btn-primary" />
									</div>
								</s:form>
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