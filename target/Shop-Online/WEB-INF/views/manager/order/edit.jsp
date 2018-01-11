<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/quyen/cap-nhat/luu" var="editRoleAction"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${editRoleAction}" method="post" modelAttribute="role"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.editRole"/></h4>
                    </div>
                    <form:hidden path="id" cssClass="form-control"/>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.Rolename"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="roleName" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"> <form:errors path="roleName"
                                                                                                  cssClass="error"/></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">

                            <label class="col-sm-2 label-on-left"><spring:message code="label.description"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty ${not empty msgPassword?'errors':''}">
                                    <label class="control-label"></label>
                                    <form:input path="description" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"> <form:errors path="description"
                                                                                                  cssClass="error"/></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button type="submit" class="btn btn-primary btn-block" >
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