<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Login</title>
	</head>

	<body>
	    <div class="row-fluid">
	        <div class="login span6 offset3">
        	    <g:if test='${flash.message}'>
        			<bootstrap:alert class="alert-error">${flash.message}</bootstrap:alert>
        		</g:if>
		
                <form class="form-signin" action="${postUrl}" method="POST" autocomplete="off">
                    <h2>Please sign in</h2>
                    <fieldset>
                        <input type="text" class="input-block-level" name="j_username" placeholder="Email" autofocus>
                        <input type="password" class="input-block-level" name="j_password" placeholder="Password">
                        <label class="checkbox">
                            <input type="checkbox" name="${rememberMeParameter}" ${hasCookie ? 'checked="checked"' : ''}> Remember me
                        </label>
                    </fieldset>
                    <button class="btn btn-large btn-primary" type="submit">Sign in</button>
                </form>
            </div>
        </div>
	</body>
</html>
