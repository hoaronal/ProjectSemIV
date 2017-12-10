<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/nguoi-dung/cap-nhat/luu" var="editUserAction"/>
<spring:message code="label.account" var="account"/>
<spring:message code="label.password" var="password"/>
<spring:message code="label.repassword" var="repassword"/>
<spring:message code="label.email" var="email"/>
<spring:message code="label.address" var="address"/>
<spring:message code="label.birthday" var="birthday"/>
<spring:message code="label.phone" var="phone"/>
<spring:message code="label.sex" var="sex"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${editUserAction}" method="post" modelAttribute="user"
                           cssClass="form-horizontal">
                    <form:hidden path="id"/>
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.updateAdmin"/></h4>
                    </div>
                    <div class="card-content">
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${account}</label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="username" cssClass="form-control" placeholder="${account}"/>
                                    <span class="help-block">A block of help text that breaks onto a new line.</span>
                                    <span class="material-input" style="color: red">
                                        <form:errors path="username" cssClass="error"/>
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
                                        <form:errors path="password" cssClass="error"/>
                                    </span>
                                </div>
                            </div>
                            <label class="col-sm-2 label-on-left">${repassword}</label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <input class="form-control" placeholder="${repassword}"/>
                                    <%--<form:input path="password" cssClass="form-control" placeholder="${repassword}"/>--%>
                                    <span class="material-input" style="color: red">
                                        <form:errors path="password" cssClass="error"/>
                                    </span></div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${email}</label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="email" cssClass="form-control" placeholder="${email}"/>
                                    <span class="material-input" style="color: red">
                                        <form:errors path="email" cssClass="error"/>
                                    </span></div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${address}</label>
                            <div class="col-sm-10">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="address" cssClass="form-control" placeholder="${address}"/>
                                    <span class="material-input" style="color: red">
                                        <form:errors path="address" cssClass="error"/>
                                    </span></div>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-sm-2 label-on-left">${birthday}</label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="birthday" cssClass="form-control datepicker" placeholder="${birthday}"/>
                                    <span class="material-input" style="color: red">
                                        <form:errors path="birthday" cssClass="error"/>
                                    </span></div>
                            </div>
                            <label class="col-sm-2 label-on-left">${phone}</label>
                            <div class="col-sm-4">
                                <div class="form-group label-floating is-empty">
                                    <label class="control-label"></label>
                                    <form:input path="phone" cssClass="form-control" placeholder="${phone}"/>
                                    <span class="material-input" style="color: red">
                                        <form:errors path="phone" cssClass="error"/>
                                    </span></div>
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
                            <label class="col-sm-2 label-on-left"></label>
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-fill btn-rose" value="Cập nhật"><spring:message code="label.updatebtn"/><div class="ripple-container"></div></button>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>