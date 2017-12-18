<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/quan-tri-vien/them-moi/luu" var="addAdminAction"/>

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
                                    <span class="material-input" style="color: red"> <form:errors path="account"
                                                                                                  cssClass="error"/></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">

                            <label class="col-sm-2 label-on-left"><spring:message code="label.password"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty ${not empty msgPassword?'errors':''}">
                                    <c:set var="msgPassword"><form:errors path="password"/></c:set>
                                    <label class="control-label"></label>
                                    <form:password path="password"
                                                   cssClass="form-control ${not empty msgPassword?'errors':''}"/>
                                    <span class="material-input" style="color: red"><form:errors path="password"
                                                                                                 cssClass="error"/></span>
                                </div>
                            </div>
                            <label class="col-sm-2 label-on-left"><spring:message code="label.repassword"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <input type="password" name="rePassword" class="form-control">
                                    <span class="material-input" style="color: red"></span></div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.email"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="email" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"><form:errors path="email"
                                                                                                 cssClass="error"/></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.address"/></label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="address" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"><form:errors path="address"
                                                                                                 cssClass="error"/></span>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.birthday"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="birthday" cssClass="form-control datepicker"/>
                                    <span class="material-input" style="color: red"><form:errors path="birthday"
                                                                                                 cssClass="error"/></span>
                                </div>
                            </div>
                            <label class="col-sm-2 label-on-left"><spring:message code="label.phone"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="phone" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"><form:errors path="phone"
                                                                                                 cssClass="error"/></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.status"/></label>
                            <div class="col-sm-10">
                                <div class="radio">
                                    <label>
                                        <form:radiobutton path="status" value="1"/><spring:message code="label.statusok"/>Kích hoạt
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <form:radiobutton path="status" value="0"/><spring:message code="label.statusnone"/>Không kích hoạt
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button type="submit" class="btn btn-primary btn-block" >
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