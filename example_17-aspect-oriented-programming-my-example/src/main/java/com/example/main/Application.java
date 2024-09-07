package com.example.main;

import com.example.config.ApplicationConfiguration;
import com.example.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        /*
         * The UserService class is the target object.
         *
         * When Spring creates a proxy for UserService, the proxy will handle method calls and apply the necessary aspects:
         * */
        var userService = context.getBean(UserService.class);

        // The proxy intercepts these calls (line 19 and 20)
        userService.createUser();
        System.out.println("User: " + userService.getUser());

        /*
         * The proxy object intercepts the createUser() and applies the aspects before or after calling the actual method.
         *
         * createUser() and getUser(): These methods are join points because they represent specific execution points where the
         * aspect's advice (e.g., logging) is applied.
         * */
    }
}
