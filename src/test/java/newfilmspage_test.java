import page.newfilmspage;
import page.homepage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class newfilmspage_test {

    WebDriver driver;

    newfilmspage newfilmspage = new newfilmspage(driver);

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homepage homepage = new homepage(driver);
        homepage.goUrl();
        homepage.newfilmsPage();
    }

    @Test
    public void printFilmName() {
        newfilmspage newfilmspage = new newfilmspage(driver);
        System.out.println(newfilmspage.findFilm());
    }

    @Test
    public void allFilmsFrom4Page() {
        newfilmspage newfilmspage = new newfilmspage(driver);
        newfilmspage.changePage();
        newfilmspage.setAllNames();
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
