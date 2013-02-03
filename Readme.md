Galahad - webapp
================

A starter project for a typical consumer web app based on Twitter Bootstrap and a curated set of plugins.


Usage
-----

Simply clone the project, change the `app.name` property in `application.properties`, and start your own Git repo.

    git clone https://github.com/grails-galahad/webapp.git myapp
    cd myapp
    rm -rf .git
    sed -i "" "s/webapp/myapp/" application.properties
    git init


About Galahad
-------------

Named after Sir Galahad the Pure, Galahad is a collection of pristine Grails starter projects for specific use cases. Each project reflects a set of opinionated choices about design paradigms, plugins, and testing methodologies.


TODO
----
* Application rename and repackage script
* Implement remember me token
* Sign up button in main nav
* Dropdown login form
* SSL
* Test nav bar collapse
* Heroku plugin
* Cookie/DB sessions
* Add admin security group and menu
* Add console plugin
* Enable db console in prod and secure
* Geb tests
* Google analytics
* Mailchimp integration
* Mandrill integration
* Password change
* Look for minifier that works with Less CSS plugin
