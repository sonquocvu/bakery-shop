<%-- 
    Document   : login
    Created on : Oct 4, 2022, 4:59:46 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<%@page import="bakeryRecipe.account_tbl.ResetPasswordError" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>

        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Bakery Recipe| Reset</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- Normalize Css -->
        <link rel="stylesheet" href="css/normalize.css">
        <!-- Main Css -->
        <link rel="stylesheet" href="css/main.css">
        <!-- Bootstrap Css -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.min.css">
        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/fontawesome-all.min.css">
        <!-- Flaticon CSS -->
        <link rel="stylesheet" href="fonts/flaticon.css">
        <!-- Custom Css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Modernizr Js -->
        <script src="js/modernizr-3.6.0.min.js"></script>

    </head>
    <body>
        

            <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->

            <!-- Add your site or application content here -->
            <!-- Preloader Start Here -->
            <div id="preloader"></div>
            <!-- Preloader End Here -->
            <!-- ScrollUp Start Here -->
            <a href="#wrapper" data-type="section-switch" class="scrollup">
                <i class="fas fa-angle-double-up"></i>
            </a>
            <!-- ScrollUp End Here -->
            <div id="wrapper" class="wrapper">

                <!-- Inne Page Banner Area Start Here -->
                <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <div class="breadcrumbs-area">
                                    <h1>User Reset Password Page</h1>
                                    <ul>
                                        <li>
                                            <a href=homePage id="btAction" value="Home">Home</a>
                                        </li>
                                        <li>reset</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Inne Page Banner Area End Here -->

                <!-- Login Area Start Here -->
                <section class="login-page-wrap padding-top-80 padding-bottom-50">
                    <div class="container">
                        <div class="row gutters-60">
                            <div class="col-lg-8">
                                <div class="login-box-layout1">
                                    <div class="section-heading heading-dark">
                                        <h2 class="item-heading">RESET PASSWORD FORM</h2>
                                    </div>
                                    <!--REGISTER FORM-->
                                    <c:set var="error" value="${requestScope.RESETPASSWOD_ERR}"></c:set>
                                        <form class="login-form" action="resetPasswordController"  method="post">
                                            <input class="main-input-box" name="txtOldPassword" type="password" placeholder="Old Password" required
                                                   oninvalid="this.setCustomValidity('Enter password Here')"
                                                   oninput="this.setCustomValidity('')"/>
                                        <c:if test="${not empty error.oldPasswordWrongErr}">
                                            <font color="red">${error.oldPasswordWrongErr}</font></br>
                                        </c:if> 

                                        <input class="main-input-box" name="txtNewPassword" type="password" placeholder="New Password" required
                                               oninvalid="this.setCustomValidity('Enter password Here')"
                                               oninput="this.setCustomValidity('')"/>
                                        <c:if test="${not empty error.newPasswordFormatErr}">
                                            <font color="red">${error.newPasswordFormatErr}</font></br>
                                        </c:if> 
                                        <c:if test="${not empty error.newPasswordSameAsErr}">
                                            <font color="red">${error.newPasswordSameAsErr}</font></br>
                                        </c:if> 

                                        <input class="main-input-box" name="txtConfirm" type="password" placeholder="Confirm" required
                                               oninvalid="this.setCustomValidity('Enter Confirm password Here')"
                                               oninput="this.setCustomValidity('')"/>
                                        <c:if test="${not empty error.confirmNotMathched}">
                                            <font color="red">${error.confirmNotMathched}</font></br>
                                        </c:if>   






                                        <div class="inline-box mb-5 mt-4">
                                            <button class="btn btn-danger" style="font-size: 1.5rem" type="submit" >Reset Password</button>

                                        </div>
                                    </form>

                                </div>
                            </div>


                        </div>
                    </div>
                </section>
                <!-- Login Area End Here -->

            </div>

            <!-- Jquery Js -->
            <script src="js/jquery-3.3.1.min.js"></script>
            <!-- Bootstrap Js -->
            <script src="js/popper.min.js"></script>
            <!-- Bootstrap Js -->
            <script src="js/bootstrap.min.js"></script>
            <!-- Plugins Js -->
            <script src="js/plugins.js"></script>
            <!-- Smoothscroll Js -->
            <script src="js/smoothscroll.min.js"></script>
            <!-- Custom Js -->
            <script src="js/main.js"></script>
        
    </body>
</html>
