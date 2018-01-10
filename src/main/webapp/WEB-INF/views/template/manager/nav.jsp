<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a class="navbar-brand" href=""> Xin chào <sec:authentication property="principal.username" /> </a>
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
                    <a href="<%=request.getContextPath()%>/quan-tri/chat">
                        <i class="material-icons">notifications</i>
                        <span class="notification">5</span>
                        <p class="hidden-lg hidden-md">
                            Notifications
                            <b class="caret"></b>
                        </p>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="material-icons">settings_applications</i>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<%=request.getContextPath()%>/quan-tri/logout">Log out</a>
                        </li>
                        <li>
                            <a href="">Test</a>
                        </li>
                    </ul>
                </li>

                <li class="separator hidden-lg hidden-md"></li>
            </ul>
            <c:if test="${listItem.item.size() > 0}">
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group form-search is-empty">
                        <input type="text" class="form-control" placeholder="Search">
                        <span class="material-input"></span>
                        <span class="material-input"></span></div>
                    <button type="submit" class="btn btn-white btn-round btn-just-icon">
                        <i class="material-icons">search</i>
                        <div class="ripple-container"></div>
                    </button>
                </form>
            </c:if>
        </div>
    </div>
</nav>