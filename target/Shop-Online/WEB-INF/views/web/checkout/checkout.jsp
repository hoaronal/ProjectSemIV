<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/dat-hang" var="order"/>
<spring:url value="/login" var="login"/>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Đặt hàng</h2>
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
                    <c:if test="${map != null && map.entrySet().size() > 0}">
                        <div class="woocommerce">
                            <%
                                if (request.getSession().getAttribute(request.getSession().getId()) == null) {
                            %>
                            <div class="woocommerce-info">Bạn là thành viên? <a class="showlogin" data-toggle="collapse"
                                                                                href="#login-form-wrap"
                                                                                aria-expanded="false"
                                                                                aria-controls="login-form-wrap">Click
                                vào đây để đăng nhập</a>
                            </div>
                            <form:form id="login-form-wrap" action="${login}" class="login collapse" method="post">
                                <p class="form-row form-row-first">
                                    <label for="username">Tài khoản <span class="required">*</span>
                                    </label>
                                    <input type="text" id="username" name="username" class="input-text">
                                </p>
                                <p class="form-row form-row-last">
                                    <label for="password">Mật khẩu <span class="required">*</span>
                                    </label>
                                    <input type="password" id="password" name="password" class="input-text">
                                </p>
                                <div class="clear"></div>
                                <p class="form-row">
                                    <input type="submit" value="Đăng nhập" name="login" class="button">
                                </p>
                                <div class="clear"></div>
                            </form:form>
                            <%
                                }
                            %>


                            <div class="woocommerce-info">Có phiếu giảm giá? <a class="showcoupon"
                                                                                data-toggle="collapse"
                                                                                href="#coupon-collapse-wrap"
                                                                                aria-expanded="false"
                                                                                aria-controls="coupon-collapse-wrap">Click
                                vào đây để nhập mã giảm giá</a>
                            </div>

                            <form:form id="coupon-collapse-wrap" method="post" class="checkout_coupon collapse">

                                <p class="form-row form-row-first">
                                    <input type="text" value="" id="coupon_code" placeholder="Mã giảm giá"
                                           class="input-text" name="coupon_code">
                                </p>

                                <p class="form-row form-row-last">
                                    <input type="submit" value="Áp dụng phiếu giảm giá" name="apply_coupon"
                                           class="button">
                                </p>

                                <div class="clear"></div>
                            </form:form>
                            <form:form action="${order}" class="checkout" method="post" name="checkout"
                                       modelAttribute="transaction">

                                <div id="customer_details" class="col2-set">
                                    <div class="col-1">
                                        <div class="woocommerce-billing-fields">
                                            <h3>Thông tin chi tiết</h3>
                                            <p id="billing_country_field"
                                               class="form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated">
                                                <label for="province">Tỉnh thành <abbr title="required"
                                                                                       class="required">*</abbr>
                                                </label>
                                                <select class="country_to_state country_select" id="province"
                                                        name="province">
                                                    <option value="0">Chọn tỉnh thành</option>
                                                    <c:forEach items="${provinceList}" var="item">
                                                        <option value="${item.id}">${item.provinceName}</option>
                                                    </c:forEach>
                                                </select>
                                            </p>

                                            <p id="billing_first_name_field"
                                               class="form-row form-row-first validate-required">
                                                <label for="firstname">First Name <abbr
                                                        title="required" class="required">*</abbr>
                                                </label>
                                                <input type="text" value="" placeholder="" id="firstname"
                                                       name="firstname" class="input-text">
                                                <span class="material-input" style="color: red"></span>
                                            </p>

                                            <p id="billing_last_name_field"
                                               class="form-row form-row-last validate-required">
                                                <label for="lastname">Last Name <abbr title="required" class="required">*</abbr>
                                                </label>
                                                <input type="text" value="" placeholder="" id="lastname"
                                                       name="lastname" class="input-text ">
                                                <span class="material-input" style="color: red"></span>
                                            </p>
                                            <div class="clear"></div>


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
                                                    <label class="" for="address">Address <abbr
                                                            title="required" class="required">*</abbr>
                                                    </label>
                                                    <input type="text" value="" id="address" name="address"
                                                           class="input-text ">
                                                    <span class="material-input" style="color: red"></span>
                                                </p>

                                                <div class="clear"></div>

                                                <p id="billing_email_field"
                                                   class="form-row form-row-first validate-required validate-email">
                                                    <label class="" for="email">Email Address <abbr
                                                            title="required" class="required">*</abbr>
                                                    </label>
                                                    <input type="text" value="" id="email" name="email"
                                                           class="input-text">
                                                    <span class="material-input" style="color: red"></span>
                                                </p>

                                                <p id="billing_phone_field"
                                                   class="form-row form-row-last validate-required validate-phone">
                                                    <label class="" for="phone">Phone <abbr title="required"
                                                                                            class="required">*</abbr>
                                                    </label>
                                                    <input type="text" value="" placeholder="" id="phone"
                                                           name="phone" class="">
                                                    <span class="material-input" style="color: red"></span>
                                                </p>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-md-12">
                                        <div style="padding-left: 13px;padding-right: 82px">
                                            <p id="order_comments_field" class="form-row notes">
                                                <label>Yêu cầu </label>
                                                <textarea cols="5" rows="2" id="message" class="input-text "
                                                          name="message"></textarea>
                                            </p>
                                        </div>
                                    </div>
                                </div>

                                <h3 id="order_review_heading">Đơn hàng của bạn</h3>

                                <div id="order_review" style="position: relative;">
                                    <table class="shop_table">
                                        <thead>
                                        <tr>
                                            <th class="product-name">Sản phẩm</th>
                                            <th class="product-total">Thành tiền</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${map.entrySet()}" var="entry">
                                            <tr class="cart_item">
                                                <td class="product-name">
                                                        ${entry.getValue().get(0).productName}<strong
                                                                class="product-quantity"> × <span style="color: red">${entry.getValue().size()}</span></strong>
                                                </td>
                                                <td class="product-total">
                                                    <span class="amount">${entry.getValue().get(0).price}</span></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                        <tfoot>

                                        <tr class="cart-subtotal">
                                            <th>Giá trị giỏ hàng</th>
                                            <td><span class="amount">${subtotal}</span>
                                            </td>
                                        </tr>

                                        <tr class="shipping">
                                            <th>Phí vận chuyển</th>
                                            <td>
                                                Miễn phí
                                                <input type="hidden" class="shipping_method" value="free_shipping"
                                                       id="shipping_method_0" data-index="0" name="shipping_method[0]">
                                            </td>
                                        </tr>

                                        <tr class="order-total">
                                            <th>Tổng đơn hàng</th>
                                            <td><strong><span class="amount">${subtotal}</span></strong></td>
                                        </tr>

                                        </tfoot>
                                    </table>


                                    <div id="payment">
                                        <ul class="payment_methods methods">
                                            <li class="payment_method_bacs">
                                                <input checked="checked" type="radio" id="paymentshipper"
                                                       data-order_button_text="" checked="checked" value="SHIPPER"
                                                       name="payment_method" class="input-radio">
                                                <label for="paymentshipper">Thanh toán cho người giao hàng </label>
                                            </li>
                                            <li class="payment_method_bacs">
                                                <input disabled type="radio" data-order_button_text="" value="BANK_TRANSFER"
                                                       name="payment_method" class="input-radio"
                                                       id="payment_method_bacs">
                                                <label for="payment_method_bacs">Chuyển khoản trực tiếp </label>
                                            </li>
                                            <li class="payment_method_cheque">
                                                <input disabled type="radio" data-order_button_text="" value="cheque"
                                                       name="payment_method" class="input-radio"
                                                       id="payment_method_cheque">
                                                <label for="payment_method_cheque">Thanh toán bằng séc</label>
                                            </li>
                                        </ul>

                                        <div class="form-row place-order">
                                            <input type="submit" value="Đặt hàng" id="place_order"
                                                   name="woocommerce_checkout_place_order" class="button alt">
                                        </div>

                                        <div class="clear"></div>

                                    </div>
                                </div>
                            </form:form>

                        </div>
                    </c:if>
                    <c:if test="${map == null || map.entrySet().size() <= 0}">
                        Bạn chưa đặt mua sản phẩm nào.
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>