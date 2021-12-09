<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2021
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
                    <a href="#"><span class="icon-user"></span> Hello ${acc.username}</a>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <a href="/login"><span class="icon-edit"></span> Đăng nhập</a>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <a href="/register"><span class="icon-edit"></span> Đăng kí</a>
                </c:if>
                <a href="contact.html"><span class="icon-envelope"></span> Liên lạc</a>
                <c:if test="${sessionScope.acc != null && acc.roleId == 2}">
                    <a class="active" href="Cart?action=def&username=${acc.username}"><span class="icon-shopping-cart"></span> Giỏ hàng<span
                            class="badge badge-warning"></span></a>
                </c:if>
            </div>
        </div>
    </div>
</div>

<!--
Lower Header Section
-->
<div class="container">
    <div id="gototop"> </div>
    <header id="header">
        <div class="row">
            <div class="span4">
                <h1>
                    <a class="logo" href="http://localhost:8080"><span>Twitter Bootstrap ecommerce template</span>
                        <img src="assets/img/logo-bootstrap-shoping-cart.png" alt="bootstrap sexy shop">
                    </a>
                </h1>
            </div>
            <div class="span4">
            </div>
            <div class="span4 alignR">
                <p><br> <strong> Support (24/7) :  0800 1234 678 </strong><br><br></p>
                <span class="btn btn-mini">[ 2 ] <span class="icon-shopping-cart"></span></span>
                <span class="btn btn-warning btn-mini">$</span>
                <span class="btn btn-mini">&pound;</span>
                <span class="btn btn-mini">&euro;</span>
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
                        <li class="active"><a href="?action=home">Trang chủ </a></li>
                        <c:if test="${sessionScope.acc != null && sessionScope.acc.roleId == 1}">
                            <li class=""><a href="/products?action=create">Thêm sản phẩm mới</a></li>
                        </c:if>
                        <c:if test="${sessionScope.acc != null && sessionScope.acc.roleId == 1}">
                            <li class=""><a href="/products?action=addCategory">Thêm danh mục</a></li>
                        </c:if>
                        <c:if test="${sessionScope.acc != null && sessionScope.acc.roleId == 1}">
                            <li class=""><a href="/products?action=addBrand">Thêm nhãn hiệu</a></li>
                        </c:if>
                        <c:if test="${sessionScope.acc == null || sessionScope.acc.roleId == 2}">
                            <li class=""><a href="/?action=huong-dan-mua-hang">Hướng dẫn mua hàng</a></li>
                            <li class=""><a href="/?action=gioi-thieu">Giới thiệu</a></li>
                        </c:if>
                    </ul>
                    <form action="#" class="navbar-search pull-right">
                        <input type="text" placeholder="Search" class="search-query span2">
                        <button>Search</button>
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
                        <li class="${tag == category.id ? "active":""}"><a href="/?action=show-product-by-category&cid=${category.id}">
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
                        <li class="${tagBrand == brand.id ? "active":""}"><a href="/?action=show-product-by-brand&bid=${brand.id}"><span
                                class="icon-chevron-right"> ${brand.name}</span></a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
            <br>
            <br>
            <ul class="nav nav-list promowrapper">
                <c:forEach var="product" items="${upComingProducts}">
                    <li>
                        <div class="thumbnail">
                            <a class="zoomTool" href="/products?action=view&id=${product.id}" title="add to cart"><span
                                    class="icon-search"></span> QUICK VIEW</a>

                            <img src="${product.image}" alt="">
                            <div class="caption">
                                <h4><a class="defaultBtn" href="/products?action=view&id=${product.id}">VIEW</a> <span
                                        class="pull-right">${product.price}</span>
                                </h4>
                            </div>
                        </div>
                    </li>
                    <li style="border:0"> &nbsp;</li>
                </c:forEach>
            </ul>
        </div>
        <div class="span9">
            <ul class="breadcrumb">
                <li><a href="http://localhost:8080">Trang chủ</a> <span class="divider">/</span></li>
                <li class="active">Thêm danh mục</li>
            </ul>

            <h3>Thêm danh mục, loại sản phẩm</h3>
            <hr class="soft"/>
            <div class="well">
                <form class="form-horizontal" method="post">
                    <div class="control-group">
                        <label class="control-label" for="name">Tên danh mục<sup>*</sup></label>
                        <div class="controls">
                            <input type="text" id="name" name="name" placeholder="name">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <input type="submit" name="submitAccount" value="Thêm danh mục" class="exclusive shopBtn">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--
    Clients
    -->
    <section class="our_client">
        <hr class="soften"/>
        <h4 class="title cntr"><span class="text">Manufactures</span></h4>
        <hr class="soften"/>
        <div class="row">
            <div class="span2">
                <a href="#"><img alt="" src="assets/img/1.png"></a>
            </div>
            <div class="span2">
                <a href="#"><img alt="" src="assets/img/2.png"></a>
            </div>
            <div class="span2">
                <a href="#"><img alt="" src="assets/img/3.png"></a>
            </div>
            <div class="span2">
                <a href="#"><img alt="" src="assets/img/4.png"></a>
            </div>
            <div class="span2">
                <a href="#"><img alt="" src="assets/img/5.png"></a>
            </div>
            <div class="span2">
                <a href="#"><img alt="" src="assets/img/6.png"></a>
            </div>
        </div>
    </section>

    <!--
    Footer
    -->
    <footer class="footer">
        <div class="row-fluid">
            <div class="span2">
                <h5>Your Account</h5>
                <a href="#">YOUR ACCOUNT</a><br>
                <a href="#">PERSONAL INFORMATION</a><br>
                <a href="#">ADDRESSES</a><br>
                <a href="#">DISCOUNT</a><br>
                <a href="#">ORDER HISTORY</a><br>
            </div>
            <div class="span2">
                <h5>Iinformation</h5>
                <a href="contact.html">CONTACT</a><br>
                <a href="#">SITEMAP</a><br>
                <a href="#">LEGAL NOTICE</a><br>
                <a href="#">TERMS AND CONDITIONS</a><br>
                <a href="#">ABOUT US</a><br>
            </div>
            <div class="span2">
                <h5>Our Offer</h5>
                <a href="#">NEW PRODUCTS</a> <br>
                <a href="#">TOP SELLERS</a><br>
                <a href="#">SPECIALS</a><br>
                <a href="#">MANUFACTURERS</a><br>
                <a href="#">SUPPLIERS</a> <br/>
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
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
<!-- Placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.easing-1.3.min.js"></script>
<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
<script src="assets/js/shop.js"></script>
</body>
</html>


