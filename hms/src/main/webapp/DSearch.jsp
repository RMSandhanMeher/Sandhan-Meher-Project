<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Search Doctor</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
            }
            h1 {
                text-align: center;
                margin-top: 20px;
            }
            form {
                margin: 20px auto;
                padding: 20px;
                background-color: white;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 50%;
            }
            .error-message {
                color: red;
                font-weight: bold;
                text-align: center;
            }
            label {
                font-weight: bold;
                display: inline-block;
                margin-top: 10px;
                width: 200px;
            }
            input[type="text"], input[type="submit"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
                font-weight: bold;
            }
            input[type="submit"]:hover {
                background-color: #45a049;
            }
            .panel-grid {
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        <h1>Doctor Search</h1>

        <h:form>
            <h:outputLabel for="searchId" value="Enter Doctor ID: " />
            <h:inputText id="searchId" value="#{hospitalController.searchId}" required="true" />

            <h:commandButton value="Search" action="#{hospitalController.searchDoctorById}" />

            <h:messages globalOnly="true" styleClass="error-message" />

            <h:panelGrid columns="2" rendered="#{not empty hospitalController.doctor.doctorId}" styleClass="panel-grid">
                <h:outputLabel value="Doctor Name:" />
                <h:outputText value="#{hospitalController.doctor.doctorName}" />

                <h:outputLabel value="Specialization:" />
                <h:outputText value="#{hospitalController.doctor.special}" />

                <h:outputLabel value="Phone Number:" />
                <h:outputText value="#{hospitalController.doctor.mobileNo}" />

                <h:outputLabel value="Status:" />
                <h:outputText value="#{hospitalController.doctor.status}" />
            </h:panelGrid>
        </h:form>
    </body>
    </html>
</f:view>
