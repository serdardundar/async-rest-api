# Comparing Async and Sync Service Performance

This service is developed to compare @Async annotated methods using 3rd party services.
Sync test url: localhost:8080/testSync
Async test url: localhost:8080/testAsync

The only difference between two services is using @Async annotation on top of each public methods.
When you run the project, you shall do two tests with above urls then the duration in milliseconds for each service will be shown in logs such as:

`[nio-8080-exec-5] i.s.a.web.AsyncRestController            : Sync Duration: 4531`

and 

`[nio-8080-exec-1] i.s.a.web.AsyncRestController            : Async Duration: 1598`

as seen in the logs Async is faster 3 times than Sync methods.

