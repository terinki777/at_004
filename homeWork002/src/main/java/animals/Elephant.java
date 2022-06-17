package animals;

import animals.interfaces.Run;
import animals.interfaces.Voice;

public class Elephant extends Herbivore implements Voice, Run {
    private String name;
    private String voice;

    public Elephant(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    public String getName() {
        return name;
    }

    @Override
    public void voice() {
        System.out.println("Elephant " + name + " say: " + voice);
    }

    @Override
    public void run() {
        System.out.println("My name is " + name + " and i can RUN slow");
    }
}
