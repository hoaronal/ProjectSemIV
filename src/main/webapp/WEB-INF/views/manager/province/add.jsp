<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/tinh-thanh/them-moi/luu" var="addProvinceAction"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js" />"></script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${addProvinceAction}" method="post" modelAttribute="province"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.addProvince"/></h4>
                    </div>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left"><spring:message code="label.Provincename"/><span
                                    style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <c:set var="msgprovinceName"><form:errors path="provinceName"/></c:set>
                                <div class="form-group label-floating is-empty ">
                                    <label class="control-label"></label>
                                    <div class="test" id="roleNameBorder">
                                        <form:input path="provinceName" id="roleName" cssClass="form-control"/>
                                    </div>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">

                            <label class="col-sm-2 label-on-left"><spring:message code="label.code"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="code" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"> </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">

                            <label class="col-sm-2 label-on-left"><spring:message code="label.description"/></label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="description" cssClass="form-control"/>
                                    <span class="material-input" style="color: red"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button onclick="addProvince()" class="btn btn-primary btn-block" >
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
    function addProvince() {
        $("#myform").validate({
            rules: {
                provinceName: {
                    required: true
                },
                code: {
                    required: true
                }
            },
            messages: {
                provinceName: {
                    required: "Tên tỉnh không được để trống!",
                },
                code: {
                    required: "Mã tỉnh không được để trống!"
                }
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    }
    window.onload = function() {
        var roleNameMsg='${msgroleName}';
        if(!checkNullOrEmpty(roleNameMsg)){
            document.getElementById('roleNameBorder').classList.add('errors');
        }
    };
</script>