import animals.*;
import food.*;

import static animals.AviarySize.*;


public class Zoo {
    public static void main(String[] args) {
        Duck duck = new Duck("Scrooge", "krya-krya", SMALL);
        Tiger tiger = new Tiger("Tigra", "ARRRR", BIG);
        Wolf wolf = new Wolf("Akella", "uuuuu", MEDIUM);
        Fish fish = new Fish("Golden", SMALL);
        Seal seal = new Seal("Billy", "Meow", MEDIUM);
        Elephant el = new Elephant("Tom", "UUUUfh", BIGGEST);
        Bull bull = new Bull("Mitchel", "myyy", BIGGEST);
        Worker worker = new Worker("Peter");
        Meat meat = new Meat();
        Grass grass = new Grass();

//        Swim[] pond = new Swim[3];
//        pond[0] = duck;
//        pond[1] = fish;
//        pond[2] = seal;

//        fish.eat(meat);
//        System.out.println();
//
//        duck.eat(grass);
//        System.out.println();
//
//        worker.feed(tiger, grass);
//        System.out.println();
//        worker.feed(tiger, meat);
//        System.out.println();
//
//        tiger.eat(meat);
//        System.out.println();
//
//        worker.feed(duck, grass);
//        System.out.println();
//
//        worker.getVoice(duck);
//        worker.getVoice(tiger);
//        worker.getVoice(seal);
//        System.out.println();

//        System.out.println("MASSIVE POND:");
//        for (Swim p : pond) {
//            p.swim();
//        }

//        System.out.println("Duck satiety: " + duck.getSatiety());
//        System.out.println("Tiger satiety: " + tiger.getSatiety());
//        System.out.println();

        System.out.println("---------AVIARY---------------");
        Aviary<Herbivore> aviaryHerbivore = new Aviary<Herbivore>(BIGGEST);
        Aviary<Carnivorous> aviaryCarnivorous = new Aviary<Carnivorous>(MEDIUM);

        aviaryHerbivore.addAnimal(duck);
        aviaryHerbivore.addAnimal(bull);
        aviaryHerbivore.addAnimal(el);
        System.out.println();
        aviaryCarnivorous.addAnimal(tiger);
        aviaryCarnivorous.addAnimal(seal);
        aviaryCarnivorous.addAnimal(fish);
        aviaryCarnivorous.addAnimal(wolf);

        System.out.println();
        aviaryCarnivorous.viewAllAnimalInAviary();
        System.out.println();
        aviaryHerbivore.viewAllAnimalInAviary();
        System.out.println();
        aviaryHerbivore.removeAnimal(el);
        aviaryHerbivore.viewAllAnimalInAviary();
        System.out.println();
        System.out.println("----------FIND in AVIARY----------");
        aviaryHerbivore.findAnimalInAviary("Mitchel");
        aviaryCarnivorous.findAnimalInAviary("Bill");
        System.out.println();
        System.out.println("----------EXCEPTION----------");
        try {
            duck.eatEx(meat);
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }
        try {
            tiger.eatEx(meat);
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }


    }

}

