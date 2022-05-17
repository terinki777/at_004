package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calc {
    private static double ans;

    public Object result(String action, String one, String two) {
        double dOne = 0.0;
        double dTwo = 0.0;

        try {
            dOne = Double.parseDouble(one);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        try {
            dTwo = Double.parseDouble(two);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        if (dOne <= 10000 && dOne >= -10000 && dTwo <= 10000 && dTwo >= -10000) {
            switch (action) {
                case "+":
                    ans = dOne + dTwo;
                    break;
                case "-":
                    ans = dOne - dTwo;
                    break;
                case "*":
                    ans = dOne * dTwo;
                    break;
                case "/":
                    ans = dOne / dTwo;
                    break;
                default:
                    System.out.println("[ERROR] Unknown operation " + "'" + action + "'");
                    return null;

            }

        } else System.out.println("[ERROR] Out of range");

        try {
            ans = new BigDecimal(ans).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Zero division");
            return null;
        }

        System.out.println("ANSWER: "+dOne+" "+action+" "+dTwo+" = " + ans);
        return ans;
    }
}