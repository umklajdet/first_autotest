import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AppFormPage;
import pages.ChoosePricePage;
import pages.MainPage;
import pages.TravelInsurancePage;

public class newSberTravelInsuranceTest extends BaseTest {

    @Test
    public void newTravelInsuranceTest(){
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookieBtn();
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("Путешествия");

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        //проверяем заголовок, переходим  по кнопке "Оформить онлайн"
        Assert.assertEquals("Страхование путешественников", travelInsurancePage.title.getText());
        wait.until(ExpectedConditions.visibilityOf(travelInsurancePage.onlineButton)).click();
        //travelInsurancePage.onlineButtonClick();

        // нажимаем кнопку "Оформить"
        String insurancePrice = "Минимальная";
        ChoosePricePage choosePricePage = new ChoosePricePage(driver);
        choosePricePage.selectPriceItem(insurancePrice);
        choosePricePage.goToAppForm();

        AppFormPage appFormPage = new AppFormPage(driver);
        String[] fields = {"Фамилия застрахованного","Имя застрахованного","Дата рождения застрахованного","Фамилия страхователя","Имя страхователя","Отчество страхователя","Дата рождения страхователя","Серия паспорта","Номер паспорта","Дата выдачи","Кем выдан"};
        String[] values = {"Иванов","Семен","01.02.1990","Иванов","Семен","Петрович","01.02.1990","4518","456321","05.06.2019","ОУФМС 33"};
        // заполняем и проверяем поля
//        appFormPage.inputValues("Фамилия застрахованного", "Иванов");
//        appFormPage.inputValues("Имя застрахованного", "Семен");
//        appFormPage.inputValues("Дата рождения застрахованного", "01.02.1990");
//        appFormPage.inputValues("Фамилия страхователя", "Иванов");
//        appFormPage.inputValues("Имя страхователя", "Семен");
//        appFormPage.inputValues("Отчество страхователя", "Петрович");
//        appFormPage.inputValues("Дата рождения страхователя", "01.02.1990");
//        appFormPage.inputValues("Серия паспорта", "4518");
//        appFormPage.inputValues("Номер паспорта", "456321");
//        appFormPage.inputValues("Дата выдачи", "05.06.2019");
//        appFormPage.inputValues("Кем выдан", "ОУФМС 33");
        for(int i=0; i<fields.length; i++)
            appFormPage.inputValues(fields[i], values[i]);

        appFormPage.sendAppForm();
        appFormPage.checkErrorMessages();

    }
}
