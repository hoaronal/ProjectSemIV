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
                                    <h4 class="card-title">Login</h4>
                                    <div class="social-line">
                                        <a class="btn btn-just-icon btn-simple">
                                            <i class="fa fa-facebook-square"></i>
                                        </a>
                                        <a class="btn btn-just-icon btn-simple">
                                            <i class="fa fa-twitter"></i>
                                        </a>
                                        <a class="btn btn-just-icon btn-simple">
                                            <i class="fa fa-google-plus"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="card-content">
                                    <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">face</i>
                                            </span>
                                        <div class="form-group label-floating is-empty">
                                            <label class="control-label">Account</label>
                                            <input type="text" id="account" name="account" class="form-control">
                                            <span class="material-input"></span></div>
                                    </div>
                                    <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">lock_outline</i>
                                            </span>
                                        <div class="form-group label-floating is-empty">
                                            <label class="control-label">Password</label>
                                            <input type="password" id="password" name="password" class="form-control">
                                            <span class="material-input"></span></div>
                                    </div>
                                    <div class="input-group input-sm">
                                        <div class="checkbox">
                                            <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>
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
