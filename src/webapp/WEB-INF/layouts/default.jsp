<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<spring:message code="datefield_regional" var="datefieldRegional"/>


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />		
	
    <link href="${res}/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${res}/jquery-ui/1.10.3/css/smoothness/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" />
    
    
	<spring:theme code="styleSheet" var="app_css" />	
	<link rel="stylesheet" type="text/css" media="screen" href="${res}/${app_css}" />
	<link rel="stylesheet" type="text/css" media="screen" href="${res}/css/app.css" />    

   	<script src="${res}/jquery/1.10.2/js/jquery-1.10.2.min.js"></script>
   	<script src="${res}/jquery-ui/1.10.3/js/jquery-ui-1.10.3.custom.min.js"></script>
   	<script src="${res}/jquery-ui/1.10.3/js/jquery-ui-i18n.min.js"></script>
	<script src="${res}/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
    		$(".datepicker" ).datepicker(    	    				
 				$.datepicker.regional[ "${datefieldRegional}" ]    			
    		);
  		});
	</script>

</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		
		<div class="container">	
			<ul class="nav navbar-nav navbar-left">
				<li><a href="${homeUrl}">Home</a></li>
				<li><a href="?lang=en_AU">en_AU</a></li>
				<li><a href="?lang=ru_RU">ru_RU</a></li>
				<li><a href="?theme=standart">Standart</a></li>
				<li><a href="?theme=green">Green</a></li>					
			</ul>			
		</div>
	</div>


	<div class="container">			
		<tiles:insertAttribute name="body"/>		
	</div>

</body>
