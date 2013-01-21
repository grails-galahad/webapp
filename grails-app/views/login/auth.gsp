<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap"/>
		<title>Login</title>
		
		<style type="text/css">
              body {
                padding-top: 40px;
                padding-bottom: 40px;
                background-color: #f5f5f5;
              }
        </style>
	</head>

	<body>
	    <div class="row-fluid">
	        <div class="login span6 offset3">
        	    <g:if test='${flash.message}'>
        			<bootstrap:alert class="alert-error">${flash.message}</bootstrap:alert>
        		</g:if>
		
                <form class="form-signin" action="${postUrl}" method="POST" autocomplete="off">
                    <h2 class="form-signin-heading">Please sign in</h2>
        
                    <input type="text" class="input-block-level" name="j_username" placeholder="Username" autofocus>
                    <input type="password" class="input-block-level" name="j_password" placeholder="Password">
                    <label class="checkbox">
                        <input type="checkbox" name="${rememberMeParameter}" ${hasCookie ? 'checked="checked"' : ''}> Remember me
                    </label>
                    <button class="btn btn-large btn-primary" type="submit">Sign in</button>
                </form>
            </div>
        </div>
	</body>
</html>
