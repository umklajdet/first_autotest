import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl;
    protected static Wait<WebDriver> wait;
    public static Properties properties = TestProperties.getInstance().getProperties();

    // создать функцию считывания настроек из файла

    @BeforeClass
    public static void beforeTests() {
        switch(properties.getProperty("browser")){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.driver"));
                driver = new FirefoxDriver();
                break;
        }
        baseUrl = properties.getProperty("url");
        wait = new WebDriverWait(driver, 5, 1000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void afterTests(){
        driver.quit();
    }

}
