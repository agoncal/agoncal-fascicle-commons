mvn package -Dquarkus.container-image.build=true -Dquarkus.container-image.push=true

Creates the following image:

```
$ docker image ls

REPOSITORY                   TAG   
agoncal/hello-fascicle       latest
```
