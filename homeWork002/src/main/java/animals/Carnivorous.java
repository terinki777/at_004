package animals;

import food.Food;
import food.Grass;

//плотоядное
public abstract class Carnivorous extends Animal {
    private int satiety; //сытость
    private String name;

    public String getName() {
        String name = "Carnivorous";
        return name;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Grass) {
            System.out.println("[EAT][ERROR] "+getClass().getSimpleName() + " does not eat this");
        } else {
            System.out.println("[EAT] "+getClass().getSimpleName() + " " + getName() + " EAT");
            satiety += 2;
        }
    }

    @Override
    public int getSatiety() {
        return satiety;
    }
}
