<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header card-header-icon" data-background-color="purple">
                    <i class="material-icons">group</i>
                    <%--<i class="material-icons">assignment</i>--%>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Danh sách người dùng</h4>
                    <div class="toolbar">
                        <c:if test="${msg != null}">
                            <div class="alert alert-${style}" id="success-${style}" style="text-align: center">
                                <button type="button" aria-hidden="true" class="close">
                                    <i class="material-icons">close</i>
                                </button>
                                <span><b>${msg}</b></span>
                            </div>
                        </c:if>
                    </div>
                    <div class="material-datatables">
                        <div id="datatables_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_length" id="datatables_length">
                                        <label class="form-group">Hiển thị <select name="datatables_length"
                                                                                   aria-controls="datatables"
                                                                                   class="form-control input-sm">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="-1">All</option>
                                        </select> mục</label>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div id="datatables_filter" class="dataTables_filter">
                                        <label class="form-group"><input type="search" class="form-control input-sm"
                                                                         placeholder="Tìm kiếm"
                                                                         aria-controls="datatables"></label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <table id="datatables"
                                           class="table table-striped table-no-bordered table-hover dataTable dtr-inline"
                                           cellspacing="0" width="100%" style="width: 100%;" role="grid"
                                           aria-describedby="datatables_info">
                                        <thead>
                                        <tr role="row">
                                            <th class="sorting_asc" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1" aria-sort="ascending"
                                                aria-label="Name: activate to sort column descending">Id
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1" aria-sort="ascending"
                                                aria-label="Name: activate to sort column descending">Tài khoản
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1" aria-label="Position: activate to sort column ascending">
                                                Email
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1"
                                                aria-label="Office: activate to sort column ascending">Số điện thoại
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1"
                                                aria-label="Age: activate to sort column ascending">Ngày sinh
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1"
                                                aria-label="Date: activate to sort column ascending">Địa chỉ
                                            </th>
                                            <th class="disabled-sorting text-right sorting" tabindex="0"
                                                aria-controls="datatables" rowspan="1" colspan="1"
                                                aria-label="Actions: activate to sort column ascending">Hành động
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${userList.item}">
                                            <tr role="row" class="odd">
                                                <td tabindex="0" class="sorting_1"><c:out value="${item.id}"/></td>
                                                <td><c:out value="${item.username}"/></td>
                                                <td><c:out value="${item.email}"/></td>
                                                <td><c:out value="${item.phone}"/></td>
                                                <td><c:out value="${item.birthday}"/></td>
                                                <td><c:out value="${item.address}"/></td>
                                                <td class="text-right">
                                                    <a href="" class="btn btn-simple btn-info btn-icon like"><i
                                                            class="material-icons">favorite</i></a>
                                                    <a href="" class="btn btn-simple btn-warning btn-icon edit"><i
                                                            class="material-icons">dvr</i></a>
                                                    <a class="btn btn-simple btn-danger btn-icon remove" data-toggle="modal" data-target="#smallAlertModal${item.id}"><i
                                                            class="material-icons">close</i></a>
                                                </td>
                                            </tr>
                                            <div class="modal fade" style="margin-top: 100px" id="smallAlertModal${item.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog modal-small ">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="material-icons">clear</i></button>
                                                        </div>
                                                        <div class="modal-body text-center">
                                                            <h5>Bạn có muốn xóa người dùng này? ${item.id}</h5>
                                                        </div>
                                                        <div class="modal-footer text-center">
                                                            <button type="button" class="btn btn-simple" data-dismiss="modal">Hủy bỏ</button>
                                                            <a href="<%=request.getContextPath()%>/quan-tri/nguoi-dung/xoa/${item.id}" class="btn btn-success btn-simple">
                                                                Đồng ý</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-5">
                                    <div class="dataTables_info" id="datatables_info" role="status" aria-live="polite">
                                        Hiển thị 1 đến 10 của ${userList.totalRecord}
                                    </div>
                                </div>
                                <div class="col-sm-7">
                                    <div class="dataTables_paginate paging_full_numbers" id="datatables_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button first " id="datatables_first">
                                                <a href="<%=request.getContextPath()%>/quan-tri/nguoi-dung/danh-sach-nguoi-dung/${userList.firstPage}">Trang đầu</a>
                                            </li>
                                            <li class="paginate_button previous" id="datatables_previous">
                                                <a href="<%=request.getContextPath()%>/quan-tri"
                                                   aria-controls="datatables" data-dt-idx="1" tabindex="0">Quay lại</a>
                                            </li>
                                            <c:forEach var="page" items="${userList.pages}">
                                                <li class="paginate_button ${userList.currentPage == page?"active":""}">
                                                    <a href="<%=request.getContextPath()%>/quan-tri/nguoi-dung/danh-sach-nguoi-dung/<c:out value="${page}"/>"
                                                       data-dt-idx="2" tabindex="0">${page}</a>
                                                </li>
                                            </c:forEach>

                                            <li class="paginate_button next" id="datatables_next"><a
                                                    href=""
                                                    aria-controls="datatables" data-dt-idx="6" tabindex="0">Tiếp theo</a>
                                            </li>
                                            <li class="paginate_button last" id="datatables_last">
                                                <a href="<%=request.getContextPath()%>/quan-tri/nguoi-dung/danh-sach-nguoi-dung/${userList.lastPage}">Trang cuối</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end content-->
            </div>
            <!--  end card  -->
        </div>
        <!-- end col-md-12 -->
    </div>
    <!-- end row -->
</div>
