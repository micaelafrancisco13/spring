package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
     * WebMvcConfigurer: This interface provides methods to configure Spring MVC. By implementing it, you can customize aspects like
     * adding view controllers, interceptors, message converters, etc. Here, the class only overrides one method: addViewControllers.
     *
     * The method below allows you to register simple automated controllers (i.e., view controllers) without the need for a full
     * controller class. A view controller directly maps a URL to a view name without any custom logic or business code.
     * */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // This maps the URL path /courses to the view named courses. When someone visits /courses, Spring will serve a view named
        // courses.html
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/about").setViewName("about");
    }

}
