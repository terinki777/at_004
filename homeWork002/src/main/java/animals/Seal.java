package animals;

import animals.interfaces.*;

public class Seal extends Carnivorous implements Voice, Swim {
    private String name;
    private String voice;

    public Seal(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }


    public String getName() {
        return name;
    }

    @Override
    public void voice() {
        System.out.println("Seal " + name + " say: " + voice);
    }

    @Override
    public void swim() {
        System.out.println("My name is " + name + " and i can SWIM underwater");
    }

}
