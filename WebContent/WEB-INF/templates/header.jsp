<%@include file="/WEB-INF/templates/include.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="uploadBox">
	<a href="javascript:void(0)" id="uploadIcon" class="img_a">
		<!-- <img src="images/user_view.png"  width="100px" height="100px" alt="upload photo"/> -->
		
		<c:choose>
			<c:when test="${empty loginUser.usrImg}">
				<img src="<%=SpittrConstant.IMAGEROOTURL%>male_default.png"> &nbsp; &nbsp;
			</c:when>
			<c:otherwise>
				<img src="data:image/jpeg;base64,${loginUser.usrImg}" alt="..."
					width="100" height="140">
			</c:otherwise>
		</c:choose>
	</a>
	
</div>
<div id="header_inner1">
	<a href="<c:url value="/logout" />">Logout</a>	
	<table>
	  <tr>
	  <td width="10%">			  
	    <a href="javascript:void(0)" id="uploadIcon" >
	    		    
             <img src="<%=SpittrConstant.IMAGEROOTURL%>ezimba.gif" width="100" height="113" alt="" title="" /> 
        </a>
	   </td>			  
	  <td width="80%" style="font-size:35px;">
        Welcome to Spittr
	  </td>	 
	  </tr>
	  <tr>			  
	  </tr>
	 </table>
</div>