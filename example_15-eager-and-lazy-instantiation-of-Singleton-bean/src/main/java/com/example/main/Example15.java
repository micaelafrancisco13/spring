package com.example.main;

import com.example.beans.Person;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example15 {

    /*
    * With eager instantiation, even before main() gets executed, the Person bean is already created by the Spring IoC container.
    * In contrast, with lazy instantiation, the Person bean will only be created if and only if it's used (e.g., by getBean(),
    * dependency injection, or by autowiring).
    * */

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Before retrieving the Person bean from the Spring Context");
        Person person = context.getBean(Person.class);
        System.out.println("After retrieving the Person bean from the Spring Context");
    }
}
