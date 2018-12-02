<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="order_delete" method="POST">

    <label>
        Czy jesteś pewien, że chcesz usunąć samochód o id:
        <input type="text" name="id" value="${id}" readonly>
    </label>
    <label>
        <input type="submit" value="Usuń">
    </label>

</form>
