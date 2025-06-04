<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Doctor List</title>

        <style>
            body {
                font-family: Arial, sans-serif;
                background: #f4f7fc;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                align-items: center;
                min-height: 100vh;
            }

            .animated-heading {
                font-size: 3rem;
                color: #2c3e50;
                margin: 40px 0 20px 0;
                animation: slideFadeDown 1s ease forwards;
                opacity: 0;
                transform: translateY(-50px);
            }

            @keyframes slideFadeDown {
                to {
                    opacity: 1;
                    transform: translateY(0);
                }
            }

            .doctorTable {
                width: 80%;
                border-collapse: collapse;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                background-color: #ffffff;
                border-radius: 8px;
                overflow: hidden;
            }

            .doctorTable th,
            .doctorTable td {
                padding: 12px 20px;
                text-align: center;
                font-size: 1rem;
                color: #333;
            }

            .doctorTable th {
                background-color: #4A90E2;
                color: white;
                font-weight: bold;
            }

            .doctorTable tr {
                transition: background-color 0.3s ease;
                opacity: 0;
                transform: translateY(20px);
                animation: fadeIn 0.5s forwards;
            }

            .doctorTable tr:hover {
                background-color: #f1f8ff;
            }

            .doctorTable tr:nth-child(odd) {
                animation-delay: 0.3s;
            }

            .doctorTable tr:nth-child(even) {
                animation-delay: 0.5s;
            }

            @keyframes fadeIn {
                to {
                    opacity: 1;
                    transform: translateY(0);
                }
            }

            @media screen and (max-width: 768px) {
                .doctorTable {
                    width: 95%;
                }

                .doctorTable th,
                .doctorTable td {
                    padding: 10px;
                    font-size: 0.9rem;
                }

                .animated-heading {
                    font-size: 2rem;
                }
            }
        </style>
    </head>
    <body>
        <!-- Animated Top Heading -->
        <div class="animated-heading">Welcome to the Doctor Directory</div>

        <!-- Table Title -->
        <h1>Doctor List</h1>

        <!-- DataTable to show the full doctor details -->
        <h:dataTable value="#{hospitalController.showAllDoctors()}" var="doctor" border="1" styleClass="doctorTable">
            <f:facet name="header">
                <h:outputText value="Doctor List" />
            </f:facet>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Doctor ID" />
                </f:facet>
                <h:outputText value="#{doctor.doctorId}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Doctor Name" />
                </f:facet>
                <h:outputText value="#{doctor.doctorName}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Specialization" />
                </f:facet>
                <h:outputText value="#{doctor.special}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Location" />
                </f:facet>
                <h:outputText value="#{doctor.location}" />
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Mobile No" />
                </f:facet>
                <h:outputText value="#{doctor.mobileNo}" />
            </h:column>

            <!-- New Column for Status -->
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Status" />
                </f:facet>
                <h:outputText value="#{doctor.status}" />
            </h:column>

        </h:dataTable>
    </body>
    </html>
</f:view>
