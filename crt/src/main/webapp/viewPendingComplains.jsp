<%@ page import="java.time.*, java.time.temporal.ChronoUnit" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="dao" class="com.java.resolve_complains.dao.ComplainsDaoImpl" scope="request" />
<c:set var="pendingComplaints" value="${dao.showPendingComplains()}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pending Complaints</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">

    <jsp:include page="Nav.jsp"/>

    <div class="container mx-auto p-8">
        <h2 class="text-3xl font-semibold text-center text-gray-800 mb-8">Pending Complaints with TAT</h2>

        <c:if test="${not empty pendingComplaints}">
            <table class="table-auto w-full text-left bg-white shadow-md rounded-lg overflow-hidden">
                <thead>
                    <tr class="bg-gray-200">
                        <th class="px-6 py-4 text-gray-700">Complaint ID</th>
                        <th class="px-6 py-4 text-gray-700">Complaint Type</th>
                        <th class="px-6 py-4 text-gray-700">Description</th>
                        <th class="px-6 py-4 text-gray-700">Date</th>
                        <th class="px-6 py-4 text-gray-700">Status</th>
                        <th class="px-6 py-4 text-gray-700">TAT (Days)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="complaint" items="${pendingComplaints}">
                        <%
                            java.sql.Timestamp ts = (java.sql.Timestamp) pageContext.getAttribute("complaint.complaintDate");
                            int tat = 0;
                            String rowClass = "";

                            if (ts != null) {
                                LocalDate complaintDate = ts.toLocalDateTime().toLocalDate();
                                tat = (int) ChronoUnit.DAYS.between(complaintDate, LocalDate.now());

                                if (tat >= 10) {
                                    rowClass = "bg-red-200";
                                } else if (tat >= 7) {
                                    rowClass = "bg-pink-200";
                                }
                            }
                        %>
                        <tr class="border-b hover:bg-gray-100 <%= rowClass %>">
                            <td class="px-6 py-4 text-gray-700">${complaint.complaintID}</td>
                            <td class="px-6 py-4 text-gray-700">${complaint.complaintType}</td>
                            <td class="px-6 py-4 text-gray-700">${complaint.cDescription}</td>
                            <td class="px-6 py-4 text-gray-700">${complaint.complaintDate}</td>
                            <td class="px-6 py-4 text-gray-700">${complaint.status}</td>
                            <td class="px-6 py-4 text-gray-700"><%= tat %></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty pendingComplaints}">
            <p class="text-center text-lg text-gray-700 mt-6">No pending complaints found.</p>
        </c:if>

        <!-- Back to Dashboard Button -->
        <div class="mt-8 text-center">
            <a href="adminDashboard.jsp">
                <button class="bg-blue-600 text-white px-6 py-3 rounded-lg text-lg font-semibold hover:bg-blue-700 transition duration-300">
                    Back to Dashboard
                </button>
            </a>
        </div>
    </div>

</body>
</html>
