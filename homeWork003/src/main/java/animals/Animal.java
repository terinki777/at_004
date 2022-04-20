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
        System.out.println("Eating: ");
        food.getName();
        if (food instanceof Grass)
            satiety++;
        else satiety += 2;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (getClass() != o.getClass()) return false;
//        Animal animal = (Animal) o;
//        return name == animal.getName();
//    }


    public int getSatiety() {
        return satiety;
    }

    public abstract String getName();

}
