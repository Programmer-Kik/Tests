import PageObject.HomePage;
import PageObject.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests{
    ChromeDriver driver;
    HomePage homePageObject;
    LoginPage loginPageObject;

    @Before
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
        loginPageObject.Authorization("alexanderustalkov", "Witcher71");
        Assert.assertEquals("Мой профиль", homePageObject.getTextMyProfile());
        Assert.assertEquals("Александр Усталков", homePageObject.getTextLogin());
    }

    @Test
    public void SecondTest()
    {
        homePageObject = new HomePage(driver);

        homePageObject.changeCity("Хвалынск");
        Assert.assertEquals("Хвалынск", homePageObject.getTextCity());
    }
    @After
    public void endOfTest()
    {
        driver.close();
    }
}