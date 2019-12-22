import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class HomePage {
    private WebDriver driver;
    private By buttonToLoginOrMyProfile = By.cssSelector("span.pFhTbV17qj");
    private By login = By.cssSelector("div._2I5v9t-gmG span[class = \"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_ QDV8hKAp1G\"]");
    private By city = By.cssSelector("span[data-auto = region-form-opener].zB1fta3NQ5");
    private By nameOfCity = By.cssSelector("div[class = \"LVfMs-qeRX tOTC_Mrer- _38DKtrKp3V nczD08OBdF _2jnB2KZa7v _1WIxduPIjW\"] input[data-tid = \"37e0ab2d\"]");
    private By cityInList = By.cssSelector("li[id = \"react-autowhatever-region--item-0\"]");
    private By confirmationButton = By.cssSelector("button[class = \"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"]");
    private By settings = By.cssSelector("a[href=\"/my/settings?track=menu\"]");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getTextLoginToAccount()
    {
        return driver.findElement(buttonToLoginOrMyProfile).getText();
    }

    public String getTextMyProfile()
    {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(buttonToLoginOrMyProfile));
        return element.getText();
    }

    public String getTextLogin()
    {
        WebElement login = driver.findElement(this.login);
        WebElement buttonToMyProfile = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(buttonToLoginOrMyProfile));
        while(!login.isDisplayed())
        {
            buttonToMyProfile.click();
        }
        return login.getText();
    }

    public void clickLoginToAccount()
    {
        driver.findElement(buttonToLoginOrMyProfile).click();
    }

    public String getTextCity(String city)
    {
        String textCity  = (new WebDriverWait(driver, 10)).until((ExpectedCondition<String>) driver1 -> {
            if(driver1.findElement(this.city).getText().equals(city) && driver1.findElement(this.city).isEnabled())
            {
                return driver1.findElement(this.city).getText();
            }
            return driver1.findElement(this.city).getText();
        });

        return textCity;
    }

    private void clickCity()
    {
        driver.findElement(city).click();
    }

    private void editCity(String city)
    {
        WebElement City = ((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(nameOfCity)));
        City.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
        for(int i = 0; i < city.length(); i++)
        {
            City.sendKeys((city.toCharArray())[i] + "");
        }
    }

    private void clickConfirmationButton(String city)
    {
        WebElement City = (new WebDriverWait(driver, 10)).until((ExpectedCondition<WebElement>) driver1 -> {
            if(driver1.findElement(cityInList).getText().equals(city) && driver1.findElement(cityInList).isDisplayed())
            {
                return driver1.findElement(cityInList);
            }
            return driver1.findElement(cityInList);
        });
        City.click();
        WebElement Button = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(confirmationButton));
        Button.click();
    }

    public void changeCity(String city)
    {
        clickCity();
        editCity(city);
        clickConfirmationButton(city);
    }

    public void clickSettings()
    {
        WebElement buttonSettings = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(settings));
        WebElement buttonToMyProfile = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(buttonToLoginOrMyProfile));
        while (!buttonSettings.isDisplayed())
        {
            buttonToMyProfile.click();
        }
        buttonSettings.click();
    }
}