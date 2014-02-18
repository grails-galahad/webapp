modules = {

    'bootstrap-affix' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'affix.js']
    }

    'bootstrap-alert' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'alert.js']
    }

    'bootstrap-button' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'button.js']
    }

    'bootstrap-carousel' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'carousel.js']
    }

    'bootstrap-collapse' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'collapse.js']
    }

    'bootstrap-dropdown' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'dropdown.js']
    }

    'bootstrap-modal' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'modal.js']
    }

    'bootstrap-popover' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'popover.js']
    }

    'bootstrap-scrollspy' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'scrollspy.js']
    }

    'bootstrap-tab' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'tab.js']
    }

    'bootstrap-tooltip' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'tooltip.js']
    }

    'bootstrap-transition' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        resource url:[dir: 'bootstrap/js', file: 'transition.js']
    }

    'bootstrap-js' {
        defaultBundle 'monolith'
        dependsOn 'jquery'
        dependsOn 'bootstrap-affix', 'bootstrap-alert', 'bootstrap-button', 'bootstrap-carousel', 'bootstrap-collapse', 'bootstrap-dropdown', 'bootstrap-modal', 'bootstrap-popover', 'bootstrap-scrollspy', 'bootstrap-tab', 'bootstrap-tooltip', 'bootstrap-transition'
    }
}
