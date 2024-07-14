<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Righ Side Bar</title>
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
        <!--Top 5 Recipes-->
        <div class="widget right-side-top-5-recipes" style="padding: 5px">          
            <div class="section-heading heading-dark">
                <h3 class="item-heading">TOP RECIPES</h3>
            </div>
            <div class="widget-latest">                    
                <ul class="block-list">                        
                    <c:set var="top5LikeRecipes" value="${sessionScope.top5LikeRecipes}"/>
                    <c:forEach var="recipeDto" items="${top5LikeRecipes}" varStatus="counter">
                        <c:set var="author" value="${recipeDto.user.profile}"/>
                        <c:set var="category" value="${recipeDto.category}"/>
                        <c:set var="image" value="${recipeDto.image}"/>
                        <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                            <c:param name="recipeId" value="${recipeDto.id}"/>
                        </c:url>                                        
                        <li class="single-item">
                            <div class="item-img">
                                <a href="${single_recipe_url}"><img src="${image.link}" alt="Post"></a>
                                <div class="count-number">${counter.count}</div>
                            </div>
                            <div class="item-content">
                                <div class="item-ctg">${category.name}</div>
                                <h4 class="item-title"><a href="${single_recipe_url}">${recipeDto.name}</a></h4>
                                <div class="item-post-by">
                                    <a href="#DisplayAuthorProfile"><i class="fas fa-user"></i><span>by</span>
                                        ${author.fullName}</a>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <!--Most View Recipes-->
        <div class="widget right-side-top-5-recipes" style="padding: 5px">          
            <div class="section-heading heading-dark">
                <h3 class="item-heading">MOST VIEW RECIPES</h3>
            </div>
            <div class="widget-latest">                    
                <ul class="block-list">                        
                    <c:set var="top3ViewRecipes" value="${sessionScope.top3ViewRecipes}"/>
                    <c:forEach var="recipe" items="${top3ViewRecipes}" varStatus="counter">
                        <c:set var="author" value="${recipe.user.profile}"/>
                        <c:set var="category" value="${recipe.category}"/>
                        <c:set var="image" value="${recipe.image}"/>
                        <c:set var="viewCount" value="${recipe.numOfView}"/>
                        <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                            <c:param name="recipeId" value="${recipe.id}"/>
                        </c:url>                                        
                        <li class="single-item">
                            <div class="item-img">
                                <a href="${single_recipe_url}"><img src="${image.link}" alt="Post"></a>
                                <div class="count-number">${counter.count}</div>
                            </div>
                            <div class="item-content">
                                <div class="item-ctg">${category.name}</div>
                                <h4 class="item-title"><a href="${single_recipe_url}">${recipe.name}</a></h4>
                                <div class="item-post-by">
                                    <a href="#DisplayAuthorProfile"><i class="fas fa-user"></i><span>by</span>
                                        ${author.fullName}</a>
                                </div>
                                <div class="">Views: ${viewCount}</div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <!--Category List-->
        <c:set var="categoryList" value="${sessionScope.allCategories}"></c:set>
        <div class="widget right-side-top-5-category">
            <div class="section-heading heading-dark">
                <h3 class="item-heading">CATEGORIES</h3>
            </div>
            <div class="widget-categories">
                <ul>
                    <c:forEach var="categoryDto" items="${categoryList}">
                        <li>
                            <a href="#${categoryDto.id}">${categoryDto.name}
                                <span>${categoryDto.numOfCategories}</span>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div> 

<!--        <c:set var="tagList" value="${sessionScope.All_TAG}"></c:set>

        <div class="widget right-side-top-5-tags">
            <div class="section-heading heading-dark">
                <h3 class="item-heading">POPULAR TAGS</h3>
            </div>
            <div class="widget-tag">
                <ul>
                    <c:forEach var="tagDto" items="${tagList}">
                        <li>
                            <a href="#${tagDto.tagId}">${tagDto.name}
                            </a>
                        </li> 
                    </c:forEach>
                </ul>
            </div>
        </div> -->
    </div>


</body>
</html>
