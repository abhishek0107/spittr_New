<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form-style-6">
	<form:form action="sendmsg" method="post" modelAttribute="dtweet">
		<form:hidden path="tweetusrid" value="${loginUser.usrid}"	/>
		<form:textarea path="tweetmsg" placeholder="Write message"></form:textarea>	
		<input type="submit" value="Send Message" /> 
	</form:form>
</div>

<c:forEach var="msg" items="${messageText}">
	<b>${msg}</b><br>
</c:forEach>