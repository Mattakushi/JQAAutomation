package kinogo_tests;

import page.Homepage;
import page.Userpage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Userpage_test {

    WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Homepage Homepage = new Homepage(driver);
        Homepage.goUrl();
        Homepage.signInButton();
        Homepage.loginFied("Autotest");
        Homepage.passField("123456789");
        Homepage.loginButton();
        Homepage.userPage();
    }

    @Test
    public void UserpageTest() {
        Userpage Userpage = new Userpage(driver);
        Assert.assertEquals(Userpage.username(), "Autotest");
    }

    @Test
    public void EditUser() {
        Userpage Userpage = new Userpage(driver);
        Userpage.editUserButton();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
