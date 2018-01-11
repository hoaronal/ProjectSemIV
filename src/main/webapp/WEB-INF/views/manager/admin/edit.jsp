<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/quan-tri-vien/cap-nhat/luu" var="editAdminAction"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js" />"></script>
<spring:message code="label.account" var="account"/>
<spring:message code="label.password" var="password"/>
<spring:message code="label.repassword" var="repassword"/>
<spring:message code="label.email" var="email"/>
<spring:message code="label.address" var="address"/>
<spring:message code="label.birthday" var="birthday"/>
<spring:message code="label.phone" var="phone"/>
<spring:message code="label.sex" var="sex"/>
<spring:message code="label.status" var="status"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${editAdminAction}" method="post" modelAttribute="admin"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.updateAdmin"/></h4>
                    </div>
                    <form:hidden path="id"/>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${account}</label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="account" cssClass="form-control" placeholder="${account}"/>
                                    <span class="help-block">A block of help text that breaks onto a new line.</span>
                                    <span class="material-input" style="color: red">
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${password}</label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:password path="password" cssClass="form-control" placeholder="${password}"/>
                                    <span class="material-input" style="color: red">
                                    </span>
                                </div>
                            </div>
                            <label class="col-sm-2 label-on-left">${repassword}</label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <input class="form-control" name="confirm_password" id="confirm_password" placeholder="${repassword}"/>
                                    <span class="material-input" style="color: red"> </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${email}</label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="email" cssClass="form-control" placeholder="${email}"/>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${address}</label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="address" cssClass="form-control" placeholder="${address}"/>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${birthday}</label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="birthday" cssClass="form-control datepicker" placeholder="${birthday}"/>
                                    <span class="material-input" style="color: red"> </span>
                                </div>
                            </div>
                            <label class="col-sm-2 label-on-left">${phone}</label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="phone" cssClass="form-control" placeholder="${phone}"/>
                                    <span class="material-input" style="color: red"> </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${sex}</label>
                            <div class="col-sm-10 checkbox-radios">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" checked="true"><span
                                            class="circle"></span><span class="check"></span> <spring:message
                                            code="label.male"/>
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios"><span class="circle"></span><span
                                            class="check"></span> <spring:message code="label.female"/>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${status}</label>
                            <div class="col-sm-10 checkbox-radios">
                                <div class="radio">
                                    <label>
                                        <form:radiobutton path="status"/><span
                                            class="circle"></span><span class="check"></span> <spring:message
                                            code="label.statusok"/>
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <form:radiobutton path="status"/><span class="circle"></span><span
                                            class="check"></span> <spring:message code="label.statusnone"/>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button onclick="edit()" class="btn btn-primary btn-block">
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
    function edit() {
        $("#myform").validate({
            rules: {
                account: {
                    required: true,
                    minlength: 5
                },
                password: {
                    minlength: 8
                },
                confirm_password: {
                    minlength: 8
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
                    minlength: "Mật khẩu phải dài tối thiểu 8 kí tự!"
                },
                confirm_password: {
                    minlength: "Bạn phải nhập mật khẩu ít nhất 8 kí tự!"
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