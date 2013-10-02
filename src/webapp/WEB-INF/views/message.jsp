<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<c:if test="${not empty msg}">
	<div class="row">
		
		<c:if test="${msg_type == \"error\"}">
			<div class="col-sm-12 alert alert-danger">
				<strong><spring:message code="error" /></strong>
				<p><c:out value="${msg}" /></p>
				
			</div>
		</c:if>
		<c:if test="${msg_type == \"success\"}">
			<div class="col-sm-12 alert alert-success">
				<strong><spring:message code="success" /></strong>
				<p><c:out value="${msg}" /></p>
				
			</div>
		</c:if>			
	</div>
</c:if>
