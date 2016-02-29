<%@include file="/WEB-INF/templates/include.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Login/Sign-In</title>

<script src="<%=SpittrConstant.JSROOTURL%>jquery.js"></script>
<script src="<%=SpittrConstant.JSROOTURL%>index.js"></script>
<script src="<%=SpittrConstant.JSROOTURL%>login.js"></script>
<script type="text/javascript"
	src="<%=SpittrConstant.JSROOTURL%>jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=SpittrConstant.JSROOTURL%>jquery.fancybox.pack.js?v=2.1.5"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.fancybox').fancybox();
	});
	function validate() {

	}
</script>

<style type="text/css">
.fancybox-custom .fancybox-skin {
	box-shadow: 0 0 50px #222;
}

body {
	max-width: 700px;
	margin: 0 auto;
}
</style>
<link rel="stylesheet" type="text/css"
	href="<%=SpittrConstant.CSSROOTURL%>jquery.fancybox.css?v=2.1.5"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="<%=SpittrConstant.CSSROOTURL%>normalize.css">
<link rel="stylesheet" type="text/css"
	href="<%=SpittrConstant.CSSROOTURL%>style.css">
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
	
</head>
<body>
<c:url var="loginUrl" value="/login" />
	<div class="logmod">
		<div class="logmod__wrapper">
			${signuperror}
			<div class="logmod__container">			
				<ul class="logmod__tabs">
					<li data-tabtar="lgm-2"><a href="#">Login</a></li>
					<li data-tabtar="lgm-1"><a href="#">Sign Up</a></li>
				</ul>
		
				<div class="logmod__tab-wrapper">
					<div class="logmod__tab lgm-1">
						<div class="logmod__form">
							<form:form modelAttribute="dusr"  action="register" class="simform" >
								<div class="sminputs">
									<div class="input full">
										<form:label path="usrfn" class="string optional" for="user-name">Full
											Name*
										</form:label> 
										<form:input path="usrfn" class="string optional" maxlength="255"
											id="user-fname" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input full">
										<form:label path="usreml" class="string optional" for="user-name">Email*</form:label>
										<form:input path="usreml" class="string optional" id="usreml" />										
									</div>
								</div>
								<div class="sminputs">
									<div class="input string optional">
										<form:label path="usrpwd" class="string optional" >Password
											*</form:label> 
										<form:password path="usrpwd" maxlength="255" id="password"
											placeholder="Password" size="50" />
									</div>
									<div class="input string optional">
										<form:label class="string optional" path="usrpwd" for="user-pw-repeat">Repeat
											password *</form:label> <form:password path="usrpwd" class="string optional" maxlength="255"
											id="user-pw-repeat" placeholder="Repeat password" 
											size="50" />
									</div>
								</div>
								<div class="simform__actions">
									<input class="sumbit" name="commit" type="submit" readonly
										value="Create Account" onclick="return validateSignup();"/>
									<span
										class="simform__actions-sidetext">By creating an
										account you agree to our <a class="special" href="#"
										target="_blank" role="link">Terms and Privacy</a>
									</span>
								</div>
							</form:form>
						</div>
					</div>
					<div class="logmod__tab lgm-2">
						<div class="logmod__form">
						<c:url var="loginUrl" value="/login" />
						
							<form:form modelAttribute="dusr"  action="${loginUrl}" class="simform" method="post">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
								<div class="sminputs">
									<div class="input full">
										<form:label class="string optional" path="usreml" for="user-name">Email*</form:label>
										<form:input  path="usreml" class="string optional" id="user-email"
											placeholder="Email" size="50" />
									</div>
								</div>
								<div class="sminputs">

									<div class="input full">
										<form:label path="usrpwd" class="string optional" for="user-pw">Password
											*</form:label> 
											<form:password  path="usrpwd" class="string optional" maxlength="255" id="user-pw"
											name="password" placeholder="Password" 
											size="50" /> <span class="hide-password">Show</span>
									</div>
									<div class="simform__actions">
										 <input
											class="sumbit" name="commit" type="submit" readonly
											value="Log In" onclick="return validateLogin();" /> <span class="simform__actions-sidetext">
											<a class="fancybox" href="#forgotPwd">Forgot your
												password?</a>
										</span>
									</div>
								</div>
								<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="forgotPwd" style="width: 400px; display: none;">
		<div class="logmod__form">
			<form:form action="sendMail" class="simform" modelAttribute="dusr">
				<div class="sminputs">
					<div class="input full">
						<form:input path="usreml" class="string optional" placeholder="Enter your email"  />
					</div>
				</div>
				<div class="simform__actions">
					<input class="sumbit" name="commit" type="submit" readonly
						value="Submit" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>