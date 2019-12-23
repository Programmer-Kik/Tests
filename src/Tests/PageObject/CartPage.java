package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;
    private By price = By.cssSelector("div[data-auto = \"price\"] span span");
    private By priceBeforeFreeShipping = By.cssSelector("span[class = \"_2YHTmhZmt4\"]");
    private By buttonGoToOrderRegistration = By.cssSelector("button[class = \"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u _39B7yXQbvm _2W4X8tX6r0\"]");
    private By buttonAddToothbrush = By.cssSelector("button[class = \"_4qhIn2-ESi _2sJs248D-A _18c2gUxCdP _3hWhO4rvmA\"]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(value = "Проверка значения \"До бесплатной доставки осталось\"")
    public void checkPriceBeforeFreeShipping(String priceForFreeShipping) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(price));
        WebElement price = driver.findElement(this.price);
        String correctPrice = price.getText().replaceAll(" ", "");
        int correctPriceValue = Integer.parseInt(correctPrice);
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceBeforeFreeShipping));
        WebElement priceBeforeFreeShipping = driver.findElement(this.priceBeforeFreeShipping);
        String correctPriceBeforeFreeShipping = priceBeforeFreeShipping.getText().substring(0,
                priceBeforeFreeShipping.getText().length() - 2);
        int priceBeforeFreeShippingValue = Integer.parseInt(correctPriceBeforeFreeShipping);
        Assert.assertEquals(Integer.parseInt(priceForFreeShipping) - correctPriceValue,
                priceBeforeFreeShippingValue);
    }

    @Step(value = "Переход в оформление заказа")
    public void goToOrderRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonGoToOrderRegistration));
        WebElement buttonGoToOrderRegistration = driver.findElement(this.buttonGoToOrderRegistration);
        buttonGoToOrderRegistration.click();
    }

    @Step(value = "Добавление зубных щеток")
    public void addToothbrushes() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddToothbrush));
        WebElement buttonAddToothbrush = driver.findElement(this.buttonAddToothbrush);
        if(buttonAddToothbrush.isEnabled()) {
            buttonAddToothbrush.click();
        }
        if(buttonAddToothbrush.isEnabled()) {
            buttonAddToothbrush.click();
        }
        if(buttonAddToothbrush.isEnabled()) {
            buttonAddToothbrush.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(buttonGoToOrderRegistration));
    }
}
