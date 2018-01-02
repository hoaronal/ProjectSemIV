<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="promo-area hidden-xs">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="single-promo promo1">
                    <i class="fa fa-refresh"></i>
                    <p>Đổi trả trong 30 ngày</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="single-promo promo2">
                    <i class="fa fa-truck"></i>
                    <p>Miễn phí vận chuyển</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="single-promo promo3">
                    <i class="fa fa-lock"></i>
                    <p>Thanh toán an toàn</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="single-promo promo4">
                    <i class="fa fa-gift"></i>
                    <p>Đa dạng mặt hàng</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End promo area -->

<div class="maincontent-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="latest-product">
                    <h2 class="section-title">Sản phẩm mới nhất</h2>
                    <div class="product-carousel">
                        <c:forEach items="${newProductList}" var="item">
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="<%=request.getContextPath()%>/resources/img/${item.imageLink}" alt="">
                                    <div class="product-hover">
                                        <a href="<%=request.getContextPath()%>/them-vao-gio-hang/${item.id}" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Thêm
                                            vào giỏ</a>
                                        <a href="<%=request.getContextPath()%>/san-pham/chi-tiet/${item.id}" class="view-details-link"><i
                                                class="fa fa-link"></i> Xem chi tiết</a>
                                    </div>
                                </div>

                                <h2><a href="<%=request.getContextPath()%>/san-pham/chi-tiet/${item.id}">${item.productName}</a></h2>

                                <div class="product-carousel-price">
                                    <ins>${item.price}</ins>
                                    <del>${item.discount}</del>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End main content area -->

<div class="brands-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="brand-wrapper">
                    <div class="brand-list">
                        <img src="<%=request.getContextPath()%>/resources/web/img/brand1.png" alt="">
                        <img src="<%=request.getContextPath()%>/resources/web/img/brand2.png" alt="">
                        <img src="<%=request.getContextPath()%>/resources/web/img/brand3.png" alt="">
                        <img src="<%=request.getContextPath()%>/resources/web/img/brand4.png" alt="">
                        <img src="<%=request.getContextPath()%>/resources/web/img/brand5.png" alt="">
                        <img src="<%=request.getContextPath()%>/resources/web/img/brand6.png" alt="">
                        <img src="<%=request.getContextPath()%>/resources/web/img/brand1.png" alt="">
                        <img src="<%=request.getContextPath()%>/resources/web/img/brand2.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End brands area -->

<div class="product-widget-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="single-product-widget">
                    <h2 class="product-wid-title">Hàng giảm giá</h2>
                    <a href="<%=request.getContextPath()%>/san-pham/giam-gia/1" class="wid-view-more">View All</a>
                    <c:forEach items="${saleProductList}" var="item">
                        <div class="single-wid-product">
                            <a href="<%=request.getContextPath()%>/san-pham/chi-tiet/${item.id}">
                                <img src="<%=request.getContextPath()%>/resources/img/${item.imageLink}" alt=""
                                    class="product-thumb"></a>
                            <h2><a href="single-product.html">${item.productName}</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>${item.price}</ins>
                                <del>${item.discount}</del>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
            <div class="col-md-4">
                <div class="single-product-widget">
                    <h2 class="product-wid-title">Xem nhiều nhất</h2>
                    <a href="<%=request.getContextPath()%>/san-pham/xem-nhieu/1" class="wid-view-more">View All</a>
                    <c:forEach items="${viewMostProductList}" var="item">
                        <div class="single-wid-product">
                            <a href="<%=request.getContextPath()%>/san-pham/chi-tiet/${item.id}">
                                <img src="<%=request.getContextPath()%>/resources/img/${item.imageLink}" alt=""
                                     class="product-thumb"></a>
                            <h2><a href="single-product.html">${item.productName}</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>${item.price}</ins>
                                <del>${item.discount}</del>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-4">
                <div class="single-product-widget">
                    <h2 class="product-wid-title">Sản phẩm mới</h2>
                    <a href="<%=request.getContextPath()%>/san-pham/hang-moi/1" class="wid-view-more">View All</a>
                    <c:forEach items="${newProductList1}" var="item">
                        <div class="single-wid-product">
                            <a href="<%=request.getContextPath()%>/san-pham/chi-tiet/${item.id}">
                                <img src="<%=request.getContextPath()%>/resources/img/${item.imageLink}" alt=""
                                     class="product-thumb"></a>
                            <h2><a href="single-product.html">${item.productName}</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>${item.price}</ins>
                                <del>${item.discount}</del>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End product widget area -->