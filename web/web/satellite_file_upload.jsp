<%--
  Created by IntelliJ IDEA.
  User: afjcjsbx
  Date: 28/03/17
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Upload</title>
</head>
<body>

<%
    //Controllo che l'utente abbia effettuato il login
    if (session.getAttribute("currentSessionUser") == null) {
        response.sendRedirect("index.jsp"); //error page
    }
%>


<div class="login-page">
    <div class="form">
        <h1>File Upload</h1>
        <form method="post" action="uploadservlet"
              enctype="multipart/form-data">
            Select file to upload:

            <input type="file" name="file" size="60" /><br />
            <br/>

            <button type="submit">Upload</button>
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



