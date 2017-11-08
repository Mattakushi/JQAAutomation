package kinogo_tests;

import page.Homepage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Authorization {

    WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {
        Homepage Homepage = new Homepage(driver);
        Homepage.goUrl();
        Homepage.signInButton();
        Homepage.loginFied("Autotest");
        Homepage.passField("123456789");
        Homepage.loginButton();
        Homepage.logoutButton();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
