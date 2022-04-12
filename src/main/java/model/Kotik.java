package model;

public class Kotik {
    //Все переменные в классе Kotik должны быть private.
    private static int count;
    private int prettiness;
    private String name;
    private int weight;
    private String meow;
    private int satiety; //сытость

    public Kotik() {
        count++;
    }

    public Kotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
        count++;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
    }

    //Метод liveAnotherDay() должен выводить на экран 24 строки.
    public void liveAnotherDay() {
        for (int i = 1; i <= 24; i++) {
            int rand = (int) (Math.random() * 5) + 1;
            System.out.println(" День " + i + ":");
            switch (rand) {
                case 1:
                    eat();
                    break;
                case 2:
                    play();
                    break;
                case 3:
                    sleep();
                    break;
                case 4:
                    chaseMouse();
                    break;
                case 5:
                    song();
                    break;
                default:
                    System.out.println("Не лезьте ко мне!");
                    break;
            }

        }
    }

    public static int getCount() {
        return count;
    }

    public void eat(int satiety) {
        this.satiety += satiety;
        System.out.println("Котик кушает");
    }

    public void eat(int satiety, String nameFood) {
        this.satiety += satiety;
        System.out.println("Котик кушает " + nameFood);
    }

    public boolean eat() {
        if (satiety <= 1) {
            eat(1, "");
            System.out.println("Котик кушает");
            return true;
        } else
            return false;

    }

    //Методы поведения котика (play(), sleep(), chaseMouse(), и. т.д) должны иметь возвращаемый тип данных boolean.
    public boolean play() {
        if (satiety > 1) {
            System.out.println("Котик " + name.toUpperCase() + " играет с игрушками.");
            satiety--;
            return true;
        } else {
            System.out.println("Котик " + name.toUpperCase() + " не хочет играть, он хочет есть.");
            satiety++;
            System.out.println("Кушай котик " + name.toUpperCase());
            play();
            return false;
        }
    }

    public boolean sleep() {
        if (satiety > 1) {
            System.out.println("Котик " + name.toUpperCase() + " спит.");
            satiety--;
            return true;
        } else {
            System.out.println("Котик " + name.toUpperCase() + " не хочет спать, он хочет есть.");
            satiety++;
            System.out.println("Кушай котик " + name.toUpperCase());
            sleep();
            return false;
        }
    }

    public boolean chaseMouse() {
        if (satiety > 1) {
            System.out.println("Котик " + name.toUpperCase() + " ловит мышь.");
            satiety--;
            return true;
        } else {
            System.out.println("Котик " + name.toUpperCase() + " не хочет ловить мышь, он хочет есть.");
            satiety++;
            System.out.println("Кушай котик " + name.toUpperCase());
            chaseMouse();
            return false;
        }
    }

    public boolean song() {
        if (satiety > 1) {
            System.out.println("Котик " + name.toUpperCase() + " поет...");
            return true;
        } else {
            System.out.println("Котик " + name.toUpperCase() + " не хочет петь, он хочет есть.");
            satiety++;
            System.out.println("Кушай котик " + name.toUpperCase());
            song();
            return false;
        }
    }


    public int getSatiety() {
        return satiety;
    }

    public int getPrettiness() {
        return prettiness;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getMeow() {
        return meow;
    }
}
