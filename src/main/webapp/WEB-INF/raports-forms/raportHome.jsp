<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
    <div class="row">
        <div class="col-sm-12">
            <table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline"
                   id="dataTables-example" role="grid" aria-describedby="dataTables-example_info" style="width: 100%;">
                <thead>
                <tr role="row">
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Rendering engine: activate to sort column ascending" >
                        Raport 1
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1"
                        aria-label="Browser: activate to sort column ascending">
                        Raport 2
                    </th>

                </tr>
                </thead>
                <tbody>

                <tr>
                    <td>Ilość przepracowanych roboczogodzin</td>
                    <td>Zysk z działalności</td>
                </tr>
                <tr>
                    <td>
                        <a href="/raport_1_form">
                            <button type="button" class="btn btn-raport">SZCZEGÓŁY</button>
                        </a>
                    </td>
                    <td>
                        <a href="/raport_2_form">
                            <button type="button" class="btn btn-raport">SZCZEGÓŁY</button>
                        </a>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>




