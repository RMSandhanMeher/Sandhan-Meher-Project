<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="dao" class="com.java.resolve_complains.dao.ComplainsDaoImpl" scope="request" />
<c:set var="complaints" value="${dao.showAllComplaint()}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Complaints</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">
    <jsp:include page="Nav.jsp"/>


    <div class="container mx-auto p-8">
        <h2 class="text-3xl font-semibold text-center text-gray-800 mb-8">All Complaints</h2>

        <c:choose>
            <c:when test="${not empty complaints}">
                <table class="table-auto w-full text-left border-collapse">
                    <thead>
                        <tr>
                            <th class="px-6 py-4 bg-gray-200 border-b text-gray-700">ID</th>
                            <th class="px-6 py-4 bg-gray-200 border-b text-gray-700">Type</th>
                            <th class="px-6 py-4 bg-gray-200 border-b text-gray-700">Description</th>
                            <th class="px-6 py-4 bg-gray-200 border-b text-gray-700">Date</th>
                            <th class="px-6 py-4 bg-gray-200 border-b text-gray-700">Severity</th>
                            <th class="px-6 py-4 bg-gray-200 border-b text-gray-700">Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="comp" items="${complaints}">
                            <tr class="hover:bg-gray-100">
                                <td class="px-6 py-4 border-b text-gray-700">${comp.complaintID}</td>
                                <td class="px-6 py-4 border-b text-gray-700">${comp.complaintType}</td>
                                <td class="px-6 py-4 border-b text-gray-700">${comp.cDescription}</td>
                                <td class="px-6 py-4 border-b text-gray-700">${comp.complaintDate}</td>
                                <td class="px-6 py-4 border-b text-gray-700">${comp.severity}</td>
                                <td class="px-6 py-4 border-b text-gray-700">${comp.status}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p class="text-center text-lg text-gray-700">No complaints found.</p>
            </c:otherwise>
        </c:choose>

        <!-- Go Back to Dashboard Button -->
        <div class="mt-8 text-center">
            <form action="adminDashboard.jsp" method="get">
                <button type="submit" class="bg-blue-600 text-white px-6 py-3 rounded-lg text-lg font-semibold hover:bg-blue-700 transition duration-300">Go to Dashboard</button>
            </form>
        </div>

    </div>

</body>
</html>
