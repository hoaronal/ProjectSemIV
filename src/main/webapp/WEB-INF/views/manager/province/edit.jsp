<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/tinh-thanh/cap-nhat/luu" var="editProvinceAction"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${editProvinceAction}" method="post" modelAttribute="province"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.editProvince"/></h4>
                    </div>
                    <form:hidden path="id" cssClass="form-control"/>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.Provincename"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <c:set var="msgprovinceName"><form:errors path="provinceName"/></c:set>
                                <div class="form-group label-floating is-empty ">
                                    <label class="control-label"></label>
                                    <div class="test" id="provinceNameBorder">
                                        <form:input path="provinceName" id="provinceName" cssClass="form-control ${not empty msgprovinceName?'errors':''}"/>
                                    </div>
                                    <span class="material-input" style="color: red"> <form:errors path="provinceName"
                                                                                                  cssClass="error"/></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">

                            <label class="col-sm-2 label-on-left"><spring:message code="label.code"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="code" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"> <form:errors path="code"
                                                                                                  cssClass="error"/></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">

                            <label class="col-sm-2 label-on-left"><spring:message code="label.description"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
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