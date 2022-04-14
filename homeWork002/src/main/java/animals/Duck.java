package animals;

import food.*;

public class Duck extends Herbivore {
    private Object Meat;

    @Override
    public void eat(Food food) {

        if (food instanceof Meat) {
            System.out.println("Duck does not eat this");
        } else super.eat(food);
    }
}
