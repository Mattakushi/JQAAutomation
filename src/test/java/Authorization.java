import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Authorization extends Configuration {

    static page.Homepage Homepage;

    @BeforeClass
    public void setup() {
        runAndConfigDriver();
        Homepage = PageFactory.initElements(driver, page.Homepage.class);
        Homepage.goUrl();
    }

    @Test
    public void loginTest() {
        Homepage.logining("Autotest", "123456789");
        Assert.assertEquals(Homepage.loginedName(), "Autotest");
        Homepage.logoutButton();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
