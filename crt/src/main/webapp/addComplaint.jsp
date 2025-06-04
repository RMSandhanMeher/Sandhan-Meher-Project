<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="complaint" class="com.java.resolve_complains.model.Complaint" />
<jsp:setProperty name="complaint" property="*" />

<jsp:useBean id="dao" class="com.java.resolve_complains.dao.ComplainsDaoImpl" />
<c:set var="result" value="${dao.addComplaint(complaint)}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="refresh" content="8;url=UserDashboard.jsp" />
    <meta charset="UTF-8">
    <title>Complaint Submitted</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">

    <div class="bg-white shadow-md rounded-lg p-8 text-center max-w-md mx-auto">
        <h1 class="text-2xl font-semibold text-green-600 mb-4">${result}</h1>
        <p class="text-gray-700">Redirecting to your dashboard...</p>
        <div class="mt-6">
            <a href="UserDashboard.jsp" class="text-blue-600 hover:underline">Click here if you are not redirected</a>
        </div>
    </div>

</body>
</html>
