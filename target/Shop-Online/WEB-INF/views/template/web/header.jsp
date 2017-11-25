
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul>
                        <li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                        <li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
                        <li><a href="cart.html"><i class="fa fa-user"></i> My Cart</a></li>
                        <li><a href="checkout.html"><i class="fa fa-user"></i> Checkout</a></li>
                        <li><a href="#"><i class="fa fa-user"></i> Login</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-4">
                <div class="header-right">
                    <ul class="list-unstyled list-inline">
                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">USD</a></li>
                                <li><a href="#">INR</a></li>
                                <li><a href="#">GBP</a></li>
                            </ul>
                        </li>

                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">English</a></li>
                                <li><a href="#">French</a></li>
                                <li><a href="#">German</a></li>
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
                    <h1><a href="./"><img src="<%=request.getContextPath()%>/resources/img/logo.png"></a></h1>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="shopping-item">
                    <a href="cart.html">Cart - <span class="cart-amunt">$100</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End site branding area -->
<div class="mainmenu-area">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">

                <ul class="main-navigation">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Front End Design</a>
                        <ul style="margin-top:2px">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a>
                                <ul style="margin-top:2px">
                                    <li><a href="#">Resets</a></li>
                                    <li><a href="#">Grids</a></li>
                                    <li><a href="#">Frameworks</a></li>
                                </ul>
                            </li>
                            <li><a href="#">JavaScript</a>
                                <ul style="margin-top:2px">
                                    <li><a href="#">Ajax</a></li>
                                    <li><a href="#">jQuery</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="#">WordPress Development</a>
                        <ul style="margin-top:2px">
                            <li><a href="#">Themes</a></li>
                            <li><a href="#">Plugins</a></li>
                            <li><a href="#">Custom Post Types</a>
                                <ul>
                                    <li><a href="#">Portfolios</a></li>
                                    <li><a href="#">Testimonials</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Options</a></li>
                        </ul>
                    </li>
                    <li><a href="#">About Us</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>