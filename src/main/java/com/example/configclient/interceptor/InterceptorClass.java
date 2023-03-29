package com.example.configclient.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class InterceptorClass implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("inside interceptor class's prehandle method");

//        String auth = request.getHeader("Authorization");
//        if (auth == null) {
//            log.info("Authorization is null");
//            return false;
//        } else if (auth.equals("test")) {
//            log.info("Test authorization");
//            return true;
//        } else {
//            log.info("invalid value of authorization");
//            return false;
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
        log.info("inside interceptor class's posthandle method");
        response.addHeader("isTrue", "true");//this does not work
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex != null) {
            ex.printStackTrace();
        }
        log.info("[afterCompletion][" + request + "][exception: " + ex + "]");// this also not working as i expected
    }

}
