<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard - Complaint Management System</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">

    <!-- Main Container -->
		    <jsp:include page="Nav.jsp"/>
    <div class="container mx-auto p-10">
		
        <!-- Header Section -->
        <header class="text-center mb-10">
            <h1 class="text-4xl font-bold text-gray-800">Admin Dashboard</h1>
            <p class="text-lg text-gray-600">Manage Complaints and Resolutions</p>
        </header>

        <!-- Dashboard Options Grid -->
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            
            <!-- View All Complaints Section -->
            <div class="bg-white p-6 shadow-lg rounded-lg text-center hover:shadow-xl transition-shadow duration-300">
                <h3 class="text-xl font-semibold text-gray-700 mb-4">View All Complaints</h3>
                <form action="viewComplaints.jsp" method="get">
                    <button type="submit" class="px-8 py-4 bg-blue-600 text-white rounded-md text-lg hover:bg-blue-700 transition duration-300">
                        View Complaints
                    </button>
                </form>
            </div>

            <!-- Fix a Complaint Section -->
            <div class="bg-white p-6 shadow-lg rounded-lg text-center hover:shadow-xl transition-shadow duration-300">
                <h3 class="text-xl font-semibold text-gray-700 mb-4">Fix a Complaint</h3>
                <form action="fixComplaint.jsp" method="get">
                    <button type="submit" class="px-8 py-4 bg-yellow-500 text-white rounded-md text-lg hover:bg-yellow-600 transition duration-300">
                        Fix Complaint
                    </button>
                </form>
            </div>

            <!-- View Pending Resolves Section -->
            <div class="bg-white p-6 shadow-lg rounded-lg text-center hover:shadow-xl transition-shadow duration-300">
                <h3 class="text-xl font-semibold text-gray-700 mb-4">View Pending Resolves</h3>
                <form action="viewPendingComplains.jsp" method="get">
                    <button type="submit" class="px-8 py-4 bg-green-600 text-white rounded-md text-lg hover:bg-green-700 transition duration-300">
                        View Resolves
                    </button>
                </form>
            </div>
        </div>

        <!-- Footer Section -->
        <footer class="text-center mt-10 text-gray-600">
            <p>&copy; 2025 Complaint Management System. All Rights Reserved.</p>
        </footer>

    </div>

</body>
</html>
