import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutoHomePage{
    private WebDriver driver;
    @FindBy
    private By textLoginToAccount = By.cssSelector("span.pFhTbV17qj");
    @FindBy
    private By textMyProfile = By.cssSelector("span.pFhTbV17qj");
    @FindBy
    private By textLogin = By.cssSelector("div._2I5v9t-gmG span[class = \"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_ QDV8hKAp1G\"]");

    public AutoHomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getTextLoginToAccount()
    {
        return driver.findElement(textLoginToAccount).getAttribute("textContent");
    }

    public String getTextMyProfile()
    {
        return driver.findElement(textMyProfile).getAttribute("textContent");
    }

    public String getTextLogin()
    {
        return driver.findElement(textLogin).getAttribute("textContent");
    }

    public void clickLoginToAccount()
    {
        driver.findElement(textLoginToAccount).click();
    }
}
