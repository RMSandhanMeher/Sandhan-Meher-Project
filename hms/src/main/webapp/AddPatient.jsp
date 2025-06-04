<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>Add Patient</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.form-container {
	margin: 50px auto;
	padding: 20px;
	width: 400px;
	background-color: white;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
}

label {
	font-weight: bold;
}

.form-control {
	width: 100%;
	padding: 8px;
	margin-top: 5px;
	margin-bottom: 15px;
}

.submit-btn {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px;
	width: 100%;
	font-size: 16px;
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="Menu.jsp" />
	<h1>Add Patient</h1>
	<h:form styleClass="form-container">

		<h:outputLabel for="pid" value="Patient ID:" />
		<h:inputText id="pid" value="#{patient.patientId}"
			styleClass="form-control" required="true" />

		<h:outputLabel for="pname" value="Patient Name:" />
		<h:inputText id="pname" value="#{patient.patientName}"
			styleClass="form-control" required="true" />

		<h:outputLabel for="dob" value="Date of Birth:" />
		<h:inputText id="dob" value="#{patient.DOB}" styleClass="form-control">
			<f:convertDateTime pattern="yyyy-MM-dd" />
		</h:inputText>

		<h:outputLabel for="docid" value="Doctor ID:" />
		<h:inputText id="docid" value="#{hospitalController.doctorId}" />

		<h:commandButton value="Add Patient"
			action="#{hospitalController.addPatient(patient)}" styleClass="submit-btn" />

		<h:messages globalOnly="true" style="color:red; font-weight:bold;" />
	</h:form>


</body>
	</html>
</f:view>
