package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Userpage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='padding_border']//b[2]")
    private WebElement userName;

    @FindBy(xpath = "//div[@class='padding_border']/a")
    private WebElement editUserButton;

    public Userpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String username(){
        return userName.getText();
    }

    public Userpage editUserButton() {
        editUserButton.isDisplayed();
        editUserButton.click();
        return this;
    }

}
