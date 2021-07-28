import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class sberTravelInsuranceTest {
    private WebDriver driver;
    private String baseUrl;
    Wait<WebDriver> wait;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.sberbank.ru/ru/person";
        wait = new WebDriverWait(driver, 5, 1000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void travelInsuranceTest() {
        driver.findElement(By.xpath("//li[contains(@class, 'kitt-top-menu__item kitt-top-menu__item_first')]//a[contains(text(), 'Страхование')]")).click();
        driver.findElement(By.xpath("//li[contains(@class, 'kitt-top-menu__item')]//a[contains(text(), 'Путешествия')]")).click();

        //проверяем заголовок, переходим  по кнопке "Оформить онлайн"
        Assert.assertEquals("Страхование путешественников", driver.findElement(By.xpath("//h1[contains(@class, 'page-teaser-dict__header')]")).getText());

        // ждем появления кнопки "Оформить онлайн" и кликаем
        WebElement buyOnlineBtn = driver.findElement(By.xpath("//span[contains(text(), 'Оформить онлайн')]"));
        wait.until(ExpectedConditions.visibilityOf(buyOnlineBtn));
        buyOnlineBtn.click();

        // нажимаем кнопку "Оформить"
        WebElement toApplicationFormBtn = driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary btn-large')]"));
        wait.until(ExpectedConditions.visibilityOf(toApplicationFormBtn));
        toApplicationFormBtn.click();

        // заполнение и проверка полей
        inputAndCheckValues(By.id("surname_vzr_ins_0"), "Иванов");
        inputAndCheckValues(By.id("name_vzr_ins_0"), "Петр");
        inputAndCheckValues(By.id("birthDate_vzr_ins_0"), "01.09.1990");
        inputAndCheckValues(By.id("person_lastName"), "Иванов");
        inputAndCheckValues(By.id("person_firstName"), "Петр");
        inputAndCheckValues(By.id("person_middleName"), "Сидорович");
        inputAndCheckValues(By.id("person_birthDate"), "01.09.1990");
        inputAndCheckValues(By.id("passportSeries"), "4508");
        inputAndCheckValues(By.id("passportNumber"), "123456");
        inputAndCheckValues(By.id("documentDate"), "02.02.2015");
        inputAndCheckValues(By.id("documentIssue"), "ОУФМС 33");

        // кнопка "продолжить"
        driver.findElement(By.xpath("//*[@class = 'btn btn-primary page__btn']")).click();

        // проверка сообщений об ошибке
        String error = "При заполнении данных произошла ошибка";
        String notFilledMsg = "Поле не заполнено.";
        Assert.assertEquals(error, driver.findElement(By.xpath("//div[@class = 'alert-form alert-form-error']")).getText());
        Assert.assertEquals(notFilledMsg, driver.findElement(By.xpath("//span[contains(@class, 'form-control__container form-control_phone form-control_mask')]")).getText());
        Assert.assertEquals(notFilledMsg, driver.findElement(By.xpath("//input[contains(@id, 'email')]//..")).getText());
        Assert.assertEquals(notFilledMsg, driver.findElement(By.xpath("//input[contains(@id, 'repeatEmail')]//..")).getText());
    }

    public void inputAndCheckValues(By locator, String str){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(str);
        Assert.assertEquals(str, driver.findElement(locator).getAttribute("value"));
    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
