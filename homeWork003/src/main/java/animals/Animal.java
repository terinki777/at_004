package animals;

import food.*;

public abstract class Animal {
    private int satiety; //сытость
    private AviarySize aviarySize;
    Animal animal;


    public AviarySize getAviarySize() {
        return aviarySize;
    }

    public void eat(Food food) {
        System.out.print("Eating: ");
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
