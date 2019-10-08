import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tests {
    @Test
    public void FirstTest()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/1/Downloads/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://beru.ru/");
        driver.findElementByCssSelector("div._3ZGcN3lbEg").click();
        driver.findElementByCssSelector("input#passp-field-login").sendKeys("alexanderustalkov");
        driver.findElementByCssSelector("button[class = \"control button2 button2_view_classic button2_size_l button2_theme_action button2_width_max button2_type_submit passp-form-button\"]").click();
        driver.findElementByCssSelector("input#passp-field-passwd").sendKeys("Witcher71");
        driver.findElementByCssSelector("button[class = \"control button2 button2_view_classic button2_size_l button2_theme_action button2_width_max button2_type_submit passp-form-button\"]").click();
        String str = driver.findElementByCssSelector("span.pFhTbV17qj").getText();
        Assert.assertTrue(str.equals("Мой профиль"));
        Assert.assertEquals("Александр Усталков", driver.findElementByCssSelector("div._2I5v9t-gmG span[class = \"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_ QDV8hKAp1G\"]").getAttribute("textContent"));
        driver.close();
    }

    @Test
    public void SecondTest()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/1/Downloads/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://beru.ru/");

    }
}