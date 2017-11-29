package page;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Newfilmspage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='shortstory'][4]/div/h2/a")
    private WebElement filmname;

    @FindBy(xpath = "//div[@class='bot-navigation']/a[3]")
    private WebElement changePage;

    @FindBy(xpath = "//div[@class='shortstory']/div/h2/a")
    private List<WebElement> setAllNames;

    public Newfilmspage(WebDriver driver) {
        this.driver = driver;
    }

    public String findFilm(){
        return filmname.getText();
    }

    public Newfilmspage changePage() {
        changePage.click();
        return this;
    }

    public ArrayList<String> setAllNames() {
        ArrayList<String> elements = new ArrayList<String>();
        for (int x = 0; x < setAllNames.size(); x = x + 1) {
            elements.add(setAllNames.get(x).getText());
        }
        return elements;
    }

}