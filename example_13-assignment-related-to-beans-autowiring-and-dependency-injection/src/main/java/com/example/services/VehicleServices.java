package com.example.services;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

    private final Speakers speakers;
    private final Tyres tyres;

    public VehicleServices(@Qualifier("sonySpeakers") Speakers speakers, Tyres tyres) {
        this.speakers = speakers;
        this.tyres = tyres;
    }

    public void playMusic() {
        String music = speakers.makeSound();
        System.out.println(music);
    }

    public void moveVehicle() {
        String status = tyres.rotate();
        System.out.println(status);
    }

}
