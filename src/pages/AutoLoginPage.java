import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutoLoginPage {
    private WebDriver driver;
    @FindBy
    private By userLogin = By.cssSelector("input#passp-field-login");
    @FindBy
    private By userPassword = By.cssSelector("input#passp-field-passwd");
    @FindBy
    private By buttonAuthorization = By.cssSelector("button[class = \"control button2 button2_view_classic button2_size_l button2_theme_action button2_width_max button2_type_submit passp-form-button\"]");

    public AutoLoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private void setUserLogin(String userLogin)
    {
        driver.findElement(this.userLogin).sendKeys(userLogin);
    }

    private void setUserPassword(String userPassword)
    {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(this.userPassword));
        element.sendKeys(userPassword);
    }

    private void clickAuthorization()
    {
        driver.findElement(buttonAuthorization).click();
    }

    public void Authorization(String userLogin, String userPassword)
    {
        setUserLogin(userLogin);
        clickAuthorization();
        setUserPassword(userPassword);
        clickAuthorization();
    }
}
