<%@ page import="org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes" %>
<%! import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU %>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title><g:layoutTitle default="${meta(name: 'app.name')}"/></title>
		<meta name="description" content="">
		<meta name="author" content="">

		<meta name="viewport" content="initial-scale = 1.0">

		<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

		<r:require modules="application"/>

		<!-- Le fav and touch icons -->
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

		<g:layoutHead/>
		<r:layoutResources/>
	</head>

	<body>

		<nav class="navbar navbar-fixed-top navbar-inverse">
			<div class="navbar-inner">
				<div class="container">
					
					<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</a>
					
					<a class="brand" href="${createLink(uri: '/')}">${meta(name: 'app.name')} <sub class="muted">v${meta(name: 'app.version')}</sub></a>

					<div class="nav-collapse collapse">
						<ul class="nav">							
							<li<%= request.forwardURI == "${createLink(uri: '/')}" ? ' class="active"' : '' %>><a href="${createLink(uri: '/')}">Home</a></li>
							<g:each var="c" in="${grailsApplication.controllerClasses.findAll { GCU.isStaticProperty(it.clazz, 'menuItem') }.sort { it.fullName } }">
								<li<%= c.logicalPropertyName == controllerName ? ' class="active"' : '' %>><g:link controller="${c.logicalPropertyName}">${c.clazz.menuItem}</g:link></li>
							</g:each>
						</ul>
					</div>
					
                    <ul class="nav pull-right">
    					<sec:ifLoggedIn>
                            <li class="dropdown">
                                <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user icon-white"></i> <sec:loggedInUserInfo field="username" /><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><g:link controller="logout">Sign Out</g:link></li>
                                </ul>
                            </li>
                        </sec:ifLoggedIn>
                        <sec:ifNotLoggedIn>
                            <li><g:link controller="registration">Sign Up</g:link></li>
                            <li><g:link controller="login">Login</g:link></li>
                        </sec:ifNotLoggedIn>
                    </ul>
				</div>
			</div>
		</nav>

		<div class="container main">
			<g:layoutBody/>
		</div>
		
		<footer class="footer-inverse">
		    <div class="container page-bottom"></div>
		    <div class="container">
		        <div class="row">
                    <div class="col-centered span3 offset1">
                        <div class="col-inner">
                            <h4>Info</h4>
                            <ul class="unstyled">
            					<li><a href="${createLink(uri: '/')}">Tour</a></li>
            					<li><a href="${createLink(uri: '/')}">Pricing</a></li>
            					<li><a href="${createLink(uri: '/')}">FAQ</a></li>
            					<li><a href="${createLink(uri: '/')}">Support</a></li>
            				</ul>
        				</div>
                    </div>
                    <div class="col-centered span3">
                        <div class="col-inner">
                            <h4>Company</h4>
                            <ul class="unstyled">
            					<li><a href="${createLink(uri: '/')}">About</a></li>
            					<li><a href="${createLink(uri: '/')}">Press</a></li>
            					<li><a href="${createLink(uri: '/')}">Contact</a></li>
            					<li><a href="${createLink(uri: '/')}">Terms</a></li>
            					<li><a href="${createLink(uri: '/')}">Privacy</a></li>
            				</ul>
        				</div>
                    </div>
                    <div class="col-centered span3">
                        <div class="col-inner">
                            <h4>Follow</h4>
                            <ul class="unstyled">
            					<li><a href="${createLink(uri: '/')}">Blog</a></li>
            					<li><a href="${createLink(uri: '/')}">Twitter</a></li>
            					<li><a href="${createLink(uri: '/')}">Facebook</a></li>
        					</ul>
    					</div>
                    </div>
		        </div>
		        
    			<p class="copy">&copy; Company, Inc. ${new GregorianCalendar().get(Calendar.YEAR)}</p>
			</div>
		</footer>

		<r:layoutResources/>

	</body>
</html>