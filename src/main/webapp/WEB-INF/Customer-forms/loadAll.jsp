<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form action="/customer_found" method="post">
    <label>
        Wyszukaj klienta po nazwisku:
        <input type="text" name="surname">
    </label>
    <input type="submit" class="btn btn-employee" value="Szukaj">
</form>


<div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
    <div class="row">
        <div class="col-sm-12">
            <table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline"
                   id="dataTables-example" role="grid" aria-describedby="dataTables-example_info" style="width: 100%;">
                <thead>
                <tr role="row">
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Rendering engine: activate to sort column ascending">
                        Id
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Browser: activate to sort column ascending">
                        Imię
                    </th>
                    <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Platform(s): activate to sort column descending" aria-sort="ascending">
                        Nazwisko
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Engine version: activate to sort column ascending">
                        Data urodzenia
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Numer telefonu
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Edycja
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Usuwanie
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Lista samochodów
                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="lis" items="${listadanych}">

                    <tr class="gradeU odd" role="row">
                        <td>${lis.id}</td>
                        <td>${lis.name}</td>
                        <td>${lis.surname}</td>
                        <td>${lis.birthDate}</td>
                        <td>${lis.customer_phone}</td>
                        <td>
                            <a href=CustomerUpdate?id=${lis.id}&name=${lis.name}&surname=${lis.surname}&birthDate=${lis.birthDate}&customer_phone=${lis.customer_phone}>
                                <button type="button" class="btn btn-employee">EDYTUJ</button>
                            </a></td>
                        <td><a href="/customer_delete?id=${lis.id}">
                            <button type="button" class="btn btn-employee">USUŃ</button>
                        </a></td>

                        <td><a href="/vehicle_load_by_customer_id?customer_id=${lis.id}">
                            <button type="button" class="btn btn-employee">SAMOCHODY KLIENTA</button>
                        </a></td>

                    </tr>

                </c:forEach>

                <tr>
                    <td colspan="8">
                        <a href="/customer_save">
                            <button type="button" class="btn btn-employee">DODAJ KLIENTA</button>
                        </a>
                    </td>

                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>