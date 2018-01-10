<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="loginUrl" value="/quan-tri/login" />
<div class="wrapper wrapper-full-page">
    <div class="full-page login-page" filter-color="black">
        <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
                        <form method="post"  action="${loginUrl}">
                            <div class="card card-login">
                                <div class="card-header text-center" data-background-color="rose">
                                    <h4 class="card-title">Đăng nhập</h4>
                                </div>
                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger" style="margin: 10px">
                                        <p>Mật khẩu hoặc tên người dùng không đúng!</p>
                                    </div>
                                </c:if>
                                <c:if test="${param.logout != null}">
                                    <div class="alert alert-success" style="margin: 10px">
                                        <p>Bạn đã đăng xuất khỏi hệ thống.</p>
                                    </div>
                                </c:if>
                                <div class="card-content">
                                    <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">face</i>
                                            </span>
                                        <div class="form-group label-floating is-empty">
                                            <label class="control-label">Tài khoản</label>
                                            <input type="text" id="account" name="account" class="form-control">
                                            <span class="material-input"></span></div>
                                    </div>
                                    <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">lock_outline</i>
                                            </span>
                                        <div class="form-group label-floating is-empty">
                                            <label class="control-label">Mật khẩu</label>
                                            <input type="password" id="password" name="password" class="form-control">
                                            <span class="material-input"></span></div>
                                    </div>
                                    <div class="input-group input-sm">
                                        <div class="checkbox">
                                            <label><input type="checkbox" id="rememberme" name="remember-me"> Nhớ mật khẩu</label>
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                <div class="footer text-center">
                                    <button type="submit" class="btn btn-rose btn-simple btn-wd btn-lg">Đăng nhập</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
