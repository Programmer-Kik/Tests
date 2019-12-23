package Tests;

import Settings.WebDriverSettings;
import org.testng.annotations.*;
import PageObject.*;

public class ChangeCityTest extends WebDriverSettings {
    HomePage homePageObject;
    LoginPage loginPageObject;
    SettingsPage settingsPageObject;
    String login = "alexanderustalkov";
    String password = "Witcher71";

    @DataProvider
    public Object[] Cities() {
        return new String[]{"Хвалынск", "Москва", "Рязань"};
    }

    @Test(dataProvider = "Cities")
    public void changeCityTest(String city)
    {
        homePageObject = new HomePage(driver);
        loginPageObject = new LoginPage(driver);
        settingsPageObject = new SettingsPage(driver);

        homePageObject.changeCity(city);
        homePageObject.checkTextCity(city);

        homePageObject.clickLoginToAccount();
        loginPageObject.Authorization(login, password);
        homePageObject.clickSettings();
        settingsPageObject.checkCityInSettings(city);
    }
}
