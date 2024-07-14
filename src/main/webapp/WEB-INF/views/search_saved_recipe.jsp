<%-- 
    Document   : search
    Created on : Sep 26, 2022, 4:37:50 PM
    Author     : trung
--%>

<%@page import="bakeryRecipe.recipe_tbl.Recipe_tblDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Search</title>
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
        <c:set var="searchValue" value="${param.txtSearchValue}"/>

        <!--        <form action="MainController">
                    Search value <input type="text" name="txtSearchValue" value="${searchValue}"/>
                    <input type="submit" value="Search" name="btAction"/>
                </form><br/>-->

        <!-- Preloader Start Here -->
        <div id="preloader"></div>
        <!-- Preloader End Here -->
        <!-- ScrollUp Start Here -->
        <a href="#wrapper" data-type="section-switch" class="scrollup">
            <i class="fas fa-angle-double-up"></i>
        </a>
        <!-- ScrollUp End Here -->
        <div id="wrapper" class="wrapper">
            <!-- Header start here-->
            <c:set var="user" value="${sessionScope.USER}"></c:set>
            <c:if test="${empty user}">
                <%@include file="header.html" %>
            </c:if>
            <c:if test="${not empty user}">
                <jsp:include page="header_user.jsp"></jsp:include>
            </c:if>
            <!-- Header end here-->

            <!-- Inne Page Banner Area Start Here -->
            <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="breadcrumbs-area">
                                <h1>Search Your Recipes</h1>
                                <ul>
                                    <li>
                                        <a href="index.html">Home</a>
                                    </li>
                                    <li>All Recipes</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Inne Page Banner Area End Here -->

            <!-- Recipe Without Sidebar Area Start Here -->
            <section class="recipe-without-sidebar-wrap padding-top-80 padding-bottom-22">
                <div class="container">
                    <div class="adv-search-wrap">
                        <div class="input-group">
                            <form action="searchSavedRecipeController" style="width: 100% !important;    display: flex !important;    justify-content: center !important;">
                                <input type="text" class="form-control" placeholder="Author Name or Recipe Search . . ." name="txtSearchValue" value="${searchValue}"/>

                                <div class="btn-group" style="display: inline-block">                            
                                    <div class="input-group-btn">
                                        <input type="submit" value="Search" name="btAction" class="btn-search"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="row">
                        <c:if test="${empty searchValue}">
                            <p>
                                No record is matched!
                            </p>
                        </c:if>
                        <c:if test="${not empty searchValue}">
                            <%--<c:set var="searchResult" value="${requestScope.SEARCH_RESULT}"/>--%>
                            <c:set var="recipeList" value="${requestScope.SEARCH_RESULT}"></c:set>
                            <c:if test="${empty recipeList}">
                                </br><h2>No record is matched!</h2>
                            </c:if>
                            <c:if test="${not empty recipeList}">
                                <c:forEach var="recipeDto" items="${recipeList}">
                                    <c:set var="category" value="${recipeDto.category}"/>
                                    <c:set var="image" value="${recipeDto.image}"/>
                                    <c:url var="single_recipe_url" value="displaySingleRecipe">
                                        <c:param name="recipeId" value="${recipeDto.recipeId}"/>
                                    </c:url>
                                    <%--<c:url var="remove_recipe_url" value="removeRecipeController">--%>
                                    <%--<c:param name="recipeId" value="${recipeDto.recipeId}"/>--%>
                                    <%--<c:param name="userId" value="${sessionScope.USER.userId}"/>--%>
                                    <%--</c:url>--%>

                                    <div class="col-lg-4 col-md-6 col-sm-6 col-12">
                                        <div class="product-box-layout1">
                                            <figure class="item-figure">
                                                <a href="${single_recipe_url}">
                                                    <img class="search-recipe-image" src=${image.imgLink} alt="Product">
                                                </a>
                                            </figure>
                                            <div class="item-content">
                                                <span class="sub-title">${category.name}</span>
                                                <h3 class="item-title"><a href="${single_recipe_url}">${recipeDto.name}</a></h3>
                                                <div class="item-rating">
                                                    <span>${recipeDto.createdDate}</span>
                                                </div>
                                                <p>${recipeDto.description}</p>
                                                <ul class="entry-meta">
                                                    <li><a href="#"><i class="fas fa-clock"></i>${recipeDto.totalTime} Mins</a></li>                                    
                                                    <li><a href="#"><i class="fas fa-heart"></i><span>${recipeDto.likedCount}</span> Likes</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <%--<c:if test="${not empty searchResult}">--%>              
                            <%--<c:forEach var="recipeDto" items="${searchResult}" varStatus="counter">--%>
                            <%--<c:set var="recipeName" value="${recipeDto.name}"/>--%>
                            <%--<c:set var="description" value="${recipeDto.description}"/>--%>
                            <%--<c:set var="author" value="${recipeDto.authorInfo}"/>--%>
                            <%--<c:set var="category" value="${recipeDto.category}"/>--%>
                            <%--<c:set var="image" value="${recipeDto.image.imgLink}"/>--%>                                    
                            <%--<c:set var="totalTime" value="${recipeDto.totalTime}"/>--%>
                            <%--<c:set var="likedCount" value="${recipeDto.likedCount}"/>--%>                                    
                            <%--<c:url var="single_recipe_url" value="DisplaySingleRecipe">--%>
                            <%--<c:param name="recipeId" value="${recipeDto.recipeId}"/>--%>
                            <%--</c:url>--%>

                            <!--                                    <div class="col-lg-4 col-md-6 col-sm-6 col-12">
                                                                    <div class="product-box-layout1">
                                                                        <figure class="item-figure">
                                                                            <a href=${single_recipe_url}>
                                                                                <img src=${image} alt="Recipe"></a>
                                                                        </figure>
                                                                        <div class="item-content">
                                                                            <span class="sub-title">${category.name}</span>
                                                                            <h3 class="item-title">
                                                                                <a href="single-recipe1.html">${recipeName}</a>
                                                                            </h3>
                            
                                                                            <p>${description} </p>
                                                                            <ul class="entry-meta">
                                                                                <li><a href="#"><i class="fas fa-clock"></i>${totalTime} minute</a></li>
                                                                                <li><a href="#"><i class="fas fa-user"></i>by <span>${author.fullName}</span></a></li>
                                                                                <li><a href="#"><i class="fas fa-heart"></i>${likedCount} Likes</a></li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </div>-->
                            <%--</c:forEach>--%>

                            <%--</c:if>--%>


                        </c:if>


                    </div>
                </div>
            </section>
            <!-- Recipe Without Sidebar Area End Here -->

            <!-- Footer Area Start Here -->
            <%@include file="footer.html" %>
            <!-- Footer Area End Here -->
        </div>
        <!-- Modal Start-->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="title-default-bold mb-none">Login</div>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <c:url var="login_url" value="loginPage"></c:url>
                        <c:url var="register_url" value="registerPage"></c:url>
                            <form class="login-form" action="login_url"  method="post" id="loginform">
                                <!--                            <input class="main-input-box" name="txtUsername" type="text" placeholder="User Name" />-->

                                <!--                            <input class="main-input-box" name="txtPassword" type="password" placeholder="Password" />-->

                                <div class="inline-box mb-5 mt-4">
                                    <!--                                <div class="checkbox checkbox-primary">
                                                                        <input id="modal-checkbox" type="checkbox">
                                                                        <label for="modal-checkbox">Remember Me</label>
                                                                    </div>-->
                                    <!--                                <label class="lost-password"><a href="#">Lost your password?</a></label>-->
                                </div>
                                <div class="inline-box mb-5 mt-4">
                                    <a href="${login_url}">Login</a>
                                <!--<a href="registration.jsp" name="Register" class="btn-register"><i class="fas fa-user"></i>Register Here!</a>-->
                                <!--                                <button type="button" class="login-btn" data-toggle="modal" data-target="#myModal2">
                                                                    <i class="flaticon-profile"></i>register here
                                                                </button>-->
                                <!--                                <div class="inline-box mb-5 mt-4">
                                                                    <button class="btn-fill" type="submit" value="Register1" name="btAction">register</button>
                                                                </div>-->
                                <a href="${register_url}">Register</a>
                            </div>
                        </form>
                        <label>Login connect with your Social Network</label>
                        <div class="login-box-social">
                            <ul>
                                <li><a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="#" class="twitter"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#" class="linkedin"><i class="fab fa-linkedin-in"></i></a></li>
                                <li><a href="#" class="google"><i class="fab fa-google-plus-g"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal End-->

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
