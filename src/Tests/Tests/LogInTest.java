package Tests;

import PageObject.*;
import Settings.WebDriverSettings;
import org.testng.annotations.Test;

public class LogInTest extends WebDriverSettings {
    HomePage homePageObject;
    LoginPage loginPageObject;
    String login = "alexanderustalkov";
    String password = "Witcher71";

    @Test
    public void logInTest() {
        homePageObject = new HomePage(driver);
        loginPageObject = new LoginPage(driver);

        homePageObject.checkTextLoginToAccount("Войти в аккаунт");

        homePageObject.clickLoginToAccount();
        loginPageObject.Authorization(login, password);
        homePageObject.checkTextMyProfile("Мой профиль");

        homePageObject.checkTextLogin("Александр Усталков");
    }
}