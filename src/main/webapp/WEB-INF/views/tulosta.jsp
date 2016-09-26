<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/style/main.css">

<link rel="stylesheet" type="text/css" href="resources/style//jquery-ui.css" />
<title><spring:message code="printAll" /></title>
</head>
<body>
	<div class="printDiv">

		<table class="printTable">
			<thead>
				<tr>
					<th><spring:message code="tunti.create.work_date" /></th>
					<th><spring:message code="tunti.create.start_time" /></th>
					<th><spring:message code="tunti.create.end_time" /></th>
					<th><spring:message code="tunti.create.info" /></th>
				</tr>

				<c:forEach var="data" items="${tunnit}">
					<tr>
						<td>${data.work_date}</td>
						<td>${data.start_time}</td>
						<td>${data.end_time}</td>
						<td>${data.info}</td>
				</c:forEach>
			<tfoot>
				<tr>
					<td colspan="4"><a href="tunnit"><button class="button">
								<spring:message code="back" />
							</button></td>

				</tr>
			</tfoot>

		</table>
	</div>
</body>
</html>