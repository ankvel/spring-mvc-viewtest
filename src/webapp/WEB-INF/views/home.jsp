<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<spring:url value="/fileup" var="fileupUrl" />
<spring:url value="/test" var="testUrl" />

<spring:message code="msg_welcome" />
<br/>
Root context: <c:out value="${ctx}" />
<ul>
<li><a href="${fileupUrl}">${fileupUrl}</a></li>
<li><a href="${testUrl}">${testUrl}</a></li>
</ul>