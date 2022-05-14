import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String action = "";
        Calc calc = new Calc();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введите тип операции ('+' | '-' | '*' | '/' | 'q' - exit): ");
            action = in.nextLine();
            if(action.equals("q")) {
                break;
            }
            System.out.print("Введите число 1: ");
            String one = in.nextLine();
            System.out.print("Введите число 2: ");
            String two = in.nextLine();

            calc.result(action, one, two);
        }
        System.exit(0);
    }
}