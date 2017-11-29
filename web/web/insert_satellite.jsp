<%@ page import="com.afjcjsbx.mrg.model.User" %>
<%@ page import="com.afjcjsbx.mrg.control.LoginController" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.afjcjsbx.mrg.control.SatelliteDAO" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: afjcjsbx
  Date: 28/03/17
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="satelliteBean" scope="session"
             class="com.afjcjsbx.mrg.model.SatelliteBean"/>

<jsp:setProperty name="satelliteBean" property="*"/>


<%
    //Controllo che l'utente abbia effettuato il login
    if (session.getAttribute("currentSessionUser") == null) {
        response.sendRedirect("index.jsp"); //error page
    }
%>


<%
    if (request.getParameter("submit_satellite") != null) {

        if (satelliteBean.validate()) {

            boolean valid = false;
            try {
                valid = SatelliteDAO.insert_satellite(satelliteBean.getNome(), satelliteBean.getOperativo_da(), satelliteBean.getAgenzia(), satelliteBean.getFine_operazione());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Compio il carrello della sessione precedente
            if (valid) {
                response.sendRedirect("/message.jsp?msg=Satellite succesfull inserted"); //error page

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
            <input type="text" name="nome" placeholder="Nome" required/>
            <input type="text" name="operativo_da" placeholder="Operativo da" required/>

            <div class="styled-select">

            <select name="agenzia">
                <%
                    ArrayList<String> agenzie = SatelliteDAO.retrieveAgenzie();
                    for(int i = 0; i < agenzie.size(); i++){
                    %>
                <option name="agenzia"><%= agenzie.get(i) %></option>
                    <%
                        }
                    %>
            </select>
            </div>

            <input type="text" name="fine_operazione" placeholder="Fine operazione" required/>

            <br><br>
            <button type="submit" name="submit_satellite" >Insert satellite</button>

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