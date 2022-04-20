package animals;

import food.*;

public class Tiger extends Carnivorous {
    private String name;
    private String voice;


    public Tiger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Grass) {
            System.out.println("Tiger "+name+" does not eat this");
        } else {
            System.out.println("Tiger "+getName());
            super.eat(food);
        }
    }

    @Override
    public void voice() {
        System.out.println("ARRRRRR");
    }
}
