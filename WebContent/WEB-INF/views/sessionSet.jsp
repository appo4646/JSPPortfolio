<%@page import="com.ds.dao.ProjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	String id = request.getParameter("myID");
	String pw = request.getParameter("myPass");
	ProjectDAO dao = ProjectDAO.getInstance();
	boolean loginOk= dao.loginMyID(id, pw);
	if (loginOk == true){
		session.setAttribute("id", id);
	} 
%>
</body>
</html>