<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/tin-tuc/them-moi/luu" var="addNewsAction"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${addNewsAction}" method="post" modelAttribute="news"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.addProvince"/></h4>
                    </div>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.title"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <c:set var="msgprovinceName"><form:errors path="title"/></c:set>
                                <div class="form-group label-floating is-empty ">
                                    <label class="control-label"></label>
                                    <div class="test" id="roleNameBorder">
                                        <form:input path="title" id="roleName"
                                                    cssClass="form-control ${not empty msgprovinceName?'errors':''}"/>
                                    </div>
                                    <span class="material-input" style="color: red"> <form:errors path="title"
                                                                                                  cssClass="error"/></span>
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
                                        <form:errors path="description" cssClass="error"/>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button type="submit" class="btn btn-primary btn-block">
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

    window.onload = function () {
        var roleNameMsg = '${msgroleName}';
        if (!checkNullOrEmpty(roleNameMsg)) {
            document.getElementById('roleNameBorder').classList.add('errors');
        }
    };
</script>