<%! import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU %>
<%! import grails.util.Environment %>

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
		
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		
			<a class="navbar-brand" href="${createLink(uri: '/')}">${meta(name: 'app.name')}</a>
		</div>

		<div class="navbar-collapse collapse" id="navbar-collapse-1">
			<ul class="nav navbar-nav">							
				<sec:ifLoggedIn>
					<g:each var="c" in="${grailsApplication.controllerClasses.findAll { GCU.isStaticProperty(it.clazz, 'menuItem') }.sort { it.fullName } }">
						<li<%= c.logicalPropertyName == controllerName ? ' class="active"' : '' %>><g:link controller="${c.logicalPropertyName}">${c.clazz.menuItem}</g:link></li>
					</g:each>
				</sec:ifLoggedIn>
				<sec:ifNotLoggedIn>
					<li<%= request.forwardURI == "${createLink(uri: '/')}" ? ' class="active"' : '' %>><a href="${createLink(uri: '/')}">Home</a></li>
				    <li><a href="${createLink(uri: '/')}">About</a></li>
				    <li><a href="${createLink(uri: '/')}">Tour</a></li>
				    <li><a href="${createLink(uri: '/')}">Pricing</a></li>
				</sec:ifNotLoggedIn>
			</ul>
			
	        <ul class="nav navbar-nav navbar-right">
				<sec:ifLoggedIn>
	                <li class="dropdown">
	                    <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>&nbsp;<sec:loggedInUserInfo field="fullName" />&nbsp;<span class="caret"></span></a>
	                    <ul class="dropdown-menu">
	                        <li><g:link controller="logout">Sign Out</g:link></li>
	                    </ul>
	                </li>
	                <sec:ifAnyGranted roles="ROLE_ADMIN">
	                    <li class="dropdown">
	                        <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span>&nbsp;<span class="caret"></span></a>
	                        <ul class="dropdown-menu">
	                            <li><g:link controller="console">Groovy Console</g:link></li>
	                            <g:if test="${Environment.current == Environment.DEVELOPMENT}">
	                                <li><g:link controller="dbconsole">Database Console</g:link></li>
	                            </g:if>
	                        </ul>
	                    </li>
					</sec:ifAnyGranted>
	            </sec:ifLoggedIn>
	            <sec:ifNotLoggedIn>
	                <li><g:link controller="registration">Sign Up</g:link></li>
	                <li><g:link controller="login">Login</g:link></li>
	            </sec:ifNotLoggedIn>
	        </ul>
		</div>
		
	</div>
</nav>
