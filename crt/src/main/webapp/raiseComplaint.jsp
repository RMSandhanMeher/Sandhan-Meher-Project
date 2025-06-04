<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Raise an Issue</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body >
	    <jsp:include page="Nav.jsp"/>
<div class="bg-gray-100 font-sans text-center py-20">


    <h2 class="text-3xl font-bold text-gray-800 mb-10">Raise a New Issue</h2>

    <form action="addComplaint.jsp" method="post"
          class="bg-white p-10 rounded-lg shadow-lg max-w-md mx-auto">
        
        <input type="text" name="complaintType" placeholder="Type of Issue" required
               class="w-full px-4 py-2 mb-5 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-green-500"/>

        <textarea name="cDescription" rows="5" placeholder="Describe the issue in detail" required
                  class="w-full px-4 py-2 mb-5 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-green-500"></textarea>

        <select name="severity" required
                class="w-full px-4 py-2 mb-6 border border-gray-300 rounded-md bg-white focus:outline-none focus:ring-2 focus:ring-green-500">
            <option value="">-- Select Severity Level --</option>
            <option value="Low">Low</option>
            <option value="Medium">Medium</option>
            <option value="High">High</option>
        </select>

        <button type="submit"
                class="w-full bg-green-600 hover:bg-green-700 text-white font-semibold py-3 rounded-md transition duration-300">
            Submit Issue
        </button>
    </form>
</div>
</body>
</html>
