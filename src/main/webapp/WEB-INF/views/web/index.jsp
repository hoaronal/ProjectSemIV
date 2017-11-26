<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

</style>
<div class="container">
    <div class="section">
        <div class="row">
            <%--<div class="col-md-6 col-md-offset-3 text-center menu-category">--%>
            <div class="col-md-8 col-md-offset-2 text-center">
                <ul class="nav nav-pills nav-pills-primary">
                    <li class="active">
                        <div class="dropdown">
                            <a class="btn btn-primary btn-round" id="dropdownMenu1" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="true">
                                Iphone
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="#">Iphone 4</a></li>
                                <li><a href="#">Iphone 4s</a></li>
                                <li><a href="#">Iphone 5</a></li>
                                <li><a href="#">Iphone 5s</a></li>
                                <li><a href="#">Iphone 6</a></li>
                                <li><a href="#">Iphone 6 plus</a></li>
                                <li><a href="#">Iphone 6s</a></li>
                                <li><a href="#">Iphone 6s plus</a></li>
                                <li><a href="#">Iphone 7</a></li>
                                <li><a href="#">Iphone 7 plus</a></li>
                                <li><a href="#">Iphone 8</a></li>
                                <li><a href="#">Iphone X</a></li>

                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown">
                            <a class="btn btn-primary btn-round" id="dropdownMenu2" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="true">
                                Dropdown
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown">
                            <a class="btn btn-primary btn-round" id="dropdownMenu3" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="true">
                                Dropdown
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown">
                            <a class="btn btn-primary btn-round" id="dropdownMenu4" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="true">
                                Dropdown
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown">
                            <a class="btn btn-primary btn-round" id="dropdownMenu5" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="true">
                                Dropdown
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu5">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row  text-center">
            <div class="col-md-4">
                <div class="info">
                    Quảng cáo 1
                </div>
            </div>
            <div class="col-md-4">
                <div class="info">
                    Quảng cáo 2
                </div>
            </div>
            <div class="col-md-4">
                <div class="info">
                    Quảng cáo 3
                </div>
            </div>
        </div>
        <div class="features text-center">
            <div class="row">
                <div class="col-md-4">
                    <div class="info">
                        <div class="icon " style="color:#00bcd4">
                            <i class="material-icons">local_shipping</i>
                        </div>
                        <h4 class="info-title">Giao hàng trong 2 ngày</h4>
                        <p>Divide details about your product or agency work into parts. Write a few lines about each
                            one. A paragraph describing a feature will be enough.</p>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="info">
                        <div class="icon icon-success">
                            <i class="material-icons">verified_user</i>
                        </div>
                        <h4 class="info-title">Chính sách hoàn lại tiền</h4>
                        <p>Divide details about your product or agency work into parts. Write a few lines about each
                            one. A paragraph describing a feature will be enough.</p>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="info">
                        <div class="icon icon-rose">
                            <i class="material-icons">favorite</i>
                        </div>
                        <h4 class="info-title">Đa dạng sản phẩm</h4>
                        <p>Divide details about your product or agency work into parts. Write a few lines about each
                            one. A paragraph describing a feature will be enough.</p>
                    </div>
                </div>

            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="card card-product" data-count="0">
                    <div class="card-image" data-header-animation="true">
                        <a href="" style="z-index:999">
                            <img class="img" src="<%=request.getContextPath()%>/resources/img/card-2.jpeg">
                        </a>
                    </div>
                    <div class="card-content">
                        <div class="card-actions" style="z-index:0">
                            <button type="button" class="btn btn-danger btn-simple fix-broken-card">
                                <i class="material-icons">build</i> Fix Header!
                            </button>
                            <button type="button" class="btn btn-default btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="View">
                                <i class="material-icons">art_track</i>
                            </button>
                            <button type="button" class="btn btn-success btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="Edit">
                                <i class="material-icons">edit</i>
                            </button>
                            <button type="button" class="btn btn-danger btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="Remove">
                                <i class="material-icons">close</i>
                            </button>
                        </div>
                        <h4 class="card-title">
                            <a href="http://demos.creative-tim.com/material-dashboard-pro/examples/dashboard.html#pablo">Cozy
                                5 Stars Apartment</a>
                        </h4>
                        <div class="card-description">
                            The place is close to Barceloneta Beach and bus stop just 2 min by walk and near to
                            "Naviglio" where you can enjoy the main night life in Barcelona.
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="price">
                            <h4>$899/night</h4>
                        </div>
                        <div class="stats pull-right">
                            <p class="category"><i class="material-icons">place</i> Barcelona, Spain</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card card-product" data-count="1">
                    <div class="card-image" data-header-animation="true">
                        <a href="" style="z-index:999">
                            <img class="img" src="<%=request.getContextPath()%>/resources/img/card-3.jpeg">
                        </a>
                    </div>
                    <div class="card-content">
                        <div class="card-actions" style="z-index:0">
                            <button type="button" class="btn btn-danger btn-simple fix-broken-card">
                                <i class="material-icons">build</i> Fix Header!
                            </button>
                            <button type="button" class="btn btn-default btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="View">
                                <i class="material-icons">art_track</i>
                            </button>
                            <button type="button" class="btn btn-success btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="Edit">
                                <i class="material-icons">edit</i>
                            </button>
                            <button type="button" class="btn btn-danger btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="Remove">
                                <i class="material-icons">close</i>
                            </button>
                        </div>
                        <h4 class="card-title">
                            <a href="http://demos.creative-tim.com/material-dashboard-pro/examples/dashboard.html#pablo">Office
                                Studio</a>
                        </h4>
                        <div class="card-description">
                            The place is close to Metro Station and bus stop just 2 min by walk and near to "Naviglio"
                            where you can enjoy the night life in London, UK.
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="price">
                            <h4>$1.119/night</h4>
                        </div>
                        <div class="stats pull-right">
                            <p class="category"><i class="material-icons">place</i> London, UK</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card card-product">
                    <div class="card-image" data-header-animation="true">
                        <a href="" style="z-index:999">
                            <img class="img" src="<%=request.getContextPath()%>/resources/img/card-1.jpeg">
                        </a>
                    </div>
                    <div class="card-content">
                        <div class="card-actions" style="z-index: 0">
                            <button type="button" class="btn btn-danger btn-simple fix-broken-card">
                                <i class="material-icons">build</i> Fix Header!
                            </button>
                            <button type="button" class="btn btn-default btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="View">
                                <i class="material-icons">art_track</i>
                            </button>
                            <button type="button" class="btn btn-success btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="Edit">
                                <i class="material-icons">edit</i>
                            </button>
                            <button type="button" class="btn btn-danger btn-simple" rel="tooltip"
                                    data-placement="bottom" title="" data-original-title="Remove">
                                <i class="material-icons">close</i>
                            </button>
                        </div>
                        <h4 class="card-title">
                            <a href="http://demos.creative-tim.com/material-dashboard-pro/examples/dashboard.html#pablo">Beautiful
                                Castle</a>
                        </h4>
                        <div class="card-description">
                            The place is close to Metro Station and bus stop just 2 min by walk and near to "Naviglio"
                            where you can enjoy the main night life in Milan.
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="price">
                            <h4>$459/night</h4>
                        </div>
                        <div class="stats pull-right">
                            <p class="category"><i class="material-icons">place</i> Milan, Italy</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="col-md-6">
                <div class="card card-raised card-background"
                     style="background-image: url(&#39;../assets/img/examples/office2.jpg&#39;)">
                    <div class="card-content">
                        <h6 class="category text-info">Worlds</h6>
                        <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                            <h3 class="card-title">The Best Productivity Apps on Market</h3>
                        </a>
                        <p class="card-description">
                            Don't be scared of the truth because we need to restart the human foundation in truth And I
                            love you like Kanye loves Kanye I love Rick Owens’ bed design but the back is...
                        </p>
                        <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                           class="btn btn-danger btn-round">
                            <i class="material-icons">format_align_left</i> Read Article
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card card-raised card-background"
                     style="background-image: url(&#39;../assets/img/examples/blog8.jpg&#39;)">
                    <div class="card-content">
                        <h6 class="category text-info">Business</h6>
                        <h3 class="card-title">Working on Wallstreet is Not So Easy</h3>
                        <p class="card-description">
                            Don't be scared of the truth because we need to restart the human foundation in truth And I
                            love you like Kanye loves Kanye I love Rick Owens’ bed design but the back is...
                        </p>
                        <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                           class="btn btn-primary btn-round">
                            <i class="material-icons">format_align_left</i> Read Article
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-md-12">
                <div class="card card-raised card-background"
                     style="background-image: url(&#39;../assets/img/examples/card-project6.jpg&#39;)">
                    <div class="card-content">
                        <h6 class="category text-info">Marketing</h6>
                        <h3 class="card-title">0 to 100.000 Customers in 6 months</h3>
                        <p class="card-description">
                            Don't be scared of the truth because we need to restart the human foundation in truth And I
                            love you like Kanye loves Kanye I love Rick Owens’ bed design but the back is...
                        </p>
                        <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                           class="btn btn-warning btn-round">
                            <i class="material-icons">subject</i> Read Case Study
                        </a>
                        <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                           class="btn btn-white btn-just-icon btn-simple" title="" rel="tooltip"
                           data-original-title="Save to Pocket">
                            <i class="fa fa-get-pocket"></i>
                        </a>

                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <!-- Pricing Plans Wrapper -->
            <div class="pricing-wrapper col-md-12">
                <!-- Pricing Plan -->
                <div class="pricing-plan">
                    <!-- Pricing Plan Ribbon -->
                    <div class="ribbon-wrapper">
                        <div class="price-ribbon ribbon-red">Popular</div>
                    </div>
                    <h2 class="pricing-plan-title">Starter</h2>
                    <p class="pricing-plan-price">FREE</p>
                    <!-- Pricing Plan Features -->
                    <ul class="pricing-plan-features">
                        <li><strong>1</strong> user</li>
                        <li><strong>Unlimited</strong> projects</li>
                        <li><strong>2GB</strong> storage</li>
                    </ul>
                    <a href="index.html" class="btn">Order Now</a>
                </div>
                <!-- End Pricing Plan -->
                <div class="pricing-plan">
                    <h2 class="pricing-plan-title">Advanced</h2>
                    <p class="pricing-plan-price">$49<span>/mo</span></p>
                    <ul class="pricing-plan-features">
                        <li><strong>10</strong> users</li>
                        <li><strong>Unlimited</strong> projects</li>
                        <li><strong>20GB</strong> storage</li>
                    </ul>
                    <a href="index.html" class="btn">Order Now</a>
                </div>
                <!-- Promoted Pricing Plan -->
                <div class="pricing-plan pricing-plan-promote">
                    <h2 class="pricing-plan-title">Premium</h2>
                    <p class="pricing-plan-price">$99<span>/mo</span></p>
                    <ul class="pricing-plan-features">
                        <li><strong>Unlimited</strong> users</li>
                        <li><strong>Unlimited</strong> projects</li>
                        <li><strong>100GB</strong> storage</li>
                    </ul>
                    <a href="index.html" class="btn">Order Now</a>
                </div>
                <div class="pricing-plan">
                    <!-- Pricing Plan Ribbon -->
                    <div class="ribbon-wrapper">
                        <div class="price-ribbon ribbon-green">New</div>
                    </div>
                    <h2 class="pricing-plan-title">Mega</h2>
                    <p class="pricing-plan-price">$199<span>/mo</span></p>
                    <ul class="pricing-plan-features">
                        <li><strong>Unlimited</strong> users</li>
                        <li><strong>Unlimited</strong> projects</li>
                        <li><strong>100GB</strong> storage</li>
                    </ul>
                    <a href="index.html" class="btn">Order Now</a>
                </div>
            </div>
            <!-- End Pricing Plans Wrapper -->
        </div>
    </div>


    <div class="section">
        <h3 class="title text-center">You may also be interested in</h3>
        <br>
        <div class="row">
            <div class="col-md-4">
                <div class="card card-plain card-blog">
                    <div class="card-image">
                        <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                            <img class="img img-raised" src="./Blog Posts _files/bg5.jpg">
                        </a>
                    </div>

                    <div class="card-content">
                        <h6 class="category text-info">Enterprise</h6>
                        <h4 class="card-title">
                            <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">Autodesk
                                looks to future of 3D printing with Project Escher</a>
                        </h4>
                        <p class="card-description">
                            Like so many organizations these days, Autodesk is a company in transition. It was until
                            recently a traditional boxed software company selling licenses.<a
                                href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                            Read More </a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card card-plain card-blog">
                    <div class="card-image">
                        <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                            <img class="img img-raised" src="./Blog Posts _files/blog5.jpg">
                        </a>
                    </div>
                    <div class="card-content">
                        <h6 class="category text-success">
                            Startups
                        </h6>
                        <h4 class="card-title">
                            <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">Lyft
                                launching cross-platform service this week</a>
                        </h4>
                        <p class="card-description">
                            Like so many organizations these days, Autodesk is a company in transition. It was until
                            recently a traditional boxed software company selling licenses.<a
                                href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                            Read More </a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card card-plain card-blog">
                    <div class="card-image">
                        <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                            <img class="img img-raised" src="./Blog Posts _files/blog6.jpg">
                        </a>
                    </div>

                    <div class="card-content">
                        <h6 class="category text-danger">
                            <i class="material-icons">trending_up</i> Enterprise
                        </h6>
                        <h4 class="card-title">
                            <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">6
                                insights into the French Fashion landscape</a>
                        </h4>
                        <p class="card-description">
                            Like so many organizations these days, Autodesk is a company in transition. It was until
                            recently a traditional boxed software company selling licenses.<a
                                href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                            Read More </a>
                        </p>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="team-5 section-image" style="background-image: url(&#39;../assets/img/bg10.jpg&#39;)">

    <div class="container">
        <div class="row">

            <div class="col-md-6">
                <div class="card card-profile card-plain">
                    <div class="col-md-5">
                        <div class="card-image">
                            <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                                <img class="img" src="./Blog Posts _files/card-profile1-square.jpg">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="card-content">
                            <h4 class="card-title">Alec Thompson</h4>
                            <h6 class="category text-muted">Author of the Month</h6>

                            <p class="card-description">
                                Don't be scared of the truth because we need to restart the human foundation in truth...
                            </p>

                            <div class="footer">
                                <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                                   class="btn btn-just-icon btn-simple btn-white"><i class="fa fa-twitter"></i></a>
                                <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                                   class="btn btn-just-icon btn-simple btn-white"><i class="fa fa-facebook-square"></i></a>
                                <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                                   class="btn btn-just-icon btn-simple btn-white"><i class="fa fa-google"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card card-profile card-plain">
                    <div class="col-md-5">
                        <div class="card-image">
                            <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo">
                                <img class="img" src="./Blog Posts _files/card-profile4-square.jpg">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="card-content">
                            <h4 class="card-title">Kendall Andrew</h4>
                            <h6 class="category text-muted">Author of the Week</h6>

                            <p class="card-description">
                                Don't be scared of the truth because we need to restart the human foundation in truth...
                            </p>

                            <div class="footer">
                                <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                                   class="btn btn-just-icon btn-simple btn-white"><i class="fa fa-linkedin"></i></a>
                                <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                                   class="btn btn-just-icon btn-simple btn-white"><i class="fa fa-facebook-square"></i></a>
                                <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                                   class="btn btn-just-icon btn-simple btn-white"><i class="fa fa-dribbble"></i></a>
                                <a href="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html#pablo"
                                   class="btn btn-just-icon btn-simple btn-white"><i class="fa fa-google"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>

