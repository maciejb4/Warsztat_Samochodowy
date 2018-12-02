<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <form action="/employee_update" method="POST">
        <tr>
            <td> aktualizacja pracownika o id:</td>
            <td><input type="number" name="id" value="${id}" readonly></td>
        </tr>
        <tr>
            <td> Imię:</td>
            <td><input type="text" name="name" value="${name}"></td>
        </tr>
        <tr>
            <td> Nazwisko:</td>
            <td><input type="text" name="lastname" value="${lastname}"></td>
        </tr>
        <tr>
            <td> Adres:</td>
            <td><input type="text" name="adress" value="${adress}"></td>
        </tr>
        <tr>
            <td> Numer telefonu:</td>
            <td><input type="text" name="employee_phone" value="${employee_phone}"></td>
        </tr>
        <tr>
            <td> Notatka:</td>
            <td><input type="text" name="note" value="${note}"></td>
        </tr>
        <tr>
            <td> Koszty roboczogodziny:</td>
            <td><input type="number" name="hourly" value="${hourly}">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Zapisz"></td>
        </tr>

    </form>
</table>


