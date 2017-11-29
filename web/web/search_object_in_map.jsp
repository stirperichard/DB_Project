<%@ page import="com.afjcjsbx.mrg.model.User" %>
<%@ page import="com.afjcjsbx.mrg.util.Roles" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.afjcjsbx.mrg.control.MappaStellareDAO" %>
<%@ page import="com.afjcjsbx.mrg.model.Sorgente" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: afjcjsbx
  Date: 28/03/17
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="objectMapBean" scope="session"
             class="com.afjcjsbx.mrg.model.ObjectMapBean"/>

<jsp:setProperty name="objectMapBean" property="*"/>


<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Search object in map</title>

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>


</head>
<body>


<%
    User user = null;
    //Controllo che l'utente abbia effettuato il login
    if (session.getAttribute("currentSessionUser") == null) {
        response.sendRedirect("index.jsp"); //error page
    } else {
        user = (User) session.getAttribute("currentSessionUser");
    }
%>


<%
    ArrayList<Sorgente> oggettiInMappa = null;

    if (request.getParameter("submit_search") != null) {

        if (objectMapBean.validate()) {

            try {
                oggettiInMappa = MappaStellareDAO.retrieveOggettiInMappa(objectMapBean.getMappa(), objectMapBean.getBanda());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>


<div class="panel-page">
    <div class="form">
        <form class="login-form">


        <div class="styled-select">

            <select name="mappa">
                <%
                    ArrayList<String> mappeStellari = MappaStellareDAO.retrieveMappeStellari();
                    for (int i = 0; i < mappeStellari.size(); i++) {
                %>
                <option name="mappa"><%= mappeStellari.get(i) %>
                </option>
                <%
                    }
                %>
            </select>

            <select name="banda">
                <option name="banda">70</option>
                <option name="banda">160</option>
                <option name="banda">250</option>
                <option name="banda">350</option>
                <option name="banda">500</option>
            </select>


        </div>
        <br>
        <button type="submit" name="submit_search" >Search</button>
        <br><br><br>
        </form>


        <table>
            <tr>
                <th>Id</th>
                <th>Lat</th>
                <th>Lng</th>
                <th>Type</th>
                <th>Lum</th>
                <th>Clump</th>
                <th>Sorgente</th>
                <th>Banda_r</th>
                <th>Banda_l</th>
            </tr>

                <%

                    if (oggettiInMappa != null) {
                        for (Sorgente anOggettiInMappa : oggettiInMappa) {
                %>
            <tr>
                <td><%= anOggettiInMappa.getId() %>
                </td>
                <td><%= anOggettiInMappa.getLat() %>
                </td>
                <td><%= anOggettiInMappa.getLng() %>
                </td>
                <td><%= anOggettiInMappa.getType() %>
                </td>
                <td><%= anOggettiInMappa.getLum() %>
                </td>
                <td><%= anOggettiInMappa.getClump() %>
                </td>
                <td><%= anOggettiInMappa.getSorgente() %>
                </td>
                <td><%= anOggettiInMappa.getBanda_r() %>
                </td>
                <td><%= anOggettiInMappa.getBanda_l() %>
                </td>
            </tr>

                <%
                        }
                    }
                %>


        </table>

        <br><br>


        <form class="login-form" action="panel.jsp">
            <button type="submit">Go back</button>
        </form>


    </div>
</div>
<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script>
<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script>$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});
//# sourceURL=pen.js
</script>


</body>
</html>
