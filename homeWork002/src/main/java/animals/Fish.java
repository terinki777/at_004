package animals;

import animals.interfaces.Swim;

public class Fish extends Carnivorous implements Swim {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void swim() {
        System.out.println("My name is " + name + " and i can SWIM underwater");
    }
}
