package Tests;

import PageObject.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest {
    ChromeDriver driver;
    HomePage homePageObject;
    LoginPage loginPageObject;
    String login = "alexanderustalkov";
    String password = "Witcher71";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/1/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://beru.ru/");
    }

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
    @AfterMethod
    public void endOfTest()
    {
        driver.close();
    }
}