<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/them-vao-gio-hang/" var="addCart"/>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Shop</h2>
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
                    <div class="product-breadcroumb">
                        <a href="<%=request.getContextPath()%>/">Trang chủ</a>
                        <a href="">${product.category.name_category}</a>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                            <div class="product-images">
                                <div class="product-main-img">
                                    <img id="zoomImg" src="<%=request.getContextPath()%>/resources/img/${product.imageLink}" alt="">
                                </div>

                                <div class="product-gallery">
                                    <c:forEach items="${listImg}" var="item">
                                        <img src="<%=request.getContextPath()%>/resources/img/${item}" alt="">
                                    </c:forEach>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="product-inner">
                                <h2 class="product-name">${product.productName}</h2>
                                <div class="product-inner-price">
                                    <ins>${product.price}</ins>
                                    <del>${product.discount}</del>
                                </div>

                                <form action="${addCart}${product.id}" class="cart">
                                    <div class="quantity">
                                        <input type="number" size="4" class="input-text qty text" title="Qty" value="1"
                                               name="quantity" min="1" max="10" step="1">
                                    </div>
                                    <button class="add_to_cart_button" type="submit">Thêm vào giỏ</button>
                                </form>

                                <div class="product-inner-category">
                                    <p>Category: <a href="">Summer</a>. Tags: <a href="">awesome</a>, <a
                                            href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>. </p>
                                </div>

                                <div role="tabpanel">
                                    <ul class="product-tab" role="tablist">
                                        <li role="presentation" class="active"><a href="#home" aria-controls="home"
                                                                                  role="tab" data-toggle="tab">Mô tả về sản phẩm</a>
                                        </li>
                                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab"
                                                                   data-toggle="tab">Đánh giá của bạn</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane fade in active" id="home">
                                            <p>
                                                ${product.detail}
                                            </p>
                                        </div>
                                        <div role="tabpanel" class="tab-pane fade" id="profile">
                                            <h2>Reviews</h2>
                                            <div class="submit-review">
                                                <p><label>Name</label> <input name="name" type="text"></p>
                                                <p><label>Email</label> <input name="email" type="email"></p>
                                                <div class="rating-chooser">
                                                    <p>Your rating</p>

                                                    <div class="rating-wrap-post">
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                        <i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <p><label>Your review</label> <textarea name="review" id="" cols="30"
                                                                                        rows="10"></textarea></p>
                                                <p><input type="submit" value="Submit"></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>


                    <div class="related-products-wrapper">
                        <h2 class="related-products-title">Sản phẩm cùng danh mục</h2>

                        <div class="related-products-carousel">
                            <c:forEach items="${productList.item}" var="item">
                                <div class="single-product">
                                    <div class="product-f-image">
                                        <img src="<%=request.getContextPath()%>/resources/img/${item.imageLink}" alt="">
                                        <div class="product-hover">
                                            <a href="${addCart}${item.id}" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Thêm
                                                vào giỏ</a>
                                            <a href="<%=request.getContextPath()%>/san-pham/chi-tiet/${item.id}" class="view-details-link"><i class="fa fa-link"></i> Xem chi tiết</a>
                                        </div>
                                    </div>

                                    <h2><a href="">${item.productName}</a></h2>

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
</div>