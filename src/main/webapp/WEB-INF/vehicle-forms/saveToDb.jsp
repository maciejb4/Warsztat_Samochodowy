<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="/vehicle_save" method="POST">

    <table>
        <tr>
            <td> Marka:</td>
            <td><input type="text" name="brand" required></td>
        </tr>
        <tr>
            <td> Model:</td>
            <td><input type="text" name="model" required></td>
        </tr>
        <tr>
            <td> Rok produkcji:</td>
            <td><input type="number" name="production_date"></td>
        </tr>
        <tr>
            <td> Nr rejestracyjny:</td>
            <td><input type="text" name="plate_number" required></td>
        </tr>
        <tr>
            <td> Data kolejnego przeglądu:</td>
            <td><input type="date" name="next_service_date"></td>
        </tr>
        <tr>
            <td> Id klienta:</td>
            <td><input type="number" name="customer_id"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Zapisz"></td>
        </tr>
    </table>

</form>
