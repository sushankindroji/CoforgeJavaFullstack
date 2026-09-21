<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hibernate Web Application</title>
    <link rel="stylesheet" href="styles/index.css">
</head>
<body>
   
    <jsp:include page="header.jsp" />

    <nav>
        <div class="container">
            <a href="register.html">Register Student</a>
            <a href="StudentList.jsp">View Students</a> 
            <a href="login.jsp">Login</a>
        </div>
    </nav>

    <main>
        <div class="container sections">
            <section>
                <h2>Mapping Techniques</h2>
                <hr>
                <a href="skills.html">Collection Mapping</a>
                <a href="#">Component Mapping</a>
                <a href="#">Inheritance Mapping</a>
                <a href="#">Association Mapping</a>
            </section>

			<section>
                <h2>Hibernate using &#x0950; Annotation Configuration</h2>
                <hr>
                <a href="#">Add Employee</a>
                <a href="#">View Employees</a>
            </section>
            
            <section>
                <h2>Query Options</h2>
                <hr>
                <a href="#">HQL</a>
                <a href="#">Criteria API</a>
                <a href="#">DML</a>
            </section>

            
        </div>
    </main>

    <footer>
        <div class="container">
            &copy; 2026 Hibernate Web Application | All Rights Reserved
        </div>
    </footer>
</body>
</html>
