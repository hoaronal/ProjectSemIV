<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/tin-tuc/cap-nhat/luu" var="editNewsAction"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js" />"></script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${editNewsAction}" method="post" modelAttribute="news"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.editNews"/></h4>
                    </div>
                    <form:hidden path="id"/>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.title"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty ">
                                    <label class="control-label"></label>
                                    <div class="test" id="roleNameBorder">
                                        <form:input path="title" id="title"
                                                    cssClass="form-control"/>
                                    </div>
                                    <span class="material-input title" style="color: red"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">

                            <label class="col-sm-2 label-on-left">Nội dung</label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:textarea path="description" id="edit" cssClass="form-control"/>
                                    <span class="material-input" style="color: red">
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button onclick="editNew()" class="btn btn-primary btn-block">
                                        <spring:message code="label.updatebtn"/>
                                    </button>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-default btn-block">
                                        <spring:message code="label.cancel"/>
                                    </button>
                                </div>
                                <div class="col-md-3">
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function editNew() {
        $("#myform").validate({
            rules: {
                title: {
                    required: true,
                    minlength: 100
                }
            },
            messages: {
                title: {
                    required: "Tiêu đề không được để trống!",
                    minlength: "Tiêu đề phải dài ít nhất 5 kí tự!"
                }
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    }
    window.onload = function () {
        var roleNameMsg = '${msgroleName}';
        if (!checkNullOrEmpty(roleNameMsg)) {
            document.getElementById('roleNameBorder').classList.add('errors');
        }
    };
</script>