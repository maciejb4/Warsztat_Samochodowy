<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/customer_save" method="post">

    <table>
        <tr>
            <td> Imię:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td> Nazwisko:</td>
            <td><input type="text" name="surname"></td>
        </tr>
        <tr>
            <td> Data urodzenia:</td>
            <td><input type="date" name="birthdate"></td>
        </tr>
        <tr>
            <td> Numer telefonu:</td>
            <td><input type="text" name="customer_phone"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Zapisz"></td>
        </tr>
    </table>

