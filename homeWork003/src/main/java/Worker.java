import animals.*;
import animals.interfaces.Voice;
import food.*;

public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    //покормить любое животное любой едой. У метода должно быть два параметра – животное и еда.
    public void feed(Animal animal, Food food) {
        System.out.println("Worker " + name + " feeding a " + animal.getName());
        animal.eat(food);
    }

    public void getVoice(Voice voice) {
        voice.voice();
    }
}
