Galahad - webapp
================
A starter project for a typical consumer web app based on Twitter Bootstrap and a curated set of plugins.

Usage
-----
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


Heroku Setup
------------
    heroku config:add -a webapp BUILDPACK_URL=https://github.com/grails-galahad/heroku-buildpack-grails.git
    heroku config:add -a webapp GRAILS_ENV="production"
    heroku labs:enable -a webapp user-env-compile


About Galahad
-------------
Named after Sir Galahad the Pure, Galahad is a collection of pristine Grails starter projects for specific use cases. Each project reflects a set of opinionated choices about design tradeoffs, plugins, testing methodologies, and 3rd party service providers (like hosting and email).
