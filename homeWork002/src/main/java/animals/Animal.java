package animals;

import animals.interfaces.Fly;
import animals.interfaces.Run;
import animals.interfaces.Swim;
import animals.interfaces.Voice;
import food.Food;

public class Animal implements Run, Swim, Voice, Fly {
    public void eat(Food food) {
        System.out.println("Покормили: ");
        food.getName();
    }

    public void fly() {
        System.out.println("FLY");
    }

    public void run() {
        System.out.println("RUN");
    }

    public void swim() {
        System.out.println("SWIM");
    }

    public void voice() {
        System.out.println("VOICE");
    }
}
