<%@ page import="com.bkap.vn.common.entity.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <%--<form:form action="${login}" method="post" cssClass="form-horizontal">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i
                                        class="material-icons">x</i></button>
                                <h5 class="modal-title" id="myModalLabel">How Do You Become an Affiliate?</h5>
                            </div>
                            <div class="modal-body">
                            <div id="customer_details" class="col2-set">
                                <div class="form-group">
                                    <label style="margin-left: 50px" for="username" class="col-sm-2 control-label">Tài khoản</label>
                                    <div class="col-sm-8 ">
                                            <input type="text" value="" placeholder="Tài khoản" id="username"
                                                   name="username" class="input-text">
                                            <span class="material-input" style="color: red"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label style="margin-left: 50px" for="username" class="col-sm-2 control-label">Mật khẩu</label>
                                    <div class="col-sm-8">
                                            <input type="text" value="" placeholder="Mật khẩu" id="password"
                                                   name="password" class="input-text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <div class="col-sm-6" style="text-align: left">
                                            <a style="margin-left: 50px" href="<%=request.getContextPath()%>/dang-ki">Đăng kí</a>
                                        </div>
                                        <div class="col-sm-6" style="text-align: right">
                                            <a style="margin-right: 50px" href="<%=request.getContextPath()%>/quen-mat-khau">Quên mật khẩu?</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                            <div class="modal-footer text-center">
                                <a href='#' onclick="checkLoginState();">Facebook Login</a>
                                <fb:login-button scope="public_profile,email"  onlogin="checkLoginState();" >Đăng nhập với facebook</fb:login-button>
                                <div id="status">
                                </div>
                                <input type="submit" style="margin-right: 50px" value="Đăng nhập" name="login" class="button">
                            </div>
                        </form:form>--%>
                            <form action="index.html" class="panel-body wrapper-lg">
                                <div class="form-group">
                                    <label class="control-label">Email</label>
                                    <input type="email" placeholder="test@example.com" class="form-control input-lg">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Password</label>
                                    <input type="password" id="inputPassword" placeholder="Password" class="form-control input-lg">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Keep me logged in
                                    </label>
                                </div>
                                <a href="#" class="pull-right m-t-xs"><small>Forgot password?</small></a>
                                <button type="submit" class="btn btn-primary">Sign in</button>
                                <div class="line line-dashed"></div>
                                <a onclick="checkLoginState();" class="btn btn-facebook btn-block m-b-sm"><i class="fa fa-facebook pull-left"></i>Sign in with Facebook</a>
                                <a href="#" class="btn btn-twitter btn-block"><i class="fa fa-twitter pull-left"></i>Sign in with Twitter</a>
                                <div class="line line-dashed"></div>
                                <a class="text-muted text-center" style="text-align: center"><small>Do not have an account?</small></a>
                            </form>
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
                </div>
                <div class="shopping-item col-xs-2 hidden-lg hidden-md hidden-sm">
                    <a href="<%=request.getContextPath()%>/gio-hang"><i class="fa fa-shopping-cart"></i> <span
                            class="product-count"><%=request.getSession().getAttribute("NUM_IN_CART")%></span></a>
                </div>
            </div>
            <div class="col-sm-8 col-xs-12">
                <div class="col-sm-8 col-xs-12">
                    <form:form action="${search}" class="form-horizontal" style="margin-top: 40px">
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