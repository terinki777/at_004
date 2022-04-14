package animals;

import food.*;

public class Fish extends Carnivorous{
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
}
