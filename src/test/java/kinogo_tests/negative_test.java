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

public class negative_test {

    private WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/homepage/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider
    public static Object[][] logins(){
        return new Object[][]{
              {"",""},
              {null,null},
              {"Autotest", "!@#$%^&*("},
              {"Фгещеуые", "123456789"}
        };

    }

    @Test(dataProvider = "logins")
    public void loginTest(String login, String pass) {
        driver.get("http://kinogo.club");
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.name("login_name")).sendKeys(login);
        driver.findElement(By.name("login_password")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@title='Войти']")).click();
        Assert.assertEquals(driver.findElement(By.id("logbtn")).getText(), "Autotest");
        driver.findElement(By.linkText("Выход")).click();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
