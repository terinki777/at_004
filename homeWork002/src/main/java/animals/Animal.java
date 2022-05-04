package animals;

import animals.interfaces.*;
import food.*;

public abstract class Animal implements Run, Swim, Voice, Fly {
    private int satiety; //сытость

    public void eat(Food food) {
        System.out.println("Eating:");
        food.getName();
        if(food instanceof Grass)
        satiety++;
        else satiety+=2;
    }

    public abstract String getVoice();
    public abstract String getName();

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
        //System.out.println("VOICE");
    }

    public int getSatiety() {
        return satiety;
    }
}
