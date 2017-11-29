<%@ page import="com.afjcjsbx.mrg.model.User" %>
<%@ page import="com.afjcjsbx.mrg.control.LoginController" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: afjcjsbx
  Date: 28/03/17
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="registrationBean" scope="session"
             class="com.afjcjsbx.mrg.model.RegistrationBean"/>

<jsp:setProperty name="registrationBean" property="*"/>


<%
    //Controllo che l'utente abbia effettuato il login
    if (session.getAttribute("currentSessionUser") == null) {
        response.sendRedirect("index.jsp"); //error page
    }
%>


<%
    if (request.getParameter("submit_registration") != null) {

        if (registrationBean.validate()) {

            boolean valid = false;
            try {
                valid = LoginController.registerUser(registrationBean.getUsername(), registrationBean.getEmail(), registrationBean.getPassword(), registrationBean.getName(), registrationBean.getSurname());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Compio il carrello della sessione precedente
            if (valid) {
                response.sendRedirect("panel.jsp"); //logged-in page

            } else {
                response.sendRedirect("error.jsp"); //error page
            }


        }
    }
%>


<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Add User</title>
</head>
<body>


<div class="login-page">
    <div class="form">
        <form class="login-form">
            <input type="text" name="username" placeholder="Username" required/>
            <input type="text" name="email" placeholder="Email address" required/>
            <input type="password" placeholder="Password" name="password" required/>
            <input type="password" placeholder="Confirm password" name="confirm_password" required/>
            <input type="text" name="name" placeholder="Name" required/>
            <input type="text" name="surname" placeholder="Surname" required/>

            <br><br>
            <button type="submit" name="submit_registration" >Register user</button>
            <br><br>

        </form>

        <form class="login-form" action="panel.jsp">
            <button type="submit" >Go back</button>
        </form>

    </div>
</div>


<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'>
</script>

<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'>
</script>


</body>
</html>