<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/don-hang/xoa" var="deleteOrderAction"/>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/quan-tri/don-hang/cap-nhat" var="editOrderAction"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header card-header-icon" data-background-color="purple">
                    <i class="material-icons">group</i>
                </div>
                <div class="card-content">
                    <h4 class="card-title"><spring:message code="label.listOrder"/></h4>
                    <a style="float: right" href="<%=request.getContextPath()%>/quan-tri/don-hang/them-moi"
                       class="btn btn-primary"><spring:message code="label.addbtn"/></a>
                    <div class="toolbar">
                        <%--<c:if test="${msg != null}">
                            <div class="alert alert-${style}" id="success-${style}" style="text-align: center">
                                <b>${msg}</b>
                            </div>
                        </c:if>--%>
                    </div>
                    <div class="material-datatables">
                        <div id="datatables_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_length" id="datatables_length">
                                        <label class="form-group"><spring:message code="label.show"/> <select
                                                name="datatables_length"
                                                aria-controls="datatables"
                                                class="form-control input-sm">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="-1"><spring:message code="label.all"/></option>
                                        </select> <spring:message code="label.entry"/></label>
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
                                                aria-label="Name: activate to sort column descending"><spring:message
                                                    code="label.id"/>
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1" aria-sort="ascending"
                                                aria-label="Name: activate to sort column descending">Số lượng sản phẩm
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1" aria-label="Position: activate to sort column ascending">
                                                Số tiền
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                                colspan="1" aria-label="Position: activate to sort column ascending">
                                                Trạng thái giao hàng
                                            </th>
                                            <th class="disabled-sorting text-right sorting" tabindex="0"
                                                aria-controls="datatables" rowspan="1" colspan="1"
                                                aria-label="Actions: activate to sort column ascending"><spring:message
                                                    code="label.action"/>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${listItem.item}">
                                            <tr role="row" class="odd" id="rowRecord">
                                                <td tabindex="0" class="sorting_1"><c:out value="${item.id}"/></td>
                                                <td class="Ordername" id="Ordername<c:out value="${item.id}"/>"><c:out
                                                        value="${item.qty}"/></td>
                                                <td><fmt:formatNumber value = "${item.amount}" currencySymbol="" type ="currency"/></td>
                                                <td>
                                                    <c:if test="${item.status == 1}">
                                                        Đã giao hàng
                                                    </c:if>
                                                    <c:if test="${item.status == 0}">
                                                       Chưa giao hàng
                                                    </c:if>
                                                </td>

                                                <td class="text-right">
                                                    <a href="" class="btn btn-simple btn-info btn-icon like"><i
                                                            class="material-icons">favorite</i></a>
                                                    <%--<a href="${editOrderAction}/${item.id}"
                                                       class="btn btn-simple btn-warning btn-icon edit"><i
                                                            class="material-icons">edit</i></a>
                                                    <a class="btn btn-simple btn-danger btn-icon remove"
                                                       data-toggle="modal" data-target="#smallAlertModal${item.id}"><i
                                                            class="material-icons">close</i></a>--%>
                                                </td>
                                            </tr>
                                            <div class="modal fade" style="margin-top: 50px"
                                                 id="smallAlertModal${item.id}" tabindex="-1" role="dialog"
                                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog modal-small ">
                                                    <div class="modal-content">

                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal"
                                                                    aria-label="Close"><span
                                                                    aria-hidden="true">&times;</span></button>
                                                            <h4 class="modal-title" id="myModalLabel" s><i
                                                                    class="material-icons"
                                                                    style="color: orange">warning</i> Xóa đơn hàng!
                                                            </h4>
                                                        </div>
                                                        <div class="modal-body text-center">
                                                            <h5>Bạn có muốn xóa đơn hàng có mã là ${item.id}? </h5>
                                                        </div>
                                                        <div class="modal-footer text-center">
                                                            <a class="btn btn-default" data-dismiss="modal"
                                                               style="margin: 0px !important;">Hủy</a>
                                                            <a href="<%=request.getContextPath()%>${deleteOrderAction}/${item.id}"
                                                               class="btn btn-primary" style="margin: 0px !important;">
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
                                <div class="col-sm-3">
                                    <div class="dataTables_info" id="datatables_info" role="status" aria-live="polite">
                                        Hiển thị <span style="color: red">${(listItem.currentPage-1)*10}</span> đến <span style="color: red">${(listItem.currentPage-1)*10 + listItem.numRecordInPage}</span>
                                        của <span style="color: red">${listItem.totalRecord}</span> bản ghi
                                    </div>
                                </div>
                                <div class="col-sm-9">
                                    <div class="dataTables_paginate paging_full_numbers" id="datatables_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button first " id="datatables_first">
                                                <a href="<%=request.getContextPath()%>/quan-tri/don-hang/danh-sach-don-hang/${listItem.firstPage}">Trang
                                                    đầu</a>
                                            </li>
                                            <li class="paginate_button previous" id="datatables_previous">
                                                <a href="<%=request.getContextPath()%>/quan-tri/don-hang/danh-sach-don-hang/<c:out value="${page - 1}"/>?keySearch=<c:out value="${keySearch}"/>">Quay lại</a>
                                            </li>
                                            <c:forEach var="page" items="${listItem.pages}">
                                                <li class="paginate_button ${listItem.currentPage == page?"active":""}">
                                                    <a href="<%=request.getContextPath()%>/quan-tri/don-hang/danh-sach-don-hang/<c:out value="${page}"/>?keySearch=<c:out value="${keySearch}"/>"
                                                       data-dt-idx="2" tabindex="0">${page}</a>
                                                </li>
                                            </c:forEach>

                                            <li class="paginate_button next" id="datatables_next"><a
                                                    href="<%=request.getContextPath()%>/quan-tri/don-hang/danh-sach-don-hang/<c:out value="${page + 1}"/>?keySearch=<c:out value="${keySearch}"/>"
                                                    aria-controls="datatables" data-dt-idx="6" tabindex="0">Tiếp
                                                theo</a>
                                            </li>
                                            <li class="paginate_button last" id="datatables_last">
                                                <a href="<%=request.getContextPath()%>/quan-tri/don-hang/danh-sach-don-hang/${listItem.lastPage}">Trang
                                                    cuối</a>
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
<script type="text/javascript">
    window.onload = function() {
        document.getElementById("componentsExamples").classList.add('in');
        document.getElementById("listOrderClass").classList.add('active');
    };
</script>