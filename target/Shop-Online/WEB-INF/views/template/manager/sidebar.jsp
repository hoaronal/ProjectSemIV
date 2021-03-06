<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar" data-active-color="rose" data-background-color="black"
     data-image="<%=request.getContextPath()%>/resources/img/sidebar-1.jpg">

    <div class="logo">
        <a href="<%=request.getContextPath()%>/quan-tri/" class="simple-text">
            I-Store Manager
        </a>
    </div>
    <div class="logo logo-mini">
        <a href="<%=request.getContextPath()%>/quan-tri/" class="simple-text">
            I-S
        </a>
    </div>
    <div class="sidebar-wrapper ps-container ps-theme-default ps-active-y"
         data-ps-id="5bc7479d-70af-7121-f583-0993c4c36241">
        <div class="user">
            <div class="photo">
                <a href="<%=request.getContextPath()%>/quan-tri/quan-tri-vien/thong-tin"><img
                        src="<%=request.getContextPath()%>/resources/img/avatar.png"></a>
            </div>
            <div class="info">
                <a href="<%=request.getContextPath()%>/quan-tri/quan-tri-vien/thong-tin">
                    Tania Andrew
                </a>
            </div>
        </div>
        <ul class="nav">
            <li id="homePage">
                <a href="<%=request.getContextPath()%>/quan-tri">
                    <i class="material-icons">dashboard</i>
                    <p>Trang chủ</p>
                </a>
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
                        <li id="listAdminClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/quan-tri-vien/1">
                                <span class="sidebar-normal">Danh sách quản trị viên </span>
                            </a>
                        </li>
                        <li id="listUserClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/nguoi-dung/1">
                                <span> Danh sách người dùng </span>
                            </a>
                        </li>
                        <li id="listProductClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/san-pham/1">
                                <span> Danh sách sản phẩm </span>
                            </a>
                        </li>
                        <li id="listCategoryClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/danh-muc/1">
                                <span> Danh sách danh mục </span>
                            </a>
                        </li>
                        <%--<li id="listRoleClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/danh-sach-quyen/1">
                                <span> Danh sách quyền </span>
                            </a>
                        </li>--%>
                        <li id="listAccessoriesClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/phu-kien/1">
                                <span> Danh sách phụ kiện </span>
                            </a>
                        </li>
                        <li id="listProvinceClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/tinh-thanh/1">
                                <span> Danh sách tỉnh thành</span>
                            </a>
                        </li>
                        <li id="listNewsClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/tin-tuc/1">
                                <span> Danh sách tin tức</span>
                            </a>
                        </li>
                        <li id="listOrderClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/don-hang/1">
                                <span> Danh sách đơn hàng</span>
                            </a>
                        </li>
                        <li id="listTransactionClass">
                            <a href="<%=request.getContextPath()%>/quan-tri/giao-dich/1">
                                <span> Danh sách giao dịch</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li id="reportClass">
                <a data-toggle="collapse" href="#reportExamples">
                    <i class="material-icons">widgets</i>
                    <p>Báo cáo thống kê
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="reportExamples">
                    <ul class="nav">
                        <li>
                            <a href="<%=request.getContextPath()%>/quan-tri/thong-ke-doanh-so">Thống kê doanh số</a>
                        </li>
                        <%--<li>
                            <a  data-toggle="collapse" href="#reportExam">
                                <p>Thống kê sản phẩm
                                    <b class="caret"></b>
                                </p></a>
                            <div class="collapse" id="reportExam">
                                <ul class="nav">
                                    <li>
                                        <a href="">Thống kê theo danh mục</a>
                                    </li>
                                </ul>
                            </div>
                        </li>--%>
                    </ul>
                </div>
            </li>
            <li id="listhistoryClass">
                <a href="<%=request.getContextPath()%>/quan-tri/lich-su-he-thong/1">
                    <i class="material-icons">history</i>
                    <p>Lịch sử hệ thống</p>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/quan-tri/sao-luu-du-lieu">
                    <i class="material-icons">backup</i>
                    <p>Sao lưu dữ liệu</p>
                </a>
            </li>
        </ul>
        <div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
            <div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div>
        </div>
        <div class="ps-scrollbar-y-rail" style="top: 0px; height: 538px; right: 0px;">
            <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 397px;"></div>
        </div>
    </div>
    <div class="sidebar-background"
         style="background-image: url(<%=request.getContextPath()%>/resources/img/sidebar-1.jpg) ">
    </div>
</div>