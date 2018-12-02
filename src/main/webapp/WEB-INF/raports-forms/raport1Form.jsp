<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/raport_1_form" method="POST">

    <label>
        Podaj przedział czasowy raportu:
    </label>
    <br>
    <label>
        Data od:
        <input type="date" name="date_start">
    </label>
    <br>
    <label>
        Data do:
        <input type="date" name="date_end">
    </label>
    <br>
    <input type="submit" value="Wyślij">
</form>
