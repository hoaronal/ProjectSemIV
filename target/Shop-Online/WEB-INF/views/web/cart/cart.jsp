<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Giỏ hàng</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Page title area -->


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
                            <form method="post" action="#">
                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                    <tr>
                                        <th class="product-remove">&nbsp;</th>
                                        <th class="product-thumbnail">&nbsp;</th>
                                        <th class="product-name">Tên sản phẩm</th>
                                        <th class="product-price">Giá</th>
                                        <th class="product-quantity">Số lượng</th>
                                        <th class="product-subtotal">Thành tiền</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${map.entrySet()}" var="entry">
                                        <tr class="cart_item">
                                            <td class="product-remove">
                                                <a href="<%=request.getContextPath()%>/gio-hang/xoa/${entry.getValue().get(0).code}"
                                                   class="remove" href="#">×</a>
                                            </td>

                                            <td class="product-thumbnail">
                                                <a href="<%=request.getContextPath()%>/san-pham/chi-tiet/${entry.getValue().get(0).id}"><img
                                                        width="145" height="145" alt="poster_1_up"
                                                        class="shop_thumbnail"
                                                        src="<%=request.getContextPath()%>/resources/img/${entry.getValue().get(0).imageLink}"></a>
                                            </td>

                                            <td class="product-name">
                                                <a href="<%=request.getContextPath()%>/san-pham/chi-tiet/${entry.getValue().get(0).id}">${entry.getValue().get(0).productName}</a>
                                            </td>

                                            <td class="product-price">
                                                <span class="amount">${entry.getValue().get(0).price}</span>
                                            </td>

                                            <td class="product-quantity">
                                                <div class="quantity buttons_added">
                                                    <input type="button" class="minus" value="-">
                                                    <input type="number" size="4" class="input-text qty text"
                                                           title="Qty" value="${entry.getValue().size()}" min="0"
                                                           step="1">
                                                    <input type="button" class="plus" value="+">
                                                </div>
                                            </td>
                                            <td class="product-subtotal">
                                                <span class="amount">${entry.getValue().size() * entry.getValue().get(0).price} VND</span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td class="actions" colspan="6">
                                            <div class="coupon">
                                                    <%--<label for="coupon_code">Coupon:</label>
                                                    <input type="text" placeholder="Coupon code" value="" id="coupon_code" class="input-text" name="coupon_code">
                                                    <input type="submit" value="Apply Coupon" name="apply_coupon" class="button">--%>
                                            </div>
                                            <a style="background: none repeat scroll 0 0 #5a88ca; border: medium none; color: #fff; padding: 11px 20px; text-transform: uppercase;text-decoration: none" name="update_cart" class="button">Cập nhật giỏ hàng</a>
                                            <a style="background: none repeat scroll 0 0 #5a88ca; border: medium none; color: #fff; padding: 11px 20px; text-transform: uppercase;text-decoration: none" href="<%=request.getContextPath()%>/dat-hang" name="proceed"
                                               class="button">Đặt hàng</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </form>

                            <div class="cart-collaterals">
                                <div class="cart_totals">
                                    <h2 style="margin-top: 10px">Tất cả giỏ hàng</h2>

                                    <table cellspacing="0">
                                        <tbody>
                                        <tr class="cart-subtotal">
                                            <th>Giá trị giỏ hàng</th>
                                            <td><span class="amount">${subtotal}</span></td>
                                        </tr>

                                        <tr class="shipping">
                                            <th>Phí vận chuyển</th>
                                            <td>Miễn phí</td>
                                        </tr>

                                        <tr class="order-total">
                                            <th>Tổng đơn hàng</th>
                                            <td><strong><span class="amount">${subtotal}</span></strong></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${map == null || map.entrySet().size() <= 0}">
                        Giỏ hàng của bạn chưa có sản phẩm nào.
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
