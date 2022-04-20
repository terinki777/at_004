import animals.*;
import animals.AviarySize;

import java.util.HashSet;

public class Aviary<T extends Animal> {
    private Animal animal;
    private AviarySize aviarySize;
    HashSet<T> aviary = new HashSet<T>();

    public Aviary(AviarySize aviarySize) {
        this.aviarySize = aviarySize;
    }

    public void addAnimal(T animal) {
        this.animal = animal;
        if (aviarySize.compareTo(animal.getAviarySize()) >= 0) {
            aviary.add(animal);
            System.out.println("[ADD] " + animal.getClass().getSimpleName() + " " + animal.getName() + " ADD in aviary " + animal.getClass().getSuperclass().getSimpleName());
        } else
            System.out.println("[ADD] " + animal.getClass().getSimpleName() + " " + animal.getName() + " NOT ADDED (BIG for this aviary)");
    }

    public void removeAnimal(T animal) {
        if (aviary.contains(animal) == true) {
            aviary.remove(animal);
            System.out.println("[REMOVE] " + animal.getClass().getSimpleName() + " " + animal.getName() + " was removed from aviary " + animal.getClass().getSuperclass().getSimpleName());
        } else System.out.println("[REMOVE] Animal not found");

    }

    public void viewAllAnimalInAviary() {
        System.out.println("[VIEW] Animal in AVIARY " + animal.getClass().getSuperclass().getSimpleName() + ":");
        for (Animal p : aviary) {
            System.out.println(p.getClass().getSimpleName() + " " + p.getName());
        }
    }

    public Animal findAnimalInAviary(String name) {
        for (Animal p : aviary) {
            if (p.getName() == name) {
                System.out.println("[FIND] Animal FOUND: " + p);
                return p;
            }
        }
        System.out.println("[FIND] Animal NOT FOUND");
        return null;
    }

}
