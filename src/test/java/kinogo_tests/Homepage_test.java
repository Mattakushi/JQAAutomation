package kinogo_tests;

import org.testng.Assert;
import page.Homepage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homepage_test {

    WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void FindFilm() {
        page.Homepage Homepage = new page.Homepage(driver);
        Homepage.goUrl();
        Assert.assertEquals(Homepage.findFilm(), "Сделано в Америке (2017)");
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
