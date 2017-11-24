<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" class="perfect-scrollbar-on">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><tiles:insertAttribute name="title"/></title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="viewport" content="width=device-width">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/material-dashboard.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/demo.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/css.css" />" rel="stylesheet">

</head>

<body>
<div class="wrapper">
    <tiles:insertAttribute name="sidebar"/>
    <div class="main-panel ps-container ps-theme-default ps-active-y" data-ps-id="a1fc1d2c-f0c7-c635-2e5d-b3d320f6abd3">
        <tiles:insertAttribute name="nav"/>
        <div class="content">
            <tiles:insertAttribute name="content"/>
        </div>
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
<%--<div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="http://demos.creative-tim.com/material-dashboard-pro/examples/dashboard.html#" data-toggle="dropdown" aria-expanded="false">
            <i class="fa fa-cog fa-2x"> </i>
        </a>
        <ul class="dropdown-menu">
            <li class="header-title"> Sidebar Filters</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger active-color">
                    <div class="badge-colors text-center">
                        <span class="badge filter badge-purple" data-color="purple"></span>
                        <span class="badge filter badge-blue" data-color="blue"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-rose active" data-color="rose"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Sidebar Background</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger background-color">
                    <div class="text-center">
                        <span class="badge filter badge-white" data-color="white"></span>
                        <span class="badge filter badge-black active" data-color="black"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Sidebar Mini</p>
                    <div class="togglebutton switch-sidebar-mini">
                        <label>
                            <input type="checkbox" unchecked=""><span class="toggle"></span>
                        </label>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Sidebar Image</p>
                    <div class="togglebutton switch-sidebar-image">
                        <label>
                            <input type="checkbox" checked=""><span class="toggle"></span>
                        </label>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Images</li>
            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="img/sidebar-1.jpg" alt="">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="img/sidebar-2.jpg" alt="">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="img/sidebar-3.jpg" alt="">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="img/sidebar-4.jpg" alt="">
                </a>
            </li>
            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/material-dashboard-pro" target="_blank" class="btn btn-rose btn-block">Buy Now</a>
                </div>
                <div class="">
                    <a href="http://www.creative-tim.com/product/material-dashboard" target="_blank" class="btn btn-info btn-block">Get Free Demo</a>
                </div>
            </li>
            <li class="header-title">Thank you for 95 shares!</li>
            <li class="button-container">
                <button id="twitter" class="btn btn-social btn-twitter btn-round sharrre"><i class="fa fa-twitter"></i> · 45</button>
                <button id="facebook" class="btn btn-social btn-facebook btn-round sharrre"><i class="fa fa-facebook-square"> ·</i>50</button>
            </li>
        </ul>
    </div>
</div>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/js/common.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/util.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/stats.js" />" ></script>--%>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/material.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/perfect-scrollbar.jquery.min.js" />" ></script>
<script  type="text/javascript"src="<c:url value="/resources/js/jquery.validate.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/moment.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/chartist.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.bootstrap-wizard.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-notify.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.sharrre.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datetimepicker.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-jvectormap.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/nouislider.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/js.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.select-bootstrap.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.datatables.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/sweetalert2.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jasny-bootstrap.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/fullcalendar.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.tagsinput.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/material-dashboard.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/demo.js" />" ></script>
<script type="text/javascript">
    $(document).ready(function () {
        demo.initDashboardPageCharts();
        demo.initVectorMap();
    });
</script>
<div class="jvectormap-tip">

</div>
</body>
</html>