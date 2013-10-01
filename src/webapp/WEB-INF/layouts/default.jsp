<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />		
	
    <link href="${res}/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${res}/jquery-ui/1.10.3/css/smoothness/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" />
    
    
	<spring:theme code="styleSheet" var="app_css" />	
	<link rel="stylesheet" type="text/css" media="screen" href="${res}/${app_css}" />
	<link rel="stylesheet" type="text/css" media="screen" href="${res}/css/app.css" />    

</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top"></div>

	<div class="container">			
		<tiles:insertAttribute name="body"/>		
	</div>

   	<script src="${res}/jquery/1.10.2/js/jquery-1.10.2.min.js"></script>
   	<script src="${res}/jquery-ui/1.10.3/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${res}/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
    		$(".datepicker" ).datepicker(    				
   				{dateFormat: "dd/mm/yy"}
    		);
  		});
	</script>
</body>
