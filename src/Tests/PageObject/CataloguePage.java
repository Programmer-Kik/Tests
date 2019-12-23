package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CataloguePage {
    private WebDriver driver;
    private By inputMinRangePrice = By.cssSelector("div[data-auto = \"filter-range-glprice\"] span[data-auto = \"filter-range-min\"] input");
    private By inputMaxRangePrice = By.cssSelector("div[data-auto = \"filter-range-glprice\"] span[data-auto = \"filter-range-max\"] input");
    private By toothbrushes = By.cssSelector("div [class = \"_3rWYRsam78\"] [data-auto = \"price\"] span[data-tid = \"c3eaad93\"]:first-child");
    private By toothbrushesAfterSearch = By.cssSelector("body.i-font_face_ys-text.i-bem.fonts-loaded:nth-child(2) div._3rWu3-6RDl.qpgDgmh6Hn._11QbuC0gtX._1zxBwSfbGK._1mXFu6EZpv div.wrItvb7JRv div.NZiH_Kn8Fj span._3l-uEDOaBN.tdrs43E7Xn._3HJsMt3YC_.W-B6JRTjJH > span._3ioN70chUh._3XRVQbB83A");
    private By buttonAddToCart = By.cssSelector("div[class = \"_3rWYRsam78\"] > div:last-child > div > div > div:nth-last-child(2) button");
    private By buttonGoToCart = By.cssSelector("button[data-auto = \"executed-cart-button\"]");

    public CataloguePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(value = "Установка минимальной и максимальной цены")
    public void setMinAndMaxPrice(String minPrice, String maxPrice) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(inputMinRangePrice));
        WebElement inputMinRangePrice = driver.findElement(this.inputMinRangePrice);
        wait.until(ExpectedConditions.presenceOfElementLocated(inputMaxRangePrice));
        WebElement inputMaxRangePrice = driver.findElement(this.inputMaxRangePrice);
        inputMinRangePrice.sendKeys(minPrice);
        inputMaxRangePrice.sendKeys(maxPrice);
    }

    @Step(value = "Проверка корректности диапазона цен")
    public void checkPriceToothbrushes(String minPrice, String maxPrice) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(toothbrushesAfterSearch));
        List<WebElement> products = driver.findElements(toothbrushes);
        for (WebElement item:products) {
            String price = item.getText().replaceAll(" ", "");
            Assert.assertEquals(Integer.parseInt(minPrice) <= Integer.parseInt(price),
                    Integer.parseInt(price) <= Integer.parseInt(maxPrice));
        }
    }

    @Step(value = "Добавление предпоследней щетки в корзину")
    public void addPenultimateToothbrushInCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddToCart));
        WebElement buttonAddToCart = driver.findElement(this.buttonAddToCart);
        buttonAddToCart.click();
    }

    @Step(value = "Переход в корзину")
    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonGoToCart));
        WebElement buttonGoToCart = driver.findElement(this.buttonGoToCart);
        buttonGoToCart.click();
    }
}
