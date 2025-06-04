<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <title>Patient Details</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    
    <style>
        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }
        
        .gradient-bg {
            background: linear-gradient(-45deg, #e0f7fa, #a7ffeb, #b2ebf2, #e0f2f1);
            background-size: 400% 400%;
            animation: gradientBG 15s ease infinite;
        }
        
        .fade-in-up {
            animation: fadeInUp 0.8s ease-out forwards;
        }
        
        @keyframes fadeInUp {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        
        .glass-card {
            backdrop-filter: blur(12px);
            -webkit-backdrop-filter: blur(12px);
        }
    </style>
</head>
<body class="gradient-bg min-h-screen pt-20 pb-10 px-4">
    <!-- Include Navigation -->
    <jsp:include page="Nav.jsp" />

    <div class="max-w-4xl mx-auto">
        <div class="glass-card bg-white/20 rounded-2xl shadow-2xl p-8 mb-10 fade-in-up">
            <h2 class="text-3xl font-bold text-center text-teal-800 mb-6">
                <i class="fas fa-search mr-2"></i>Search Patient by ID
            </h2>
            
            <h:form styleClass="space-y-6">
                <div class="space-y-2">
                    <h:outputLabel for="patientId" value="Enter Patient ID:" styleClass="block text-teal-700 font-medium"/>
                    <h:inputText id="patientId" value="#{hospitalController.patientId}" 
                                styleClass="w-full px-4 py-2 rounded-lg border border-teal-300 focus:ring-2 focus:ring-teal-500 focus:border-teal-500 transition"/>
                </div>
                
                <h:commandButton value="Search" action="#{hospitalController.showPatient}" 
                                styleClass="w-full bg-gradient-to-r from-teal-500 to-teal-600 hover:from-teal-600 hover:to-teal-700 text-white font-bold py-3 px-4 rounded-lg shadow-md hover:shadow-lg transition-all duration-300 transform hover:scale-101"/>
                
                <h:messages globalOnly="true" styleClass="text-red-500 font-bold text-center"/>
                
                <!-- Patient Details Section -->
                <h:panelGrid columns="2" rendered="#{not empty hospitalController.patient.patientId}" 
                            styleClass="w-full bg-white/30 rounded-xl p-6 mt-6 backdrop-blur-sm">
                    <div class="font-semibold text-teal-700 p-2">Patient ID:</div>
                    <div class="p-2 text-gray-700">#{hospitalController.patient.patientId}</div>
                    
                    <div class="font-semibold text-teal-700 p-2">Patient Name:</div>
                    <div class="p-2 text-gray-700">#{hospitalController.patient.patientName}</div>
                    
                    <div class="font-semibold text-teal-700 p-2">Doctor ID:</div>
                    <div class="p-2 text-gray-700">#{hospitalController.patient.doctor.doctorId}</div>
                    
                    <div class="font-semibold text-teal-700 p-2">Date of Birth:</div>
                    <div class="p-2 text-gray-700">#{hospitalController.patient.DOB}</div>
                </h:panelGrid>
            </h:form>
        </div>
    </div>

    <script>
        tailwind.config = {
            theme: {
                extend: {
                    fontFamily: {
                        sans: ['Poppins', 'sans-serif']
                    },
                    transitionProperty: {
                        'spacing': 'margin, padding',
                        'transform': 'transform',
                    }
                }
            }
        }
    </script>
</body>
</html>
</f:view>