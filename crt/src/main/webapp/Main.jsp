<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Complaint Management System</title>

    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-gray-100 to-white font-sans">

    <jsp:include page="Nav.jsp"/>

    <!-- Main Content Section -->
    <div class="py-24">
        <h1 class="text-4xl font-bold text-gray-800 mb-16">Welcome to Complaint Management</h1>

        <!-- Action Buttons -->
        <div class="flex justify-center gap-10">
            <!-- Raise an Issue Button -->
            <form action="UserDashboard.jsp" method="get">
                <button type="submit"
                        class="bg-green-600 hover:bg-green-700 text-white font-semibold px-10 py-5 rounded-lg shadow-md transition duration-300">
                    Raise an Issue
                </button>
            </form>

            <!-- Solve an Issue Button -->
            <form action="adminDashboard.jsp" method="get">
                <button type="submit"
                        class="bg-blue-600 hover:bg-blue-700 text-white font-semibold px-10 py-5 rounded-lg shadow-md transition duration-300">
                    Solve an Issue
                </button>
            </form>
        </div>
    </div>

    

</body>
</html>
