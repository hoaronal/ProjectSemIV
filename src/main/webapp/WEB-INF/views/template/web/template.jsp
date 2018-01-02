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
    <link rel="stylesheet" href="<c:url value="/resources/web/css/app.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/web/css/style.css" />">
</head>

<body style="position: relative">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<div id="fb-root"></div>
<script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.11&appId=299806640540917';
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<%--<script>
    function statusChangeCallback(response) {
        if (response.status === 'connected') {
            var accessToken = response.authResponse.accessToken;
            window.location.href = 'login-facebook?accessToken='+accessToken;
            //testAPI();
        } else {
            document.getElementById('status').innerHTML = 'Please log ' +
                'into this app.';
        }
    }

    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    }

    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1495471333905861',
            cookie     : true,
            xfbml      : true,
            version    : 'v2.11'
        });
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    };

    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = "https://connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function testAPI() {
        FB.api('/me', function(response) {
            console.log('Successful login for: ' + response.name);
            document.getElementById('status').innerHTML =
                'Thanks for logging in, ' + response.name + '!';
        });
    }
</script>--%>
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1495471333905861',
            cookie     : true,
            xfbml      : true,
            version    : 'v2.11'
        });

        FB.AppEvents.logPageView();

    };


    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    }

    function statusChangeCallback(response) {
        if (response.status === 'connected') {
            var accessToken = response.authResponse.accessToken;
            window.location.href = 'login-facebook?accessToken='+accessToken;
        } else {
            document.getElementById('status').innerHTML = 'Please log ' +
                'into this app.';
        }
    }

    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.11&appId=1495471333905861';
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>
<%--<script type="text/javascript">
    //<![CDATA[
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1495471333905861',
            channelURL : '',
            cookie     : true,
            xfbml      : true,
            oauth      : true,
            status     : true,
            cookie     : true,
            version    : 'v2.11'
        });
        FB.AppEvents.logPageView();
    };
    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "https://connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    }

    function login(){
        FB.getLoginStatus(function(r){
            if (response.status === 'connected') {
                var accessToken = response.authResponse.accessToken;
                window.location.href = 'login-facebook?accessToken='+accessToken;
            }else{
                FB.login(function(response) {
                    if(response.authResponse) {
                        window.location.href = 'fbconnect.php';
                    } else {

                    }
                },{scope:'email'});
            }
        });
    }
    (function() {
        var e = document.createElement('script'); e.async = true;
        e.src = document.location.protocol + '//connect.facebook.net/en_US/all.js';
        document.getElementById('fb-root').appendChild(e);
    }());
    //]]>
</script>--%>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="mainmenu"/>
<tiles:insertAttribute name="slider"/>
<tiles:insertAttribute name="content"/>

<tiles:insertAttribute name="footer"/>

<p id="back-top">
    <a href="#top" title="Go to top"><img src="<c:url value="/resources/web/img/arrow.png"/>"/></a>
</p>
<%--<iframe src="https://www2.cbox.ws/box/?boxid=2382234&boxtag=faq8Xy" width="100%" height="450" allowtransparency="yes" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe>--%>
<script src="https://uhchat.net/code.php?f=a64d3d"></script>
<!-- Latest jQuery form server -->
<script src="<c:url value="/resources/web/js/jquery-1.8.3.min.js" />"></script>
<script src="<c:url value="/resources/web/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/web/js/owl.carousel.min.js" />"></script>
<script src="<c:url value="/resources/web/js/jquery.sticky.js" />"></script>
<script src="<c:url value="/resources/web/js/jquery.easing.1.3.min.js" />"></script>
<script src="<c:url value="/resources/web/js/main.js" />"></script>

<script src="<c:url value="/resources/web/js/jquery.elevatezoom.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/bxslider.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/script.slider.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.bootstrap-wizard.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/web/js/bootstrap-notify.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.sharrre.js" />"></script>
<script type="text/javascript">
    /*$("#zoomImg").elevateZoom();*/
    function checkNullOrEmpty(value) {
        return (!value || value == undefined || value == "" || value.length == 0);
    }
    $(document).ready(function () {
        $("#back-top").hide();

        $(function () {
            $(window).scroll(function () {
                if ($(this).scrollTop() > 300) {
                    $('#back-top').fadeIn();
                } else {
                    $('#back-top').fadeOut();
                }
            });

            // scroll body to 0px on click
            $('#back-top a').click(function () {
                $('body,html').animate({
                    scrollTop: 0
                }, 800);
                return false;
            });
        });


        var checkAction = '${msg}';
        var style = '${style}';
        if (checkAction.length > 0) {
            if (style == 'info') {
                showMsgInfo('top', 'center', checkAction);
            } else {
                showMsgError('top', 'center', checkAction);
            }
        }
        $('.cart_item').find("td:last").html();
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
        }else if(category === 'tim-kiem'){

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
    $('.linkSearch').click(function(){
        var keySearch =  $('input[name=keySearch]').val();
        var categoryId = $('input[name=categoryId]').val();
        var page = $(this).text();
        $('input[name=page]').val(page);
        $('#formSearch').submit();
        /*$.ajax({
            url: "tim-kiem",
            type: "POST",
            data: {
                keySearch:keySearch,
                categoryId:categoryId,
                page:page
            },
            success: function (data) {
                alert('vào');
            }
        });*/
    });

    $('#btnLoginModal').click(function(){
        $('#login-form-modal').submit();
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

    function showMsgInfo(froms, align, a) {
        type = ['info'];
        color = Math.floor((Math.random() * 6) + 1);
        $.notify({
            message: a
        }, {
            type: type[0],
            timer: 3000,
            placement: {
                from: froms,
                align: align
            }
        });
    }

    function showMsgError(froms, align, a) {
        type = ['danger'];
        $.notify({
            message: a
        }, {
            type: type[0],
            timer: 3000,
            placement: {
                from: froms,
                align: align
            }
        });
    }
</script>
</body>
</html>