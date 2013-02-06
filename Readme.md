Galahad - webapp
================

A starter project for a typical consumer web app based on Twitter Bootstrap and a curated set of plugins.


Usage
-----

Simply clone the project, change the `app.name` property in `application.properties`, and start your own Git repo.

    git clone https://github.com/grails-galahad/webapp.git myapp
    cd myapp
    rm -rf .git
    grails galahad-init myapp
    git init


About Galahad
-------------

Named after Sir Galahad the Pure, Galahad is a collection of pristine Grails starter projects for specific use cases. Each project reflects a set of opinionated choices about design paradigms, plugins, and testing methodologies.


TODO
----
* Add admin security group and menu
* Add console plugin
* Enable db console in prod and secure
* Rename application.less and application.js to webapp.less/js and rename in script to new app name
* Geb tests
* DB migration
* Google analytics
* Mailchimp integration
* Mandrill integration
* Sign up button in main nav
* Dropdown login form
* Test nav bar collapse
* Password change
* Look for minifier that works with Less CSS plugin
