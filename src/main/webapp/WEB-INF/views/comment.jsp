<%-- Document : top_recipe Created on : Sep 25, 2022, 5:19:05 PM Author : LamVo --%>

    <%@page import="bakeryRecipe.comment_tbl.Comment_tblDTO" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <%@taglib uri="jakarta.tags.core" prefix="c" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <title>Bakery Recipe - Comment</title>
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
                    <!-- Owl Carousel CSS -->
                    <link rel="stylesheet" href="css/owl.carousel.min.css">
                    <link rel="stylesheet" href="css/owl.theme.default.min.css">
                    <!-- Custom Css -->
                    <link rel="stylesheet" href="css/style.css">
                    <!-- Modernizr Js -->
                    <script src="js/modernizr-3.6.0.min.js"></script>
                </head>

                <body>
                    <c:set var="currentUser" value="${sessionScope.USER}"></c:set>
                    <c:set var="commentsList" value="${requestScope.COMMENTS_LIST}" />
                    <c:set var="recipeDto" value="${requestScope.RECIPE_INFO}" />
                    <c:if test="${not empty commentsList}">
                        <div class="recipe-reviews">
                            <div class="section-heading heading-dark">
                                <h2 class="item-heading">RECIPE COMMENTS</h2>
                            </div>
                            <div class="avarage-rating-wrap">
                                <div class="total-reviews">Total Comments: <span
                                        class="review-number">${commentsList.size()}</span></div>
                            </div>
                            <ul id="commentList">
                                <c:forEach var="commentDto" items="${commentsList}">
                                    <c:set var="userId" value="${commentDto.userId}" />
                                    <c:set var="fullName" value="${commentDto.fullName}" />
                                    <c:set var="avtUrl" value="${commentDto.avtUrl}" />
                                    <c:set var="commentDetail" value="${commentDto.commentDetail}" />
                                    <c:set var="createdDate" value="${commentDto.createdDate}" />
                                    <c:set var="lastModified" value="${commentDto.lastModified}" />

                                    <li class="reviews-single-item comment-element">
                                        <div class="media media-none--xs">
                                            <img src="${avtUrl}" alt="commenter-avatar" class="media-img-auto"
                                                style="height: 20%; width: 20%">
                                            <div class="media-body">
                                                <h4 class="comment-title">${fullName}</h4>

                                                <c:if test="${userId == currentUser.userId}">
                                                    <p class="d-none" id="comment-detail">${commentDetail}</p>
                                                    <button class="quantity-plus btn-edit" type="submit">Edit</button>
                                                    <p class="d-none">${commentDto.commentId}</p>
                                                    <button class="quantity-plus btn-delete"
                                                        type="submit">Delete</button>
                                                </c:if>
                                                <span class="post-date">${createdDate}</span>
                                                <p id="comment-detail-${commentDto.commentId}">${commentDetail}</p>
                                                <div>
                                                    <form class="d-none comment-edit-form-${commentDto.commentId}">
                                                        <input name="content" type="text" value="${commentDetail}" required >
                                                        <button type="submit">Save</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </li>


                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>




                    <div class="leave-review">
                        <div class="section-heading heading-dark">
                            <h2 class="item-heading">LEAVE A COMMENT</h2>
                        </div>
                        <!--            <div class="rate-wrapper">
                            <div class="rate-label">Like</div>
                            <div class="rate">
                                <div class="rate-item"><i class="fa fa-heart" aria-hidden="true"></i></div>
                            </div>
                        </div>-->
                        <form action="CreateNewComment" class="leave-form-box">
                            <div class="row">
                                <div class="col-12 form-group">
                                    <label>Comment :</label>
                                    <textarea placeholder="" class="textarea form-control" name="txtCommentContent"
                                        rows="7" cols="20" data-error="Message field is required" required></textarea>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <input type="hidden" name="txtRecipeId" value="${recipeDto.recipeId}">
                                <div class="col-12 form-group mb-0">
                                    <button type="submit" class="item-btn" value="Comment"
                                        name="btAction">COMMENT</button>
                                </div>
                            </div>
                            <div class="form-response"></div>
                        </form>
                    </div>

                    <!-- Jquery Js -->
                    <script src="js/jquery-3.3.1.min.js"></script>
                    <!-- Bootstrap Js -->
                    <script src="js/popper.min.js"></script>
                    <!-- Bootstrap Js -->
                    <script src="js/bootstrap.min.js"></script>
                    <!-- Plugins Js -->
                    <script src="js/plugins.js"></script>
                    <!-- Owl Carousel Js -->
                    <script src="js/owl.carousel.min.js"></script>
                    <!-- Smoothscroll Js -->
                    <script src="js/smoothscroll.min.js"></script>
                    <!-- Ajax JQuery Js -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
                    <!-- Custom Js -->
                    <script src="js/main.js"></script>
                    <!-- ThongNT JS -->
                    <script src="js/comment.js"></script>

                </body>

                </html>