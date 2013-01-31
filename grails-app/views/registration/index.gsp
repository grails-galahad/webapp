<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap"/>
		<title>Sign Up</title>
	</head>

	<body>
	    <div class="row">
	        <div class="span8 offset2">
        	    <div class="page-header">
            	    <h1>Sign Up</h1>
        	    </div>
        	    
        	    <g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

				<g:hasErrors bean="${user}">
				<bootstrap:alert class="alert-error">
				<ul>
					<g:eachError bean="${user}" var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:eachError>
				</ul>
				</bootstrap:alert>
				</g:hasErrors>

				<fieldset>
					<g:form class="form-horizontal" action="save">
						<fieldset>
					        <f:with bean="${user}">
                                <f:field property="fullName" />
                                <f:field property="username" />
                                <f:field property="password" />
                                <f:field property="email" />
                            </f:with>
                            <div class="form-actions">
    							<button type="submit" class="btn btn-primary">Sign Up</button>
							</div>
						</fieldset>
					</g:form>
				</fieldset>
				
    	    </div>
	    </div>
	</body>
</html>
