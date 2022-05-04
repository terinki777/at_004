package animals;

import animals.interfaces.Swim;
import food.*;

public class Fish extends Carnivorous implements Swim {
    private String name;

    public Fish(String name) {
        this.name = name;
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
}
