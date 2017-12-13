<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar" data-active-color="rose" data-background-color="black" data-image="<%=request.getContextPath()%>/resources/img/sidebar-1.jpg">

    <div class="logo">
        <a href="http://www.creative-tim.com/" class="simple-text">
            I-Store Manager
        </a>
    </div>
    <div class="logo logo-mini">
        <a href="http://www.creative-tim.com/" class="simple-text">
            I-S
        </a>
    </div>
    <div class="sidebar-wrapper ps-container ps-theme-default ps-active-y"
         data-ps-id="5bc7479d-70af-7121-f583-0993c4c36241">
        <div class="user">
            <div class="photo">
                <img src="<%=request.getContextPath()%>/resources/img/avatar.png">
            </div>
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    Tania Andrew
                    <b class="caret"></b>
                </a>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li>
                            <a href="">My Profile</a>
                        </li>
                        <li>
                            <a href="">Edit Profile</a>
                        </li>
                        <li>
                            <a href="">Settings</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <ul class="nav">
            <li class="active">
                <a href="<%=request.getContextPath()%>/quan-tri">
                    <i class="material-icons">dashboard</i>
                    <p>Trang chủ</p>
                </a>
            </li>
            <li>
                <a data-toggle="collapse" href="#pagesExamples" class="collapsed" aria-expanded="false">
                    <i class="material-icons">group</i>
                    <p>Quản trị viên
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="pagesExamples" aria-expanded="false" style="height: 0px;">
                    <ul class="nav">
                        <li class="active">
                            <a href="">Danh sách</a>
                        </li>
                        <li>
                            <a href="">Thêm mới</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li>
                <a data-toggle="collapse" href="#componentsExamples">
                    <i class="material-icons">perm_data_setting</i>
                    <p>Quản trị hệ thống
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="componentsExamples">
                    <ul class="nav">
                        <li>
                            <a href="">Buttons</a>
                        </li>
                        <li>
                            <a href="">Grid System</a>
                        </li>
                        <li>
                            <a href="">Panels</a>
                        </li>
                        <li>
                            <a href="">Sweet Alert</a>
                        </li>
                        <li>
                            <a href="">Notifications</a>
                        </li>
                        <li>
                            <a href="">Icons</a>
                        </li>
                        <li>
                            <a href="">Typography</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li>
                <a data-toggle="collapse" href="#formsExamples">
                    <i class="material-icons">widgets</i>
                    <p>Báo cáo thống kê
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="formsExamples">
                    <ul class="nav">
                        <li>
                            <a href="">Thống kê doanh số</a>
                        </li>
                        <li>
                            <a href="">Thống kê sản phẩm</a>
                        </li>
                    </ul>
                </div>
            </li>
        </ul>
        <div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
            <div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div>
        </div>
        <div class="ps-scrollbar-y-rail" style="top: 0px; height: 538px; right: 0px;">
            <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 397px;"></div>
        </div>
    </div>
    <div class="sidebar-background" style="background-image: url(<%=request.getContextPath()%>/resources/img/sidebar-1.jpg) ">
    </div>
</div>