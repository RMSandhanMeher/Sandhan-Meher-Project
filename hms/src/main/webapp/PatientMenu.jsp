<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Actions</title>

<!-- Tailwind CSS CDN -->
<script src="https://cdn.tailwindcss.com"></script>

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
@
keyframes gradientBG { 0% {
	background-position: 0% 50%;
}

50
%
{
background-position
:
100%
50%;
}
100
%
{
background-position
:
0%
50%;
}
}
.gradient-bg {
	background: linear-gradient(-45deg, #e0f7fa, #a7ffeb, #b2ebf2, #e0f2f1);
	background-size: 400% 400%;
	animation: gradientBG 15s ease infinite;
}

.fade-in-up {
	animation: fadeInUp 0.8s ease-out forwards;
}

@
keyframes fadeInUp {from { opacity:0;
	transform: translateY(20px);
}

to {
	opacity: 1;
	transform: translateY(0);
}

}
.glass-card {
	backdrop-filter: blur(12px);
	-webkit-backdrop-filter: blur(12px);
}
</style>
</head>
<body
	class="gradient-bg min-h-screen flex items-center justify-center p-4">
	<jsp:include page="Nav.jsp" />
	<div
		class="glass-card bg-white/20 rounded-2xl shadow-2xl p-10 w-full max-w-2xl fade-in-up">
		<p
			class="text-3xl font-bold text-teal-900 mb-10 flex items-center justify-center gap-3">
			<i class="fas fa-user-injured text-teal-700"></i> Patient Management
			Portal
		</p>

		<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
			<a href="AddPatient.jsf"
				class="flex flex-col items-center justify-center gap-3 p-6 rounded-xl text-white font-medium 
                     bg-gradient-to-br from-emerald-400 to-emerald-600 shadow-lg
                     transition-all duration-300 hover:from-emerald-500 hover:to-emerald-700 
                     hover:scale-105 hover:shadow-xl transform">
				<i class="fas fa-user-plus text-3xl"></i> <span>Add Patient</span>
			</a> <a href="ShowPaitentById.jsf"
				class="flex flex-col items-center justify-center gap-3 p-6 rounded-xl text-white font-medium 
                     bg-gradient-to-br from-blue-400 to-blue-600 shadow-lg
                     transition-all duration-300 hover:from-blue-500 hover:to-blue-700 
                     hover:scale-105 hover:shadow-xl transform">
				<i class="fas fa-id-card text-3xl"></i> <span>Find by ID</span>
			</a> <a href="ShowPatientByDoc.jsf"
				class="flex flex-col items-center justify-center gap-3 p-6 rounded-xl text-white font-medium 
                     bg-gradient-to-br from-purple-400 to-purple-600 shadow-lg
                     transition-all duration-300 hover:from-purple-500 hover:to-purple-700 
                     hover:scale-105 hover:shadow-xl transform">
				<i class="fas fa-user-md text-3xl"></i> <span>By Doctor</span>
			</a>
		</div>
	</div>

	<script>
		tailwind.config = {
			theme : {
				extend : {
					fontFamily : {
						sans : [ 'Poppins', 'sans-serif' ]
					},
					transitionProperty : {
						'spacing' : 'margin, padding',
						'transform' : 'transform',
					}
				}
			}
		}
	</script>
</body>
</html>