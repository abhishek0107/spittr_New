
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="profile_table">
	<tr>
		<td>Name</td>
		<td>${loginUser.usrfn}</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>${loginUser.usreml}</td>
	</tr>
	<tr>
		<td>Mobile No</td>
		<td>${loginUser.usrphn}</td>
	</tr>
	<tr>
		<td>Profession</td>
		<td>${loginUser.usrProfession}</td>
	</tr>
	<tr>
		<td>Website</td>
		<td>${loginUser.url}</td>
	</tr>
	<tr>
		<td>Hobbies</td>
		<td>${loginUser.hobbies}</td>
	</tr>
	<tr>
		<td>Address Line1</td>
		<td>${loginUser.usrAddr1}</td>
	</tr>
	<tr>
		<td>Address Line2</td>
		<td>${loginUser.usrAddr2}</td>
	</tr>
	<tr>
		<td>City</td>
		<td>${loginUser.usrCity}</td>
	</tr>
	<tr>
		<td>State</td>
		<td><c:forEach items="${State}" var="state">
				<c:if test="${loginUser.usrState eq state.appmasid}">
				${state.appmasdesc}
			</c:if>
			</c:forEach></td>
	</tr>
	<tr>
		<td>Country</td>
		<td><c:forEach items="${Country}" var="Country">
				<c:if test="${loginUser.usrCountry eq Country.appmasid}">
					${Country.appmasdesc}
					
				</c:if>
			</c:forEach></td>
	</tr>

</table>