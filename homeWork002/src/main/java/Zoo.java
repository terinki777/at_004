import animals.*;
import food.*;

public class Zoo {
    public static void main(String[] args) {
        Duck duck = new Duck();

        Food chicken = new Chicken();
        Food fruit = new Fruit();
        duck.eat(fruit);
        // f.getName();

    }

}
