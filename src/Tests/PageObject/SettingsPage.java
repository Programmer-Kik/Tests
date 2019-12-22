package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SettingsPage {
    private WebDriver driver;
    private By cityInSettings = By.cssSelector("span[data-auto=\"region\"]");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(value = "Проверка изменения города в натройках")
    public void checkCityInSettings(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(cityInSettings));
        WebElement cityInSettings = driver.findElement(this.cityInSettings);
        Assert.assertEquals(city, cityInSettings.getText());
    }
}
