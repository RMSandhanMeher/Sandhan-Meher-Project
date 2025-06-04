<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fix Complaint - Enter Complaint ID</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body >
    <jsp:include page="Nav.jsp"/>
	<div class="bg-gray-100 font-sans flex items-center justify-center h-screen">
	
	
    <div class="bg-white p-8 rounded shadow-md w-full max-w-md">
        <h2 class="text-2xl font-semibold text-center text-blue-700 mb-6">Enter Complaint ID to Resolve</h2>

        <form action="resolveForm.jsp" method="get" class="space-y-4">
            <div>
                <label for="complaintID" class="block text-gray-700 font-medium mb-1">Complaint ID</label>
                <input type="text" id="complaintID" name="complaintID" required
                       class="w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>

            <div class="text-center">
                <button type="submit"
                        class="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700 font-semibold">
                    Next
                </button>
            </div>
        </form>
    </div>
	</div>
</body>
</html>
