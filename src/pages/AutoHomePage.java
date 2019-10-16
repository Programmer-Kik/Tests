import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoHomePage{
    private WebDriver driver;
    @FindBy
    private By LoginToAccount = By.cssSelector("span.pFhTbV17qj");
    @FindBy
    private By MyProfile = By.cssSelector("span.pFhTbV17qj");
    @FindBy
    private By Login = By.cssSelector("div._2I5v9t-gmG span[class = \"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_ QDV8hKAp1G\"]");

    public AutoHomePage(WebDriver driver)
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
}