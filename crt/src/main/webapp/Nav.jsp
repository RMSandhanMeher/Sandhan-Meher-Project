<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Complaint Management System</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-gray-100 to-white font-sans">

    <!-- Navbar -->
    <nav class="bg-gray-800 text-white shadow-md">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-4">
            <div class="flex items-center justify-between">
                <!-- Logo / App name -->
                <div class="text-2xl font-semibold">Complaint Management</div>
                
                <!-- Navbar links -->
                <div class="space-x-6">
                    <a href="Main.jsp" class="hover:text-gray-400">Home</a>
                    <a href="adminDashboard.jsp" class="hover:text-gray-400">Admin Dashboard</a> <!-- New Admin Dashboard link -->
                    <a href="viewPendingComplains.jsp" class="hover:text-gray-400">Pending Complains</a>
                    <a href="raiseComplaint.jsp" class="hover:text-gray-400">raise Complaint</a>
                </div>
            </div>
        </div>
    </nav>


</body>
</html>
