<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en" class="perfect-scrollbar-on">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><tiles:insertAttribute name="title"/></title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/owl.carousel.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/style.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/responsive.css" />">
</head>

<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="slider"/>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>
<script type="text/javascript" src="<c:url value="/resources/web/js/jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/owl.carousel.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/jquery.sticky.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/jquery.easing.1.3.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/main.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/bxslider.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/script.slider.js" />"></script>
<div class="jvectormap-tip">

</div>
</body>
</html>