<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="changePassowrd">
	<form:form class="form-style-7" action="updatePassword"
		modelAttribute="passwordManagement">
		<form:hidden path="userId" value= "${loginUser.usrid}"/> 
		<form:password path="currentPassword" name="currentPassword"
			placeholder="Enter current password" />
		<form:password path="newPassword" name="newPassword" placeholder="Enter new password" />
		<form:password path="newPassword" name="confirmPassword"
			placeholder="confirm password" />
		<input type="submit" value="change" />
		<input type="submit" value="Cancel" />
	</form:form>
</div>