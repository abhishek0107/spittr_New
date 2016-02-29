<%@include file="/WEB-INF/templates/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <c:forEach items="${metaInformation}" var="metaInfo">
		<meta name="${metaInfo.key}" content="${metaInfo.value}"/>
	</c:forEach>
    <c:if test="${not empty canonical}">
		<link rel="canonical" href="${canonical}" />
	</c:if>
	<title><tiles:insertAttribute name="title" /></title>
        
    <link rel="stylesheet" type="text/css" href="<%=SpittrConstant.CSSROOTURL%>div_page.css">
	<link rel="stylesheet" type="text/css" href="<%=SpittrConstant.CSSROOTURL%>style-7.css">
	<link rel="stylesheet" type="text/css" href="<%=SpittrConstant.CSSROOTURL%>style-6.css">
	<link rel="stylesheet" type="text/css" href="<%=SpittrConstant.CSSROOTURL%>menu.css">
	<link rel="stylesheet" type="text/css" href="<%=SpittrConstant.CSSROOTURL%>twitter_core.bundle.css">
	<link rel="stylesheet" type="text/css" href="<%=SpittrConstant.CSSROOTURL%>spittr_more_2.bundle.css">
	
	
	<style type="text/css">
    	.uploadFile{
    		visibility : hidden;
    	}
	</style>
	
	<script src="<%=SpittrConstant.JSROOTURL%>jquery.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="<%=SpittrConstant.JSROOTURL%>script.js"></script>
    <script>
	  	$( document ).ready(function() {
	  		$("#uploadIcon").click(function(){
	  			
	  			$(this).next().trigger('click');
	  		});
	  	 });
   </script>  
  </head>
    <body>
  		<div id="header"><tiles:insertAttribute name="header" /></div>
		<div id='cssmenu'><tiles:insertAttribute name="header-menu" /></div>
		<div id="home_nav" class='home_nav'>			
			<tiles:insertAttribute name="leftNav-top" />
			<tiles:insertAttribute name="myprofile-leftNav-top" />			
			<tiles:insertAttribute name="leftNav" />		
			
		</div>
		<div id="section">
			<tiles:insertAttribute name="body" />			
		</div>
		
		<div id="footer"><tiles:insertAttribute name="footer" /></div>
  </body>
</html>