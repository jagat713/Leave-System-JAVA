<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Leave Management System</title>
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
            text-align: center;
            padding: 20px 0;
        }

        .header h1 {
            font-size: 3rem;
        }

        .hero {
            background: url('leave-management.jpg') no-repeat center center/cover;
            height: 70vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: black;
            text-align: center;
            flex-direction: column;
        }

        .hero h2 {
            font-size: 2.5rem;
            margin-bottom: 10px;
        }

        .hero p {
            font-size: 1.5rem;
            max-width: 700px;
        }

        .login-btn {
            margin-top: 20px;
        }

        .login-btn button {
            font-size: 1.2rem;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        .login-btn button:hover {
            background-color: #45a049;
        }

        .features {
            padding: 50px 20px;
            background-color: white;
            display: flex;
            justify-content: space-around;
            text-align: center;
            flex-wrap: wrap; /* This will ensure it wraps on smaller screens */
        }

        .features div {
            width: 30%;
            margin-bottom: 20px;
        }

        .features h3 {
            font-size: 1.8rem;
            color: #4CAF50;
        }

        .features p {
            font-size: 1rem;
            margin-top: 10px;
        }

        .footer {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 10px 0;
        }

        /* Responsive styles */
        @media screen and (max-width: 768px) {
            .hero {
                height: 50vh;
            }

            .hero h2 {
                font-size: 2rem;
            }

            .hero p {
                font-size: 1.2rem;
            }

            .header h1 {
                font-size: 2.5rem;
            }

            .features div {
                width: 45%; /* Make feature boxes take up more space on smaller screens */
            }

            .login-btn button {
                padding: 8px 16px;
                font-size: 1rem;
            }
        }

        @media screen and (max-width: 480px) {
            .hero {
                height: 40vh;
            }

            .hero h2 {
                font-size: 1.8rem;
            }

            .hero p {
                font-size: 1rem;
            }

            .header h1 {
                font-size: 2rem;
            }

            .features div {
                width: 100%; /* Feature boxes take full width on mobile screens */
            }

            .login-btn button {
                padding: 6px 12px;
                font-size: 0.9rem;
            }
        }
    </style>
</head>
<body>

    <header class="header">
        <h1>Leave Management System</h1>
    </header>

    <section class="hero">
        <h2>Efficient Leave Management for Your Organization</h2>
        <p>Manage employee leaves, approvals, and records seamlessly with our intuitive Leave Management System.</p>
        <div class="login-btn">
            <button onclick="window.location.href='login.jsp'">Login</button>
        </div>
    </section>

    <section class="features">
        <div>
            <h3>Easy to Use</h3>
            <p>Simplified workflows for leave requests, tracking, and approvals.</p>
        </div>
        <div>
            <h3>User-Friendly Interface</h3>
            <p>A clean, user-friendly interface that simplifies the leave management process.</p>
        </div>
    </section>

    <footer class="footer">
        <p>Leave Management System &copy; 2024</p>
    </footer>
</body>
</html>

