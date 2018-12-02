<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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

                </tr>
                </thead>
                <tbody>

                <c:forEach var="lis" items="${listadanychnazwiska}">

                    <tr>
                        <td>${lis.id}</td>
                        <td>${lis.name}</td>
                        <td>${lis.surname}</td>
                        <td>${lis.birthDate}</td>
                        <td>${lis.customer_phone}</td>

                    </tr>

                </c:forEach>


                </tbody>
            </table>
        </div>
    </div>
</div>

