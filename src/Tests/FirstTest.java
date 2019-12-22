import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FirstTest{
    ChromeDriver driver;
    HomePage homePageObject;
    LoginPage loginPageObject;
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
    public void FirstTest()
    {
        homePageObject = new HomePage(driver);
        loginPageObject = new LoginPage(driver);
        Assert.assertEquals("Войти в аккаунт", homePageObject.getTextLoginToAccount());

        homePageObject.clickLoginToAccount();
        loginPageObject.Authorization(login, password);
        Assert.assertEquals("Мой профиль", homePageObject.getTextMyProfile());
        Assert.assertEquals("Александр Усталков", homePageObject.getTextLogin());
    }
    @AfterMethod
    public void endOfTest()
    {
        driver.close();
    }
}