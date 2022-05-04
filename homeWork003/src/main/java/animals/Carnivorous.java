package animals;

import food.Food;
import food.Grass;


//плотоядное
public abstract class Carnivorous extends Animal {

    public String getName() {
        String name = "Carnivorous";
        return name;
    }

    public void eatEx (Food food)throws WrongFoodException{
        if (food instanceof Grass) {
            throw new WrongFoodException("Carnivorous does not eat this");
        } else {
            System.out.print(getName()+" ");
            super.eat(food);
        }
    }
}
