package page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newfilmspage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='shortstory'][4]/div/h2/a")
    private WebElement filmname;

    @FindBy(xpath = "//div[@class='bot-navigation']/a[3]")
    private WebElement changePage;

    @FindBy(xpath = "//div[@class='shortstory']/div/h2/a")
    private WebElement setAllNames;

    public newfilmspage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String findFilm(){
        return filmname.getText();
    }

    public newfilmspage changePage() {
        changePage.click();
        return this;
    }

    public newfilmspage setAllNames() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='shortstory']/div/h2/a"));
        for (WebElement names : elements) {
            names.getText();
        }
        return this;
    }

}