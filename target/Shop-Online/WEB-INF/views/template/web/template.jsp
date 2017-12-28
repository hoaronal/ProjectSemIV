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

    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=inherit:400,100' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value="/resources/web/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/owl.carousel.css" />">

    <link rel="stylesheet" href="<c:url value="/resources/web/css/responsive.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/style.css" />">

</head>

<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="mainmenu"/>
<tiles:insertAttribute name="slider"/>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>


<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/web/js/owl.carousel.min.js" />"></script>
<script src="<c:url value="/resources/web/js/jquery.sticky.js" />"></script>
<script src="<c:url value="/resources/web/js/jquery.easing.1.3.min.js" />"></script>
<script src="<c:url value="/resources/web/js/main.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/bxslider.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/script.slider.js" />"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var category = '${category}';
        if(category === 'dien-thoai'){
            $('.phone').addClass('active');
        }else if(category === 'may-tinh'){
            $('.pc').addClass('active');
        }else if(category === 'lap-top'){
            $('.laptop').addClass('active');
        }else if(category === 'phu-kien'){
            $('.accessories').addClass('active');
        }else if(category === '' || category === 'trang-chu'){
            $('.home').addClass('active');
        }else if(category === 'other'){
            $('.other').addClass('active');
        }
        var $window = $(window);
        function checkWidth() {
            var windowsize = $window.width();
            if (windowsize < 800) {

            }
        }

        // Execute on load
        checkWidth();
        // Bind event listener
        $(window).resize(checkWidth);
    });
</script>
<script type="text/javascript">
    $uploadCrop = $('#upload-demo').croppie({
        enableExif: true,
        viewport: {
            width: 120,
            height: 120
        },
        boundary: {
            width: 200,
            height: 200
        }
    });

    $('#upload').on('change', function () {
        var reader = new FileReader();
        reader.onload = function (e) {
            $uploadCrop.croppie('bind', {
                url: e.target.result
            }).then(function () {
                console.log('jQuery bind complete');
            });

        }
        reader.readAsDataURL(this.files[0]);
    });

    $('.upload-result').on('click', function (ev) {
        $uploadCrop.croppie('result', {
            type: 'canvas',
            size: 'viewport'
        }).then(function (resp) {
            $('#imageUpload').val(resp);
            $('#myform').submit();
            /*$.ajax({
                url: "san-pham/them-moi/luu",
                type: "POST",
                data: {"image":resp},
                success: function (data) {
                    alert();
                    html = '<img src="' + resp + '" />';
                    $("#upload-demo-i").html(html);
                }
            });*/
        });
    });

</script>
</body>
</html>