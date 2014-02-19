<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Galahad - ${meta(name: 'app.name')}</title>
	</head>

	<body>
        <div class="billboard">
            <r:img dir="images" file="billboard.jpg" />
            <div class="billboard-caption">
              <h1>Hello, world.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <g:link class="btn btn-lg btn-primary" controller="registration">Sign up today</g:link>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="javascript:void(0)">View details »</a></p>
            </div>
            
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="javascript:void(0)">View details »</a></p>
            </div>
            
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                <p><a class="btn btn-default" href="javascript:void(0)">View details »</a></p>
            </div>
        </div>
	</body>
</html>
