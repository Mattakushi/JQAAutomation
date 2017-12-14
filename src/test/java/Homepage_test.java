import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homepage_test extends Configuration {

    static page.Homepage Homepage;

    @BeforeClass
    public void setup() {
        runAndConfigDriver();
        Homepage = PageFactory.initElements(driver, page.Homepage.class);
        Homepage.goUrl();
    }

    @Test
    public void FindFilm() {
        Assert.assertEquals(Homepage.findFilm(), "Человек-паук: Возвращение домой (2017)");
    }

    @AfterClass
    public void down() {
        driver.quit();
    }

}
