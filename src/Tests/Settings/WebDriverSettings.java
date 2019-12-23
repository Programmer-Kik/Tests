package Settings;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverSettings {
    public static ChromeDriver chromeDriver;
    public static EventFiringWebDriver driver;
    public static SeleniumListener listener;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/1/Downloads/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(chromeDriver);
        listener = new SeleniumListener();
        driver.register(listener);
        driver.manage().window().maximize();
        driver.get("http://www.beru.ru");
    }

    @AfterMethod
    protected void finish() {

        driver.quit();
    }

    @AfterMethod
    public void catchFailure(ITestResult result) {
        if (!result.isSuccess()) {
            takeScreenshot();
        }
    }

    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
