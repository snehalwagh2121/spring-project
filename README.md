#LOGGING

mostly used logging pattern:<br>
*%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}*

clr means color. The following colors are supported:
1. blue
2. cyan
3. faint
4. green

When a file in the classpath has one of the following names, Spring Boot will automatically load it over the default configuration:

1. logback-spring.xml
2. logback.xml
3. logback-spring.groovy
4. logback.groovy

## MDC
we can create a filter which will generate a random UUID and can be passed in every request. This will help in tracking the flow.
sample Code:
```java
@Component
public class MDCFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        MDC.put("tracking", request.getHeader("tracking-header"));
        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
```

#EXCEPTION HANDLING IN SPRING BOOT

Some annotations that spring boot provides:
1. @ResponseStatus
2. @ExceptionHandler
3. @ControllerAdvice

the property **server.error.include-message=always** sends the message of exception in the response.

![exception](exception-msg.png)

properties of logger:
[click here](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.server)


@ResponseStatus specifies the status of Http request to be sent as response.

@ExceptionHAndler as the name suggests, it handles the excpetion. Whenever we annotate a method with ExceptionHandler and provide the name of the exception to be handled, the particular method is called just before sending the response and will be executed.

eg:
```java
@ExceptionHandler(Sample404ExceptionClass.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleSample404Exception(Sample404ExceptionClass e) {
        log.info("handling Sample404 Exception using Exception handler");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
```

Here whenever a Sample404Exception is supposed to be thrown, the handleSample404Exception method is called.

But for @ExceptionHandler to be executed, we need @ControllerAdvice or @RestControllerAdvice on top of the class.

```java
@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Sample404ExceptionClass.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleSample404Exception(Sample404ExceptionClass e) {
        log.info("handling Sample404 Exception using Exception handler");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
```
