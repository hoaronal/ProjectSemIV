<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/quan-tri/san-pham/them-moi/luu" var="addProductAction"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/yui-min.js" />"></script>
<script src="<c:url value="/resources/js/cropbox.js" />"></script>
<style type="text/css">
    .container
    {
        position: absolute;
        top: 10%; left: 10%; right: 0; bottom: 0;
    }
    .action
    {
        width: 300px;
        height: 30px;
        margin: 10px 0;
    }
    .cropped>img
    {
        margin-right: 10px;
    }
    .imageBox
    {
        position: relative;
        height: 350px;
        width: 300px;
        border:1px solid #aaa;
        background: #fff;
        overflow: hidden;
        background-repeat: no-repeat;
        cursor:move;
    }

    .imageBox .thumbBox
    {
        position: absolute;
        top: 42%;
        left: 50%;
        width: 200px;
        height: 250px;
        margin-top: -100px;
        margin-left: -100px;
        box-sizing: border-box;
        border: 1px solid rgb(102, 102, 102);
        box-shadow: 0 0 0 1000px rgba(0, 0, 0, 0.5);
        background: none repeat scroll 0% 0% transparent;
    }

    .imageBox .spinner
    {
        position: absolute;
        top: 0;
        left: 0;
        bottom: 0;
        right: 0;
        text-align: center;
        line-height: 400px;
        background: rgba(0,0,0,0.7);
    }
</style>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myformAdd" action="${addProductAction}" method="post" modelAttribute="product"
                           cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title"><spring:message code="label.addproductName"/></h4>
                    </div>
                    <input type="hidden" id="imgData" name="imgData"/>
                    <div class="card-content">
                        <div class="col-md-8">
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.productName"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-10">
                                    <div class="form-group label-floating is-empty">
                                        <label class="control-label"></label>
                                        <form:input path="productName" cssClass="form-control"/>
                                        <span class="material-input" style="color: red"> </span>
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
                                        <span class="material-input" style="color: red"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 label-on-left"><spring:message code="label.category"/><span
                                        style="color: red">*</span></label>
                                <div class="col-sm-10">
                                    <div class="btn-group bootstrap-select show-tick">
                                        <select style="padding-left: 5px" class="selectpicker" name="categoryId"
                                                data-style="select-with-transition"
                                                title="<spring:message code="label.chooseCategory"/>" tabindex="-98">
                                            <option disabled="disabled"><spring:message
                                                    code="label.chooseCategory"/></option>
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
                                        <span class="material-input" style="color: red"></span>
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
                                        <span class="material-input" style="color: red"> </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                                <div class="container">
                                    <div class="action">
                                        <label for="file">Chọn ảnh</label>
                                        <input type="file" name="file"  id="file" style="float:left; width: 200px;display: none">
                                        <input type="button" id="btnCrop" value="Crop" style="float: right">
                                        <input type="button" id="btnZoomIn" value="+" style="float: right">
                                        <input type="button" id="btnZoomOut" value="-" style="float: right">
                                    </div>
                                    <div class="imageBox">
                                        <div class="thumbBox"></div>
                                        <div class="spinner" style="display: none">Loading...</div>
                                    </div>
                                    <%--<div class="cropped">
                                    </div>--%>
                                </div>
                        </div>
                        <div class="row ">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button onclick="addProduct()" class="btn btn-primary btn-block">
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
    YUI().use('node', 'crop-box', function(Y){
        var options =
            {
                imageBox: '.imageBox',
                thumbBox: '.thumbBox',
                spinner: '.spinner',
                imgSrc: '/resources/img/avatar.jpg'
            }
        var cropper = new Y.cropbox(options);
        Y.one('#file').on('change', function(){
            var reader = new FileReader();
            reader.onload = function(e) {
                options.imgSrc = e.target.result;
                cropper = new Y.cropbox(options);
            }
            reader.readAsDataURL(this.get('files')._nodes[0]);
            this.get('files')._nodes = [];
        })
        Y.one('#btnCrop').on('click', function(){
            var img = cropper.getDataURL();
            document.getElementById("imgData").value = img;
        })
        Y.one('#btnZoomIn').on('click', function(){
            cropper.zoomIn();
        })
        Y.one('#btnZoomOut').on('click', function(){
            cropper.zoomOut();
        })
    })
    function addProduct() {
        $("#myformAdd").validate({
            rules: {
                productName: {
                    required: true
                },
                code: {
                    required: true
                },
                categoryId: {
                    required: true
                },
                price: {
                    required: true
                }
            },
            messages: {
                productName: {
                    required: "Tên sản phẩm không được để trống!",
                },
                code: {
                    required: "Mã sản phẩm không được để trống!"
                },
                categoryId: {
                    required: "Danh mục không được để trống!"
                },
                price: {
                    required: "Giá không được để trống!",
                }
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    }
</script>