<div class="subscribe-line">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h3 class="title">Get Tips &amp; Tricks every Week!</h3>
                <p class="description">
                    Join our newsletter and get news in your inbox every week! We hate spam too, so no worries about
                    this.
                </p>
            </div>
            <div class="col-md-6">
                <div class="card card-plain card-form-horizontal">
                    <div class="card-content">
                        <form method=""
                              action="http://demos.creative-tim.com/material-kit-pro/examples/blog-posts.html">
                            <div class="row">
                                <div class="col-md-8">

                                    <div class="input-group">
												<span class="input-group-addon">
													<i class="material-icons">mail</i>
												</span>
                                        <div class="form-group is-empty"><input type="email" value=""
                                                                                placeholder="Your Email..."
                                                                                class="form-control"><span
                                                class="material-input"></span></div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <button type="button" class="btn btn-primary btn-round btn-block">Subscribe</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<div id="left_ads_float">
    <a href="Link đường dẫn" target="_blank">
        <img border="0"
             src="http://3.bp.blogspot.com/-DFWCRf2oANg/UmDs8ZxWtiI/AAAAAAAAFC0/0Ecu36I5MgI/s1600/fptarena1.png"
             width="120"/></a>
</div>

<style>
    #left_ads_float {

        bottom: 50px;
        left: 30px;
        position: fixed;
    }
</style>

<script>
    var vtlai_remove_fads = false;

    function vtlai_check_adswidth() {
        if (vtlai_remove_fads) {
            document.getElementById('left_ads_float').style.display = 'none';
            return;
        } else if (document.cookie.indexOf('vtlai_remove_float_ads') != -1) {
            vtlai_remove_fads = true;
            vtlai_check_adswidth();
            return;
        } else {
            var lwidth = parseInt(document.body.clientWidth);
            if (lwidth < 1110) {
                document.getElementById('left_ads_float').style.display = 'none';
            } else {
                document.getElementById('left_ads_float').style.display = 'block';
            }
            setTimeout('vtlai_check_adswidth()', 10);
        }
    }
</script>