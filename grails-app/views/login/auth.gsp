<!doctype html>
<html>
	<head>
		<meta name="layout" content="splash"/>
		<title>Login</title>
	</head>

	<body>
	    <div class="row">
	        <div class="login col-md-6 col-md-offset-3">
        	    <g:if test='${flash.message}'>
        			<bootstrap:alert class="alert-danger">${flash.message}</bootstrap:alert>
        		</g:if>
		
                <form class="form-signin" action="${postUrl}" method="POST" autocomplete="off">
                    <h2>Please sign in</h2>
                    <fieldset>
                        <input type="text" class="form-control" name="j_username" placeholder="Email" autofocus>
                        <input type="password" class="form-control" name="j_password" placeholder="Password">
						<div class="checkbox">
	                        <label>
	                            <input type="checkbox" name="${rememberMeParameter}" ${hasCookie ? 'checked="checked"' : ''}> Remember me
	                        </label>
						</div>
                    </fieldset>
                    <button class="btn btn-lg btn-primary" type="submit">Sign in</button>
                </form>
            </div>
        </div>
	</body>
</html>
