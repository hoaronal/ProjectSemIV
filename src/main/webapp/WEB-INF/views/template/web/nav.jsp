<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-primary navbar-transparent navbar-absolute">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>--%>
            <a class="navbar-brand" href="<%=request.getContextPath()%>/trang-chu" style="font-size: 30px">I-Store<span><i class="material-icons" style="color: red">favorite</i></span></a>
        </div>

        <div class="collapse navbar-collapse">
            <a style="color: white !important;" data-toggle="modal" data-target="#loginModal">
                        <span class="icon icon-info">
                            <i class="material-icons">group</i>
                        </span>
                Đăng nhập
                <div class="ripple-container"></div>
            </a>
            <a href="<%=request.getContextPath()%>/gio-hang"
               class="btn btn-white btn-simple">
                <i class="material-icons">shopping_cart</i> Giỏ hàng<span class="notification">5</span>
            </a>
        </div>
    </div>
</nav>