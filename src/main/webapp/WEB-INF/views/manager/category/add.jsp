<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/danh-muc/them-moi/luu" var="addCategoryAction"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${addCategoryAction}" method="post" modelAttribute="category"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.addcategory"/></h4>
                    </div>
                    <form:hidden path="id" cssClass="form-control"/>
                    <div class="card-content">
                        <div class="col-md-9">
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.namecategory"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="name_category" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"> </span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.category"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-10">
                                    <div class="btn-group bootstrap-select show-tick">
                                        <select class="selectpicker" name="categoryId" data-style="select-with-transition"
                                                title="<spring:message code="label.chooseCategory"/>" tabindex="-98">
                                            <option disabled="disabled"> <spring:message code="label.chooseCategory"/></option>
                                            <c:forEach var="category" items="${listCategory}">
                                                <option value="${category.id}">${category.name_category}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.description"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:textarea path="description" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"></span>
                                    </div>
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
                name_category: {
                    required: true
                },
                description: {
                    maxlength: 500
                }
            },
            messages: {
                name_category: {
                    required: "Tên danh mục không được để trống!",
                },
                description:{
                    maxlength:"Nội dung có độ dài tối đa 500 kí tự!",
                }
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    }
</script>