<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--TODO czy można to jakoś umieścić w filtrze--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="col-lg-12">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>WARSZTAT</title>


    <a href="/" ><h3>WARSZTAT</h3></a>
</head>

<body>

<jsp:include page="header.jsp"/>


<jsp:include page="${link}"/>


<jsp:include page="footer.jsp"/>
</body>
</div>

</html>

