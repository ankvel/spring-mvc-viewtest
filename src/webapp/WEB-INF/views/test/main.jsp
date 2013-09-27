<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<spring:message code="label_id" var="labelId"/>
<spring:message code="label_author" var="labelAuthor"/>
<spring:message code="label_content" var="labelContent"/>
<spring:message code="label_save" var="labelSave"/>
<spring:message code="label_created_date" var="labelCreatedDate"/>


<div class="page-header">
   	<h1>Aks Messages</h1>
   </div>

   <div class="row">
    <div class="col-md-8">
		<form:form commandName="aksMessage" accept-charset="UTF-8" method="POST">
		    <div class="row">
			    <div class="col-md-2">${labelAuthor}</div>
			    <div class="col-md-10"><form:input path="author" /><form:errors path="author" cssClass="alert-danger" /></div>				    
		    </div>
		    <div class="row">
			    <div class="col-md-2">${labelContent}</div>
			    <div class="col-md-10"><form:textarea path="content" /><form:errors path="content" cssClass="alert-danger" /></div>				    
		    </div>
	    	<div class="row">
	    		<div class="col-md-12"><input type="submit" value="${labelSave}" /></div>
	    	</div>
		</form:form>
	</div> 
	<div class="col-md-4"></div>		
</div>

<tiles:insertAttribute name="message"/>

<h1>Message List</h1>

<c:if test="${not empty aksMessages}">

	<table class="bordered-table zebra-striped">
		<thead>
			<tr>
				<th>${labelId}</th>
				<th>${labelAuthor}</th>
				<th>${labelContent}</th>
				<th>${labelCreatedDate}</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${aksMessages}" var="aksMessage">
				<tr>
					<td>${aksMessage.id}</td>
					<td>${aksMessage.author}</td>
					<td>${aksMessage.content}</td>
					<%-- <td>${aksMessage.createdDate}</td> --%>
					<td><joda:format value="${aksMessage.createdDate}" pattern="yyyy-MM-dd"/></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</c:if>


	
	
