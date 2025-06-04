<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <title>Patient Medical History</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f7ff;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            color: #007acc;
            margin-top: 30px;
            font-size: 2rem;
        }

        .form-container {
            width: 400px;
            margin: 30px auto;
            background: #ffffff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease-in-out;
        }

        .form-container:hover {
            transform: scale(1.02);
        }

        .form-container input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: 1px solid #007acc;
            border-radius: 5px;
            transition: box-shadow 0.3s ease;
        }

        .form-container input[type="text"]:focus {
            box-shadow: 0 0 10px rgba(0, 122, 204, 0.4);
            outline: none;
        }

        .form-container .ui-commandbutton,
        .form-container input[type="submit"],
        .form-container .command-btn {
            background-color: #007acc;
            color: white;
            border: none;
            padding: 10px;
            margin-top: 15px;
            width: 100%;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        .form-container .command-btn:hover {
            background-color: #005999;
        }

        .table-container {
            width: 90%;
            max-width: 900px;
            margin: 30px auto;
            background: #ffffff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            animation: fadeIn 0.6s ease-in-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .jsf-table {
            width: 100%;
            border-collapse: collapse;
            border-spacing: 0;
        }

        .jsf-table th,
        .jsf-table td {
            padding: 15px;
            text-align: center;
            font-size: 1rem;
            border-bottom: 1px solid #e0e0e0;
        }

        .jsf-table th {
            background-color: #007acc;
            color: #fff;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        .jsf-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .jsf-table tr:hover {
            background-color: #e6f4ff;
            transition: background-color 0.3s ease;
        }

        .cell-style {
            color: #333;
        }

        .no-data {
            text-align: center;
            color: #cc0000;
            font-weight: bold;
        }

        @media screen and (max-width: 600px) {
            .form-container, .table-container {
                width: 95%;
                padding: 15px;
            }

            .jsf-table th,
            .jsf-table td {
                padding: 10px;
                font-size: 0.9rem;
            }

            h2 {
                font-size: 1.5rem;
            }
        }
    </style>
</head>
<body>
	<jsp:include page="MedicalMenu.jsp" />
    <h2>Patient Medical History</h2>

    <!-- Form to Enter Patient ID -->
    <h:form styleClass="form-container">
        <h:outputLabel for="patientId" value="Enter Patient ID: " />
        <h:inputText id="patientId" value="#{hospitalController.patientId}" required="true" />
        <br/><br/>
        <h:commandButton styleClass="command-btn" value="Show Medical History" action="#{hospitalController.showPatientMedicalHistory}" />
        <br/><br/>
        <!-- Display error or success messages -->
        <h:messages style="color:red;" />
    </h:form>

    <!-- Table displaying medical history -->
    <h:panelGroup rendered="#{not empty hospitalController.patientMedicalHistory}" layout="block" styleClass="table-container">
        <h:dataTable value="#{hospitalController.patientMedicalHistory}" var="mh" styleClass="jsf-table" border="0" cellpadding="5" cellspacing="0">
            
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Med ID" />
                </f:facet>
                <h:outputText value="#{mh.medId}" styleClass="cell-style"/>
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Patient ID" />
                </f:facet>
                <h:outputText value="#{mh.patient.patientId}" styleClass="cell-style"/>
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Medicines" />
                </f:facet>
                <h:outputText value="#{mh.medicine}" styleClass="cell-style"/>
            </h:column>

            <h:column>
                <f:facet name="header">
                    <h:outputText value="Tests" />
                </f:facet>
                <h:outputText value="#{mh.tests}" styleClass="cell-style"/>
            </h:column>

        </h:dataTable>
    </h:panelGroup>

    <!-- Message when no data -->
    <h:panelGroup rendered="#{empty hospitalController.patientMedicalHistory}" layout="block">
        <p class="no-data">No Medical History Found for this Patient ID</p>
    </h:panelGroup>

</body>
</html>
</f:view>
