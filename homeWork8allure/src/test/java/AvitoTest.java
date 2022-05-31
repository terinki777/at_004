
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class AvitoTest {

    private static WebDriver driver;
    static WebElement params;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public static void teardown() {
        driver.quit();
    }

    @Attachment
    public byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    @Step("Шаг 1. Открыть сайт Авито")
    public void openSiteAvito() {
        driver.get("https://www.avito.ru/");
        captureScreenshot(driver);
    }

    @Test
    @Step("Шаг 2. Выбрать в выпадающем списке “категория” значение оргтехника и расходники")
    public void selectCategory() {
        driver.get("https://www.avito.ru/");
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText("Оргтехника и расходники");
        captureScreenshot(driver);

    }

    @Test
    @Step("Шаг 3. В поле поиск по объявлению ввести значение “Принтер”")
    public void enterPrinter() {
        driver.get("https://www.avito.ru/");
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText("Оргтехника и расходники");
        driver.findElement(By.xpath("//div/label/input[@data-marker='search-form/suggest']"))
                .sendKeys("Принтер");
        captureScreenshot(driver);
    }

    @Test
    @Step("Шаг 4. Нажать на поле город”")
    public void clickOnTheCity() {
        driver.get("https://www.avito.ru/");
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText("Оргтехника и расходники");
        driver.findElement(By.xpath("//div/label/input[@data-marker='search-form/suggest']"))
                .sendKeys("Принтер");
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']/div"))
                .click();
        captureScreenshot(driver);

    }

    @Test
    @Step("Шаг 5. Заполнить значением “Владивосток” поле город  в открывшемся окне и" +
            "кликнуть по первому предложенному варианту. Нажать на кнопку “Показать объявления”")
    public void fillInTheValueVladivostokAndClick() {
        driver.get("https://www.avito.ru/");
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText("Оргтехника и расходники");
        driver.findElement(By.xpath("//div/label/input[@data-marker='search-form/suggest']"))
                .sendKeys("Принтер");
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']/div"))
                .click();
        driver.findElement(By.xpath("//div/input[@data-marker='popup-location/region/input']"))
                .sendKeys("Владивосток");
        driver.findElement(By.xpath("//strong")).click();

        driver.findElement(By.xpath("//div/button[@data-marker='popup-location/save-button']"))
                .click();
        captureScreenshot(driver);
    }

    @Test
    @Step("Шаг 6. Проверить, активирован ли чекбокс, и если не активирован – " +
            "активировать и нажать кнопку “Показать объявления”")
    public void checkboxActivated() {
        driver.get("https://www.avito.ru/");
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText("Оргтехника и расходники");
        driver.findElement(By.xpath("//div/label/input[@data-marker='search-form/suggest']"))
                .sendKeys("Принтер");
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']/div"))
                .click();
        driver.findElement(By.xpath("//div/input[@data-marker='popup-location/region/input']"))
                .sendKeys("Владивосток");
        driver.findElement(By.xpath("//strong")).click();

        driver.findElement(By.xpath("//div/button[@data-marker='popup-location/save-button']"))
                .click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        params = driver.findElement(By.xpath("//div[@class]/select[option" +
                "[contains(text(),'Дороже')]]"));
        js.executeScript("arguments[0].scrollIntoView();", params);

        params = driver.findElement(By.xpath("//label[@data-marker='delivery-filter']"));
        boolean isSelected = params.isSelected();
        if (isSelected == false) params.click();
        captureScreenshot(driver);
        driver.findElement(By.xpath("//div[@class]/button[@data-marker='search-filters/submit-button']")).click();
    }

    @Test
    @Step("Шаг 7. В выпадающем списке фильтрации выбрать фильтрацию по убыванию цены.")
    public void filteringByDescendingPrice() {
        driver.get("https://www.avito.ru/");
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText("Оргтехника и расходники");
        driver.findElement(By.xpath("//div/label/input[@data-marker='search-form/suggest']"))
                .sendKeys("Принтер");
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']/div"))
                .click();
        driver.findElement(By.xpath("//div/input[@data-marker='popup-location/region/input']"))
                .sendKeys("Владивосток");
        driver.findElement(By.xpath("//strong")).click();

        driver.findElement(By.xpath("//div/button[@data-marker='popup-location/save-button']"))
                .click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        params = driver.findElement(By.xpath("//div[@class]/select[option" +
                "[contains(text(),'Дороже')]]"));
        js.executeScript("arguments[0].scrollIntoView();", params);

        params = driver.findElement(By.xpath("//label[@data-marker='delivery-filter']"));
        boolean isSelected = params.isSelected();
        if (isSelected == false) params.click();

        driver.findElement(By.xpath("//div[@class]/button[@data-marker='search-filters/submit-button']")).click();

        Select selectSort = new Select(driver.findElement(By.xpath("//div[@class]/select[option" +
                "[contains(text(),'Дороже')]]")));
        selectSort.selectByVisibleText("Дороже");
        captureScreenshot(driver);
    }

    @Test
    @Step("Шаг 8. Вывести в консоль название и стоимость 3х самых дорогих принтеров")
    public void theThreeMostExpensivePrinters() {
        driver.get("https://www.avito.ru/");
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText("Оргтехника и расходники");
        driver.findElement(By.xpath("//div/label/input[@data-marker='search-form/suggest']"))
                .sendKeys("Принтер");
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']/div"))
                .click();
        driver.findElement(By.xpath("//div/input[@data-marker='popup-location/region/input']"))
                .sendKeys("Владивосток");
        driver.findElement(By.xpath("//strong")).click();

        driver.findElement(By.xpath("//div/button[@data-marker='popup-location/save-button']"))
                .click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        params = driver.findElement(By.xpath("//div[@class]/select[option" +
                "[contains(text(),'Дороже')]]"));
        js.executeScript("arguments[0].scrollIntoView();", params);

        params = driver.findElement(By.xpath("//label[@data-marker='delivery-filter']"));
        boolean isSelected = params.isSelected();
        if (isSelected == false) params.click();

        driver.findElement(By.xpath("//div[@class]/button[@data-marker='search-filters/submit-button']")).click();

        Select selectSort = new Select(driver.findElement(By.xpath("//div[@class]/select[option" +
                "[contains(text(),'Дороже')]]")));
        selectSort.selectByVisibleText("Дороже");

        List<WebElement> title = driver.findElements(By.xpath("//div[starts-with" +
                "(@class,'iva-item-titleStep')]"));
        List<WebElement> price = driver.findElements(By.xpath("//div[starts-with" +
                "(@class,'iva-item-priceStep')]"));
        for (int i = 0; i < 3; ++i) {
            String attachment = "Title: " + title.get(i).getText() + "\nPrice: " + price.get(i).getText();
            System.out.println(attachment);
            Allure.addAttachment("Title&Price:", attachment);
        }

        params = driver.findElement(By.xpath("//div[@class]/select[option" +
                "[contains(text(),'Дороже')]]"));
        js.executeScript("arguments[0].scrollIntoView();", params);
        captureScreenshot(driver);
    }


}
