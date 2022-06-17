package animals;

import food.*;

public abstract class Animal {

    public abstract void eat(Food food);

    public abstract int getSatiety();

    public abstract String getName();
}
