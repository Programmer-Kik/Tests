package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class HomePage {
    private WebDriver driver;
    private By LoginToAccount = By.cssSelector("span.pFhTbV17qj");
    private By MyProfile = By.cssSelector("span.pFhTbV17qj");
    private By Login = By.cssSelector("div._2I5v9t-gmG span[class = \"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_ QDV8hKAp1G\"]");
    private By City = By.cssSelector("span[data-auto = region-form-opener]._2XJ6yiRp5w");
    private By NameOfCity = By.cssSelector("div[class = \"LVfMs-qeRX tOTC_Mrer- _38DKtrKp3V nczD08OBdF _2jnB2KZa7v _1WIxduPIjW\"] input[data-tid = \"37e0ab2d\"]");
    private By CityInList = By.cssSelector("div[data-auto = \"suggestionTitle Хвалынск\"]");
    private By ConfirmationButton = By.cssSelector("button[class = \"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"]");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getTextLoginToAccount()
    {
        return driver.findElement(LoginToAccount).getText();
    }

    public String getTextMyProfile()
    {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(MyProfile));
        return element.getText();
    }

    public String getTextLogin()
    {
        return driver.findElement(Login).getAttribute("textContent");
    }

    public void clickLoginToAccount()
    {
        driver.findElement(LoginToAccount).click();
    }

    public String getTextCity()
    {
        return driver.findElement(City).getText();
    }

    private void clickCity()
    {
        driver.findElement(City).click();
    }

    private void editCity(String city)
    {
        WebElement City = ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(NameOfCity)));
        City.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
        for(int i = 0; i < city.length(); i++)
        {
            City.sendKeys((city.toCharArray())[i] + "");
        }
    }

    private void clickConfirmationButton()
    {
        WebElement City = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(CityInList));
        City.click();
        WebElement Button = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(ConfirmationButton));
        Button.click();
    }

    public void changeCity(String city)
    {
        clickCity();
        editCity(city);
        clickConfirmationButton();
    }
}