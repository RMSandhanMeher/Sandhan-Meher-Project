<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:useBean id="complaint" class="com.java.resolve_complains.model.Complaint" scope="request" />
<c:set var="complaintID" value="${param.complaintID}" />
<jsp:setProperty name="complaint" property="complaintID" />
<jsp:useBean id="dao" class="com.java.resolve_complains.dao.ComplainsDaoImpl" scope="request" />
<c:set var="searchResult" value="${dao.searchComplaint(complaintID)}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Resolve Complaint</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 text-gray-800 font-sans py-10 px-4">

    <h2 class="text-3xl font-bold text-center mb-6">Resolve Complaint</h2>

    <c:choose>
        <c:when test="${not empty searchResult}">
            <div class="max-w-xl mx-auto bg-white p-8 rounded-lg shadow">
                <h3 class="text-xl font-semibold mb-4 text-green-700">Complaint ID: ${searchResult.complaintID}</h3>

                <form action="submitResolve.jsp" method="post" class="space-y-4">
                    <input type="hidden" name="complaintID" value="${complaint.complaintID}" />

                    <div>
                        <label class="block font-medium mb-1" for="resolveDate">Resolve Date:</label>
                        <input type="date" name="resolveDate" required
                               class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-green-500">
                    </div>

                    <div>
                        <label class="block font-medium mb-1" for="resolvedBy">Resolved By:</label>
                        <input type="text" name="resolvedBy" required
                               class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-green-500">
                    </div>

                    <div>
                        <label class="block font-medium mb-1" for="comments">Comments:</label>
                        <textarea name="comments" required rows="4"
                                  class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-green-500"></textarea>
                    </div>

                    <button type="submit"
                            class="w-full bg-green-600 hover:bg-green-700 text-white font-bold py-2 px-4 rounded transition duration-300">
                        Submit Resolve
                    </button>
                </form>
            </div>
        </c:when>

        <c:otherwise>
            <div class="max-w-lg mx-auto mt-10 bg-white p-8 rounded shadow text-center">
                <p class="text-red-600 text-lg font-semibold mb-4">Complaint ID not found. Please check the ID and try again.</p>
                <a href="fixComplaint.jsp"
                   class="text-blue-600 hover:underline font-medium">Go Back and Try Again</a>
            </div>
        </c:otherwise>
    </c:choose>

</body>
</html>
