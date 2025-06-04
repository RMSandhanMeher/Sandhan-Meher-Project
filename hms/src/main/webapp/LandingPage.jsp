<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Portal</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    
    <style>
        @keyframes float {
            0% { transform: translateY(0px); }
            50% { transform: translateY(-10px); }
            100% { transform: translateY(0px); }
        }
        .floating { animation: float 4s ease-in-out infinite; }
    </style>
</head>
<body class="bg-gradient-to-r from-indigo-100 via-purple-100 to-pink-100 min-h-screen">
   <jsp:include page="Nav.jsp"/>

    <main class="pt-24 pb-12 px-4 max-w-4xl mx-auto">
        <div class="bg-white/80 backdrop-blur-sm rounded-2xl shadow-lg p-8 md:p-12">
            <div class="text-center mb-12">
                <div class="floating inline-block mb-6">
                    <i class="fas fa-user-circle text-6xl text-indigo-500"></i>
                </div>
                <h1 class="text-3xl md:text-4xl font-bold text-gray-800 mb-2">Patient Dashboard</h1>
                <p class="text-gray-600">Manage your healthcare journey</p>
            </div>

            <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
                <a href="Menu.jsp" class="bg-gradient-to-br from-indigo-100 to-indigo-200 hover:from-indigo-200 hover:to-indigo-300 rounded-xl p-6 text-center shadow-md transition-all duration-300 hover:shadow-lg hover:-translate-y-1">
                    <div class="bg-indigo-500 text-white p-4 rounded-full inline-block mb-4">
                        <i class="fas fa-user-md text-2xl"></i>
                    </div>
                    <h3 class="text-xl font-semibold text-gray-800 mb-2">Doctors</h3>
                    <p class="text-gray-600">Find specialists</p>
                </a>

                <a href="PatientMenu.jsp" class="bg-gradient-to-br from-pink-100 to-pink-200 hover:from-pink-200 hover:to-pink-300 rounded-xl p-6 text-center shadow-md transition-all duration-300 hover:shadow-lg hover:-translate-y-1">
                    <div class="bg-pink-500 text-white p-4 rounded-full inline-block mb-4">
                        <i class="fas fa-user-injured text-2xl"></i>
                    </div>
                    <h3 class="text-xl font-semibold text-gray-800 mb-2">My Profile</h3>
                    <p class="text-gray-600">Personal details</p>
                </a>

                <a href="MedicalMenu.jsp" class="bg-gradient-to-br from-purple-100 to-purple-200 hover:from-purple-200 hover:to-purple-300 rounded-xl p-6 text-center shadow-md transition-all duration-300 hover:shadow-lg hover:-translate-y-1">
                    <div class="bg-purple-500 text-white p-4 rounded-full inline-block mb-4">
                        <i class="fas fa-file-medical text-2xl"></i>
                    </div>
                    <h3 class="text-xl font-semibold text-gray-800 mb-2">Records</h3>
                    <p class="text-gray-600">Medical history</p>
                </a>
            </div>
        </div>
    </main>

   
</body>
</html>