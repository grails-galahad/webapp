modules = {
    application {
        defaultBundle 'monolith'
        dependsOn 'jquery, jquery-ui'
        resource url: 'bootstrap/js/bootstrap.min.js'
        resource url: 'js/moment.min.js'
        resource url: 'js/bootstrap-datetimepicker.js'
        resource url: 'js/holder.js'
        resource url: 'js/application.js'
        resource url: 'css/application.css'
    }
	
    images {
        resource url: 'images/apple-touch-icon-retina.png'
        resource url: 'images/apple-touch-icon.png'
        resource url: 'images/billboard.jpg'
        resource url: 'images/favicon.ico'
    }

    overrides {
        jquery {
            defaultBundle 'monolith'
        }
        'jquery-ui' {
            defaultBundle 'monolith'
        }
    }
}
