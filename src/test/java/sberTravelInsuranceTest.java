import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class sberTravelInsuranceTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void travelInsuranceTest() {
        driver.findElement(By.xpath("//li[contains(@class, 'kitt-top-menu__item kitt-top-menu__item_first')]//a[contains(text(), 'Страхование')]")).click();
        driver.findElement(By.xpath("//li[contains(@class, 'kitt-top-menu__item')]//a[contains(text(), 'Путешествия')]")).click();

        // ждем появления кнопки "Оформить онлайн"
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement buyOnlineBtn = driver.findElement(By.xpath("//span[contains(text(), 'Оформить онлайн')]"));
        wait.until(ExpectedConditions.visibilityOf(buyOnlineBtn));

        //проверяем заголовок, переходим  по кнопке "Оформить онлайн"
        Assert.assertEquals("Страхование путешественников", driver.findElement(By.xpath("//h1[contains(@class, 'kitt-heading  page-teaser-dict__header kitt-heading_size_l')]")).getText());
        buyOnlineBtn.click();

        // нажимаем кнопку "Оформить"
        WebElement toApplicationFormBtn = driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary btn-large')]"));
        wait.until(ExpectedConditions.visibilityOf(toApplicationFormBtn));
        toApplicationFormBtn.click();

        // заполнение полей
        inputValues(By.id("surname_vzr_ins_0"), "Иванов");
        inputValues(By.id("name_vzr_ins_0"), "Петр");
        inputValues(By.id("birthDate_vzr_ins_0"), "01091990");
        driver.findElement(By.id("person_lastName")).click();
        inputValues(By.id("person_lastName"), "Иванов");
        inputValues(By.id("person_firstName"), "Петр");
        inputValues(By.id("person_middleName"), "Сидорович");
        inputValues(By.id("person_birthDate"), "01091990");
        driver.findElement(By.id("passportSeries")).click();
        inputValues(By.id("passportSeries"), "4508");
        inputValues(By.id("passportNumber"), "123456");
        inputValues(By.id("documentDate"), "02022015");
        driver.findElement(By.id("documentIssue")).click();
        inputValues(By.id("documentIssue"), "ОУФМС 33");

        // проверка корректности заполнения полей
        Assert.assertEquals("Иванов", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Петр", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("01.09.1990", driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Иванов", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Петр", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Сидорович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        Assert.assertEquals("01.09.1990", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        Assert.assertEquals("4508", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("123456", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("02.02.2015", driver.findElement(By.id("documentDate")).getAttribute("value"));
        Assert.assertEquals("ОУФМС 33", driver.findElement(By.id("documentIssue")).getAttribute("value"));

        // кнопка "продолжить"
        driver.findElement(By.xpath("//*[@class = 'btn btn-primary page__btn']")).click();

        // проверка сообщений об ошибке
        String notFilledMsg = "Поле не заполнено.";
        Assert.assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[@class = 'alert-form alert-form-error']")).getText());
        Assert.assertEquals(notFilledMsg, driver.findElement(By.xpath("//span[contains(@class, 'form-control__container form-control_phone form-control_mask')]")).getText());
        Assert.assertEquals(notFilledMsg, driver.findElement(By.xpath("//input[contains(@id, 'email')]//..")).getText());
        Assert.assertEquals(notFilledMsg, driver.findElement(By.xpath("//input[contains(@id, 'repeatEmail')]//..")).getText());
    }

    public void inputValues(By locator, String str){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(str);
    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
