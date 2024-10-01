<%@page import="ModelClass.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Home</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
        }

        .header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            text-align: center;
        }

        .header h1 {
            margin-bottom: 10px;
        }

        .nav {
            background-color: #333;
            overflow: hidden;
        }

        .nav a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }

        .nav a:hover {
            background-color: #ddd;
            color: black;
        }

        .container {
            max-width: 1000px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .section {
            margin-bottom: 30px;
        }

        .section h2 {
            font-size: 1.5rem;
            color: #4CAF50;
            margin-bottom: 15px;
        }

        .leave-balance, .leave-status {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        .leave-balance p, .leave-status p {
            font-size: 1.2rem;
        }

        .apply-leave-form {
            display: flex;
            flex-direction: column;
        }

        .apply-leave-form input[type="date"],
        .apply-leave-form select,
        .apply-leave-form textarea {
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            width: 100%;
        }

        .apply-leave-form button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1.1rem;
            cursor: pointer;
        }

        .apply-leave-form button:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
<%
    EmployeeModel employeeData = (EmployeeModel) request.getAttribute("employeeData");
%>
    <!-- Header Section -->
    <div class="header">
        <h1>Employee Dashboard</h1>
        <p>Welcome, <%= employeeData.getEmployeeName() %></p>
    </div>

    <!-- Navigation Bar -->
    <div class="nav">
        <a href="employeeHome.jsp">Home</a>
        <a href="allLeaveApplications.jsp">All Leave Applications</a>
        <a href="profile.jsp">Profile</a>
        <a href="logout.jsp">Logout</a>
    </div>

    <!-- Main Container -->
    <div class="container">

        <!-- Section for Leave Balance -->
        <div class="section">
            <h2>Leave Balance</h2>
            <div class="leave-balance">
                <p>Total Leave Balance: <%= employeeData.getEmployeeLeaveBalance() %></p>
            </div>
        </div>

        <!-- Section to Apply for Leave -->
        <div class="section">
            <h2>Apply for Leave</h2>
            <form class="apply-leave-form" action="applyLeave.jsp" method="post">
                <label for="leaveType">Leave Type:</label>
                <select id="leaveType" name="leaveType" required>
                    <option value="Sick Leave">Sick Leave</option>
                    <option value="Casual Leave">Casual Leave</option>
                    <option value="Earned Leave">Earned Leave</option>
                </select>

                <label for="fromDate">From Date:</label>
                <input type="date" id="fromDate" name="fromDate" required>

                <label for="toDate">To Date:</label>
                <input type="date" id="toDate" name="toDate" required>

                <label for="reason">Reason:</label>
                <textarea id="reason" name="reason" rows="4" required></textarea>

                <button type="submit">Submit Leave Application</button>
            </form>
        </div>

        <!-- Section for Leave Status -->
        <div class="section">
            <h2>Leave Status</h2>
            <div class="leave-status">
                <p>Pending Leave Requests: 2</p>
                <p>Approved Leaves: 5</p>
            </div>
        </div>

    </div>

</body>
</html>
