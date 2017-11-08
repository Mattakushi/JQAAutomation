package kinogo_tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.Homepage;

public class NegativeAuth {

    private WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider
    public static Object[][] logins(){
        return new Object[][]{
              {"",""},
              {"Autotest", "!@#$%^&*("},
              {"Фгещеуые", "123456789"}
        };

    }

    @Test(dataProvider = "logins")
    public void loginTest(String login, String pass) {
        Homepage Homepage = new Homepage(driver);
        Homepage.goUrl();
        Homepage.signInButton();
        Homepage.loginFied(login);
        Homepage.passField(pass);
        Homepage.loginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='oformlenie']/h1")).getText(), "Ошибка авторизации");
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
