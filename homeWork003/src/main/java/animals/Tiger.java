package animals;

import animals.interfaces.Run;
import animals.interfaces.Voice;
import food.*;

import java.util.Objects;

public class Tiger extends Carnivorous implements Voice, Run {
    private String name;
    private String voice;
    private AviarySize aviarySize;


    public Tiger(String name, String voice, AviarySize aviarySize) {
        this.name = name;
        this.voice = voice;
        this.aviarySize = aviarySize;
    }

    public String getName() {
        return name;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Grass) {
            System.out.println("Tiger " + name + " does not eat this");
        } else {
            System.out.println("Tiger " + getName());
            super.eat(food);
        }
    }

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    @Override
    public void voice() {
        System.out.println("Tiger " + name + " say: " + voice);
    }

    @Override
    public void run() {
        System.out.println("My name is " + name + " and i can RUN fast");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Tiger tiger = (Tiger) o;

        return tiger.name == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
