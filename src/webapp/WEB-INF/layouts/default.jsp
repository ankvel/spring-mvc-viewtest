<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />		
	
    <link href="${res}/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <%-- <link href="${res}/css/app.css" rel="stylesheet" /> --%>
    
    
	<spring:theme code="styleSheet" var="app_css" />	
	<link rel="stylesheet" type="text/css" media="screen" href="${res}/${app_css}" />    
    
	<style>			
		body {
			padding-top: 60px;
			padding-bottom: 40px;
		}
	</style>
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top"></div>

	<div class="container">			
		<tiles:insertAttribute name="body"/>		
	</div>

   	<script src="${res}/jquery/1.10.2/js/jquery.min.js"></script>
	<script src="${res}/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	
</body>
