<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap"/>
		<title>Galahad - ${meta(name: 'app.name')}</title>
	</head>

	<body>

	    <%--
        <div class="hero-unit">
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a class="btn btn-primary btn-large" href="javascript:void(0)">Learn more »</a></p>
        </div>
        --%>
        
        <div class="billboard">
            <r:img dir="images" file="billboard.jpg" />
            <div class="billboard-caption">
              <h1>Hello, world.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="javascript:void(0)">Sign up today</a>
            </div>
        </div>
        
        <div class="row">
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="javascript:void(0)">View details »</a></p>
            </div>
            
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="javascript:void(0)">View details »</a></p>
            </div>
            
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                <p><a class="btn" href="javascript:void(0)">View details »</a></p>
            </div>
        </div>
	</body>
</html>