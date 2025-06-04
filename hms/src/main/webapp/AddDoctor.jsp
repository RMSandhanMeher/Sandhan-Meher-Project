<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<f:view>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Doctor</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fc;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            min-height: 100vh;
        }

        .form-container {
            margin-top: 40px;
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
            width: 500px;
            animation: fadeSlideIn 0.8s ease forwards;
            opacity: 0;
            transform: translateY(30px);
        }

        @keyframes fadeSlideIn {
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
            font-size: 2.2rem;
        }

        .form-container label {
            font-weight: bold;
            color: #333;
        }

        .form-container input[type="text"],
        .form-container select {
            width: 100%;
            padding: 8px 10px;
            font-size: 1rem;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin: 6px 0 15px 0;
            box-sizing: border-box;
        }

        .form-container .button-row {
            text-align: center;
            margin-top: 20px;
        }

        .form-container .button-row input[type="submit"] {
            padding: 10px 25px;
            background-color: #4A90E2;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-container .button-row input[type="submit"]:hover {
            background-color: #357ABD;
        }

        @media screen and (max-width: 600px) {
            .form-container {
                width: 90%;
                padding: 20px;
            }

            h1 {
                font-size: 1.8rem;
            }
        }
    </style>
</head>
<body>

    <div class="form-container">
    <h1>Add New Doctor</h1>

    <h:form>
        <h:panelGrid columns="2" cellpadding="5" columnClasses="label,value" style="width:100%">

            <h:outputLabel for="doctorId" value="Doctor ID:" />
            <h:inputText id="doctorId" value="#{doctor.doctorId}" required="true" />

            <h:outputLabel for="doctorName" value="Doctor Name:" />
            <h:inputText id="doctorName" value="#{doctor.doctorName}" required="true" />

            <h:outputLabel for="special" value="Specialization:" />
        <h:selectOneMenu id="special" value="#{hospitalController.doctor.special}" required="true">
            <f:selectItem itemLabel="-- Select Specialization --" itemValue="" />
            <f:selectItem itemLabel="Heart" itemValue="HEART" />
            <f:selectItem itemLabel="Skin" itemValue="SKIN" />
            <f:selectItem itemLabel="General" itemValue="GENERAL" />
            <f:selectItem itemLabel="Kidney" itemValue="KIDNEY" />
        </h:selectOneMenu>

            <h:outputLabel for="location" value="Location:" />
            <h:inputText id="location" value="#{doctor.location}" required="true" />

            <h:outputLabel for="mobileNo" value="Mobile No:" />
            <h:inputText id="mobileNo" value="#{doctor.mobileNo}" required="true" />

            <h:outputLabel for="status" value="Status:" />
            <h:selectOneMenu id="status" value="#{doctor.status}" required="true">
                <f:selectItem itemLabel="-- Select Status --" itemValue="" />
                <f:selectItem itemLabel="Active" itemValue="ACTIVE" />
                <f:selectItem itemLabel="Inactive" itemValue="INACTIVE" />
            </h:selectOneMenu>

        </h:panelGrid>

        <div class="button-row">
            <h:commandButton value="Add Doctor" action="#{hospitalController.addDoctor(doctor)}" />
        </div>
    </h:form>
</div>
</body>
</html>
</f:view>