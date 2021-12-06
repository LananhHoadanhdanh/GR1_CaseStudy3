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
                <div class="pull-left socialNw">
                    <a href="#"><span class="icon-twitter"></span></a>
                    <a href="#"><span class="icon-facebook"></span></a>
                    <a href="#"><span class="icon-youtube"></span></a>
                    <a href="#"><span class="icon-tumblr"></span></a>
                </div>
                <a class="active" href="http://localhost:8080"> <span class="icon-home"></span> Home</a>
                <a href="#"><span class="icon-user"></span> My Account</a>
                <a href="/login"><span class="icon-edit"></span>Login</a>
                <a href="/register"><span class="icon-edit"></span>Register</a>
                <a href="contact.html"><span class="icon-envelope"></span> Contact us</a>
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
                    <a class="logo" href="http://localhost:8080"><span>Twitter Bootstrap ecommerce template</span>
                        <img src="assets/img/logo-bootstrap-shoping-cart.png" alt="bootstrap sexy shop">
                    </a>
                </h1>
            </div>
            <div class="span4">
            </div>
            <div class="span4 alignR">
                <p><br> <strong> Support (24/7) : 0800 1234 678 </strong><br><br></p>
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
                        <li class="active"><a href="http://localhost:8080">Home </a></li>
                        <li class=""><a href="list-view.html">List View</a></li>
                        <li class=""><a href="grid-view.html">Grid View</a></li>
                        <li class=""><a href="three-col.html">Three Column</a></li>
                        <li class=""><a href="four-col.html">Four Column</a></li>
                        <li class=""><a href="general.html">General Content</a></li>
                    </ul>
                    <form action="#" class="navbar-search pull-right">
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
                <h3>Category</h3>
                <ul class="nav nav-list">
                    <li><a href="products.html"><span class="icon-chevron-right"></span>Figure</a></li>
                    <li><a href="products.html"><span class="icon-chevron-right"></span>Nendoroid</a></li>
                    <li><a href="products.html"><span class="icon-chevron-right"></span>Cosplay</a></li>
                    <li><a href="products.html"><span class="icon-chevron-right"></span>Accessory</a></li>
                </ul>
            </div>

    <div class="well well-small">
        <h3>Brand</h3>
        <ul class="nav nav-list">
            <li><a href="products.html"><span class="icon-chevron-right"></span>Naruto</a></li>
            <li><a href="products.html"><span class="icon-chevron-right"></span>Dragon Ball</a></li>
            <li><a href="products.html"><span class="icon-chevron-right"></span>Kimetsu no Yaiba</a></li>
            <li><a href="products.html"><span class="icon-chevron-right"></span>One Piece</a></li>
            <li><a href="products.html"><span class="icon-chevron-right"></span>Gundam</a></li>
        </ul>
    </div>

    <ul class="nav nav-list promowrapper">
        <li>
            <div class="thumbnail">
                <a class="zoomTool" href="product_details.html" title="add to cart"><span
                        class="icon-search"></span> QUICK VIEW</a>

                <img src="assets/img/bootstrap-ecommerce-templates.PNG" alt="bootstrap ecommerce templates">
                <div class="caption">
                    <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
                            class="pull-right">$22.00</span>
                    </h4>
                </div>
            </div>
        </li>
        <li style="border:0"> &nbsp;</li>
        <li>
            <div class="thumbnail">
                <a class="zoomTool" href="product_details.html" title="add to cart"><span
                        class="icon-search"></span> QUICK VIEW</a>
                <img src="assets/img/shopping-cart-template.PNG" alt="shopping cart template">
                <div class="caption">
                    <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
                            class="pull-right">$22.00</span>
                    </h4>
                </div>
            </div>
        </li>
        <li style="border:0"> &nbsp;</li>
        <li>
            <div class="thumbnail">
                <a class="zoomTool" href="product_details.html" title="add to cart"><span
                        class="icon-search"></span> QUICK VIEW</a>
                <img src="assets/img/bootstrap-template.png" alt="bootstrap template">
                <div class="caption">
                    <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span
                            class="pull-right">$22.00</span>
                    </h4>
                </div>
            </div>
        </li>
    </ul>

</div>
<div class="span9">
<div class="well np">
    <div id="myCarousel" class="carousel slide homCar">
        <div class="carousel-inner">
            <div class="item">
                <img style="width:100%" src="assets/img/bootstrap_free-ecommerce.png"
                     alt="bootstrap ecommerce templates">
                <div class="carousel-caption">
                    <h4>Bootstrap shopping cart</h4>
                    <p><span>Very clean simple to use</span></p>
                </div>
            </div>
            <div class="item">
                <img style="width:100%" src="assets/img/carousel1.png" alt="bootstrap ecommerce templates">
                <div class="carousel-caption">
                    <h4>Bootstrap Ecommerce template</h4>
                    <p><span>Highly Google seo friendly</span></p>
                </div>
            </div>
            <div class="item active">
                <img style="width:100%" src="assets/img/carousel3.png" alt="bootstrap ecommerce templates">
                <div class="carousel-caption">
                    <h4>Twitter Bootstrap cart</h4>
                    <p><span>Very easy to integrate and expand.</span></p>
                </div>
            </div>
            <div class="item">
                <img style="width:100%" src="assets/img/bootstrap-templates.png" alt="bootstrap templates">
                <div class="carousel-caption">
                    <h4>Bootstrap templates integration</h4>
                    <p><span>Compitable to many more opensource cart</span></p>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>
