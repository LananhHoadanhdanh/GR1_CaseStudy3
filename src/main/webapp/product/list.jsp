<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Twitter Bootstrap shopping cart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- Customize styles -->
    <link href="style.css" rel="stylesheet"/>
    <!-- font awesome styles -->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!--[if IE 7]>
    <link href="css/font-awesome-ie7.min.css" rel="stylesheet">
    <![endif]-->

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Favicons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
</head>
<body>
<!--
Upper Header Section
-->
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="topNav">
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
                        <li class=""><a href="/">Trang chủ</a></li>
                        <li class="active"><a href="/list-view">Tất cả sản phẩm</a></li>
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
    <!--
    Body Section
    -->
    <div class="row">
        <div id="sidebar" class="span3">
            <div class="well well-small">
                <h3>Danh mục sản phẩm</h3>
                <ul class="nav nav-list">
                    <c:forEach items="${listCategory}" var="category">
                        <li class="${tag == category.id ? "active":""}"><a href="category?cid=${category.id}">
                    <span class="icon-chevron-right">
                            ${category.name}
                    </span>
                        </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="well well-small">
                <h3>Sản phẩm theo thể loại</h3>
                <ul class="nav nav-list">
                    <c:forEach items="${listBrand}" var="brand">
                        <li><a href="brand?bid=${brand.id}"><span class="icon-chevron-right"> ${brand.name}</span></a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <ul class="nav nav-list promowrapper">
                <c:forEach var="product" items="${upComingProducts}">
                    <li>
                        <div class="thumbnail">
                            <a class="zoomTool" href="product_details.html" title="add to cart"><span
                                    class="icon-search"></span> QUICK VIEW</a>

                            <img src="${product.image}" alt="">
                            <div class="caption">
                                <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
                                        class="pull-right">${product.price}</span>
                                </h4>
                            </div>
                        </div>
                    </li>
                    <li style="border:0"> &nbsp;</li>
                </c:forEach>

                <%--        <li>--%>
                <%--            <div class="thumbnail">--%>
                <%--                <a class="zoomTool" href="product_details.html" title="add to cart"><span--%>
                <%--                        class="icon-search"></span> QUICK VIEW</a>--%>
                <%--                <img src="assets/img/shopping-cart-template.PNG" alt="shopping cart template">--%>
                <%--                <div class="caption">--%>
                <%--                    <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span--%>
                <%--                            class="pull-right">$22.00</span>--%>
                <%--                    </h4>--%>
                <%--                </div>--%>
                <%--            </div>--%>
                <%--        </li>--%>
                <%--        <li style="border:0"> &nbsp;</li>--%>
                <%--        <li>--%>
                <%--            <div class="thumbnail">--%>
                <%--                <a class="zoomTool" href="product_details.html" title="add to cart"><span--%>
                <%--                        class="icon-search"></span> QUICK VIEW</a>--%>
                <%--                <img src="assets/img/bootstrap-template.png" alt="bootstrap template">--%>
                <%--                <div class="caption">--%>
                <%--                    <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span--%>
                <%--                            class="pull-right">$22.00</span>--%>
                <%--                    </h4>--%>
                <%--                </div>--%>
                <%--            </div>--%>
                <%--        </li>--%>
            </ul>
        </div>
        <div class="span9">
            <!--
            New Products
            -->
            <div class="well well-small">
                <h3>Our Products </h3>
                <div class="row-fluid">
                    <ul class="thumbnails">
                        <c:forEach var="product" items="${products}">
                            <li class="span4" style="margin: 0px !important; padding: 5px">
                                <div class="thumbnail">
                                    <a href="?action=product-detail&id=${product.id}" class="overlay"></a>
                                    <a class="zoomTool" href="?action=product-detail&id=${product.id}" title="add to cart"><span
                                            class="icon-search"></span> QUICK VIEW</a>
                                    <a href="?action=product-detail&id=${product.id}"><img src="${product.image}" alt=""></a>
                                    <div class="caption cntr">
                                        <h3>${product.name}</h3>
                                        <p style="display: inline !important;"><strong> ${product.price}</strong></p>
                                        <span style="padding: 5px !important; font-weight: bold !important;">VNĐ</span><br>
                                        <span  style="font-weight: bold !important; padding: 5px !important;">Số lượng: </span>
                                        <span><strong> ${product.quantity}</strong></span>
                                        <h4><a class="shopBtn" href="/login" title="add to cart"> Add to cart </a></h4>
                                        <br class="clr">
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--
    Footer
    -->
    <footer class="footer">
        <div class="row-fluid">
            <div class="span2">
                <h5>Liên kết</h5>
                <a href="">Trang chủ</a><br>
                <a href="/list-view">Tất cả sản phẩm</a><br>
                <a href="?action=huong-dan-mua-hang">Hướng dẫn mua hàng</a><br>
                <a href="?action=gioi-thieu">Giới thiệu</a><br>
            </div>
            <div class="span2">
                <h5>Chính sách hỗ trợ</h5>
                <a href="#">Tìm kiếm</a><br>
                <a href="#">Giới thiệu</a><br>
                <a href="#">Chính sách thanh toán</a><br>
                <a href="#">Chính sách vận chuyển</a><br>
            </div>
            <div class="span2">
                <%--                <h5>Our Offer</h5>--%>
                <%--                <a href="#">NEW PRODUCTS</a> <br>--%>
                <%--                <a href="#">TOP SELLERS</a><br>--%>
                <%--                <a href="#">SPECIALS</a><br>--%>
                <%--                <a href="#">MANUFACTURERS</a><br>--%>
                <%--                <a href="#">SUPPLIERS</a> <br/>--%>
            </div>
            <div class="span6">
                <h5>The standard chunk of Lorem</h5>
                The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for
                those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et
                Malorum" by Cicero are also reproduced in their exact original form,
                accompanied by English versions from the 1914 translation by H. Rackham.
            </div>
        </div>
    </footer>
</div><!-- /container -->

<div class="copyright">
    <div class="container">
        <p class="pull-right">
            <a href="#"><img src="assets/img/maestro.png" alt="payment"></a>
            <a href="#"><img src="assets/img/mc.png" alt="payment"></a>
            <a href="#"><img src="assets/img/pp.png" alt="payment"></a>
            <a href="#"><img src="assets/img/visa.png" alt="payment"></a>
            <a href="#"><img src="assets/img/disc.png" alt="payment"></a>
        </p>
        <span>Copyright &copy; 2013<br> bootstrap ecommerce shopping template</span>
    </div>
</div>
<a href="http://localhost:8080/" class="gotop"><i class="icon-double-angle-up"></i></a>
<!-- Placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.easing-1.3.min.js"></script>
<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
<script src="assets/js/shop.js"></script>
</body>
</html>

