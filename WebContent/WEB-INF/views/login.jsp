<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form">
				<div class="form-group">
					 
					<label for="InputId">
						Id
					</label>
					<input type="text" class="form-control" id="inputID" name="myID" />
				</div>
				<div class="form-group">
					 
					<label for="InputPassword">
						Password
					</label>
					<input type="password" class="form-control" id="inputPass" name="myPass"/>
				</div>
				<button type="submit" class="btn btn-primary" onclick="location.href='login_run.dong'">
					Login
				</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>