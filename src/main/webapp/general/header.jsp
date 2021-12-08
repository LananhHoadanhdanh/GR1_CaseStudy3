<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
Upper Header Section
-->
<div class="container">
    <div class="alignR">
        <a class="active" href="http://localhost:8080"> <span class="icon-home"></span> Trang chủ</a>
        <c:if test="${sessionScope.acc != null}">
            <a href="/logout"><span class="icon-edit"></span> Đăng xuất</a>
            <a href="#"><span class="icon-user"></span>Hello ${acc.username}</a>
        </c:if>
        <c:if test="${sessionScope.acc == null}">
            <a href="/login"><span class="icon-edit"></span> Đăng nhập</a>
        </c:if>
        <a href="/register"><span class="icon-edit"></span> Đăng kí</a>
        <a href="contact.html"><span class="icon-envelope"></span> Liên lạc</a>
        <a class="active" href="product/cart.jsp"><span class="icon-shopping-cart"></span> Giỏ hàng<span
                class="badge badge-warning"></span></a>
    </div>
</div>
</div>
</div>

<!--
Lower Header Section
-->
<div class="container">
    <div id="gototop"></div>
    <header id="header">
        <div class="row">
            <div class="span4">
                <h1>
                    <a class="logo" href="/login">
                        <img src="assets/img/logo-bootstrap-shoping-cart.png" alt="bootstrap sexy shop">
                    </a>
                </h1>
            </div>
            <div class="span4">
            </div>
            <div class="span4 alignR">
                <p><br> <strong> Hỗ trợ (24/7) : 088 1234 678 </strong><br><br></p>
            </div>
        </div>
    </header>

    <!--
    Navigation Bar Section
    -->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li class="active"><a href="">Trang chủ </a></li>
                        <li class=""><a href="/list-view">Tất cả sản phẩm</a></li>
                        <li class=""><a href="?action=huong-dan-mua-hang">Hướng dẫn mua hàng</a></li>
                        <li class=""><a href="?action=gioi-thieu">Giới thiệu</a></li>
                        <li class=""><a href="general.html">Tin tức</a></li>
                    </ul>
                    <form method="post" action="findByName" class="navbar-search pull-right">
                        <input type="text" placeholder="Search" class="search-query span2">
                        <input type="submit" value="Search">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
