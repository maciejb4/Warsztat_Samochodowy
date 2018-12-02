<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="/vehicle_update" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" value="${id}" readonly></td>
        </tr>
        <tr>
            <td>Marka:</td>
            <td><input type="text" name="brand" value="${brand}"></td>
        </tr>
        <tr>
            <td>Model:</td>
            <td><input type="text" name="model" value="${model}"></td>
        </tr>
        <tr>
            <td>Rok produkcji:</td>
            <td><input type="number" name="production_date" value="${production_year}"></td>
        </tr>
        <tr>
            <td>Nr rejestracyjny:</td>
            <td><input type="text" name="plate_number" value="${plate_number}"></td>
        </tr>
        <tr>
            <td>Data kolejnego przeglądu:</td>
            <td><input type="date" name="next_service_date" value="${next_service_date}"></td>
        </tr>
        <tr>
            <td>Id klienta:</td>
            <td><input type="number" name="customer_id" value="${customer_id}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Zapisz"></td>
        </tr>
    </table>

</form>

