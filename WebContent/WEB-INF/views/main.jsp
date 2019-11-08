<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DS 606 - Seven's JSP Project </title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
// function myFunction(){
//     var x = document.getElementById("myFile");
//     if ('files' in x) {
//         if (x.files.length == 0) {
//         	alert("파일이 선택되지 않았습니다.");
//         } else{
//         	for (var i = 0; i < x.files.length; i++){
//         		var file = x.files[i];
//         		var fileName = file.name;
//         		console.log("fileName = " + fileName);
// 	        	$(this).prev().val(fileName);
//         	}
//         }
//     } else {
//     	if (x.value ==""){
//     		alert("파일이 선택되지 않았습니다.");
//     	} else {
//     		alert("이 파일은 업로드가 불가능 합니다.")
//     	}
//     }   
// }
$(document).ready(function(){
	$(".InputFile").on('click','.addFile', function(){
		$(this).prev().trigger("click");
	});
		
	
	
		var i = 1;
	$("input[name=plusFile]").click(function(){
		console.log("btnclick");
		var target = $('input[name=cfile]').last();
		var btnAddFile = $('input[name=addFile]').last();
		var realPath = $('input[name=realFiles]').last();
		realPath.clone().attr('name',"realFiles" + (i)).appendTo($("div[class=InputFile]"));
		target.clone().attr('name',"cfile" + (i)).appendTo($("div[class=InputFile]"));
		btnAddFile.clone().attr('name',"addFile" + (i)).appendTo($("div[class=InputFile]"));
		i++;
	});
	
	$('.thumbnails > div').click(function(e) {
			e.preventDefault();
			console.log($(this));
			$("#popupDisplay").css('display', 'block');
// 			var img = $(this).next().attr('src');
// 			var text = $(this).next().next().text();
// 			console.log(img);
// 			console.log(text);
	});
	
	$('#btnSearch').click(function(){
		console.log("click");
		var searchType = $('select[name=searchType]').val();
		console.log(searchType);
		var searchValue = $('input[name=searchValue]').val();
		console.log(searchValue);
		
		location.href="main.dong?searchType=" + searchType + "&searchValue=" + searchValue ;
	})
});
</script>
<style>
	p {
 		text-align: right; 
		padding : 10px ;
		margin : 10px auto;
	}
	ft {
		color : black;
		font-size : 20px;
		padding : 10px ;
		margin : 10px auto;
	}
	form[role='form']{
	     border-radius: 10px;
	     padding : 10px;
		 background-color: white;
    }
    div[class='col-md-4']{
    	text-align: center;
		color: white;    	
    	width: 300px;
    	border-radius: 5px;
    	padding: 0px;
    	margin: 10px auto;
    	margin-right: 10px;
    }
    img{
    	border-radius: 5px;
    	width: 300px;
    }
}
</style>
<script>
</script>
</head>
<p>
	<c:set var="word" value="${ result }"></c:set>
	<c:choose>
		<c:when test="${word.equals('success')}">
			<span class="label label-success">주인장 로그인중&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" 
					class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal2">글쓰기</button>
			<button type="button" class="btn btn-danger btn-lg" onclick="location.href='main.dong'" >Logout</button>
		</c:when>
		<c:otherwise>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Login</button>
		</c:otherwise>
	</c:choose>
</p>

  <!-- Modal -->
  
  <div class="modal fade"  id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
    	<form action="login.dong" method="post" role="form">
			<div class="form-group" >
				<label for="InputId" ><ft>ID</ft></label>
				<input type="text" class="form-control" id="inputID" name="myID" />
			</div>
			<div class="form-group">
				<label for="InputPassword"><ft>PASSWORD</<ft></label>
				<input type="password" class="form-control" id="inputPass" name="myPass"/>
			</div>
			<button type="submit" class="btn btn-primary" id="btnLogin">
				Login
			</button>
		</form>
    </div>
  </div>
  
  <!-- // Modal -->

		<!-- Wrapper -->
		
			<div id="wrapper">

				<!-- Header -->
				
					<header id="header">
						
						<span class="avatar"><img src="images/airplane.jpg" alt="" /></span>
						<h1>This is <strong>BBang's Blog</strong>, welcome to visit my blog ! <a href="main.dong?result=${result }"><br />Here </a>
						is My own Place and i record my social activity and something about that i hope in here.</h1>
						<ul class="icons">
							<li><a href="https://twitter.com/surrender_hs" class="icon style2 fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="mailto:appo4646@naver.com" class="icon style2 fa-envelope-o"><span class="label">Email</span></a></li>
						</ul>
					</header>
					
				<!-- //Header -->	

				<!-- Main -->
				
<section id="main">
					
