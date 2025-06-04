<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Navigation</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        .nav-transition {
            transition: all 0.3s ease;
        }
        .dropdown:hover .dropdown-menu {
            display: block;
        }
    </style>
</head>
<body>
    <nav class="bg-white/80 backdrop-blur-md shadow-sm fixed w-full top-0 z-10">
        <div class="max-w-7xl mx-auto px-4">
            <div class="flex justify-between items-center py-4">
                <div class="flex items-center space-x-2">
                    <i class="fas fa-heartbeat text-2xl text-pink-500"></i>
                    <a href="index.jsp" class="font-semibold text-gray-800 hover:text-pink-600">MediCare</a>
                </div>
                
                <div class="hidden md:flex space-x-6">
                    <!-- Home -->
                    <a href="index.jsp" class="text-gray-600 hover:text-pink-600 nav-transition">Home</a>
                    
                    <!-- Patient Menu Dropdown -->
                    <div class="dropdown relative">
                        <button class="text-gray-600 hover:text-pink-600 nav-transition focus:outline-none">
                            Patients <i class="fas fa-chevron-down ml-1 text-xs"></i>
                        </button>
                        <div class="dropdown-menu absolute hidden bg-white mt-2 py-2 w-48 rounded-md shadow-lg z-20">
                            <a href="AddPatient.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">Add Patient</a>
                            <a href="ShowPatientById.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">View Patient</a>
                            <a href="PatientMenu.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">Patient Menu</a>
                        </div>
                    </div>
                    
                    <!-- Doctor Menu Dropdown -->
                    <div class="dropdown relative">
                        <button class="text-gray-600 hover:text-pink-600 nav-transition focus:outline-none">
                            Doctors <i class="fas fa-chevron-down ml-1 text-xs"></i>
                        </button>
                        <div class="dropdown-menu absolute hidden bg-white mt-2 py-2 w-48 rounded-md shadow-lg z-20">
                            <a href="AddDoctor.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">Add Doctor</a>
                            <a href="ShowDoctor.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">View Doctors</a>
                            <a href="DShowBycategory.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">Doctors by Category</a>
                            <a href="ShowPatientByDoc.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">Patients by Doctor</a>
                        </div>
                    </div>
                    
                    <!-- Medical Menu Dropdown -->
                    <div class="dropdown relative">
                        <button class="text-gray-600 hover:text-pink-600 nav-transition focus:outline-none">
                            Medical <i class="fas fa-chevron-down ml-1 text-xs"></i>
                        </button>
                        <div class="dropdown-menu absolute hidden bg-white mt-2 py-2 w-48 rounded-md shadow-lg z-20">
                            <a href="AddMedicalHistory.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">Add Medical History</a>
                            <a href="ShowMedicalHistory.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">View Medical History</a>
                            <a href="ShowMedicalTest.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">Medical Tests</a>
                            <a href="MedicalMenu.jsp" class="block px-4 py-2 text-gray-700 hover:bg-pink-50 hover:text-pink-600">Medical Menu</a>
                        </div>
                    </div>
                    
                    <!-- Search -->
                    <a href="DSearch.jsp" class="text-gray-600 hover:text-pink-600 nav-transition">Search</a>
                    
                    <!-- Main Menu -->
                    <a href="Menu.jsp" class="text-gray-600 hover:text-pink-600 nav-transition">Main Menu</a>
                </div>
                
                <!-- Mobile menu button -->
                <div class="md:hidden">
                    <button id="mobile-menu-button" class="text-gray-600 hover:text-pink-600 focus:outline-none">
                        <i class="fas fa-bars text-xl"></i>
                    </button>
                </div>
            </div>
            
            <!-- Mobile menu (hidden by default) -->
            <div id="mobile-menu" class="hidden md:hidden pb-4">
                <a href="index.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Home</a>
                
                <div class="pl-2">
                    <button class="patient-menu-toggle flex items-center justify-between w-full py-2 text-gray-600 hover:text-pink-600">
                        Patients <i class="fas fa-chevron-down ml-1 text-xs"></i>
                    </button>
                    <div class="patient-menu hidden pl-4">
                        <a href="AddPatient.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Add Patient</a>
                        <a href="ShowPatientById.jsp" class="block py-2 text-gray-600 hover:text-pink-600">View Patient</a>
                        <a href="PatientMenu.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Patient Menu</a>
                    </div>
                </div>
                
                <div class="pl-2">
                    <button class="doctor-menu-toggle flex items-center justify-between w-full py-2 text-gray-600 hover:text-pink-600">
                        Doctors <i class="fas fa-chevron-down ml-1 text-xs"></i>
                    </button>
                    <div class="doctor-menu hidden pl-4">
                        <a href="AddDoctor.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Add Doctor</a>
                        <a href="ShowDoctor.jsp" class="block py-2 text-gray-600 hover:text-pink-600">View Doctors</a>
                        <a href="DShowBycategory.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Doctors by Category</a>
                        <a href="ShowPatientByDoc.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Patients by Doctor</a>
                    </div>
                </div>
                
                <div class="pl-2">
                    <button class="medical-menu-toggle flex items-center justify-between w-full py-2 text-gray-600 hover:text-pink-600">
                        Medical <i class="fas fa-chevron-down ml-1 text-xs"></i>
                    </button>
                    <div class="medical-menu hidden pl-4">
                        <a href="AddMedicalHistory.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Add Medical History</a>
                        <a href="ShowMedicalHistory.jsp" class="block py-2 text-gray-600 hover:text-pink-600">View Medical History</a>
                        <a href="ShowMedicalTest.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Medical Tests</a>
                        <a href="MedicalMenu.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Medical Menu</a>
                    </div>
                </div>
                
                <a href="DSearch.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Search</a>
                <a href="Menu.jsp" class="block py-2 text-gray-600 hover:text-pink-600">Main Menu</a>
            </div>
        </div>
    </nav>

    <script>
        // Toggle mobile menu
        document.getElementById('mobile-menu-button').addEventListener('click', function() {
            document.getElementById('mobile-menu').classList.toggle('hidden');
        });
        
        // Toggle patient menu in mobile
        document.querySelector('.patient-menu-toggle').addEventListener('click', function() {
            document.querySelector('.patient-menu').classList.toggle('hidden');
        });
        
        // Toggle doctor menu in mobile
        document.querySelector('.doctor-menu-toggle').addEventListener('click', function() {
            document.querySelector('.doctor-menu').classList.toggle('hidden');
        });
        
        // Toggle medical menu in mobile
        document.querySelector('.medical-menu-toggle').addEventListener('click', function() {
            document.querySelector('.medical-menu').classList.toggle('hidden');
        });
    </script>
</body>
</html>