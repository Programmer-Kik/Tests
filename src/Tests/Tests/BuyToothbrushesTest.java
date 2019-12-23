package Tests;

import PageObject.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyToothbrushesTest {
    ChromeDriver driver;
    HomePage homePageObject;
    LoginPage loginPageObject;
    CataloguePage cataloguePageObject;
    CartPage cartPageObject;
    OrderRegistrationPage orderRegistrationPageObject;
    String login = "alexanderustalkov";
    String password = "Witcher71";
    String minPrice = "999";
    String maxPrice = "1999";
    String priceFreeShipping = "2499";

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/1/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://beru.ru/");
    }

    @Test
    public void buyToothbrushesTest() {
        homePageObject = new HomePage(driver);
        loginPageObject = new LoginPage(driver);
        cataloguePageObject = new CataloguePage(driver);
        cartPageObject = new CartPage(driver);
        orderRegistrationPageObject = new OrderRegistrationPage(driver);

        homePageObject.clickLoginToAccount();
        loginPageObject.Authorization(login, password);

        homePageObject.goToCatalogueOfToothbrushes();

        cataloguePageObject.setMinAndMaxPrice(minPrice, maxPrice);
        cataloguePageObject.checkPriceToothbrushes(minPrice, maxPrice);
        cataloguePageObject.addPenultimateToothbrushInCart();
        cataloguePageObject.goToCart();

        cartPageObject.checkPriceBeforeFreeShipping(priceFreeShipping);
        cartPageObject.goToOrderRegistration();

        orderRegistrationPageObject.changeTypeOfShipping();
        orderRegistrationPageObject.checkCorrectPrice();
        orderRegistrationPageObject.goToChangeCart();

        cartPageObject.addToothbrushes();
        cartPageObject.goToOrderRegistration();
        orderRegistrationPageObject.changeTypeOfShipping();
        orderRegistrationPageObject.checkCorrectPrice();
    }

    @AfterMethod
    public void endOfTest()
    {
        driver.close();
    }
}
