
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
                    System.out.println("Answer = " + ans);
                    break;
                case "-":
                    ans = dOne - dTwo;
                    System.out.println("Answer = " + ans);
                    break;
                case "*":
                    ans = dOne * dTwo;
                    System.out.println("Answer = " + ans);
                    break;
                case "/":
                    ans = dOne / dTwo;
                    System.out.println("Answer = " + ans);
                    break;
                default:
                    System.out.println("[ERROR] Unknown operation "+"'"+action+"'");
                    return null;

            }

        } else System.out.println("[ERROR] Out of range");

        return ans;
    }
}