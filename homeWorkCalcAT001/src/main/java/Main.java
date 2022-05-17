import calculator.Calc;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String action = "";
        Calc calc = new Calc();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Input operation ('+' | '-' | '*' | '/' | 'q' - exit): ");
            action = in.nextLine();
            if(action.equals("q")) {
                break;
            }
            System.out.print("Input number #1: ");
            String one = in.nextLine();
            System.out.print("Input number #2: ");
            String two = in.nextLine();

            calc.result(action, one, two);
        }
        System.exit(0);
    }
}