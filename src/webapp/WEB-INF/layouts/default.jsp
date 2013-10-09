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
