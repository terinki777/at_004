package animals;

import animals.interfaces.*;
import food.*;

public class Duck extends Herbivore implements Voice, Swim, Fly {
    private String name;
    private String voice;

    public Duck(String name, String voice) {
        this.name = name;
        this.voice = voice;
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

    @Override
    public void voice() {
        System.out.println("Duck " + name + " say: " + voice);
    }

    @Override
    public void swim() {
        System.out.println("My name is " + name + " and i can SWIM above water");
    }

    @Override
    public void fly() {
        System.out.println("My name is " + name + " and i can FLY");
    }
}
