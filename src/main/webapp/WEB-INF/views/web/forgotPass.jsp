<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/tim-mat-khau" var="getpass"/>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Quên mật khẩu</h2>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="single-sidebar">
                    <h2 class="sidebar-title">Quảng cáo</h2>
                </div>

            </div>

            <div class="col-md-9">
                <div class="product-content-right">
                    <div class="woocommerce">
                        ${msg}
                        <form:form action="${getpass}" method="post">
                            <div id="customer_details" class="col2-set">
                                <div class="col-md-12">
                                    <div style="padding-left: 13px;padding-right: 82px">
                                        <p id="order_comments_field" class="form-row notes">
                                            <label>Nhập email của bạn để lấy lại mật khẩu</label>
                                            <input style="height: 50px;width: 100%" type="email" id="email" class="input-text "
                                                      name="email"></input>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div id="order_review" style="position: relative;">
                                <div id="payment">
                                    <div class="form-row place-order">
                                        <input type="submit" value="Lấy lại mật khẩu" id="place_order" class="button alt">
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>