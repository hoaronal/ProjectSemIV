<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/san-pham/cap-nhat/luu" var="updateProductAction"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${updateProductAction}" method="post" modelAttribute="product"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.updateproductName"/></h4>
                    </div>
                    <form:hidden path="id" cssClass="form-control"/>
                    <div class="card-content">
                        <div class="col-md-9">
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.productName"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="productName" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"> <form:errors path="productName"
                                                                                                      cssClass="error"/></span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left">Mã sản phẩm<span
                                        style="color: red">*</span></label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="code" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"> <form:errors path="code"
                                                                                                      cssClass="error"/></span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.category"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-10">
                                    <div class="btn-group bootstrap-select show-tick">
                                        <select style="padding-left: 5px" class="selectpicker" name="categoryId" data-style="select-with-transition"
                                                title="<spring:message code="label.chooseCategory"/>" tabindex="-98">
                                            <option disabled="disabled"> <spring:message code="label.chooseCategory"/></option>
                                            <c:forEach var="category" items="${listCategory}">
                                                <option value="${category.id}" ${category.id == product.category.id?"selected":""}>${category.name_category}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.price"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-4">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="price" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"><form:errors path="price"
                                                                                                     cssClass="error"/></span>
                                    </div>
                                </div>
                                <label class="col-sm-2 label-on-left"><spring:message code="label.discount"/></label>
                                <div class="col-sm-4">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="discount" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.detail"/></label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:textarea path="detail" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"> <form:errors path="detail"
                                                                                                      cssClass="error"/></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="col-md-3 col-sm-4">
                                <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                    <div class="fileinput-new thumbnail img-circle" style="margin-top: 10px;">
                                        <img src="<%=request.getContextPath()%>/resources/img/placeholder.jpg"
                                             alt="iphone">
                                    </div>
                                    <div class="fileinput-preview fileinput-exists thumbnail img-circle"></div>
                                    <div>
                                                    <span class="btn btn-round btn-rose btn-file">
                                                        <span class="fileinput-new"><spring:message
                                                                code="label.chooseImg"/></span>
                                                        <span class="fileinput-exists"><spring:message
                                                                code="label.changeImg"/></span>

                                                        <input type="file" name="productImg">
                                                    </span>
                                        <br>
                                        <a class="btn btn-danger btn-round fileinput-exists" data-dismiss="fileinput"><i
                                                class="fa fa-times"></i> <spring:message code="label.cancel"/></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button type="submit" class="btn btn-primary btn-block">
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