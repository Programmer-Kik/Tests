package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderRegistrationPage {
    private WebDriver driver;
    private By buttonTypeOfShipping = By.cssSelector("label[class = \"_32Rl_SqO9- aWusV1otSv\"]");
    private By priceToothbrush = By.cssSelector("div[data-auto = \"total-items\"] span[data-auto = \"value\"]");
    private By priceShipping = By.cssSelector("div[data-auto = \"total-delivery\"] span[data-auto = \"value\"]");
    private By totalPrice = By.cssSelector("div[data-auto = \"total-price\"] span[class = \"_1oBlNqVHPq\"]");
    private By buttonChangeCart = By.cssSelector("div[data-zone-name = \"ITEMS-CHANGE\"]");

    public OrderRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(value = "Изменение типа доставки")
    public void changeTypeOfShipping() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonTypeOfShipping));
        WebElement buttonTypeOfShipping = driver.findElement(this.buttonTypeOfShipping);
        buttonTypeOfShipping.click();
    }

    @Step(value = "Проверка правильности подсчёта полной суммы заказа")
    public void checkCorrectPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceToothbrush));
        String priceToothbrush = driver.findElement(this.priceToothbrush).getText();
        priceToothbrush = priceToothbrush.substring(0, priceToothbrush.length() - 2);
        priceToothbrush = priceToothbrush.replaceAll(" ", "");
        int priceToothbrushValue = Integer.parseInt(priceToothbrush);

        wait.until(ExpectedConditions.visibilityOfElementLocated(priceShipping));
        String priceShipping = driver.findElement(this.priceShipping).getText();
        priceShipping = priceShipping.substring(0, priceShipping.length() - 2);
        priceShipping = priceShipping.replaceAll(" ", "");
        int priceShippingValue = Integer.parseInt(priceShipping);

        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        String totalPrice = driver.findElement(this.totalPrice).getText();
        totalPrice = totalPrice.substring(0, totalPrice.length() - 2);
        totalPrice = totalPrice.replaceAll(" ", "");
        int totalPriceValue = Integer.parseInt(totalPrice);

        Assert.assertEquals(priceShippingValue + priceToothbrushValue, totalPriceValue);
    }

    @Step(value = "Переход к изменению корзины")
    public void goToChangeCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonChangeCart));
        WebElement buttonChangeCart = driver.findElement(this.buttonChangeCart);
        buttonChangeCart.click();
    }
}
