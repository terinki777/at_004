package animals;

import animals.interfaces.Run;
import animals.interfaces.Voice;
import food.Food;
import food.Meat;

import java.util.Objects;

public class Elephant extends Herbivore implements Voice, Run {
    private String name;
    private String voice;
    private AviarySize aviarySize;

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public Elephant(String name, String voice, AviarySize aviarySize) {
        this.name = name;
        this.voice = voice;
        this.aviarySize = aviarySize;
    }

    public String getName() {
        return name;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Meat) {
            System.out.println("Elephant " + name + " does not eat this");
        } else {
            System.out.println("Elephant " + getName());
            super.eat(food);
        }
    }

    @Override
    public void voice() {
        System.out.println("Elephant " + name + " say: " + voice);
    }

    @Override
    public void run() {
        System.out.println("My name is " + name + " and i can RUN slow");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Elephant elephant = (Elephant) o;

        return elephant.name == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
