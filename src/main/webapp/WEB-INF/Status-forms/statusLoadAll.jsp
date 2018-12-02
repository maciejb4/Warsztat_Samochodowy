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
                        aria-label="Browser: activate to sort column ascending">
                        Id
                    </th>
                    <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Platform(s): activate to sort column descending" aria-sort="ascending">
                        Status
                    </th>

                </tr>
                </thead>
                <tbody>

                <c:forEach var="status" items="${Lista}">
                    <tr>
                        <td>${status.id}</td>
                        <td>${status.status}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="2">
                        <a href="/status_save">
                            <button type="button" class="btn btn-raport">DODAJ STATUS</button>
                        </a>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>