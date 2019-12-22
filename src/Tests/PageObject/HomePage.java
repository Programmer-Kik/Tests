package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private By buttonMyProfile = By.cssSelector("button._1FEpprw_Km");
    private By buttonToLogin = By.cssSelector("a[class = \"_3ioN70chUh _1FEpprw_Km _3Uc73lzxcf\"]");
    private By login = By.cssSelector("div._2I5v9t-gmG span[class = \"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_ QDV8hKAp1G\"]");
    private By city = By.cssSelector("span[data-auto = region-form-opener].zB1fta3NQ5");
    private By nameOfCity = By.cssSelector("div[class = \"LVfMs-qeRX tOTC_Mrer- _38DKtrKp3V nczD08OBdF _2jnB2KZa7v _1WIxduPIjW\"] input[data-tid = \"37e0ab2d\"]");
    private By cityInList = By.cssSelector("li[id = \"react-autowhatever-region--item-0\"]");
    private By confirmationButton = By.cssSelector("button[class = \"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"]");
    private By settings = By.cssSelector("a[href=\"/my/settings?track=menu\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step(value = "Проверка текста \"Войти в аккаунт\"")
    public void checkTextLoginToAccount(String textOfProfile) {
        Assert.assertEquals(driver.findElement(buttonToLogin).getText(), textOfProfile);
    }

    @Step(value = "Проверка смены текста на \"Мой профиль\" после авторизации")
    public void checkTextMyProfile(String textOfProfile) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonMyProfile));
        WebElement element = driver.findElement(buttonMyProfile);
        Assert.assertEquals(element.getText(), textOfProfile);
    }

    @Step(value = "Проверка отображения логина в меню \"Мой профиль\"")
    public void checkTextLogin(String textOfLogin) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonMyProfile));
        driver.findElement(buttonMyProfile).click();
        WebElement login = (new WebDriverWait(driver,
                10)).until(ExpectedConditions.visibilityOfElementLocated(this.login));
        Assert.assertEquals(login.getText(), textOfLogin);
    }

    @Step(value = "Переход на страницу авторизации")
    public void clickLoginToAccount() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonToLogin));
        driver.findElement(buttonToLogin).click();
    }

    @Step(value = "Проверка изменения города")
    public void checkTextCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(this.city, city));
        String textCity = driver.findElement(this.city).getText();
        Assert.assertEquals(city, textCity);
    }

    private void clickCity() {
        driver.findElement(city).click();
    }

    private void editCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(nameOfCity));
        WebElement cityInInput = driver.findElement(nameOfCity);
        cityInInput.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
        for(int i = 0; i < city.length(); i++)
        {
            cityInInput.sendKeys((city.toCharArray())[i] + "");
        }
    }

    private void clickConfirmationButton(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(cityInList, city));
        WebElement cityInList = driver.findElement(this.cityInList);
        cityInList.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmationButton));
        WebElement button = driver.findElement(confirmationButton);
        button.click();
    }

    public void changeCity(String city) {
        clickCity();
        editCity(city);
        clickConfirmationButton(city);
    }

    @Step(value = "Переход в настройки")
    public void clickSettings() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonMyProfile));
        WebElement buttonToMyProfile = driver.findElement(buttonMyProfile);
        buttonToMyProfile.click();
        wait.until(ExpectedConditions.elementToBeClickable(settings));
        WebElement buttonSettings = driver.findElement(settings);
        buttonSettings.click();
    }
}