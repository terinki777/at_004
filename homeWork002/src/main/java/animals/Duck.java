package animals;

import food.*;

public class Duck extends Herbivore {
    private String name;
    private String voice;

    public Duck(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Meat) {
            System.out.println("Duck " + name + " does not eat this");
        } else {
            System.out.println("Duck " + getName());
            super.eat(food);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String getVoice() {
        return voice;
    }
    @Override
    public void voice() {
        System.out.println("KRYA-KRYA");
    }
}
