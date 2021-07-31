package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppFormPage extends BasePage {

    @FindBy(xpath = "//form[contains(@class, 'forming-product-form')]//div[@class ='container']")
    public WebElement mainForm;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement insuredSurname;

    @FindBy(id = "name_vzr_ins_0")
    WebElement insuredName;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement insuredBirthDate;

    @FindBy(xpath = "//div//span[contains(text(), 'Гражданство')]")
    WebElement personCitizenship;

    @FindBy(id = "person_lastName")
    WebElement personSurname;

    @FindBy(id = "person_firstName")
    WebElement personName;

    @FindBy(id = "person_middleName")
    WebElement personMiddleName;

    @FindBy(id = "person_birthDate")
    WebElement personBirthDate;

//    @FindBy(xpath = "//div//span[text()='Пол']")
//    WebElement personGender;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement passportDate;

    @FindBy(id = "documentIssue")
    WebElement passportIssue;

    public AppFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // здесь будет заполнение полей

    // здесь будет проверка заполнения полей

    public void sendAppForm(String name){
        mainForm.findElement(By.xpath("//*[@class = 'btn btn-primary page__btn']")).click();
    }
}
