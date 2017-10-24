import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class authorization_test {

    private WebDriver driver;

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {
        driver.get("http://kinogo.club");
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.name("login_name")).sendKeys("Autotest");
        driver.findElement(By.name("login_password")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[@title='Войти']")).click();
        Assert.assertEquals(driver.findElement(By.id("logbtn")).getText(), "Autotest");
        driver.findElement(By.linkText("Выход")).click();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
