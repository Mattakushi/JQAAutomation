package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    WebDriver driver;

    @FindBy(linkText = "Вход")
    private WebElement signInButton;

    @FindBy(name = "login_name")
    private WebElement loginField;

    @FindBy(name = "login_password")
    private WebElement passField;

    @FindBy(xpath = "//button[@title='Войти']")
    private WebElement loginButton;

    @FindBy(linkText = "Выход")
    private WebElement logoutButton;

    @FindBy(id = "logbtn")
    private WebElement userPage;

    @FindBy(xpath = "//table[@class='menu']//td[2]")
    private WebElement newFilmsPage;

    @FindBy(xpath = "//li[@class='visible_1'][4]//a")
    private WebElement findfilm;

    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Homepage goUrl() {
        driver.get("http://kinogo.club");
        return this;
    }

    public Homepage signInButton() {
        signInButton.click();
        return this;
    }

    public Homepage loginFied(String loginName) {
        loginField.sendKeys(loginName);
        return this;
    }

    public Homepage passField(String password) {
        passField.sendKeys(password);
        return this;
    }

    public Homepage loginButton() {
        loginButton.click();
        return this;
    }

    public Homepage logoutButton() {
        logoutButton.click();
        return this;
    }

    public Homepage userPage() {
        userPage.click();
        return this;
    }

    public Homepage newFilmsPage() {
        newFilmsPage.click();
        return this;
    }

    public String findFilm() {
        return findfilm.getAttribute("title");
    }
}
