package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelInsurancePage extends BasePage {

    @FindBy(xpath = "//h1[contains(@class, 'page-teaser-dict__header')]")
    public WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'Оформить онлайн')]")
    public WebElement onlineButton;

    public TravelInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void onlineButtonClick(){
        onlineButton.click();
    }

}