<div class="container-fluid" style="width:950px">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					 <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
					</button> <a class="navbar-brand" href="main.dong?result=${result }">Main</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
							<a href="main.dong?page=1&searchType=diary">Diary</a>
						</li>
						<li>
							<a href="main.dong?page=1&searchType=travel">Travel</a>
						</li>
						<li>
							<a href="main.dong?page=1&searchType=review">Review</a>
						</li>
						<li>
							<a href="main.dong?page=1&searchType=follow">Follow</a>
						</li>
						
						<li class="dropdown">
							<div class="form-group">
								<select class="form-control" name="searchType" style="margin-top:10px;">
								    <option value="diary">Diary</option>
								    <option value="travel">Travel</option>
								    <option value="review">Review</option>
								    <option value="follow">Follow</option>
								</select>
							</div>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" id="txtSubject" name="searchValue"/><br>
						</div> 
						<button type="button" id="btnSearch" class="btn btn-default">
							Search
						</button>
					</form>
				</div>
			</nav>
		</div>
	</div>
</div>
		<!-- //Main -->

		<!-- Thumbnails -->
		
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<c:forEach var="vo" items="${list }">
					<a href="detail_view.dong?cnum=${vo.cNum }">
					<div class="col-md-4">
						<div class="card">
							<c:choose>
								<c:when test="${empty vo.cFile }">
									<img src="images/avatar.jpg" >
								</c:when>
								<c:otherwise>
									<img src="upload/${vo.cFile}" alt="images/avatar.jpg" >
								</c:otherwise>
							</c:choose>
							<div class="card-block">
								<h5 class="card-title">
									${vo.cSubject }
								</h5>
							</div>
						</div>
					</div>
					</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</section>

	<!-- // thumbnails -->

				<!-- Footer -->

			
	<!-- 글쓰기 폼 -->
	
	<div class="modal fade" id="myModal2" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	    	<form action="write_run.dong" method="post" role="form" enctype="multipart/form-data">
	    		<select class="form-control" name="ctype">
	    			<option value="diary"><ft>DIARY</ft></option>
	    			<option value="travel"><ft>TRAVEL</ft></option>
	    			<option value="review"><ft>REVIEW</ft></option>
	    			<option value="follow"><ft>FOLLOW</ft></option>
	    		</select>
				<div class="form-group" >
					<label for="subject" ><ft>SUBJECT</ft></label>
					<input type="text" class="form-control" id="inputSubject" name="csubject"/>
				</div>
				<div class="form-group">
					<label for="content"><ft>CONTENT</<ft></label>
					<textarea rows="10" cols="10" name="ccontent" ></textarea>
				</div>
				<div class="InputFile">
<!-- 					<input type="hidden" id="filePath" name="realFiles" value=""> -->
				    <input type="file" id="myfile" name="cfile" style="display:none;" accept=".gif, .jpg, .png" multiple>
				    <input type="button" class="addFile" name="addFile" value="파일첨부">
				</div>
				<div class="addFile">
				    <input type="button" name="plusFile" value="첨부파일 추가">
				</div>
				<button type="submit" class="btn btn-primary" id="btnWrite" >
					WRITE
				</button>
				<button type="button" class="btn btn-primary" onclick="location.href='main.dong?result=success'" >
					CANCEL
				</button>
			</form>
	    </div>
	</div>
  	
	<!--  // 글쓰기 폼 -->
	
	<!-- page 변경 버튼 -->
	<div class="pagingbtn" style="text-align:center;">
		<ul class="pagination" >
			<li>
				<c:if test="${pagingDTO.nowPage gt PagingDTO.PAGE_BLOCK }">
					<a href="main.dong?&page=${pagingDTO.startPage - 1}&searchType=${searchDTO.searchType }&searchValue=${ searchDTO.searchValue}">&laquo;</a>
				</c:if>
			</li>
			<li>
				<c:forEach var ="i" begin="${pagingDTO.startPage}" end="${pagingDTO.endPage }" >
					<a href="main.dong?&page=<c:out value="${i}"/>&searchType=${searchDTO.searchType }&searchValue=${ searchDTO.searchValue}">
					<c:out value="${i }"/></a>
				</c:forEach>
			</li>
			<li>
				<c:if test="${pagingDTO.endPage lt pagingDTO.totalPage }">
					<a href="main.dong?&page=${pagingDTO.endPage + 1}&searchType=${searchDTO.searchType }&searchValue=${ searchDTO.searchValue}">&raquo;</a>
				</c:if>
			</li>
		</ul>
	</div>

	<!-- // page 변경 버튼 -->
	
	<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.poptrox.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
<!-- 			<script src="assets/js/main.js"></script> -->

</body>
</html>