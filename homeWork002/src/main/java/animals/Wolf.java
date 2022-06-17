package animals;

import animals.interfaces.Run;
import animals.interfaces.Voice;

public class Wolf extends Carnivorous implements Voice, Run {
    private String name;
    private String voice;

    public Wolf(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    public String getName() {
        return name;
    }

    @Override
    public void voice() {
        System.out.println("Wolf " + name + " say: " + voice);
    }

    @Override
    public void run() {
        System.out.println("My name is " + name + " and i can RUN fast");
    }
}
