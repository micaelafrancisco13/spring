package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Example13 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var beansFromPerson = context.getBeanNamesForType(Person.class);
        System.out.println(Arrays.toString(beansFromPerson)); // prints "[personBean]"

        var beansFromVehicle = context.getBeanNamesForType(Vehicle.class);
        System.out.println(Arrays.toString(beansFromVehicle)); // prints "[vehicleBean]"

        var vehicle = context.getBean(Vehicle.class);
        vehicle.getVehicleServices().moveVehicle(); // prints "Vehicle moving with Michelin tyres"
        vehicle.getVehicleServices().playMusic(); // prints "Playing music with Sony speakers"

        // MichelinTyres is annotated with @Primary
        // SonySpeakers constructor injection is annotated with @Qualifier

        // line 21 to 23 is identical to the following lines below
        var person = context.getBean(Person.class);
        person.getVehicle().getVehicleServices().moveVehicle();
        person.getVehicle().getVehicleServices().playMusic();
    }
}
