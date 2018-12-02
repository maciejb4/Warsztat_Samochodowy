<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/employee_save" method="POST">

    <table>
        <tr>
            <td> Imię:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td> Nazwisko:</td>
            <td><input type="text" name="lastname"></td>
        </tr>
        <tr>
            <td> Adres:</td>
            <td><input type="text" name="adress"></td>
        </tr>
        <tr>
            <td> Numer telefonu:</td>
            <td><input type="text" name="employee_phone"></td>
        </tr>
        <tr>
            <td> Notatka:</td>
            <td><input type="text" name="note"></td>
        </tr>
        <tr>
            <td> Koszty roboczogodziny:</td>
            <td><input type="number" name="hourly"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Zapisz"></td>
        </tr>
    </table>


</form>