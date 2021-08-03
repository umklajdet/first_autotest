package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class, 'kitt-top-menu__list')]")
    WebElement mainMenu;

    @FindBy(xpath = "//div[contains(@class, 'kitt-top-menu__column_subaction')]")
    WebElement insuranceSubMenu;

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    WebElement cookiesBtn;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMenuItem(String name){
        mainMenu.findElement(By.xpath(".//li//a[contains(text(), '"+name+"')]")).click();
    }

    public void selectInsuranceItem(String name){
        mainMenu.findElement(By.xpath(".//li//a[contains(text(), '"+name+"')]")).click();
    }

    public void closeCookieBtn () {
        try {
            cookiesBtn.click();
        } catch (NoSuchElementException ignore) {
        }
    }
}