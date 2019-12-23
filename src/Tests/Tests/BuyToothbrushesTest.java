package Tests;

import PageObject.*;
import Settings.WebDriverSettings;
import org.testng.annotations.Test;

public class BuyToothbrushesTest extends WebDriverSettings {
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
}
