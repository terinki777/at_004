import animals.*;
import animals.interfaces.*;
import food.*;


public class Zoo {
    public static void main(String[] args) {
        Duck duck = new Duck("Scrooge", "krya-krya");
        Tiger tiger = new Tiger("Tigra", "ARRRR");
        Fish fish = new Fish("Golden");
        Seal seal = new Seal("Billy", "Meow");
        Worker worker = new Worker("Peter");
        Food meat = new Meat();
        Food grass = new Grass();
        Swim[] pond = new Swim[3];
        pond[0] = duck;
        pond[1] = fish;
        pond[2] = seal;

        fish.eat(meat);
        System.out.println();

        duck.eat(grass);
        System.out.println();

        worker.feed(tiger, grass);
        System.out.println();
        worker.feed(tiger, meat);
        System.out.println();

        tiger.eat(meat);
        System.out.println();

        worker.feed(duck, grass);
        System.out.println();

        worker.getVoice(duck);
        worker.getVoice(tiger);
        worker.getVoice(seal);
        System.out.println();

        System.out.println("MASSIVE POND:");
        for (Swim p : pond) {
            p.swim();
        }
        System.out.println();
        System.out.println("Duck satiety: " + duck.getSatiety());
        System.out.println("Tiger satiety: " + tiger.getSatiety());

    }

}
