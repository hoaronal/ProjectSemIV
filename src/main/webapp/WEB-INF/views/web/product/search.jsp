<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/tim-kiem" var="search"/>
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
        <c:if test="${productList.item == null || productList.item.size() <= 0}">
            Không có sản phẩm nào
        </c:if>
        <c:if test="${productList.item != null && productList.item.size() > 0}">
            <div class="row">
                <div class="col-md-12" style="margin-left: 30px">
                    <c:forEach items="${productList.item}" var="item" varStatus="status">
                        <div class="col-md-3 col-sm-6">
                            <div class="single-shop-product">
                                <div class="product-upper">
                                    <img src="<%=request.getContextPath()%>/resources/img/${item.imageLink}" alt="">
                                </div>
                                <h2><a href="">${item.productName}</a></h2>
                                <div class="product-carousel-price">
                                    <ins>${item.price}</ins>
                                    <del>${item.discount}</del>
                                </div>

                                <div class="product-option-shop">
                                    <a class="add_to_cart_button" data-quantity="1" data-product_sku=""
                                       data-product_id="70"
                                       rel="nofollow" href="<%=request.getContextPath()%>/them-vao-gio-hang/${item.id}">Thêm
                                        vào giỏ</a>
                                </div>
                            </div>
                        </div>
                        <c:if test="${((status.index + 1) % 4) == 0}">
                            <hr style="width: 100%;border-top: 1px solid #e5e5e5;"/>
                        </c:if>
                    </c:forEach>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <form:form action="${search}" id="formSearch" cssStyle="display: none">
                            <input type="hidden" name="keySearch" value="${keySearch}"/>
                            <input type="hidden" name="categoryId" value="${categoryId}"/>
                            <input type="hidden" name="page"  value="${page}"/>
                        </form:form>
                        <nav>
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <c:forEach var="page" items="${productList.pages}">
                                    <li class="paginate_button ${productList.currentPage == page?"active":""}">
                                        <a class="linkSearch">${page}</a>
                                    </li>
                                </c:forEach>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </c:if>

    </div>
</div>