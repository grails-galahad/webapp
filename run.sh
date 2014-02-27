#!/bin/bash

java -Djetty.port=8080 -jar server/jetty-runner.jar --config server/jetty.xml target/*.war
