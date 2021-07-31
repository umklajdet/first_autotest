package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class, 'kitt-top-menu__list')]")
    WebElement mainMenu;

    @FindBy(xpath = "//div[contains(@class, 'kitt-top-menu__column_subaction')]")
    WebElement insuranceSubMenu;

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

}
