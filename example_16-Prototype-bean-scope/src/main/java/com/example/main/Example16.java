package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example16 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices", VehicleServices.class);
        System.out.println("Hashcode of the object vehicleServices1 : " + vehicleServices1.hashCode());
        System.out.println("Hashcode of the object vehicleServices2 : " + vehicleServices2.hashCode());
        System.out.println("vehicleServices1 == vehicleServices2 " + (vehicleServices1 == vehicleServices2));

        /*
        * vehicleServices1 and vehicleServices2 do not point to the same object in memory.
        *
        * Prototype-scoped beans may be used to avoid race conditions when modifying the same object in memory.
        * There is no concept of eager and lazy instantiation with prototype-scoped beans because Spring IoC container creates
        * a new instance whenever that bean is used.
        * It is rarely used.
        *
        * The non-singleton prototype scope of bean deployment results in the creation of a new bean instance every time a
        * request for that specific bean is made. That is, the bean is injected into another bean or you request it through
        * a getBean() method call on the container. As a rule, you should use the prototype scope for all stateful beans and
        * the singleton scope for stateless beans.
        *
        * Singleton Beans with Prototype-bean Dependencies
        * When you use singleton-scoped beans with dependencies on prototype beans, be aware that dependencies are resolved
        * at instantiation time. Thus, if you dependency-inject a prototype-scoped bean into a singleton-scoped bean, a new
        * prototype bean is instantiated and then dependency-injected into the singleton bean. The prototype instance is the
        * sole instance that is ever supplied to the singleton-scoped bean.
        *
        * However, suppose you want the singleton-scoped bean to acquire a new instance of the prototype-scoped bean repeatedly
        * at runtime. You cannot dependency-inject a prototype-scoped bean into your singleton bean, because that injection
        * occurs only once, when the Spring container instantiates the singleton bean and resolves and injects its dependencies.
        * If you need a new instance of a prototype bean at runtime more than once, see Method Injection.
        * */

        // Prototype-scoped beans are more suitable for mutable objects in order to avoid race conditions (confinement solution).

    }
}
