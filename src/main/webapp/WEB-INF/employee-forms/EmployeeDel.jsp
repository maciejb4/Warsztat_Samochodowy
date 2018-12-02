<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/employee_delete" method="POST">

    <label>
        Czy na pewno chcesz usunac pracownika o id:
        <input type="number" name="id" value="${id}" readonly>
    </label>
    <label>
        <input type="submit" value="Usuń">
    </label>


</form>