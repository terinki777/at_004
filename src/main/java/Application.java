import model.Kotik;

public class Application {
    public static void main(String[] args) {
        int sat = (int) (Math.random() * 6) + 1;
        //Программа должна создавать два экземпляра класса Kotik
        Kotik kot = new Kotik(1, "Rich", 15, "meooow");
        Kotik cat = new Kotik(2, "Jess", 10, "meoow");

        kot.eat(sat);
        //Метод liveAnotherDay() должен выводить на экран 24 строки.
        kot.song();


        //Программа должна выводить на экран результат сравнения переменных meow у созданных объектов.
        if (kot.getMeow() == cat.getMeow())
            System.out.println("Мы мяукаем одинаково");
        else
            System.out.println("Мы мяукаем по разному");

        //Программа должна выводить на экран количество созданных объектов.
        System.out.println("Количество котиков: " + Kotik.getCount());
      
    }
}
