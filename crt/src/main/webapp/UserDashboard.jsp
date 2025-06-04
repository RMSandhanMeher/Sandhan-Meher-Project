<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - Complaint System</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">
    <jsp:include page="Nav.jsp"/>

    <div class="container mx-auto p-8 text-center">
        <h1 class="text-3xl font-semibold text-gray-800 mb-10">User Dashboard</h1>

        <!-- Raise Complaint -->
        <form action="raiseComplaint.jsp" method="get" class="mb-8">
            <button class="btn bg-green-600 text-white px-6 py-3 rounded-lg text-lg font-semibold hover:bg-green-700 transition duration-300">Raise a New Complaint</button>
        </form>

        <!-- Search Resolve by Complaint ID -->
        <div class="mb-10">
            <h2 class="text-2xl font-semibold text-gray-700 mb-4">Search Resolve Record</h2>
            <form action="UserDashboard.jsp" method="get">
                <input type="text" name="complaintId" placeholder="Enter Complaint ID" required class="p-3 border border-gray-300 rounded-lg w-64 text-lg mb-4">
                <button class="btn bg-blue-600 text-white px-6 py-3 rounded-lg text-lg font-semibold hover:bg-blue-700 transition duration-300">Search</button>
            </form>
        </div>

        <jsp:useBean id="dao" class="com.java.resolve_complains.dao.ResolveImp" />
        
        <c:if test="${not empty param.complaintId}">
            <c:set var="resolve" value="${dao.searchResolveByComplaintId(param.complaintId)}"/>
        </c:if>

        <!-- Display Search Results (if any) -->
        <c:if test="${not empty resolve}">
            <c:choose>
                <c:when test="${resolve.tat >= 10}">
                    <div class="result bg-red-600 text-white p-6 rounded-lg shadow-md mb-6">
                </c:when>
                <c:when test="${resolve.tat >= 7}">
                    <div class="result bg-pink-300 text-gray-800 p-6 rounded-lg shadow-md mb-6">
                </c:when>
                <c:otherwise>
                    <div class="result bg-white text-gray-800 p-6 rounded-lg shadow-md mb-6">
                </c:otherwise>
            </c:choose>

            <h3 class="text-xl font-semibold mb-4">Resolve Record</h3>
            <p><strong>Complaint ID:</strong> ${resolve.complaint.complaintID}</p>
            <p><strong>Resolve ID:</strong> ${resolve.resolveId}</p>
            <p><strong>Resolved By:</strong> ${resolve.resolvedBy}</p>
            <p><strong>Comments:</strong> ${resolve.comments}</p>
            <p><strong>Resolution Date:</strong> ${resolve.resolveDate}</p>
            <p><strong>TAT (Turnaround Time):</strong> ${resolve.tat}</p>
        </div>
        </c:if>

        <!-- Display Message if No Result Found -->
        <c:if test="${empty resolve}">
            <div class="result bg-gray-200 text-gray-800 p-6 rounded-lg shadow-md mb-6">
                <p>No resolve record found for the given complaint ID.</p>
            </div>
        </c:if>

    </div>

</body>
</html>
