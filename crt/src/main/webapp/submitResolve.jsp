<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- UseBean for Resolve object and Complaint object -->
<jsp:useBean id="resolve" class="com.java.resolve_complains.model.Resolve" scope="request" />
<jsp:setProperty name="resolve" property="*" />

<jsp:useBean id="complaint" class="com.java.resolve_complains.model.Complaint" scope="request" />
<!-- Set the complaint object using the complaintID parameter -->
<jsp:setProperty name="complaint" property="complaintID" param="complaintID" />

<%-- Set the complaint in resolve object --%>
<jsp:setProperty name="resolve" property="complaint" value="${complaint}" />

<jsp:useBean id="dao" class="com.java.resolve_complains.dao.ResolveImp" scope="request" />

<!-- Call resolve method and get the result -->
<c:set var="result" value="${dao.resolve(resolve)}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="5;url=adminDashboard.jsp" />
    <title>Resolve Submitted</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 text-gray-800 font-sans flex items-center justify-center min-h-screen">

    <div class="bg-white p-8 rounded-lg shadow-lg max-w-md w-full text-center">
        <h2 class="text-2xl font-semibold text-green-600 mb-4">Complaint Resolved Successfully!</h2>
        <p class="text-lg text-gray-700 mb-4">${result}</p>
        <p class="text-gray-500">You will be redirected to the Admin Dashboard shortly.</p>
    </div>

</body>
</html>
