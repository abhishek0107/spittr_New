<%@include file="/WEB-INF/templates/include.jsp"%>
<ul>
   <li class="${ tab eq 'Home' ? 'active' : ''}">
   	<a href='/Spittr/'>Home</a>
   </li>
   <li class="${ tab eq 'Message' ? 'active' : ''}">
   	<a href='message'>My Messages</a>
   </li>
   <li class="${ tab eq 'Profile' ? 'active' : ''}">
   	<a href='myProfile'>My Profile</a>
   </li>
   <li class="${ tab eq 'Followers' ? 'active' : ''}">
   	<a href='myFollowers'>Followers</a>
   </li>
</ul>