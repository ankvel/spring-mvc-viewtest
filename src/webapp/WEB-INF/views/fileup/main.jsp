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
 
    <table id="uploaded-files" class="table table-bordered table-striped">
        <tr>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th>Download</th>
        </tr>
    </table>
    
	<script type="text/javascript">
		$(function () {
		    $('#fileupload').fileupload({
		        dataType: 'json',
		 
		        done: function (e, data) {
		            $("tr:has(td)").remove();
		            $.each(data.result, function (index, file) {
		 
		                $("#uploaded-files").append(
		                        $('<tr/>')
		                        .append($('<td/>').text(file.fileName))
		                        .append($('<td/>').text(file.fileSize))
		                        .append($('<td/>').text(file.fileType))
		                        .append($('<td/>').html("<a href='${ctx}/fileup/get/"+index+"'>Click</a>"))
		                        );//end $("#uploaded-files").append()
		            }); 
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
