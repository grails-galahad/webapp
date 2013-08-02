modules = {
    application {
        defaultBundle 'monolith'
        dependsOn 'jquery, jquery-ui, bootstrap-js'
        resource url: 'js/bootstrap-datepicker.js'
        resource url: 'js/spin.min.js'
        resource url: 'js/jquery.spin.js'
        resource url: 'js/modernizr.min.js'
        resource url: 'js/bootstrap-datetimepicker.min.js'
        resource url: 'js/application.js'
        resource url: 'less/application.less'
        resource url: 'css/bootstrap-datetimepicker.min.css'
        resource url: 'css/dummy.css'
    }

    overrides {
        jquery {
            defaultBundle 'monolith'
        }
    }
}
