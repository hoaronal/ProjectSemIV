<%@ page contentType="text/html;charset=UTF-8"%>
<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul>
                        <li><a href="#"><i class="fa fa-cog"></i> My Account</a></li>
                        <li><a href="#"><i class="fa fa-money"></i> Checkout</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-log-in"></i> Login</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-4">
                <div class="header-right">
                    <ul class="list-unstyled list-inline">
                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">English</a></li>
                                <li><a href="#">Vietnamese</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End header area -->

<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="logo">
                    <h1><a href="<%=request.getContextPath()%>/">Dream-Shop</a></h1>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="shopping-item">
                    <a href="<%=request.getContextPath()%>/gio-hang"><i class="fa fa-shopping-cart"></i> <span class="product-count"><%=request.getSession().getAttribute("NUM_IN_CART")%></span></a>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End site branding area -->