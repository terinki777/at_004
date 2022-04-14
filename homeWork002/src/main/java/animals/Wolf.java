package animals;

import animals.interfaces.Run;
import animals.interfaces.Voice;
import food.Food;
import food.Grass;

public class Wolf extends Carnivorous implements Voice, Run {
    private String name;
    private String voice;

    public Wolf(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    public String getName() {
        return name;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Grass) {
            System.out.println("Wolf " + name + " does not eat this");
        } else {
            System.out.println("Wolf " + getName());
            super.eat(food);
        }
    }

    @Override
    public void voice() {
        System.out.println("Wolf " + name + " say: " + voice);
    }

    @Override
    public void run() {
        System.out.println("My name is " + name + " and i can RUN fast");
    }
}
