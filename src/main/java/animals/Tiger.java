package animals;

import animals.interfaces.Run;
import animals.interfaces.Voice;
import food.*;

public class Tiger extends Carnivorous implements Voice, Run {
    private String name;
    private String voice;


    public Tiger(String name, String voice) {
        this.name = name;
        this.voice = voice;
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

    @Override
    public void voice() {
        System.out.println("Tiger " + name + " say: " + voice);
    }

    @Override
    public void run() {
        System.out.println("My name is " + name + " and i can RUN fast");
    }
}
