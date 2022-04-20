package animals;

import animals.interfaces.Run;
import animals.interfaces.Voice;
import food.Food;
import food.Meat;

public class Bull extends Herbivore implements Voice, Run {
    private String name;
    private String voice;
    private AviarySize aviarySize;

    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public Bull(String name, String voice, AviarySize aviarySize) {
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
            System.out.println("Bull " + name + " does not eat this");
        } else {
            System.out.println("Bull " + getName());
            super.eat(food);
        }
    }

    @Override
    public void voice() {
        System.out.println("Bull " + name + " say: " + voice);
    }

    @Override
    public void run() {
        System.out.println("My name is " + name + " and i can RUN slow");
    }
}
