<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
    <div class="row">
        <div class="col-sm-12">
            <table width="100%"
                   class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline"
                   id="dataTables-example" role="grid" aria-describedby="dataTables-example_info"
                   style="width: 100%;">
                <thead>
                <tr role="row">
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Rendering engine: activate to sort column ascending">
                        Id
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Data przyjęcia
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Przewidywana data zakończenia
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Rozpoczęcie naprawy
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Id pracownika
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Opis problemu
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Opis naprawy
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Status
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Id pojazdu
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Koszty naprawy
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Koszty części
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="CSS grade: activate to sort column ascending">
                        Roboczo godziny
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

                <c:forEach var="lista" items="${lista}">
                    <tr>
                        <td>${lista.id}</td>
                        <td>${lista.date_in}</td>
                        <td>${lista.date_out}</td>
                        <td>${lista.started_date}</td>
                        <td>${lista.employee_id}</td>
                        <td>${lista.issue_note}</td>
                        <td>${lista.repair_note}</td>
                        <td>
                            <c:choose>
                                <c:when test="${lista.status_id==1}">
                                    Przyjęty
                                </c:when>
                                <c:when test="${lista.status_id==2}">
                                    Zatwierdzone koszty naprawy
                                </c:when>
                                <c:when test="${lista.status_id==3}">
                                    W naprawie
                                </c:when>
                                <c:when test="${lista.status_id==4}">
                                    Gotowy do odbioru
                                </c:when>
                                <c:when test="${lista.status_id==5}">
                                    Rezygnacja
                                </c:when>
                                <c:otherwise>
                                    Inne
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${lista.vehicle_id}</td>
                        <td>${lista.repair_cost}</td>
                        <td>${lista.parts_cost}</td>
                        <td>${lista.man_hours}</td>

                        <td>
                            <a href=order_update?id=${lista.id}&date_in=${lista.date_in}&date_out=${lista.date_out}&started_date=${lista.started_date}&employee_id=${lista.employee_id}&issue_note=${lista.issue_note}&repair_note=${lista.repair_note}&status_id=${lista.status_id}&vehicle_id=${lista.vehicle_id}&repair_cost=${lista.repair_cost}&parts_cost=${lista.parts_cost}&man_hours=${lista.man_hours}>
                                <button type="button" class="btn btn-order">EDYTUJ</button>
                            </a>
                        </td>
                        <td>
                            <a href=order_delete?id=${lista.id}>
                                <button type="button" class="btn btn-order">USUŃ</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="14">
                        <a href="/order_save">
                            <button type="button" class="btn btn-order">DODAJ ZLECENIE</button>
                        </a>
                    </td>

                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
