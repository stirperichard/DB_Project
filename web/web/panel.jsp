<%@ page import="com.afjcjsbx.mrg.model.User" %>
<%@ page import="com.afjcjsbx.mrg.util.Roles" %><%--
  Created by IntelliJ IDEA.
  User: afjcjsbx
  Date: 28/03/17
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Panel</title>
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


<div class="panel-page">
    <div class="form">

        <table style="width:100%" cellspacing="20">

            <p class="message"><a href="/logout">Logout</a></p>

            <% if ((user != null ? user.getType() : null) == Roles.ADMINISTRATOR) { %>
            <tr>
                <th width="50%">
                    <form action="add_user.jsp">
                        <button>Add User</button>
                    </form>
                </th>
                <th width="50%">
                    <form action="satellite_file_upload.jsp">
                        <button>Import satellite's file</button>
                    </form>

                </th>
            </tr>
            <tr>
                <th width="50%">
                    <form action="insert_tool.jsp">
                        <button>Enter tool data</button>
                    </form>
                </th>
                <th width="50%">
                    <form action="insert_satellite.jsp">
                        <button>Enter satellite's data</button>
                    </form>

                </th>
            </tr>

            <% } %>

            <tr>
                <th width="50%">
                    <form action="search_object_in_map.jsp">
                        <button>Search object in map</button>
                    </form>
                </th>
                <th width="50%">
                    <form action="search_clump.jsp">
                        <button>Search clump</button>
                    </form>

                </th>
            </tr>


            <tr>
                <th width="50%">
                    <form action="search_clump_by_density.jsp">
                        <button>Search clumps by density</button>
                    </form>

                </th>

                <th width="50%">
                    <form action="view_massa_clumps.jsp">
                        <button>Via Clumps mass</button>
                    </form>
                </th>

            </tr>


            <tr>
                <th width="50%">
                    <form action="search_object_in_region.jsp">
                        <button>Search object in a region</button>
                    </form>
                </th>
                <th width="50%">
                    <form action="view_statistics.jsp">
                        <button>View Statistics</button>
                    </form>

                </th>
            </tr>



        </table>


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
