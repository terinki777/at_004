package animals;

import food.*;

//травоядное
public class Herbivore extends Animal {
    public String name;
    private int satiety;

    public String getName() {
        String name = "Herbivore";
        return name;
    }

    public void eatEx(Food food) throws WrongFoodException {
        if (food instanceof Meat) {
            throw new WrongFoodException("Herbivore does not eat this");
        } else {
            System.out.println(getName());
            super.eat(food);
        }
    }
}
