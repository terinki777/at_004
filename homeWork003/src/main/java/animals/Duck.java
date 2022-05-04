package animals;

import animals.interfaces.*;
import food.*;

import java.util.Objects;

public class Duck extends Herbivore implements Voice, Swim, Fly {
    public String name;
    private String voice;
    private AviarySize aviarySize;


    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public Duck(String name, String voice, AviarySize aviarySize) {
        this.name = name;
        this.voice = voice;
        this.aviarySize = aviarySize;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Duck " + name + " does not eat this");
        } else {
            System.out.println("Duck " + getName());
            super.eat(food);
        }
    }

    public String getName() {
        return name;
    }


    public void voice() {
        System.out.println("Duck " + name + " say: " + voice);
    }


    public void swim() {
        System.out.println("My name is " + name + " and i can SWIM above water");
    }


    public void fly() {
        System.out.println("My name is " + name + " and i can FLY");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Duck duck = (Duck) o;

        return duck.name == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
