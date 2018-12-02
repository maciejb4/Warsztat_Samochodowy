<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="/vehicle_delete" method="post">

    <label>
        Czy jesteś pewien, że chcesz usunąć samochód o id:
        <input type="text" name="id" value="${id}" readonly>
    </label>
    <label>
        <input type="submit" value="Usuń">
    </label>

</form>
