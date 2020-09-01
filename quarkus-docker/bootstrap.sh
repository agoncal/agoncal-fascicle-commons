#!/usr/bin/env bash

mvn io.quarkus:quarkus-maven-plugin:1.7.1.Final:create \
     -DprojectGroupId=org.agoncal.fascicle.commons \
     -DprojectArtifactId=hello-fascicle \
     -DprojectVersion=1.0-SNAPSHOT \
     -DclassName="org.agoncal.fascicle.commons.quarkus.docker.HelloFascicle" \
     -Dpath="/hello" \
     -Dextensions="resteasy-jsonb,docker"
