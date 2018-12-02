<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="order_save" method="POST">

    <table>
        <tr>
            <td> Data przyjęcia:</td>
            <td><input type="date" name="date_in"></td>
        </tr>
        <tr>
            <td> Data zakończenia:</td>
            <td><input type="date" name="date_out"></td>
        </tr>
        <tr>
            <td> Data rozpoczęcia:</td>
            <td><input type="date" name="started_date"></td>
        </tr>
        <tr>
            <td> Employee_id:</td>
            <td><input type="number" name="employee_id"></td>
        </tr>
        <tr>
            <td> Uszkodzenia:</td>
            <td><input type="text" name="issue_note"></td>
        </tr>
        <tr>
            <td> Naprawa:</td>
            <td><input type="text" name="repair_note"></td>
        </tr>
        <tr>
            <td> Status</td>
            <td><input type="number" name="status_id"></td>
        </tr>
        <tr>
            <td> Id samochodu:</td>
            <td><input type="number" name="vehicle_id"></td>
        </tr>
        <tr>
            <td> Koszt naprawy:</td>
            <td><input type="number" name="repair_cost"></td>
        </tr>
        <tr>
            <td> Koszty części:</td>
            <td><input type="number" name="parts_cost"></td>
        </tr>
        <tr>
            <td> Roboczogodziny:</td>
            <td><input type="numbers" name="man_hours"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Zapisz"></td>
        </tr>
    </table>

</form>


