import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Authorization {

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
    public void loginTest() {
        Homepage.signInButton();
        Homepage.loginFied("Autotest");
        Homepage.passField("123456789");
        Homepage.loginButton();
        Assert.assertEquals(Homepage.loginedName(), "Autotest");
        Homepage.logoutButton();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
