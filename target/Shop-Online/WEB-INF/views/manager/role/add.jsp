<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/quyen/them-moi/luu" var="addRoleAction"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${addRoleAction}" method="post" modelAttribute="role"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.addRole"/></h4>
                    </div>
                    <form:hidden path="id" cssClass="form-control"/>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.Rolename"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <c:set var="msgroleName"><form:errors path="roleName"/></c:set>
                                <div class="form-group label-floating is-empty ">
                                    <label class="control-label"></label>
                                    <div class="test" id="roleNameBorder">
                                        <form:input path="roleName" id="roleName" cssClass="form-control ${not empty msgroleName?'errors':''}"/>
                                    </div>
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

    window.onload = function() {
        var roleNameMsg='${msgroleName}';
        if(!checkNullOrEmpty(roleNameMsg)){
            document.getElementById('roleNameBorder').classList.add('errors');
        }
    };
</script>