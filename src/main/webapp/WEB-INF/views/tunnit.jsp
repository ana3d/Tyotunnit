<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/style/main.css">

<link rel="stylesheet" type="text/css" href="resources/style//jquery-ui.css" />

    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/jquery-ui.min.js"></script>
    <script src="resources/js/jquery.ui.timepicker.js"></script>
    <script src="resources/js/ui.datepicker-fi.js"> </script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/generic.js"></script>

<title><spring:message code="tunti.create.title_main" /></title>
</head>
<body>

	<div id="langsel">
	<a href="tulosta"><button class="button"><spring:message code="print" /></button></a>
		<a href="?lang=en"><img src="resources/gfx/US.gif" class="flag"></a> | <a href="?lang=fi"><img src="resources/gfx/FI.gif" class="flag"></a>
		
	</div>
	
	<legend><spring:message code="tunti.create.legend" />  </legend> 
	<br>
		<c:forEach var="data" items="${tunnit}">
		<div class="div">
			
		<spring:message code="tunti.create.work_date" />	${data.work_date}<br>
		<spring:message code="tunti.create.start_time" />	 ${data.start_time}<br>
		<spring:message code="tunti.create.end_time" />	 ${data.end_time}<br>
		<spring:message code="tunti.create.info" />	${data.info}
			
			</div>
		</c:forEach>
		
		
		<form:form modelAttribute="tunti" method="post">
		  	<fieldset>		
				<legend><spring:message code="tunti.create.legend" /></legend>
				
				<spring:hasBindErrors name="tunti">
					<p class="Virheotsikko"><spring:message code="tunti.create.errors" />:</p>
					<div class="Virheblokki"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
				<p>
					<form:label	path="work_date"><spring:message code="tunti.create.work_date" /></form:label><br/>
					<form:input path="work_date" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="work_date" cssClass="Virheteksti"/>		
				</p>
				<p>	
					<form:label path="start_time"><spring:message code="tunti.create.start_time" /></form:label><br/>
					<form:input path="start_time" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="start_time" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<form:label path="end_time"><spring:message code="tunti.create.end_time" /></form:label><br/>
					<form:input path="end_time" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="end_time" cssClass="Virheteksti"/>	
				</p>
				<p>	
					<form:label path="info"><spring:message code="tunti.create.info" /></form:label><br/>
					<form:input path="info" cssErrorClass="VirheellinenKentta"/> <br>
					<form:errors path="info" cssClass="Virheteksti"/>	
				</p>

				<p>	
					<button type="submit" class="button"><spring:message code="tunti.create.add" /></button>
				</p>
			</fieldset>
		</form:form>
		

</body>
</html>