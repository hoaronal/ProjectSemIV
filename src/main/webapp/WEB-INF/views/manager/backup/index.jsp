<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url var="backup" value="/quan-tri/sao-luu" />
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form:form id="myform" action="${backup}" method="post" cssClass="form-horizontal">
                    <div class="card-header card-header-text" data-background-color="rose">
                        <h4 class="card-title">Sao lưu dữ liệu</h4>
                    </div>
                    <div class="card-content">
<div class="row">
    <div class="col-lg-12">
        <h2>Dữ liệu database của bạn sẽ được sao lưu tại D:\home\backup</h2>
    </div>
</div>

                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-10">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-3">
                                    <button type="submit" class="btn btn-primary btn-block upload-result">
                                        Sao lưu
                                    </button>
                                </div>
                                <div class="col-md-3">
                                    <a href="<%=request.getContextPath()%>/quan-tri" class="btn btn-default btn-block">
                                        <spring:message code="label.cancel"/>
                                    </a>
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