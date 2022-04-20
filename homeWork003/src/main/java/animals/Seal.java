package animals;

import animals.interfaces.*;
import food.*;

public class Seal extends Carnivorous implements Voice, Swim {
    private String name;
    private String voice;
    private AviarySize aviarySize;

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public Seal(String name, String voice, AviarySize aviarySize) {
        this.name = name;
        this.voice = voice;
        this.aviarySize = aviarySize;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Grass) {
            System.out.println("Seal " + name + " does not eat this");
        } else {
            System.out.println("Seal " + getName());
            super.eat(food);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public void voice() {
        System.out.println("Seal " + name + " say: " + voice);
    }

    @Override
    public void swim() {
        System.out.println("My name is " + name + " and i can SWIM underwater");
    }

}
