<%@ page import="com.bkap.vn.common.entity.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/tim-kiem" var="search"/>
<spring:url value="/login" var="login"/>
<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul class="list-unstyled list-inline">
                        <%
                            if (request.getSession().getAttribute(request.getSession().getId()) != null) {
                        %>
                        <li><a href="#"><i class="fa fa-cog"></i>Xin chào <span
                                style="color: #5a88ca;font-weight: bold"><%=((Users) request.getSession().getAttribute(request.getSession().getId())).getUsername()%></span></a>
                        </li>
                        <%
                            }
                        %>
                        <li><a href="<%=request.getContextPath()%>/dat-hang"><i class="fa fa-money"></i>Thanh toán</a>
                        </li>
                        <%
                            if (request.getSession().getAttribute(request.getSession().getId()) == null) {
                        %>
                        <li><a href="#" data-toggle="modal" data-target="#noticeModal"><i
                                class="glyphicon glyphicon-log-in"></i> Đăng nhập</a></li>
                        <%
                        } else {
                        %>
                        <li><a href="<%=request.getContextPath()%>/logout"><i
                                class="glyphicon glyphicon-log-in"></i> Đăng xuất</a></li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
            <div class="modal fade" id="noticeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-notice">
                    <div class="modal-content">
                            <form:form action="${login}" class="panel-body wrapper-lg">
                                <div class="form-group">
                                    <label class="control-label">Email</label>
                                    <input type="text" placeholder="Tài khoản" name="username" id="username" class="form-control input-lg">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Password</label>
                                    <input type="password" id="password" name="password" placeholder="Password" class="form-control input-lg">
                                </div>
                                <a href="<%=request.getContextPath()%>/quen-mat-khau" class="pull-right m-t-xs"><small>Quên mật khẩu?</small></a>
                                <button type="submit" class="btn btn-primary">Đăng nhập</button>
                                <div class="line line-dashed"></div>
                                <a onclick="checkLoginState();" class="btn btn-facebook btn-block m-b-sm"><i class="fa fa-facebook pull-left"></i>Đăng nhập với Facebook</a>
                                <%--<a href="#" class="btn btn-twitter btn-block"><i class="fa fa-twitter pull-left"></i>Đăng nhập với Twitter</a>--%>
                                <div class="line line-dashed"></div>
                                <a href="<%=request.getContextPath()%>/dang-ki" class="text-muted text-center" style="text-align: center"><small>Chưa có tài khoản?</small></a>
                                <%--<fb:login-button scope="public_profile,email" onClick="checkLoginState();">
                                </fb:login-button>--%>
                                <%--<div class="fb-login-button" data-max-rows="1" data-size="large" data-button-type="continue_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="false"></div>--%>

                            </form:form>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="header-right">
                    <ul class="list-unstyled list-inline">
                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span
                                    class="key">language :</span><span class="value">English </span><b
                                    class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">English</a></li>
                                <li><a href="#">Vietnamese</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End header area -->

<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-xs-12">
                <div class="logo col-xs-10">
                    <h1><a href="<%=request.getContextPath()%>/">Dream-Shop</a></h1>
                    <%--<img src="https://graph.facebook.com/762694757258295/picture?type=square" alt="dsdsd">--%>
                </div>
                <div class="shopping-item col-xs-2 hidden-lg hidden-md hidden-sm">
                    <a href="<%=request.getContextPath()%>/gio-hang"><i class="fa fa-shopping-cart"></i> <span
                            class="product-count"><%=request.getSession().getAttribute("NUM_IN_CART")%></span></a>
                </div>
            </div>
            <div class="col-sm-8 col-xs-12">
                <div class="col-sm-8 col-xs-12">
                    <form:form action="${search}" class="form-horizontal" id="searchForm" style="margin-top: 40px">
                        <select class="selectSearch" style="border: 1px solid #ddd; margin-bottom: 15px; padding: 10px;"
                                id="categoryId"
                                name="categoryId">
                            <option value="0" ${categoryId == 0 ? "selected":""}>Tất cả</option>
                            <option value="1" ${categoryId == 1 ? "selected":""}>Điện thoại</option>
                            <option value="2" ${categoryId == 2 ? "selected":""}>Máy tính</option>
                            <option value="3" ${categoryId == 3 ? "selected":""}>Laptop</option>
                            <option value="4" ${categoryId == 4 ? "selected":""}>Phụ kiện</option>
                        </select>
                        <input type="hidden" name="page" value="1"/>
                        <input type="text" value="${keySearch}" placeholder="Tìm kiếm" id="keySearch" class="input-text"
                               name="keySearch">
                        <input type="submit" value="Tìm kiếm" id="btnSearch" class="button">
                    </form:form>
                </div>
                <div class="hidden-xs col-sm-4">
                    <div class="shopping-item">
                        <a href="<%=request.getContextPath()%>/gio-hang"><i class="fa fa-shopping-cart"></i> <span
                                class="product-count"><%=request.getSession().getAttribute("NUM_IN_CART")%></span></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End site branding area -->