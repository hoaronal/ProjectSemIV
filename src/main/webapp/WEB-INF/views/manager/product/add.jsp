<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/san-pham/them-moi/luu" var="addProductAction"/>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/croppie.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/croppie.css" />">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${addProductAction}" method="post" modelAttribute="product"
                           enctype="multipart/form-data"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.addproductName"/></h4>
                    </div>
                    <form:hidden path="id" cssClass="form-control"/>
                    <div class="card-content">

                        <div class="col-md-7">
                            <div class="row">
                                <label class="col-sm-4 label-on-left"><spring:message code="label.productName"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-8">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="productName" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"> <form:errors path="productName"
                                                                                                      cssClass="error"/></span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-4 label-on-left"><spring:message code="label.category"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-8">
                                    <div class="btn-group bootstrap-select show-tick">
                                        <select class="selectpicker" name="categoryId"
                                                data-style="select-with-transition"
                                                title="<spring:message code="label.chooseCategory"/>" tabindex="-98">
                                            <option disabled="disabled"><spring:message
                                                    code="label.chooseCategory"/></option>
                                            <c:forEach var="category" items="${listCategory}">
                                                <option value="${category.id}">${category.name_category}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-4 label-on-left"><spring:message code="label.Giftname"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-8">
                                    <div class="btn-group bootstrap-select show-tick">
                                        <select class="selectpicker" multiple="multiple" name="giftId"
                                                data-style="select-with-transition" tabindex="-98">
                                            <option disabled="disabled"> chọn quà tặng</option>
                                            <c:forEach var="gift" items="${listGift}">
                                                <option value="${gift.id}">${gift.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-4 label-on-left"><spring:message code="label.price"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-8">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="price" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"><form:errors path="price"
                                                                                                     cssClass="error"/></span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-4 label-on-left"><spring:message code="label.discount"/></label>
                                <div class="col-sm-8">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="discount" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"><form:errors path="discount"
                                                                                                     cssClass="error"/></span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-4 label-on-left"><spring:message code="label.detail"/></label>
                                <div class="col-sm-8">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:textarea path="detail" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"> <form:errors path="detail"
                                                                                                      cssClass="error"/></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div id="upload-demo" style="width:350px">
                                <label for="upload" >
                                    <img style="width: 30px;height: 30px" src="<%=request.getContextPath()%>/resources/img/camera.png"/>
                                </label>
                            </div>
                            <input type="hidden" name="image" id="imageUpload"/>
                            <br/>

                            <input type="file" name="upload" id="upload" style="display: none">
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button type="submit" class="btn btn-primary btn-block upload-result">
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
    $uploadCrop = $('#upload-demo').croppie({
        enableExif: true,
        viewport: {
            width: 200,
            height: 200
        },
        boundary: {
            width: 300,
            height: 300
        }
    });

    $('#upload').on('change', function () {
        var reader = new FileReader();
        reader.onload = function (e) {
            $uploadCrop.croppie('bind', {
                url: e.target.result
            }).then(function () {
                console.log('jQuery bind complete');
            });

        }
        reader.readAsDataURL(this.files[0]);
    });

    $('.upload-result').on('click', function (ev) {
        $uploadCrop.croppie('result', {
            type: 'canvas',
            size: 'viewport'
        }).then(function (resp) {
            $('#imageUpload').val(resp);
            $('#myform').submit();
            /*$.ajax({
                url: "san-pham/them-moi/luu",
                type: "POST",
                data: {"image":resp},
                success: function (data) {
                    alert();
                    html = '<img src="' + resp + '" />';
                    $("#upload-demo-i").html(html);
                }
            });*/
        });
    });

</script>