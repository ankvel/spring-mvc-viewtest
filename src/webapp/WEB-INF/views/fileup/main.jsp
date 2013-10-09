<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<%-- <spring:message code="label_id" var="labelId"/>
<spring:message code="label_author" var="labelAuthor"/>
<spring:message code="label_content" var="labelContent"/>
<spring:message code="label_save" var="labelSave"/>
<spring:message code="label_some_date" var="labelSomeDate"/>
<spring:message code="label_created_date" var="labelCreatedDate"/>
<spring:message code="datefield_hint" var="datefieldHint"/>
<spring:message code="label_message_list" var="labelMessageList"/>
<spring:message code="label_picture" var="labelPicture"/> --%>

	<div class="page-header">
   		<h1>Spring MVC - jQuery File Upload</h1>
   	</div>
   	
	<input id="fileupload" type="file" name="files[]" data-url="${ctx}/fileup/upload" class="btn btn-default" multiple>
 
    <div id="dropzone">Drop files here</div>
 
    <div id="progress">
        <div style="width: 0%;"></div>
    </div>
    
	<table id="uploaded_files" class="table table-bordered table-striped">
	    <thead>
	        <tr>
	        	<th>Id</th>
				<th>File Name</th>
				<th>File Size</th>
				<th>File Type</th>
				<th>&nbsp;</th>            
	        </tr>
	    </thead>
	</table>    

    
    <script type="text/javascript">
 
    	function initDataTable() {    		
    		return $('#uploaded_files').dataTable( {
    			
    			bServerSide: true,
    			bPaginate: true,
    			bJQueryUI: true,      			 
    			bLengthChange: true, 
    			bFilter: false,
    			bSort: false,
    			bInfo: true, 
    			bAutoWidth: true, 
    			bProcessing: true,
    			iDisplayLength: 10,  					       
    			aoColumns: [
					{mData: "id"},
					{mData: "fileName"},
					{mData: "fileSize"},
					{mData: "fileType"},
					{mData: function(source, type, val ) {
							return "<a href='${ctx}/fileup/get/" + source.id + "'>Download</a>"; 		
						
						}					
					}
	            ],
    				
    			     
				sAjaxSource: "${ctx}/fileup/doajax",
		        
		    } );
    	}
    	
    	

		$(document).ready(function() {
			var dataTable = initDataTable();
	
		    $('#fileupload').fileupload({
		        dataType: 'json',
		 
		        done: function (e, data) {		        	
		        	dataTable.fnDraw();
		        },
		 
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress .bar').css(
		                'width',
		                progress + '%'
		            );
		        },
		 
		        dropZone: $('#dropzone')
		    });
		    
		});	
	</script>
