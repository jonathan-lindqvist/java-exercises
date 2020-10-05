package exercises.ex1inheritance;

import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Vehicle {
    private String id;
    private Person owner;

    public Vehicle(Person owner, String id) {
        this.id = id;
        this.owner = owner;
    }

    public Person getOwner(){
        return owner;
    }

    public String getId(){
        return id;
    }
}
