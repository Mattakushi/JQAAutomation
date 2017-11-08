package kinogo_tests;

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

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Homepage Homepage = new Homepage(driver);
        Homepage.goUrl();
        Homepage.newFilmsPage();
    }

    @Test
    public void printFilmName() {
        Newfilmspage newfilms = new Newfilmspage(driver);
        System.out.println(newfilms.findFilm());
    }

    @Test
    public void allFilmsFrom4Page() {
        Newfilmspage Newfilmspage = new Newfilmspage(driver);
        Newfilmspage.changePage();
        Newfilmspage.setAllNames();
        System.out.println(Newfilmspage.setAllNames());
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
