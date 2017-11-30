<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="perfect-scrollbar-on">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><tiles:insertAttribute name="title"/></title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="viewport" content="width=device-width">
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/material-dashboard.css" rel="stylesheet">
    <link href="css/demo.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/css.css" rel="stylesheet" type="text/css" >--%>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/material-dashboard.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/demo.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/css.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/web/css/main.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/web/css/material-kit.css" />">
    <style>
        #left_ads_float {
            bottom: 50px;
            left: 30px;
            position: fixed;
        }
        #right_ads_float {
            bottom: 50px;
            left: 30px;
            position: fixed;
        }

        .icon.icon-info {
            color: white !important;
        }
    </style>
</head>

<body class="blog-posts">
<tiles:insertAttribute name="navbar"/>
<div class="wrapper">
    <tiles:insertAttribute name="header"/>
    <div class="main main-raised">
        <tiles:insertAttribute name="content"/>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>


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

<%--<script type="text/javascript" async="" src="<c:url value="/resources/web/js/ga.js" />"></script>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/web/js/moment.min.js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/web/js/nouislider.min.js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/web/js/bootstrap-selectpicker.js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/web/js/bootstrap-tagsinput.js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/web/js/jasny-bootstrap.min.js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/web/js/js.js" />"></script>--%>
<script type="text/javascript" src="<c:url value="/resources/web/js/material-kit.js" />"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("#success-${style}").fadeTo(2000, 500).slideUp(500, function(){
            $("#success-${style}").slideUp(500);
        });
        // Optimalisation: Store the references outside the event handler:
        var $window = $(window);
        var $pane = $('#pane1');

        function checkWidth() {
            var windowsize = $window.width();
            if (windowsize < 800) {
                alert('sdsdsdsd');
            }
        }
        // Execute on load
        checkWidth();
        // Bind event listener
        $(window).resize(checkWidth);
    });
</script>
</body>
</html>