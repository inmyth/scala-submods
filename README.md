# Scala Submodules

Proof of concepts, snippets...

### JWTManual
JWT manual authentication. To be used for websocket. 

### VertxWS
Websocket in Vertx.

### SubstrateVM / native-image
Turn jar into executable native binary. So far the biggest problem in the build is logging tool.
Currently the only logging tools that work is lone slf4j w/o implementation or with slf4j-simple.
```
native-image -jar my-app.jar 
-H:IncludeResources=".*.xml|.*.conf" 
-H:+ReportUnsupportedElementsAtRuntime 
-H:+TraceClassInitialization 
--initialize-at-build-time=org.slf4j.simple.SimpleLogger,org.slf4j.LoggerFactory
-H:Name=my-app
--verbose
```
Check my SO anwer:
https://stackoverflow.com/questions/60654455/how-to-fix-try-avoiding-to-initialize-the-class-that-caused-initialization-wit  

