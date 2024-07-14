<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Left Side Bar</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon -->
        <link rel="shortcut icon" href="/img/favicon.png">
        <!-- Normalize Css -->
        <link rel="stylesheet" href="/css/normalize.css">
        <!-- Main Css -->
        <link rel="stylesheet" href="/css/main.css">
        <!-- Bootstrap Css -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="/css/animate.min.css">
        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="/css/fontawesome-all.min.css">
        <!-- Flaticon CSS -->
        <link rel="stylesheet" href="/fonts/flaticon.css">
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="/css/owl.carousel.min.css">
        <link rel="stylesheet" href="/css/owl.theme.default.min.css">
        <!-- Custom Css -->
        <link rel="stylesheet" href="/css/style.css">
        <!--ThongNT custom css-->
        <link rel="stylesheet" href="/css/custom/homepage.css">
    </head>
    <body>    
    <div class="col-lg-3 sidebar-widget-area sidebar-break-md">        
        <!--Own profile-->
        <c:set var="profile_result" value="${sessionScope.MOST_RECIPE_PROFILE}"/>                    
        <c:set var="followers_result" value="${sessionScope.MOST_RECIPE_PROFILE_FOLLOWERS}"/>
        <c:set var="following_result" value="${sessionScope.MOST_RECIPE_PROFILE_FOLLOWING}"/>
        <div class="widget left-side-most-recipes">          
            <c:if test="${ not empty profile_result}">
            <div class="section-heading heading-dark">
                <div style="display: flex; flex-direction: column; align-items: center;">
                    <img src="${profile_result.avatar}" alt="Blog Author" class="rounded-circle media-img-auto"
                         style="width: 50%; height: 50%">
                    <div style="display: flex; flex-direction: column; margin-left: 10px; margin-top: 20px">
                        <h2 class="author-title" style="text-align: center; overflow-wrap: anywhere;">${profile_result.username}
                        </h2>
<!--                        <p><b>${followers_result}</b> Followers <b style="margin-left: 20px">${following_result}</b> Following</p>-->
                        <p style="margin-bottom: 0"><b>Followers</b><b style="margin-left: 10px">Following</b></p>
                        <p><span style="margin-left: 25px">${followers_result}</span><span style="margin-left: 80px">${following_result}</span></p>
                    </div>
                    <div style="width: 100%; text-align: center">
                        <form action="displayOtherUserProfileController">
                            <button class="custom-btn-anhdh" style="padding: 5px; width: 100%"><i class="fas fa-user"></i>&nbsp;View Profile</button>
                            <input class="" type="hidden" name="authorID" value="${profile_result.userId}">
                        </form>
                    </div>
                </div>
            </div>
            </c:if>
            
            <c:set var="profileList" value="${sessionScope.USER_MOST_FOLLOW_LIST}"></c:set>
            <div class="widget-latest">                    
                <ul class="block-list">                        
                    <div class="section-heading heading-dark">
                        <h3 class="item-heading">SUGGESTIONS</h3>
                    
                    <c:forEach var="profileDto" items="${profileList}" varStatus="counter">
                        <c:set var="author" value="${recipeDto.authorInfo}"/>
                        <c:set var="category" value="${recipeDto.category}"/>
                        <c:set var="image" value="${recipeDto.image}"/>                                    
                        <li class="single-item" style="display: flex; align-items: center">
                            <img src="${profileDto.avatarUrl}" alt="Blog Author" class="rounded-circle media-img-auto"
                                 style="width: 20%; height: 20%">
                            <div style="display: flex; flex-direction: column; margin-left: 10px; margin-top: 20px; width: 60%">
                                <h5 class="author-title">${profileDto.fullName}
                                </h5>
                            </div>
                            <div style="width: 20%; text-align: center">
                            <form action="displayOtherUserProfileController">
                                <button class="custom-btn-anhdh" style="padding: 5px; width: 100%; margin-left: 30px"><i class="fas fa-user"></i></button>
                                <input class="" type="hidden" name="authorID" value="${profileDto.userId}">
                            </form>
                            </div>
                        </li>
                    </c:forEach>
                            </div>
                </ul>
            </div>
        </div>

        <c:set var="top10Tags" value="${sessionScope.top10Tags}"></c:set>

        <div class="widget right-side-top-5-tags">
            <div class="section-heading heading-dark">
                <h3 class="item-heading">POPULAR TAGS</h3>
            </div>
            <div class="widget-tag">
                <ul>
                    <c:forEach var="tagDto" items="${top10Tags}">
                        <li>
                            <a href="#${tagDto.id}">${tagDto.name}
                            </a>
                        </li> 
                    </c:forEach>
                </ul>
            </div>
        </div> 
    </div>


</body>
</html>
