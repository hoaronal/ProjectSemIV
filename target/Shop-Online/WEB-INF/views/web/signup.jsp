<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/dang-ki" var="signup"/>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Đăng kí</h2>
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
                            <form:form action="${signup}" method="post">

                                <div id="customer_details" class="col2-set">
                                    <div class="col-1">
                                        <div class="woocommerce-billing-fields">
                                            <h3>Thông tin khách hàng</h3>

                                            <p id="email_field"
                                               class="form-row form-row-first validate-required validate-email">
                                                <label class="" for="email">Địa chỉ email <abbr
                                                        title="required" class="required">*</abbr>
                                                </label>
                                                <input type="text" value="" id="email" name="email"
                                                       class="input-text ${email != null?"border_error":""}">
                                                <span class="material-input" style="color: red">${email}</span>
                                            </p>
                                            <div class="clear"></div>

                                            <p id="address_field"
                                               class="form-row form-row-wide address-field validate-required">
                                                <label for="username">Tài khoản <abbr
                                                        title="required" class="required">*</abbr>
                                                </label>
                                                <input type="text" value="" id="username" name="username"
                                                       class="input-text  ${username != null?"border_error":""}">
                                                <span class="material-input" style="color: red">${username}</span>
                                            </p>
                                            <div class="clear"></div>
                                        </div>
                                    </div>

                                    <div class="col-2">
                                        <div class="woocommerce-shipping-fields">
                                            <h3 id="ship-to-different-address">
                                                <label class="checkbox"> </label>
                                            </h3>
                                            <div class="shipping_address" style="display: block;">
                                                <p id="billing_address_1_field"
                                                   class="form-row form-row-wide address-field validate-required">
                                                    <label class="" for="password">Mật khẩu <abbr
                                                            title="required" class="required">*</abbr>
                                                    </label>
                                                    <input type="text" value="" id="password" name="password"
                                                           class="input-text ${password != null?"border_error":""}">
                                                    <span class="material-input" style="color: red">${password}</span>
                                                </p>

                                                <div class="clear"></div>

                                                <p id="billing_email_field"
                                                   class="form-row form-row-first validate-required validate-email">
                                                    <label class="" for="email">Nhập lại mật khẩu <abbr
                                                            title="required" class="required">*</abbr>
                                                    </label>
                                                    <input type="text" value="" id="re_password" name="re_password"
                                                           class="input-text ${re_password != null?"border_error":""}">
                                                    <span class="material-input" style="color: red">${re_password}</span>
                                                </p>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div id="order_review" style="position: relative;">
                                    <div id="payment">
                                        <div class="form-row place-order">
                                            <input type="submit" value="Đăng kí" id="signup"
                                                   name="signup" class="button">
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