<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Submit Complaint</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 text-gray-800 font-sans py-10 px-4">

    <c:set var="result" value="${dao.addComplaint(complaint)}"/>

    <div class="max-w-xl mx-auto bg-white p-8 rounded-lg shadow-md">
        <c:choose>
            <c:when test="${not empty result}">
                <h2 class="text-2xl font-semibold text-green-600 mb-4">Complaint Submitted Successfully!</h2>
                <p class="text-lg text-gray-700">Thank you for submitting your complaint. We will review it soon.</p>
            </c:when>
            <c:otherwise>
                <h2 class="text-2xl font-semibold text-red-600 mb-4">Submission Failed</h2>
                <p class="text-lg text-gray-700">Something went wrong while submitting your complaint. Please try again later.</p>
            </c:otherwise>
        </c:choose>
        
        <div class="mt-6">
            <a href="raiseComplaint.jsp" class="text-blue-600 hover:underline">Go back to form</a>
        </div>
    </div>

</body>
</html>
