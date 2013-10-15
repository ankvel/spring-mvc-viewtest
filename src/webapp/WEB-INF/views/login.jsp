<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<spring:url var="loginUrl" value="/login" />
<div id="login">
	<form name="loginForm" action="${loginUrl}" method="post">
		<table>
			<caption align="left">Login:</caption>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="j_username" /></td>
			</tr>				
			<tr> 
				<td>Password:</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input name="submit"
					type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</div>


