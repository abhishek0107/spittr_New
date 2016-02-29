<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:form modelAttribute="dusr" action="editProfile">
	<form:hidden path="usrid" />
	<p class="view-profile-nav">&nbsp;</p>
	<ul>
		<li><a href="<c:url value="/edit?id=${loginUser.usrid}" />">Edit
				Profile</a></li>
		<li><a href="<c:url value="/changePassword?id=${loginUser.usrid}" />">Change
				Password</a></li>
		<li><a href="<c:url value="/changePicture?id=${loginUser.usrid}" />">
				changePicture</a></li>


	</ul>
	<p>&nbsp;</p>
</form:form>