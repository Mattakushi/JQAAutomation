import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Newfilmspage_test extends Configuration {

    private page.Homepage Homepage;
    private page.Newfilmspage Newfilmspage;

    @BeforeClass
    public void setup() {
        runAndConfigDriver();
        Homepage = PageFactory.initElements(driver, page.Homepage.class);
        Newfilmspage = PageFactory.initElements(driver, page.Newfilmspage.class);
        Homepage.goUrl()
                .newFilmsPage();
    }

    @Test
    public void printFilmName() {
        System.out.println(Newfilmspage.findFilmName());
    }

    @Test(priority = 1)
    public void allFilmsFrom4Page() {
        Newfilmspage.changePage();
        System.out.println(Newfilmspage.setAllNames());
    }

    @AfterClass
    public void down() {
        driver.quit();
    }

}
