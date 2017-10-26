package kinogo_tests;

import page.homepage;
import page.userpage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class userpage_test {

    WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homepage homepage = new homepage(driver);
        homepage.goUrl();
        homepage.signInButton();
        homepage.loginFied("Autotest");
        homepage.passField("123456789");
        homepage.loginButton();
        homepage.userPage();
    }

    @Test
    public void UserpageTest() {
        userpage userpage = new userpage(driver);
        Assert.assertEquals(userpage.username(), "Autotest");
    }

    @Test
    public void EditUser() {
        userpage userpage = new userpage(driver);
        userpage.editUserButton();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
