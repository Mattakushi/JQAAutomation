import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.Homepage;

public class NegativeAuth {

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

    @DataProvider
    public static Object[][] logins() {
        return new Object[][]{
              {"", ""},
              {"Autotest", "!@#$%^&*("},
              {"Фгещеуые", "123456789"}
        };
    }

    @Test(dataProvider = "logins")
    public void loginTest(String login, String pass) {
        Homepage.signInButton();
        Homepage.loginFied(login);
        Homepage.passField(pass);
        Homepage.loginButton();
        Assert.assertEquals(Homepage.loginFailed(), "Ошибка авторизации");
    }

    @AfterClass
    public void down() {
        driver.quit();
    }

}
