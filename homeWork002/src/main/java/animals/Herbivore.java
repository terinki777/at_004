package animals;

import food.Food;
import food.Meat;

//травоядное
public class Herbivore extends Animal {
    private String name;
    private int satiety; //сытость

    public String getName() {
        String name = "Herbivore";
        return name;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Meat) {
            System.out.println("[EAT][ERROR] "+getClass().getSimpleName() + " does not eat this");
        } else {
            System.out.println("[EAT] "+getClass().getSimpleName() + " " + getName() + " EAT");
            satiety += 1;
        }
    }

    @Override
    public int getSatiety() {
        return satiety;
    }
}
