<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List - Spring Boot JSP</title>

<style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
            color: #333;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }
        h1 {
            color: #2c3e50;
            border-bottom: 3px solid #3498db;
            padding-bottom: 15px;
            margin-bottom: 30px;
        }
        .header-info {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px;
            border-radius: 8px;
            margin-bottom: 30px;
        }
        .employee-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .employee-table th {
            background-color: #34495e;
            color: white;
            padding: 15px;
            text-align: left;
            font-weight: 600;
        }
        .employee-table td {
            padding: 12px 15px;
            border-bottom: 1px solid #ddd;
        }
        .employee-table tr:nth-child(even) {
            background-color: #f8f9fa;
        }
        .employee-table tr:hover {
            background-color: #e8f4f8;
            transform: translateY(-1px);
            transition: all 0.2s ease;
        }
        .department-badge {
            padding: 4px 12px;
            border-radius: 20px;
            font-size: 0.85em;
            font-weight: 600;
        }
        .engineering { background-color: #e8f5e8; color: #27ae60; }
        .marketing { background-color: #fff3cd; color: #856404; }
        .sales { background-color: #d1ecf1; color: #0c5460; }
        .hr { background-color: #f8d7da; color: #721c24; }
        .finance { background-color: #e2e3e5; color: #383d41; }
        .stats {
            display: flex;
            justify-content: space-around;
            margin: 20px 0;
            flex-wrap: wrap;
        }
        .stat-card {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            text-align: center;
            min-width: 150px;
            margin: 10px;
        }
        .stat-number {
            font-size: 2em;
            font-weight: bold;
            color: #3498db;
        }
        .navigation {
            margin: 30px 0;
            text-align: center;
        }
        .btn {
            display: inline-block;
            padding: 12px 24px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin: 0 10px;
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #2980b9;
        }
        .email {
            color: #3498db;
            text-decoration: none;
        }
        .email:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
        <h1>🏢 Employee Directory</h1>
        
        <div class="header-info">
            <h2>Welcome to Company Employee Management System</h2>
            <p>Total Employees: <strong>${totalEmployees}</strong> | 
               Current Date: <strong>${currentDate}</strong></p>
        </div>

        <div class="stats">
            <div class="stat-card">
                <div class="stat-number">${totalEmployees}</div>
                <div>Total Employees</div>
            </div>
            <div class="stat-card">
                <div class="stat-number">
                    <fmt:formatNumber value="${employees.stream().filter(e -> e.department == 'Engineering').count()}" pattern="0"/>
                </div>
                <div>Engineering</div>
            </div>
            <div class="stat-card">
                <div class="stat-number">
                    <fmt:formatNumber value="${employees.stream().filter(e -> e.department == 'Sales').count()}" pattern="0"/>
                </div>
                <div>Sales Team</div>
            </div>
        </div>

        <table class="employee-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Hire Date</th>
                    <th>Contact</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>#${employee.id}</td>
                        <td><strong>${employee.fullName}</strong></td>
                        <td>${employee.position}</td>
                        <td>
                            <span class="department-badge ${employee.department.toLowerCase()}">
                                ${employee.department}
                            </span>
                        </td>
                        <td><strong>${employee.formattedSalary}</strong></td>
                        <td>${employee.formattedHireDate}</td>
                        <td>
                            <a href="mailto:${employee.email}" class="email">
                                📧 ${employee.email}
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="navigation">
            <a href="/hello" class="btn">← Back to Hello Page</a>
            <a href="/employees" class="btn">🔄 Refresh Employee List</a>
        </div>

        <div style="margin-top: 30px; padding: 20px; background-color: #f8f9fa; border-radius: 8px;">
            <h3>📊 Department Summary</h3>
            <p>This table displays all employees across different departments with their complete details. 
               Use the navigation buttons to explore other sections of the application.</p>
        </div>
    </div>
</body>
</html>