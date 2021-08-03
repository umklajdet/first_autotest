package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoosePricePage extends BasePage {

    @FindBy(xpath = "//form//div[@class='container']")
    public WebElement mainForm;

    public ChoosePricePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectPriceItem(String name){
        mainForm.findElement(By.xpath(".//div//h3[contains(text(), '"+name+"')]")).click();
    }

    public void goToAppForm(){
        mainForm.findElement(By.xpath(".//*[@class ='btn btn-primary btn-large']")).click();
    }
}
