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
    public static void liveAnotherDay() {
//int a = (int) Math.random();
    }

    public static int getCount() {
        return count;
    }

    public void eat(int satiety) {
        this.satiety += satiety;
    }

    public void eat(int satiety, String nameFood) {
        this.satiety = satiety;
    }

    public boolean eat() {
        return eat();
    }

    //Методы поведения котика (play(), sleep(), chaseMouse(), и. т.д) должны иметь возвращаемый тип данных boolean.
    public boolean play() {
        return false;
    }

    public boolean sleep() {
        return false;
    }

    public boolean chaseMouse() {
        return false;
    }

    public boolean song() {
        if (satiety > 1) {
            System.out.println("Kitty " + name.toUpperCase() + " sings...");
            return true;
        } else {
            System.out.println("Kitty " + name.toUpperCase() + " doesn't want to sing. I have eat.");
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
