package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

    private WebDriver driver;

    @FindBy(linkText = "Вход")
    private WebElement signInButton;

    @FindBy(name = "login_name")
    private WebElement loginField;

    @FindBy(name = "login_password")
    private WebElement passField;

    @FindBy(xpath = "//button[@title='Войти']")
    private WebElement loginButton;

    @FindBy(id = "logbtn")
    private WebElement loginedName;

    @FindBy(xpath = "//div[@class='oformlenie']/h1")
    private WebElement loginFailed;

    @FindBy(linkText = "Выход")
    private WebElement logoutButton;

    @FindBy(xpath = "//li[@class='visible_1'][4]//a")
    private WebElement findfilm;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void goUrl() {
        driver.get("http://kinogo.cc/");
    }

    public void logining(String loginName, String password) {
        signInButton.click();
        loginField.sendKeys(loginName);
        passField.sendKeys(password);
        loginButton.click();
    }

    public String loginedName() {
        return loginedName.getText();
    }

    public String loginFailed() {
        return loginFailed.getText();
    }

    public void logoutButton() {
        logoutButton.click();
    }

    public String findFilm() {
        return findfilm.getAttribute("title");
    }

}
