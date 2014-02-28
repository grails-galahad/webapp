# Galahad - webapp
A starter project for a typical consumer web app based on Twitter Bootstrap, LESS, jQuery and a curated set of plugins, hosted on Heroku, and using MailChimp and Mandrill for email.

##Usage
Simply clone the project, run galahad-init, and init your own git repo.

    git clone https://github.com/grails-galahad/webapp.git myapp
    cd myapp
    rm -rf .git
    grails galahad-init myapp
    git init
    git add .
    git ci -am "Initial commit"
    heroku create
    git push heroku master
    heroku open


##Heroku Setup
Basic setup

    heroku labs:enable -a myapp user-env-compile
    heroku config:add -a myapp GRAILS_ENV="production"
    heroku config:add -a myapp BUILDPACK_URL=https://github.com/grails-galahad/heroku-buildpack-grails.git
    heroku config:set -a myapp JAVA_OPTS="-Xms832m -Xmx832m"
    (after starting 1st dyno) heroku ps:resize -a myapp web=2x

Production database

    heroku addons:add -a myapp heroku-postgresql:crane
    heroku pg:promote -a myapp CHARCOAL
    heroku addons:add -a myapp pgbackups:auto-month

SSL and custom domain

    heroku addons:add -a myapp ssl
    heroku certs:add -a myapp src/security/myapp.crt src/security/myapp.key
    heroku domains:add -a myapp www.myapp.com

Pre-boot (zero downtime deploys)

    heroku labs:enable -a myapp preboot

Monitoring and log alerts

    heroku addons:add -a myapp newrelic:standard
    heroku config:set -a myapp JAVA_OPTS="-Xms832m -Xmx832m -javaagent:newrelic/newrelic.jar"
    heroku addons:add -a myapp papertrail:choklad


##About Galahad
Named after Sir Galahad the Pure, Galahad is a collection of pristine Grails starter projects for specific use cases. Each project reflects a set of opinionated decisions about design, plugins, testing methodologies and 3rd party service providers, and is intended to be a starting point for developing a production Grails app based on best practices.

##Known Issues

###Validation errors on embedded fields not being enforced
* When validation errors exist only for an embedded object, errors are not displayed and invalid state is saved
* Workaround is to call discard() in controller

##To Do
* Remove Project and Tasks during init
* Geb tests
    * FunctionalSpecBase for resetting DB
* Security filter test (may require adding package to filter class)
* Implement fixtures plugin
* Add NewRelic
* Mailchimp integration
* Braintree integration
* Google analytics
* Auto-generate ImageResources.groovy
* Password change
* Dropdown login form
* Job cluster sync util (?)
* Rich text field with tinyMCE (?)