</div>
<!--
New Products
-->
<div class="well well-small">
<h3>New Products </h3>
<hr class="soften"/>
<div class="row-fluid">
<div id="newProductCar" class="carousel slide">
<div class="carousel-inner">
<div class="item active">
<ul class="thumbnails">
<c:forEach var="product" items="${newProducts}">
    <li class="span3">
    <div class="thumbnail">
    <a class="zoomTool" href="product_details.html"
    title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
    <a href="#" class="tag"></a>
    <a href="product_details.html"><img src="${product.image}" alt=""></a>
    </div>
    </li>
</c:forEach>
    </ul>
    </div>
    <div class="item">
    <ul class="thumbnails">
    <c:forEach var="product" items="${newProducts}">
        <li class="span3">
            <div class="thumbnail">
                <a class="zoomTool" href="product_details.html"
                   title="add to cart"><span
                        class="icon-search"></span> QUICK VIEW</a>
                <a href="product_details.html"><img src="${product.image}" alt=""></a>
            </div>
        </li>

    </c:forEach>
    </ul>
    </div>
    </div>
    <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
    <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
    </div>
    </div>
    <div class="row-fluid">
    <ul class="thumbnails">
    <c:forEach var="product" items="${topThreeProducts}">
        <li class="span4" style="margin: 0 !important; padding: 5px">
            <div class="thumbnail">
                <a class="zoomTool" href="product_details.html" title="add to cart"><span
                        class="icon-search"></span> QUICK VIEW</a>
                <a href="product_details.html"><img src="<c:out value="${product.image}"/>" alt=""></a>
                <div class="caption cntr">
                    <p>Manicure & Pedicure</p>
                    <p><strong> $22.00</strong></p>
                    <h4><a class="shopBtn" href="/Cart?action=addToCart&id=${product.id}" title="add to cart"> Add to
                        cart1000</a></h4>
                    <div class="actionList">
                        <a class="pull-left" href="#">Add to Wish List </a>
                        <a class="pull-left" href="#"> Add to Compare </a>
                    </div>
                    <br class="clr">
                </div>
            </div>

        </li>
    </c:forEach>
    </ul>

    </div>
    </div>
    <!--
    Featured Products
    -->
    <div class="well well-small">
    <h3><a class="btn btn-mini pull-right" href="products.html" title="View more">VIew More<span
    class="icon-plus"></span></a> Featured Products </h3>
    <hr class="soften"/>
    <div class="row-fluid">
    <ul class="thumbnails">
    <li class="span4">
    <div class="thumbnail">
    <a class="zoomTool" href="product_details.html" title="add to cart"><span
    class="icon-search"></span> QUICK VIEW</a>
    <a href="product_details.html"><img src="assets/img/d.jpg" alt=""></a>
    <div class="caption">
    <h5>Manicure & Pedicure</h5>
    <h4>
    <a class="defaultBtn" href="product_details.html" title="Click to view"><span
    class="icon-zoom-in"></span></a>
    <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>
    <span class="pull-right">$22.00</span>
    </h4>
    </div>
    </div>
    </li>
    <li class="span4">
    <div class="thumbnail">
    <a class="zoomTool" href="product_details.html" title="add to cart"><span
    class="icon-search"></span> QUICK VIEW</a>
    <a href="product_details.html"><img src="assets/img/e.jpg" alt=""></a>
    <div class="caption">
    <h5>Manicure & Pedicure</h5>
    <h4>
    <a class="defaultBtn" href="product_details.html" title="Click to view"><span
    class="icon-zoom-in"></span></a>
    <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>
    <span class="pull-right">$22.00</span>
    </h4>
    </div>
    </div>
    </li>
    <li class="span4">
    <div class="thumbnail">
    <a class="zoomTool" href="product_details.html" title="add to cart"><span
    class="icon-search"></span> QUICK VIEW</a>
    <a href="product_details.html"><img src="assets/img/f.jpg" alt=""/></a>
    <div class="caption">
    <h5>Manicure & Pedicure</h5>
    <h4>
    <a class="defaultBtn" href="product_details.html" title="Click to view"><span
    class="icon-zoom-in"></span></a>
    <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>
    <span class="pull-right">$22.00</span>
    </h4>
    </div>
    </div>
    </li>
    </ul>
    </div>
    </div>

    <div class="well well-small">
    <a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
    Popular Products
    </div>
    <hr>
    <div class="well well-small">
    <a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
    Best selling Products
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
    <h5>Information</h5>
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
