<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Sign Up</title>
	</head>

	<body>
	    <div class="row">
	        <div class="col-md-8 col-md-offset-2">
        	    <div class="page-header">
            	    <h1>Sign Up</h1>
        	    </div>
        	    
        	    <g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

				<g:hasErrors bean="${userInstance}">
				<bootstrap:alert class="alert-error">
				<ul>
					<g:eachError bean="${userInstance}" var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:eachError>
				</ul>
				</bootstrap:alert>
				</g:hasErrors>

				<fieldset>
					<g:form class="form-horizontal" action="save">
						<fieldset>
					        <f:with bean="${userInstance}">
                                <f:field property="fullName" input-class="form-control"/>
                                <f:field property="email" input-class="form-control"/>
                                <f:field property="password" input-class="form-control"/>
                            </f:with>
                            
                            <div class="form-group">
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
