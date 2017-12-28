<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quanghoa
  Date: 12/22/2017
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="col-md-4">
                <div class="single-sidebar">
                    <h2 class="sidebar-title">Tìm kiếm</h2>
                    <form action="">
                        <input type="text" placeholder="Tìm kiếm...">
                        <input type="submit" value="Search">
                    </form>
                </div>

                <div class="single-sidebar">
                    <h2 class="sidebar-title">Sản phẩm khác</h2>
                    <div class="thubmnail-recent">
                        <img src="<%=request.getContextPath()%>/resources/web/img/product-thumb-1.jpg"
                             class="recent-thumb" alt="">
                        <h2><a href="">Sony Smart TV - 2015</a></h2>
                        <div class="product-sidebar-price">
                            <ins>$700.00</ins>
                            <del>$100.00</del>
                        </div>
                    </div>
                    <div class="thubmnail-recent">
                        <img src="<%=request.getContextPath()%>/resources/web/img/product-thumb-1.jpg"
                             class="recent-thumb" alt="">
                        <h2><a href="">Sony Smart TV - 2015</a></h2>
                        <div class="product-sidebar-price">
                            <ins>$700.00</ins>
                            <del>$100.00</del>
                        </div>
                    </div>
                    <div class="thubmnail-recent">
                        <img src="<%=request.getContextPath()%>/resources/web/img/product-thumb-1.jpg"
                             class="recent-thumb" alt="">
                        <h2><a href="">Sony Smart TV - 2015</a></h2>
                        <div class="product-sidebar-price">
                            <ins>$700.00</ins>
                            <del>$100.00</del>
                        </div>
                    </div>
                    <div class="thubmnail-recent">
                        <img src="<%=request.getContextPath()%>/resources/web/img/product-thumb-1.jpg"
                             class="recent-thumb" alt="">
                        <h2><a href="">Sony Smart TV - 2015</a></h2>
                        <div class="product-sidebar-price">
                            <ins>$700.00</ins>
                            <del>$100.00</del>
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-md-8">
                <div class="product-content-right">
                    <div class="product-breadcroumb">
                        <a href="<%=request.getContextPath()%>/">Trang chủ</a>
                        <a href="">${product.category.name_category}</a>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                            <div class="product-images">
                                <div class="product-main-img">
                                    <img src="<%=request.getContextPath()%>/resources/img/${product.imageLink}" alt="">
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

                                <form action="" class="cart">
                                    <div class="quantity">
                                        <input type="number" size="4" class="input-text qty text" title="Qty" value="1"
                                               name="quantity" min="1" step="1">
                                    </div>
                                    <button class="add_to_cart_button" type="submit">Add to cart</button>
                                </form>

                                <div class="product-inner-category">
                                    <p>Category: <a href="">Summer</a>. Tags: <a href="">awesome</a>, <a
                                            href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>. </p>
                                </div>

                                <div role="tabpanel">
                                    <ul class="product-tab" role="tablist">
                                        <li role="presentation" class="active"><a href="#home" aria-controls="home"
                                                                                  role="tab" data-toggle="tab">Description</a>
                                        </li>
                                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab"
                                                                   data-toggle="tab">Reviews</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane fade in active" id="home">
                                            <h2>Product Description</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tristique,
                                                diam in consequat iaculis, est purus iaculis mauris, imperdiet facilisis
                                                ante ligula at nulla. Quisque volutpat nulla risus, id maximus ex
                                                aliquet ut. Suspendisse potenti. Nulla varius lectus id turpis dignissim
                                                porta. Quisque magna arcu, blandit quis felis vehicula, feugiat gravida
                                                diam. Nullam nec turpis ligula. Aliquam quis blandit elit, ac sodales
                                                nisl. Aliquam eget dolor eget elit malesuada aliquet. In varius lorem
                                                lorem, semper bibendum lectus lobortis ac.</p>

                                            <p>Mauris placerat vitae lorem gravida viverra. Mauris in fringilla ex.
                                                Nulla facilisi. Etiam scelerisque tincidunt quam facilisis lobortis. In
                                                malesuada pulvinar neque a consectetur. Nunc aliquam gravida purus, non
                                                malesuada sem accumsan in. Morbi vel sodales libero.</p>
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
                                            <a href="" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Thêm
                                                vào giỏ</a>
                                            <a href="" class="view-details-link"><i class="fa fa-link"></i> Xem chi tiết</a>
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