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