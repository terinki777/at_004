import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalcTest {

    @DataProvider
    public Object[][] testDataPositive() {
        return new Object[][]{
                {1, "-", "2", "1"},
                {3, "-", "2", "-1"},
                {-3.5, "-", "-2.5", "1"},

                {14, "+", "6", "8"},
                {2, "+", "-6", "8"},
                {14.5, "+", "6", "8.5"},

                {13.5, "*", "3", "4.5"},
                {-13.5, "*", "3", "-4.5"},
                {14, "*", "-3.5", "-4"},

                {2, "/", "10", "5"},
                {-2, "/", "-5", "2.5"},
                {2, "/", "-3", "-1.5"},

                {50000, "*", "5", "10000"},//граничные значения
                {-10000.1, "+", "-10000", "-0.1"},//граничные значения

        };

    }

    @DataProvider
    public Object[][] testDataNegative() {
        return new Object[][]{

                {10000, "-", "10000.1", "0.1"},//граничные значения
                {-10000, "+", "0.1", "-10000.1"},//граничные значения
                {300, "f", "100", "200"},
                {100, "/", "100", "afr"},
                {100, "*", "afr", "100"},
                {0, "/", "100", "0"},//деление на 0

        };

    }


    @Test(dataProvider = "testDataPositive")
    public void testResultPositive(double answer, String action, String one, String two) {
        Assert.assertEquals(answer, new Calc().result(action, one, two));
    }

    @Test(dataProvider = "testDataNegative")
    public void testResultNegative(double answer, String action, String one, String two) {
        Assert.assertNotEquals(answer, new Calc().result(action, one, two));
    }


}