<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/danh-muc/xoa" var="deleteCategoryAction"/>
<spring:url value="/quan-tri/danh-muc/cap-nhat" var="editCategoryAction"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header card-header-icon" data-background-color="purple">
                    <i class="material-icons">group</i>
                </div>
                <div class="card-content">
                    <h4 class="card-title"><spring:message code="label.listproduct"/></h4>
                    <a style="float: right" href="<%=request.getContextPath()%>/quan-tri/danh-muc/them-moi"
                       class="btn btn-primary"><spring:message code="label.addbtn"/></a>
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
                                            aria-label="Name: activate to sort column descending"><spring:message
                                                code="label.namecategory"/>
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="datatables" rowspan="1"
                                            colspan="1" aria-label="Position: activate to sort column ascending">
                                            <spring:message code="label.description"/>
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
                                            <td class="categoryName" id="categoryName<c:out value="${item.id}"/>">
                                                <c:out value="${item.name_category}"/></td>
                                            <td><c:out value="${item.description}"/></td>

                                            <td class="text-right">
                                                <a href="" class="btn btn-simple btn-info btn-icon like"><i
                                                        class="material-icons">favorite</i></a>
                                                <a href="${editCategoryAction}/${item.id}"
                                                   class="btn btn-simple btn-warning btn-icon edit"><i
                                                        class="material-icons">edit</i></a>
                                                <a class="btn btn-simple btn-danger btn-icon remove"
                                                   data-toggle="modal" data-target="#smallAlertModal${item.id}"><i
                                                        class="material-icons">close</i></a>
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

                                                        <h4 style="line-height: 40px"><i class="material-icons"
                                                                                         style="color: orange;">warning</i>Xóa
                                                            danh mục!</h4>
                                                    </div>
                                                    <div class="modal-body text-center">
                                                        <h5>Bạn có muốn xóa danh mục có mã là ${item.id}? </h5>
                                                    </div>
                                                    <div class="modal-footer text-center">
                                                        <a class="btn btn-default" data-dismiss="modal"
                                                           style="margin: 0px !important;">Hủy</a>
                                                        <a href="${deleteCategoryAction}/${item.id}"
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
                            <div class="col-sm-5">
                                <div class="dataTables_info" id="datatables_info" role="status" aria-live="polite">
                                    Hiển thị <span style="color: red">${(listItem.currentPage-1)*10}</span> đến <span
                                        style="color: red">${(listItem.currentPage-1)*10 + listItem.numRecordInPage}</span>
                                    của <span style="color: red">${listItem.totalRecord}</span> bản ghi
                                </div>
                            </div>
                            <div class="col-sm-7">
                                <div class="dataTables_paginate paging_full_numbers" id="datatables_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button first " id="datatables_first">
                                            <a href="<%=request.getContextPath()%>/quan-tri/san-pham/${listItem.firstPage}">Trang
                                                đầu</a>
                                        </li>
                                        <li class="paginate_button previous" id="datatables_previous">
                                            <a href="<%=request.getContextPath()%>/quan-tri"
                                               aria-controls="datatables" data-dt-idx="1" tabindex="0">Quay lại</a>
                                        </li>
                                        <c:forEach var="page" items="${listItem.pages}">
                                            <li class="paginate_button ${listItem.currentPage == page?"active":""}">
                                                <a href="<%=request.getContextPath()%>/quan-tri/san-pham/<c:out value="${page}"/>?keySearch<c:out value="${keySearch}"/>"
                                                   data-dt-idx="2" tabindex="0">${page}</a>
                                            </li>
                                        </c:forEach>
                                        <li class="paginate_button next" id="datatables_next"><a
                                                href=""
                                                aria-controls="datatables" data-dt-idx="6" tabindex="0">Tiếp
                                            theo</a>
                                        </li>
                                        <li class="paginate_button last" id="datatables_last">
                                            <a href="<%=request.getContextPath()%>/quan-tri/san-pham/${listItem.lastPage}">Trang
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
<script type="text/javascript">
    window.onload = function() {
        document.getElementById("componentsExamples").classList.add('in');
        document.getElementById("listCategoryClass").classList.add('active');
    };
</script>