import org.openqa.selenium.support.PageFactory;
import page.Newfilmspage;
import page.Homepage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Newfilmspage_test {

    WebDriver driver;
    static page.Homepage Homepage;
    static page.Newfilmspage Newfilmspage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Homepage = PageFactory.initElements(driver, page.Homepage.class);
        Newfilmspage = PageFactory.initElements(driver, page.Newfilmspage.class);
        Homepage.goUrl();
        Homepage.newFilmsPage();
    }

    @Test(priority = 1)
    public void printFilmName() {
        System.out.println(Newfilmspage.findFilm());
    }

    @Test(priority = 2)
    public void allFilmsFrom4Page() {
        Newfilmspage.changePage();
        System.out.println(Newfilmspage.setAllNames());
    }

    @AfterClass
    public void down() {
        driver.quit();
    }

}
