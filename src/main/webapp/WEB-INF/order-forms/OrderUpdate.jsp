<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="order_update" method="POST">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="number" name="id" value="${id}" readonly></td>
        </tr>
        <tr>
            <td>Data przyjęcia:</td>
            <td><input type="date" name="date_in" value="${date_in}"></td>
        </tr>
        <tr>
            <td>Data zakończenia:</td>
            <td><input type="date" name="date_out" value="${date_out}"></td>
        </tr>
        <tr>
            <td> Data rozpoczęcia:</td>
            <td><input type="date" name="started_date" value="${started_date}"></td>
        </tr>
        <tr>
            <td> Id pracownika:</td>
            <td><input type="number" name="employee_id" value="${employee_id}">
            </td>
        </tr>
        <tr>
            <td> Uszkodzenia:</td>
            <td><input type="text" name="issue_note" value="${issue_note}"></td>
        </tr>
        <tr>
            <td> Naprawa:</td>
            <td><input type="text" name="repair_note" value="${repair_note}"></td>
        </tr>
        <tr>
            <td> Status:</td>
            <td><input type="number" name="status_id" value="${status_id}"></td>
        </tr>
        <tr>
            <td> Id samochodu:</td>
            <td><input type="number" name="vehicle_id" value="${vehicle_id}"></td>
        </tr>
        <tr>
            <td> Koszt naprawy:</td>
            <td><input type="number" name="repair_cost" value="${repair_cost}"></td>
        </tr>
        <tr>
            <td> Koszty części:</td>
            <td><input type="number" name="parts_cost" value="${parts_cost}"></td>
        </tr>
        <tr>
            <td> Roboczogodziny:</td>
            <td><input type="numbers" name="man_hours" value="${man_hours}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Zapisz"></td>
        </tr>
    </table>
</form>