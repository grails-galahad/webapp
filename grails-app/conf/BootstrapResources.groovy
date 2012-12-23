modules = {

    'bootstrap-alert' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-alert.js']
    }

    'bootstrap-affix' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-affix.js']
    }

    'bootstrap-dropdown' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-dropdown.js']
    }

    'bootstrap-modal' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-modal.js']
    }

    'bootstrap-popover' {
        defaultBundle 'monolith'
        dependsOn 'bootstrap-tooltip, jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-popover.js']
    }

    'bootstrap-scrollspy' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-scrollspy.js']
    }

    'bootstrap-tab' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-tab.js']
    }

    'bootstrap-tooltip' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-tooltip.js']
    }

    'bootstrap-button' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-button.js']
    }

    'bootstrap-carousel' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-carousel.js']
    }

    'bootstrap-typeahead' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-typeahead.js']
    }

    'bootstrap-collapse' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-collapse.js']
    }

    'bootstrap-transition' {
        defaultBundle 'monolith'
        dependsOn "jquery"
        resource url:[dir: 'bootstrap/js', file: 'bootstrap-transition.js']
    }

    'bootstrap-js' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        dependsOn 'bootstrap-transition, bootstrap-alert, bootstrap-dropdown, bootstrap-modal, bootstrap-scrollspy, bootstrap-tab, bootstrap-tooltip, bootstrap-popover, bootstrap-button, bootstrap-carousel, bootstrap-typeahead, bootstrap-collapse, bootstrap-affix'
    }
}
