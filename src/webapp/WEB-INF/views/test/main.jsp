<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<spring:message code="label_id" var="labelId"/>
<spring:message code="label_author" var="labelAuthor"/>
<spring:message code="label_content" var="labelContent"/>
<spring:message code="label_save" var="labelSave"/>
<spring:message code="label_some_date" var="labelSomeDate"/>
<spring:message code="label_created_date" var="labelCreatedDate"/>
<spring:message code="date_format" var="dateFormat"/>
<spring:message code="datefield_hint" var="datefieldHint"/>
<spring:message code="label_message_list" var="labelMessageList"/>

	<div class="page-header">
   		<h1>Aks Messages</h1>
   	</div>

	<form:form commandName="aksMessage" accept-charset="UTF-8" method="POST">
			<div class="row">
			    <div class="form-group col-sm-4">
				    <label for="author">${labelAuthor}</label>
				    <form:input path="author" class="input-mir form-control" /><form:errors path="author" cssClass="alert-danger" />				    
			    </div>
		    </div>
		    <div class="row">	    
			    <div class="form-group col-sm-4">
				    <label for="content">${labelContent}</label>
				    <form:textarea path="content" class="form-control" /><form:errors path="content" cssClass="alert-danger" />				    
			    </div>
			</div>
			<div class="row">	  
			    <div class="form-group col-sm-4">
				    <label for="someDate">${labelSomeDate} (${datefieldHint})</label>
				    <form:input path="someDate" class="form-control datepicker" /><form:errors path="someDate" cssClass="alert-danger" />				    
			    </div>
	    	</div>
    	
		<input type="submit" value="${labelSave}" class="btn btn-default" />
		
	</form:form>
	
	<div class="row">
		<tiles:insertAttribute name="message"/>
	</div>


<c:if test="${not empty aksMessages}">

	<h1>${labelMessageList}</h1>
	
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>${labelId}</th>
				<th>${labelAuthor}</th>
				<th>${labelContent}</th>
				<th>${labelSomeDate}</th>
				<th>${labelCreatedDate}</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${aksMessages}" var="aksMessage">
				<tr>
					<td>${aksMessage.id}</td>
					<td>${aksMessage.author}</td>
					<td>${aksMessage.content}</td>						
					<td><spring:eval expression="aksMessage.someDate" /></td>
					<td>[<spring:eval expression="aksMessage.createdDate" />]</td>		
					<%-- <td><joda:format value="${aksMessage.someDate}" pattern="${dateFormat}"/></td> --%>	
					<%-- <td><joda:format value="${aksMessage.createdDate}" pattern="[dd.MM.yyyy hh:mm]"/></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</c:if>


	
	
