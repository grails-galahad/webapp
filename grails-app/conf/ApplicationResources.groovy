modules = {
    application {
        defaultBundle 'monolith'
        dependsOn 'jquery, jquery-ui, bootstrap-js'
        resource url: 'js/spin.min.js'
        resource url: 'js/jquery.spin.js'
        resource url: 'js/modernizr.min.js'
        resource url: 'js/bootstrap-datetimepicker.min.js'
        resource url: 'js/application.js'
        resource url: 'css/application.css'
        resource url: 'css/bootstrap-datetimepicker.min.css'
        resource url: 'css/dummy.css'
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
    }
}
