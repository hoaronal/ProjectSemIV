<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Lịch sử đặt hàng</h2>
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
                <%
                    if (request.getSession().getAttribute(request.getSession().getId()) == null) {
                %>
                <h1>Chức năng chỉ dành cho người dùng đã đăng nhập!</h1>
                <%
                    }else {
                %>
                <h1>Lịch sử mua hàng</h1>

                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>