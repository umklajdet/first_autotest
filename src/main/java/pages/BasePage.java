package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class BasePage {

    WebDriver driver;

    //public void waitElements(){};

    public void inputAndCheckValues(WebElement element, String str){
        element.click();
        element.clear();
        element.sendKeys(str);
        assertEquals(str, element.getAttribute("value"));
    }

//    public void waitForVisibility(By locator){
//        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).click();
//    }

}
