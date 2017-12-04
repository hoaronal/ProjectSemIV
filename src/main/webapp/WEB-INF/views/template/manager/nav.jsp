<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="${searchRrl}" var="addUserAction"/>
<nav class="navbar navbar-transparent navbar-absolute">
    <div class="container-fluid">
        <div class="navbar-minimize">
            <button id="minimizeSidebar" class="btn btn-round btn-white btn-fill btn-just-icon">
                <i class="material-icons visible-on-sidebar-regular">more_vert</i>
                <i class="material-icons visible-on-sidebar-mini">view_list</i>
            </button>
        </div>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown" title="Ngôn ngữ">
                        <i class="material-icons">g_translate</i>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="?lang=vi_VN">Tiếng việt</a>
                        </li>
                        <li>
                            <a href="?lang=en_US">Tiếng anh</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="material-icons">notifications</i>
                        <span class="notification">5</span>
                        <p class="hidden-lg hidden-md">
                            Notifications
                            <b class="caret"></b>
                        </p>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="">Mike John responded to your email</a>
                        </li>
                        <li>
                            <a href="">You have 5 new tasks</a>
                        </li>
                        <li>
                            <a href="">You're now friend with Andrew</a>
                        </li>
                        <li>
                            <a href="">Another Notification</a>
                        </li>
                        <li>
                            <a href="">Another One</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="material-icons">settings_applications</i>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="">Log out</a>
                        </li>
                        <li>
                            <a href="">Test</a>
                        </li>
                    </ul>
                </li>

                <li class="separator hidden-lg hidden-md"></li>
            </ul>

        </div>
    </div>
</nav>