import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Avito {

    static WebElement params;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "homeWork8allure/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
            System.out.println(title.get(i).getText());
            System.out.println(price.get(i).getText());
        }

        driver.quit();

    }
}
