package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
