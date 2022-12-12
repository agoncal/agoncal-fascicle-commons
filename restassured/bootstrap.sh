#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:3.0.0.Alpha2:create \
    -DplatformVersion=3.0.0.Alpha2 \
    -DprojectGroupId=org.agoncal.fascicle.commons \
    -DprojectArtifactId=restassured \
    -DprojectVersion=1.0 \
    -DclassName="org.agoncal.fascicle.commons.restassured.CustomerResource" \
    -Dpath="/customers" \
    -Dextensions="resteasy, resteasy-jsonb"
