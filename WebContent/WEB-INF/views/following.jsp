<%@include file="/WEB-INF/templates/include.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${allUser}" var="usr">
	<div class="follw_user">
		<c:choose>
			<c:when test="${empty usr.usrImg}">
				<img src="<%=SpittrConstant.IMAGEROOTURL%>male_default.png"> &nbsp; &nbsp;
			</c:when>
			<c:otherwise>
				<img src="data:image/jpeg;base64,${usr.usrImg}" alt="..."
					width="100" height="140">
			</c:otherwise>
		</c:choose>
		<span class="ProfileCard-actions"> ${usr.usrfn}</span>		
		<span class="follow_button"><a href="follow?id=${usr.usrid}">following</a></span>
	</div>
</c:forEach>
