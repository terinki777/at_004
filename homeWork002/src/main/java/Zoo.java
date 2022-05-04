import animals.*;
import food.*;

public class Zoo {
    public static void main(String[] args) {
        Duck duck = new Duck("Scrooge","krya-krya");
        Tiger tiger = new Tiger("Tigra");
        Fish fish = new Fish("Golden");
        Worker worker = new Worker("Peter");
        Food meat = new Meat();
        Food grass = new Grass();

        fish.eat(meat);
        duck.eat(grass);
        System.out.println();

        worker.feed(tiger,grass);
        System.out.println();

        tiger.eat(meat);
        System.out.println();

        System.out.println("Duck satiety: "+duck.getSatiety());
        System.out.println("Tiger satiety: "+tiger.getSatiety());
        System.out.println("Duck voice: "+duck.getVoice());
        //System.out.println("Fish voice: "+fish.voice());
        fish.voice();
        //tiger.eat(meat);

    }

}
