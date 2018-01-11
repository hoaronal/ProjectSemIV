<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="footer-top-area">

    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="footer-about-us">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.658525935219!2d105.78126931418022!3d21.0463449925554!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab3b4220c2bd%3A0x1c9e359e2a4f618c!2sB%C3%A1ch+Khoa+Aptech!5e0!3m2!1svi!2s!4v1514883151171" width="250" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">Điều hướng</h2>
                    <ul>
                        <li><a href="#">Tài khoản</a></li>
                        <li><a href="<%=request.getContextPath()%>/dat-hang/lich-su-dat-hang">Lịch sử đặt hàng</a></li>
                        <li><a href="<%=request.getContextPath()%>/gio-hang">Giỏ hàng</a></li>
                        <li><a href="#">Liên hệ nhà cung cấp</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">Danh mục</h2>
                    <ul>
                        <li class="phone"><a href="<%=request.getContextPath()%>/san-pham/dien-thoai/1">Điện thoại</a></li>
                        <li class="pc"><a href="<%=request.getContextPath()%>/san-pham/may-tinh/1">Máy tính</a></li>
                        <li class="laptop"><a href="<%=request.getContextPath()%>/san-pham/lap-top/1">Laptop</a></li>
                        <li class="accessories"><a href="<%=request.getContextPath()%>/san-pham/phu-kien/1">Phụ kiện</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-newsletter">
                    <h2 class="footer-wid-title">Đăng kí nhận mail</h2>
                    <p>Đăng kí nhận mail từ chúng tôi để nhận những thông tin khuyến mãi sớm nhất.</p>
                    <div class="newsletter-form">
                        <form action="#">
                            <input type="email" placeholder="Nhập email của bạn">
                            <input type="submit" value="Đăng kí">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End footer top area -->

<div class="footer-bottom-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="copyright">
                    <p>&copy; 2018 All Rights Reserved.</p>
                </div>
            </div>

            <%--<div class="col-md-4">
                <div class="footer-card-icon">
                    <i class="fa fa-cc-discover"></i>
                    <i class="fa fa-cc-mastercard"></i>
                    <i class="fa fa-cc-paypal"></i>
                    <i class="fa fa-cc-visa"></i>
                </div>
            </div>--%>
        </div>
    </div>
</div> <!-- End footer bottom area -->