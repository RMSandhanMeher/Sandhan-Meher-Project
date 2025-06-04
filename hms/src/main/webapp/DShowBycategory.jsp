<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<f:view>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Doctor by Specialization</title>

            <style>
                body {
                    font-family: Arial, sans-serif;
                    margin: 0;
                    padding: 0;
                    background-color: #f4f7fc;
                    display: flex;
                    justify-content: center;
                    padding-top: 50px;
                }

                .form-container {
                    width: 80%;
                    max-width: 600px;
                    background-color: white;
                    padding: 30px;
                    border-radius: 10px;
                    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                }

                h1 {
                    text-align: center;
                    color: #2c3e50;
                }

                .dropdown-label {
                    font-weight: bold;
                    color: #333;
                    margin-bottom: 10px;
                }

                .output-label {
                    font-weight: bold;
                }

                .table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 20px;
                }

                .table th, .table td {
                    padding: 12px 15px;
                    text-align: left;
                    border: 1px solid #ddd;
                }

                .table th {
                    background-color: #4A90E2;
                    color: white;
                }
            </style>
        </head>
        <body>
            <div class="form-container">
                <h1>Doctors by Specialization</h1>

                <h:form>
                    <!-- Specialization Dropdown -->
                    <label class="dropdown-label" for="specialization">Select Specialization:</label>
                    <h:selectOneMenu id="specialization" value="#{hospitalController.special}" onchange="submit()">
                        <f:selectItem itemLabel="-- Select Specialization --" itemValue="" />
                        <f:selectItems value="#{hospitalController.getSpecializations()}" var="special" itemLabel="#{special}" itemValue="#{special}" />
                    </h:selectOneMenu>

                    <br /><br />

                    <!-- Display Selected Specialization -->
                    <h:outputLabel id="heading" value="Selected Specialization is " styleClass="output-label" />
                    <h:outputText id="result" value="#{hospitalController.special}" />

                    <!-- Data Table displaying Doctor information based on specialization -->
                    <h:dataTable value="#{hospitalController.doctorDao.showbyCategory(hospitalController.special)}" var="doctor" border="1" styleClass="table">
                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="Doctor Name" />
                            </f:facet>
                            <h:outputText value="#{doctor.doctorName}" />
                        </h:column>

                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="Specialization" />
                            </f:facet>
                            <h:outputText value="#{doctor.special}" />
                        </h:column>

                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="Phone Number" />
                            </f:facet>
                            <h:outputText value="#{doctor.mobileNo}" />
                        </h:column>

                        <h:column>
                            <f:facet name="header">
                                <h:outputLabel value="Status" />
                            </f:facet>
                            <h:outputText value="#{doctor.status}" />
                        </h:column>
                    </h:dataTable>
                </h:form>
            </div>
        </body>
    </html>
</f:view>
