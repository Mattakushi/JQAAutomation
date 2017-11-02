package kinogo_tests;

import page.homepage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class authorization_test {

    WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {
        homepage homepage = new homepage(driver);
        homepage.goUrl();
        homepage.signInButton();
        homepage.loginFied("Autotest");
        homepage.passField("123456789");
        homepage.loginButton();
        homepage.logoutButton();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}