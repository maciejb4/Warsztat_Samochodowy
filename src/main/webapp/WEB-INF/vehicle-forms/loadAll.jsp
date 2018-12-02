<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
                        Marka
                    </th>
                    <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Platform(s): activate to sort column descending" aria-sort="ascending">
                        Model
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Engine version: activate to sort column ascending">
                        Rok produkcji
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Nr rejestracji
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Następny przegląd
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Id klienta
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Historia
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Edycja
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Usuwanie
                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="vehicle" items="${Lista}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.brand}</td>
                        <td>${vehicle.model}</td>
                        <td>${vehicle.production_year}</td>
                        <td>${vehicle.plate_number}</td>
                        <td>${vehicle.next_service_date}</td>
                        <td>${vehicle.customer_id}</td>
                        <td>
                            <a href="/vehicle_history?vehicle_id=${vehicle.id}">
                                <button type="button" class="btn btn-raport">Historia zleceń</button>
                            </a>
                        </td>
                        <td>
                            <a href="/vehicle_update?id=${vehicle.id}&model=${vehicle.model}&brand=${vehicle.brand}&production_year=${vehicle.production_year}&plate_number=${vehicle.plate_number}&next_service_date=${vehicle.next_service_date}&customer_id=${vehicle.customer_id}">
                                <button type="button" class="btn btn-raport">EDYTUJ</button>
                            </a>
                        </td>
                        <td>
                            <a href="/vehicle_delete?id=${vehicle.id}">
                                <button type="button" class="btn btn-raport">USUŃ</button>
                            </a>
                        </td>

                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="10">
                        <a href="/vehicle_save">
                            <button type="button" class="btn btn-raport">DODAJ SAMOCHÓD</button>
                        </a>
                    </td>

                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>