<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/quan-tri-vien/them-moi/luu" var="addAdminAction"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js" />"></script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${addAdminAction}" method="post" modelAttribute="admin"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.addadmin"/></h4>
                    </div>
                    <form:hidden path="id" cssClass="form-control"/>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.account"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="account" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"> </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.password"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty ">
                                    <label class="control-label"></label>
                                    <form:password path="password"
                                                   cssClass="form-control"/>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                            <label class="col-sm-2 label-on-left"><spring:message code="label.repassword"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <input type="password" name="confirm_password" class="form-control">
                                    <span class="material-input" style="color: red"></span></div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.Rolename"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="btn-group bootstrap-select show-tick">
                                    <select class="selectpicker" name="roleadmin" multiple
                                            data-style="select-with-transition"
                                            title="<spring:message code="label.chooseRole"/>" tabindex="-98">
                                        <option disabled="disabled"><spring:message code="label.chooseRole"/></option>
                                        <option value="3">MANAGER</option>
                                        <option value="1">ADMIN</option>
                                        <option value="2">USER</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.email"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="email" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.address"/></label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="address" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.birthday"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="birthday" cssClass="form-control datepicker"/>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                            <label class="col-sm-2 label-on-left"><spring:message code="label.phone"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="phone" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.status"/></label>
                            <div class="col-sm-10">
                                <div class="radio">
                                    <label>
                                        <form:radiobutton path="status" value="1"/><spring:message
                                            code="label.statusok"/>Kích hoạt
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <form:radiobutton path="status" value="0"/><spring:message
                                            code="label.statusnone"/>Không kích hoạt
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button onclick="add()" class="btn btn-primary btn-block">
                                        <spring:message code="label.addbtn"/>
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
    function add() {
        $('.error').css("color", "red");
        $("#myform").validate({
            rules: {
                account: {
                    required: true,
                    minlength: 2
                },
                password: {
                    required: true,
                    minlength: 8
                },
                confirm_password: {
                    required: true,
                    minlength: 8,
                    equalTo: "#password"
                },
                roleadmin:{
                    required: true
                },
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
                account: {
                    required: "Tài khoản không được để trống!",
                    minlength: "Tài khoản phải dài ít nhất 5 kí tự!"
                },
                password: {
                    required: "Mật khẩu không được để trống!",
                    minlength: "Mật khẩu phải dài tối thiểu 8 kí tự!"
                },
                confirm_password: {
                    required: "Mật khẩu nhập lại không được để trống!",
                    minlength: "Bạn phải nhập mật khẩu ít nhất 8 kí tự!",
                    equalTo: "Mật khẩu nhập lại không khớp với mật khẩu!"
                },
                roleadmin:{
                    required: "Quyền không được để trống!",
                },
                email: "Email bạn nhập không hợp lệ!"
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    }
</script>