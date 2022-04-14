package animals;

import animals.interfaces.*;
import food.*;

public abstract class Animal {
    private int satiety; //сытость

    public void eat(Food food) {
        System.out.println("Eating:");
        food.getName();
        if (food instanceof Grass)
            satiety++;
        else satiety += 2;
    }

    public int getSatiety() {
        return satiety;
    }

    public abstract String getName();
}
