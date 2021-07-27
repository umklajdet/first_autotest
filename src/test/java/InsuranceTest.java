import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void beforeTest() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "https://www.rgs.ru/";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testInsurance() throws Exception{
        driver.findElement(By.xpath("//li[contains(@class, 'dropdown adv-analytics-navigation-line1-link current')]")).click();
        driver.findElement(By.xpath("//li[contains(@class, 'adv-analytics-navigation-line3-link')]//a[contains(text(), 'Финансовый иммунитет')]")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'ок')]")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement buyBtn = driver.findElement(By.xpath("//i[contains(@class, 'fa fa-medkit')]"));
        wait.until(ExpectedConditions.elementToBeClickable(buyBtn));
        buyBtn.click();

        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@name, 'content.policyHolder.dob')]"))));
        //driver.findElement(By.name("content.policyHolder.dob")).click();
        //WebElement inputBirthDate = driver.findElement(By.xpath("//input[contains(@name, 'content.policyHolder.dob')]"));
        //inputBirthDate.sendKeys("01011985");

        driver.findElement(By.xpath("//*[contains(text(), 'Мужской')]")).click();

    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
