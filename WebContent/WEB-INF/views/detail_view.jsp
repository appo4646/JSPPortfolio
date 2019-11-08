<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	$('#btnReply').click(function(){
		
		console.log($('#replyNum').val());
		$('#rNum').attr("value","$('#replyNum').val()");
		console.log($('#rNum').val());
	});
	
	$(".btn-dialog").click(function() {
		var rnum = $(this).attr("data-rnum");
		$('#rNum').val(rnum);
	});	
	
	
});
</script>
<style>	
	body{
		background-color: @body-bg;
	}
 	div[class='carousel slide'] { 
 		left :300px;
 		border-radius: 20px; 
 		height : 500px; 
 		width : 500px; 
 	} 
 	div[class='carousel-inner'] { 
 		border-radius: 20px; 
 		height : 500px; 
 		width : 500px; 
 	} 
	img {
		height : 500px;
		width : 500px;
	}
</style>
</head>
<body>
<div class="container" style="text-align:center;">
			<div class="carousel slide" id="carousel-366663">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-366663" class="active">
					</li>
					<li data-slide-to="1" data-target="#carousel-366663">
					</li>
					<li data-slide-to="2" data-target="#carousel-366663">
					</li>
				</ol>
				<div class="carousel-inner">
				<c:forEach var="v" begin="0" end="${fileNames.size()-1}">
					
					<c:choose>
						<c:when test="${ v eq 0 }">
							<div class="carousel-item active">		
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
						</c:otherwise>
					</c:choose>
					
					
						<img class="d-block w-100" alt="Carousel Bootstrap" src="upload/${fileNames.get(v)}" alt="images/avatar.jpg">
					</div>
				</c:forEach>
					
				</div> <a class="carousel-control-prev" href="#carousel-366663" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-366663" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
				<a style="color:white;">
				<h3>
					<br>
					${vo.cSubject }
				</h3>
				<h6 style="text-align:right;">
					${vo.cDate }
				</h6>
				<p>
					${vo.cContent }
				</p>
				</a>
				<c:forEach var="user" items="${ list}">
					<a style="margin:20px;">
						<label>${user.userID }</label>
						<input type="hidden" id="replyNum" value="${user.rNum }">
						<label style="font-size:10px;">${user.rDate }</label>
						<button type="button" class="btn btn-danger btn-xs btn-dialog"  data-toggle="modal" data-target="#deleteReply"
							data-rnum="${user.rNum}" >Delete</button>
<!-- 						<button type="button" class="btn btn-danger btn-xs" data-toggle="modal" id="btndelete" data-target="#deleteReply" -->
<%-- 							data-rnum="${user.rNum}" onclick="pass_rNum();">Delete</button> --%>
						
						<br>
						<label>${user.userComment }</label><br>
					</a>	
				</c:forEach>
				<c:if test="${result eq false }">
					<div class="alert alert-danger alert-dismissible fade in">
					    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					    <strong>삭제 실패!</strong> 설정한 비밀번호와 일치하지 않습니다.
					</div>
				</c:if>
		<form action="reply_run.dong?cnum=${vo.cNum }" method="post">
			<div class="form-group">
				<label>
			 		<input type="text" class="form-control" name="userID" placeholder="ID">
			  		<input type="password" class="form-control" name="userPW" placeholder="PASSWORD">
		 		</label>
				<label>
					<textarea class="form-control" rows="4" name="userComment" style="width:500px" placeholder="Your comment is your face."></textarea>
				</label>
				<label>
					<button type="submit" class="btn btn-primary" id="btnReply">Reply</button>
				</label>
				<label>
					<button type="button" class="btn btn-success" id="btnReply" onclick="location.href='main.dong'">List</button>
				</label>
			</div>
		</form>
		
<!-- 		deleteReply -->


	

	<div id="deleteReply" data-rnum="" class="modal fade" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	    	<form action="delete_reply_run.dong?" method="post">
				<div class="form-group">
					<label for="InputPassword"><ft>PASSWORD</<ft></label>
					<input type="hidden" name = "cNum" value="${vo.cNum }">
					<input type="hidden" name = "rNum" id="rNum" > 
					<input type="password" class="form-control" id="inputPass" name="deletePW"/>
				</div>
				<button type="submit" class="btn btn-primary" id="btnDelete">
					Delete
				</button>
			</form>
		</div>
	</div>
<!-- 	// deleteReply -->
</div>	
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.poptrox.min.js"></script>
    <script src="assets/js/skel.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>