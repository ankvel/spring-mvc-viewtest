<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<spring:message code="datefield_regional" var="datefieldRegional"/>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />		
	
    <link href="${resVen}/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${resVen}/jquery-ui/1.10.3/css/smoothness/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" />
    
    
	<spring:theme code="styleSheet" var="app_css" />	
	<link rel="stylesheet" type="text/css" media="screen" href="${res}/${app_css}" />
	<link rel="stylesheet" type="text/css" media="screen" href="${res}/css/app.css" />    

   	<script src="${resVen}/jquery/1.10.2/js/jquery-1.10.2.min.js"></script>
   	<script src="${resVen}/jquery-ui/1.10.3/js/jquery-ui-1.10.3.custom.min.js"></script>
   	<script src="${resVen}/jquery-ui/1.10.3/js/jquery-ui-i18n.min.js"></script>
	<script src="${resVen}/bootstrap/3.0.0/js/bootstrap.min.js"></script>	
	<script src="${resVen}/tinymce/4.0.7/js/tinymce/tinymce.min.js"></script>
	<script src="${resVen}/blueimp-file-upload/8.8.5/js/jquery.iframe-transport.js"></script>
	<script src="${resVen}/blueimp-file-upload/8.8.5/js/jquery.fileupload.js"></script>
	<script src="${resVen}/datatables/1.9.4/js/jquery.dataTables.min.js"></script>
	
	
	<link rel="stylesheet" type="text/css" media="screen" href="${res}/css/dropzone.css" />	
	
	<script type="text/javascript">
		$(function() {
    		$(".datepicker" ).datepicker(    	    				
 				$.datepicker.regional[ "${datefieldRegional}" ]    			
    		);
  		});
	</script>
	
	<script type="text/javascript">
		tinymce.init({
		    selector: "textarea",
		    plugins: [
		        "advlist autolink lists link image charmap print preview anchor",
		        "searchreplace visualblocks code fullscreen",
		        "insertdatetime media table contextmenu paste"
		    ],
		    toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
		    
		});
	</script>	

</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		
		<div class="container">	
			<div class="navbar-header">
				<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>	
					
				<a href="${homeUrl}" class="navbar-brand">Home</a>	
			</div>
		
			<nav class="navbar-collapse bs-navbar-collapse collapse" role="navigation">
				<ul class="nav navbar-nav">				
					
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Lang<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="?lang=en_AU">en_AU</a></li>
							<li><a href="?lang=ru_RU">ru_RU</a></li>
						</ul>
					</li>
					
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Theme<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="?theme=standart">Standart</a></li>
							<li><a href="?theme=green">Green</a></li>
						</ul>
					</li>			
				</ul>
				
				<sec:authorize access="isAuthenticated()">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><sec:authentication property="principal.username" /></a></li>				
				</ul>				
				</sec:authorize>				
					
			</nav>			
			

		</div>
	</div>


	<div class="container">			
		<tiles:insertAttribute name="body"/>		
	</div>

</body>
