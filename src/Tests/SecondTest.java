import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SecondTest {
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
    @Test
    public void SecondTest()
    {
        homePageObject = new HomePage(driver);
        loginPageObject = new LoginPage(driver);
        settingsPageObject = new SettingsPage(driver);

        homePageObject.changeCity("Хвалынск");
        Assert.assertEquals("Хвалынск", homePageObject.getTextCity("Хвалынск"));

        homePageObject.clickLoginToAccount();
        loginPageObject.Authorization(login, password);
        homePageObject.clickSettings();
        Assert.assertEquals("Хвалынск", settingsPageObject.getCityInSettings());
    }
    @AfterMethod
    public void endOfTest()
    {
        driver.close();
    }
}
