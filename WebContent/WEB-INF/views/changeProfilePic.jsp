<%@include file="/WEB-INF/templates/include.jsp"%>
<style type="text/css">
</style>
	<script src="<%=SpittrConstant.JSROOTURL%>jquery.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="<%=SpittrConstant.JSROOTURL%>script.js"></script>
    <script>
	  	$( document ).ready(function() {
	  		$("#uploadIcon2").click(function(){
	  			
	  			$(this).next().trigger('click');
	  		});
	  	 });
   </script>
<div>
	
</div>
<img src="data:image/jpeg;base64,${imgData}" alt="..." width="200" height="200">
<form:form method="post" action="changePic" enctype="multipart/form-data" modelAttribute="dAppImage">
<form:hidden path="appimgusrid"/>
	<input type="file" name="file" value="" id="file" />
	<input type="submit"  value="Change Picture"/>
</form:form>

<%-- <img src="${pageContext.servletContext.contextPath }/ImageServlet?id=${dusr.usrid}" /> --%>
