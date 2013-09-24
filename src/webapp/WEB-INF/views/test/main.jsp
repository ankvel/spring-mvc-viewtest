<%@ include file="/WEB-INF/taglibs.jsp"%>
<body>
	<div class="page-header">
    	<h1>Aks Messages</h1>
    </div>

    <div class="row">
	    <div class="col-md-8">
			<form:form commandName="aksMessage" method="POST">
			    <div class="row">
				    <div class="col-md-2">Author</div>
				    <div class="col-md-10"><form:input path="author" /><form:errors path="author" cssClass="alert-danger" /></div>				    
			    </div>
			    <div class="row">
				    <div class="col-md-2">Content</div>
				    <div class="col-md-10"><form:textarea path="content" /><form:errors path="content" cssClass="alert-danger" /></div>				    
			    </div>
		    	<div class="row">
		    		<div class="col-md-12"><input type="submit" value="Save Changes" /></div>
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
					<th>Id</th>
					<th>Author</th>
					<th>Content</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${aksMessages}" var="aksMessage">
					<tr>
						<td>${aksMessage.id}</td>
						<td>${aksMessage.author}</td>
						<td>${aksMessage.content}</td>
					</tr>
				</c:forEach>
			</tbody>

	</c:if>

</body>
</html>