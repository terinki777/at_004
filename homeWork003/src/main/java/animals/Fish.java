package animals;

import animals.interfaces.Swim;
import food.*;

import java.util.Objects;

public class Fish extends Carnivorous implements Swim {
    private String name;
    private AviarySize aviarySize;

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public Fish(String name, AviarySize aviarySize) {
        this.name = name;
        this.aviarySize = aviarySize;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Grass) {
            System.out.println("Fish " + name + " does not eat this");
        } else {
            System.out.println("Fish " + getName());
            super.eat(food);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public void swim() {
        System.out.println("My name is " + name + " and i can SWIM underwater");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Fish fish = (Fish) o;

        return fish.name == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
