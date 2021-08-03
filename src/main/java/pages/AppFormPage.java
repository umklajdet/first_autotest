package pages;

import org.junit.Assert;
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

//    @FindBy(xpath = "//div[@class = 'alert-form alert-form-error']")
//    WebElement errorAlert;

    @FindBy(xpath = "//span[contains(@class, 'form-control_phone')]")
    WebElement phone;

    @FindBy(xpath = "//input[contains(@id, 'email')]//..")
    WebElement email;

    @FindBy(xpath = "//input[contains(@id, 'repeatEmail')]//..")
    WebElement repeatEmail;


    public AppFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // здесь будет заполнение полей
    public void inputValues(String fieldName, String value){
        switch (fieldName){
            case "Фамилия застрахованного":
                inputAndCheckValues(insuredSurname, value);
                break;
            case "Имя застрахованного":
                inputAndCheckValues(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                inputAndCheckValues(insuredBirthDate, value);
                break;
            case "Фамилия страхователя":
                inputAndCheckValues(personSurname, value);
                break;
            case "Имя страхователя":
                inputAndCheckValues(personName, value);
                break;
            case "Отчество страхователя":
                inputAndCheckValues(personMiddleName, value);
                break;
            case "Дата рождения страхователя":
                inputAndCheckValues(personBirthDate, value);
                break;
            case "Серия паспорта":
                inputAndCheckValues(passportSeries, value);
                break;
            case "Номер паспорта":
                inputAndCheckValues(passportNumber, value);
                break;
            case "Дата выдачи":
                inputAndCheckValues(passportDate, value);
                break;
            case "Кем выдан":
                inputAndCheckValues(passportIssue, value);
                break;
            default:
                throw new AssertionError("поле " + fieldName + " отсутствует на странице");
        }
    }

    public void sendAppForm(){
        mainForm.findElement(By.xpath("//*[@class = 'btn btn-primary page__btn']")).click();
    }

    String error = "При заполнении данных произошла ошибка";
    String notFilledMsg = "Поле не заполнено.";

    public void checkErrorMessages(){
        Assert.assertEquals(error, driver.findElement(By.xpath(".//div[@class = 'alert-form alert-form-error']")).getText());
        Assert.assertEquals(notFilledMsg, phone.getText());
        Assert.assertEquals(notFilledMsg, email.getText());
        Assert.assertEquals(notFilledMsg, repeatEmail.getText());
    }
}
