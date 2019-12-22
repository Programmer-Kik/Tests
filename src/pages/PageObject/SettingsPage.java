import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
    private WebDriver driver;
    private By cityInSettings = By.cssSelector("span[data-auto=\"region\"]");

    public SettingsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getCityInSettings()
    {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(cityInSettings)).getText();
    }
}
