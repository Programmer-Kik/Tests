package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import PageObject.*;

public class ChangeCityTest {
    ChromeDriver driver;
    HomePage homePageObject;
    LoginPage loginPageObject;
    SettingsPage settingsPageObject;
    String login = "alexanderustalkov";
    String password = "Witcher71";

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/1/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://beru.ru/");
    }

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

    @AfterMethod
    public void endOfTest()
    {
        driver.close();
    }
}
