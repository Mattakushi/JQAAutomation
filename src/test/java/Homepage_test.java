import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homepage_test {

    WebDriver driver;
    static page.Homepage Homepage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Homepage = PageFactory.initElements(driver, page.Homepage.class);
        Homepage.goUrl();
    }

    @Test
    public void FindFilm() {
        Assert.assertEquals(Homepage.findFilm(), "Человек-паук: Возвращение домой (2017)");
    }

    @AfterClass
    public void down() {
        driver.quit();
    }

}
