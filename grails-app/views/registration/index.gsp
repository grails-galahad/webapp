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
                            
                            <div class="control-group">
                                <div class="controls">
                                	<label id="terms-check" class="checkbox">
                                	    I accept the <a href="javascript:void(0)">terms of use</a>
                                	</label>
                                	<r:script>
                                	    $('#terms-check').prepend('<input type="checkbox" name="terms" ${params.terms == 'on' ? 'checked="true"' : ''}>');
                                	</r:script>
                            	</div>
                            </div>
                            
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
