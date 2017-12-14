package page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Newfilmspage extends Homepage {


    @FindBy(xpath = "//div[@class='shortstory'][4]/div/h2/a")
    private WebElement filmname;

    @FindBy(xpath = "//div[@class='bot-navigation']/a[3]")
    private WebElement changePage;

    @FindBy(xpath = "//div[@class='shortstory']/div/h2/a")
    private List<WebElement> setAllNames;

    public Newfilmspage(WebDriver driver) {
        super(driver);
    }

    public String findFilmName() {
        return filmname.getText();
    }

    public Newfilmspage changePage() {
        changePage.click();
        return this;
    }

    public List<String> setAllNames() {
        List<String> elements = new ArrayList<>();
        for (WebElement element : setAllNames) {
            elements.add(element.getText());
        }
        return elements;
    }

}