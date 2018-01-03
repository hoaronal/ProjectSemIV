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

    function testAPI() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            var imgLink = get_avatar_from_service('facebook',response.id , 'square');
            alert(imgLink);
        });
    }

    function statusChangeCallback(response) {
        if (response.status === 'connected') {
            var accessToken = response.authResponse.accessToken;
            testAPI();

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
<div style="position:fixed; z-index:9999999; right:10px; bottom:10px;" class="fb-page" data-tabs="messages" data-href="https://www.facebook.com/Shop-online-139809593375175/" data-width="250" data-height="300" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false"<%-- data-show-facepile="true" --%>data-show-posts="false"></div>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="mainmenu"/>
<tiles:insertAttribute name="slider"/>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>

<p id="back-top">
    <a href="#top" title="Go to top"><img src="<c:url value="/resources/web/img/arrow.png"/>"/></a>
</p>
<%--<iframe src="https://www2.cbox.ws/box/?boxid=2382234&boxtag=faq8Xy" width="100%" height="450" allowtransparency="yes" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe>--%>
<%--<script src="https://uhchat.net/code.php?f=a64d3d"></script>--%>

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

    function get_avatar_from_service(service, userid, size) {
        // this return the url that redirects to the according user image/avatar/profile picture
        // implemented services: google profiles, facebook, gravatar, twitter, tumblr, default fallback
        // for google   use get_avatar_from_service('google', profile-name or user-id , size-in-px )
        // for facebook use get_avatar_from_service('facebook', vanity url or user-id , size-in-px or size-as-word )
        // for gravatar use get_avatar_from_service('gravatar', md5 hash email@adress, size-in-px )
        // for twitter  use get_avatar_from_service('twitter', username, size-in-px or size-as-word )
        // for tumblr   use get_avatar_from_service('tumblr', blog-url, size-in-px )
        // everything else will go to the fallback
        // google and gravatar scale the avatar to any site, others will guided to the next best version
        var url = '';

        switch (service) {

            case "google":
                // see http://googlesystem.blogspot.com/2011/03/unedited-google-profile-pictures.html (couldn't find a better link)
                // available sizes: all, google rescales for you
                url = "http://profiles.google.com/s2/photos/profile/" + userid + "?sz=" + size;
                break;

                square
            case "facebook":
                // available sizes: square (50x50), small (50xH) , normal (100xH), large (200xH)
                var sizeparam = '';
                if (isNumber(size)) {
                    if (size >= 200) {
                        sizeparam = 'large'
                    };
                    if (size >= 100 && size < 200) {
                        sizeparam = 'normal'
                    };
                    if (size >= 50 && size < 100) {
                        sizeparam = 'small'
                    };
                    if (size < 50) {
                        sizeparam = 'square'
                    };
                } else {
                    sizeparam = size;
                }
                url = "https://graph.facebook.com/" + userid + "/picture?type=" + sizeparam;
                break;
            case "gravatar":
                url = "http://www.gravatar.com/avatar/" + userid + "?s=" + size
                break;
            case "twitter":
                var sizeparam = '';
                if (isNumber(size)) {
                    if (size >= 73) {
                        sizeparam = 'bigger'
                    };
                    if (size >= 48 && size < 73) {
                        sizeparam = 'normal'
                    };
                    if (size < 48) {
                        sizeparam = 'mini'
                    };
                } else {
                    sizeparam = size;
                }
                url = "http://api.twitter.com/1/users/profile_image?screen_name=" + userid + "&size=" + sizeparam;
                break;
            case "tumblr":
                var sizeparam = '';
                if (size >= 512) {
                    sizeparam = 512
                };
                if (size >= 128 && size < 512) {
                    sizeparam = 128
                };
                if (size >= 96 && size < 128) {
                    sizeparam = 96
                };
                if (size >= 64 && size < 96) {
                    sizeparam = 64
                };
                if (size >= 48 && size < 64) {
                    sizeparam = 48
                };
                if (size >= 40 && size < 48) {
                    sizeparam = 40
                };
                if (size >= 30 && size < 40) {
                    sizeparam = 30
                };
                if (size >= 24 && size < 30) {
                    sizeparam = 24
                };
                if (size < 24) {
                    sizeparam = 16
                };
                url = "http://api.tumblr.com/v2/blog/" + userid + "/avatar/" + sizeparam;
                break;
            default:
                // http://www.iconfinder.com/icondetails/23741/128/avatar_devil_evil_green_monster_vampire_icon
                url = "http://i.imgur.com/RLiDK.png"; // 48x48
        }
        return url;
    }


    // helper methods

    function isNumber(n) {
        // see http://stackoverflow.com/questions/18082/validate-numbers-in-javascript-isnumeric
        return !isNaN(parseFloat(n)) && isFinite(n);
    }
</script>
</body>
</html>