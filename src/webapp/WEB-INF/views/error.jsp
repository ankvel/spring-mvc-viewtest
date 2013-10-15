<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<spring:url value="/fileup" var="fileupUrl" />
<spring:url value="/test" var="testUrl" />

<h1>
<spring:message code="error" />
</h1>

<pre>
	${exception}
</pre>

