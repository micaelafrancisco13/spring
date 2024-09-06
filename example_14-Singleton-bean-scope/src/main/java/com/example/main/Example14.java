package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example14 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices", VehicleServices.class);
        System.out.println("Hashcode of the object vehicleServices1 : " + vehicleServices1.hashCode());
        System.out.println("Hashcode of the object vehicleServices2 : " + vehicleServices2.hashCode());
        System.out.println("vehicleServices1 == vehicleServices2 " + (vehicleServices1 == vehicleServices2));

        // vehicleServices1 and vehicleServices2 point to the same object in memory

//        Only one shared instance of a singleton bean is managed, and all requests for beans with an ID or IDs
//        that match that bean definition results in that one specific bean instance being returned by the Spring container.
//        To put it another way, when you define a bean definition and it is scoped as a singleton, the Spring IoC container
//        creates exactly one instance of the object defined by that bean definition. This single instance is stored in a
//        cache of such singleton beans, and all subsequent requests and references for that named bean return the cached object.

        // Singleton-scoped beans are more suitable for immutable objects
    }
}
