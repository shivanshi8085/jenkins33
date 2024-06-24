
<%@page import="in.co.rays.project_3.controller.OwnerCtl"%>
<%@page import="in.co.rays.project_3.controller.SalaryCtl"%>
<%@page import="in.co.rays.project_3.controller.JobCtl"%>
<%@page import="java.util.List"%>

<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<%=ORSView.APP_CONTEXT%>/js/validateInput.js"></script>
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Owner view</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript">
	function numberLength(input) {
		if (input.value.length > 10) {
			input.value = input.value.slice(0, 10);
		}
	}
</script>
<style type="text/css">
i.css {
	border: 2px solid #8080803b;
	padding-left: 10px;
	padding-bottom: 11px;
	background-color: #ebebe0;
}

.input-group-addon {
	box-shadow: 9px 8px 7px #001a33;
	background-image: linear-gradient(to bottom right, purple, white);
	background-repeat: no repeat;
	background-size: 100%;
	padding-bottom: 11px;
}

.hm {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/download (3).jpeg');
	background-size: cover;
	padding-top: 6%;
}
</style>

</head>
<body class="hm">
	<div class="header">
		<%@include file="Header.jsp"%>
		<%@include file="calendar.jsp"%>
	</div>
	<div>

		<main>
		<form action="<%=ORSView.OWNER_CTL%>" method="post">
			<jsp:useBean id="dto" class="in.co.rays.project_3.dto.OwnerDTO"
				scope="request"></jsp:useBean>
			<div class="row pt-3">
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card input-group-addon">
						<div class="card-body">

							<%
								long id = DataUtility.getLong(request.getParameter("id"));

								if (dto.getId() != null && id > 0) {
							%>
							<h3 class="text-center default-text text-primary">Update
								Owner</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text text-primary">Add Owner</h3>
							<%
								}
							%>
							<!--Body-->
							<div>



								<H4 align="center">
									<%
										if (!ServletUtility.getSuccessMessage(request).equals("")) {
									%>
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getSuccessMessage(request)%>
									</div>
									<%
										}
									%>
								</H4>

								<H4 align="center">
									<%
										if (!ServletUtility.getErrorMessage(request).equals("")) {
									%>
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getErrorMessage(request)%>
									</div>
									<%
										}
									%>

								</H4>

								<input type="hidden" name="id" value="<%=dto.getId()%>">

							</div>

							<div class="md-form">

								<span class="pl-sm-5"><b> Name</b> <span
									style="color: red;">*</span></span> </br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-user-alt grey-text" style="font-size: 1rem;"></i>
											</div>
										</div>
										<input type="text" class="form-control" name="name"
											placeholder="Enter Name"
											value="<%=DataUtility.getStringData(dto.getName())%>">
											
 										
									</div>
								</div>
								
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("name", request)%></font></br>
								
								<span class="pl-sm-5"><b>InsurenceAmount</b> <span
									style="color: red;">*</span></span></br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-list grey-text" style="font-size: 1rem;"></i>
											</div>
										</div>
										<input type="number" class="form-control" id="insurenceAmount"
											name="insurenceAmount" oninput="validateMobileNo(event)"
											maxlength="10" placeholder=" Enter Amount"
											value="<%=DataUtility.getStringData(dto.getInsuranceAmount()).equals("0") ? ""
					: DataUtility.getStringData(dto.getInsuranceAmount())%>">
									</div>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("insurenceAmount", request)%></font></br>

								<span class="pl-sm-5"><b>VehicleId</b> <span
									style="color: red;">*</span></span></br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-user-circle grey-text"
													style="font-size: 1rem;"></i>
											</div>
										</div>
										<%-- <input type="number" class="form-control"
											name="vehicleId" placeholder=" Enter VehicleId" maxlength="10"
											value="<%=DataUtility.getStringData(dto.getVehicleId()).equals("0") ? ""
					: DataUtility.getStringData(dto.getVehicleId())%>">
 --%>
										<%
											HashMap<String, String> map = new HashMap<>();
											map.put("11", "11");
											map.put("12", "12");
											map.put("13", "13");
											map.put("14", "14");
											map.put("15", "15");

											String vehicleId = String.valueOf(dto.getVehicleId());

											String htmlList = HTMLUtility.getList("vehicleId", vehicleId, map);
										%>
										<%=htmlList%>




									</div>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("vehicleId", request)%></font></br>





								<span class="pl-sm-5"><b>Dob</b> <span
									style="color: red;">*</span></span></br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-calendar grey-text" style="font-size: 1rem;"></i>
											</div>
										</div>
										<%-- <input type="text" id="datepicker" name="dob"
											class="form-control" placeholder=" Enter Dob"
											readonly="readonly"
											value="<%=DataUtility.getDateString(dto.getDob())%>">
 --%>

										<%
											HashMap<String, String> map1 = new HashMap<>();
											map1.put("03/03/2020", "03/03/2020");
											map1.put("11/02/2021", "11/02/2021");
											map1.put("09/07/2022", "09/07/2022");

											String dob = String.valueOf(dto.getDob());

											String htmlList1 = HTMLUtility.getList("dob", dob, map1);
										%>
										<%=htmlList1%>


									</div>

								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("dob", request)%></font></br>







								<%-- 
								<%
								if (dto.getId()==null||id<=0) {
								%> --%>





								<%
									if (dto.getId() != null && id > 0) {
								%>

								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=OwnerCtl.OP_UPDATE%>"> <input type="submit"
										name="operation" class="btn btn-warning btn-md"
										style="font-size: 17px" value="<%=OwnerCtl.OP_CANCEL%>">

								</div>
								<%
									} else {
								%>
								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=OwnerCtl.OP_SAVE%>"> <input type="submit"
										name="operation" class="btn btn-warning btn-md"
										style="font-size: 17px" value="<%=OwnerCtl.OP_RESET%>">
								</div>

							</div>
							<%
								}
							%>
						</div>
					</div>
		</form>
		</main>
		<div class="col-md-4 mb-4"></div>

	</div>

</body>
<%@include file="FooterView.jsp"%>

</body>
</html>


