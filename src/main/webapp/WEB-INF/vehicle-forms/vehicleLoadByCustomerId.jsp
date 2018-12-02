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
                    <%--<th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"--%>
                        <%--aria-label="CSS grade: activate to sort column ascending">--%>
                        <%--Id klienta--%>
                    <%--</th>--%>

                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="vehicleDList" items="${vehicleDList}">
                    <tr>
                        <td>${vehicleDList.id}</td>
                        <td>${vehicleDList.brand}</td>
                        <td>${vehicleDList.model}</td>
                        <td>${vehicleDList.production_year}</td>
                        <td>${vehicleDList.plate_number}</td>
                        <td>${vehicleDList.next_service_date}</td>
                        <%--<td>${vehicleDList.customer_id}</td>--%>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>