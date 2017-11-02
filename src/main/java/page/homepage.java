package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

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

    public homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public homepage goUrl() {
        driver.get("http://kinogo.club");
        return this;
    }

    public homepage signInButton() {
        signInButton.click();
        return this;
    }

    public homepage loginFied(String loginName) {
        loginField.sendKeys(loginName);
        return this;
    }

    public homepage passField(String password) {
        passField.sendKeys(password);
        return this;
    }

    public homepage loginButton() {
        loginButton.click();
        return this;
    }

    public homepage logoutButton() {
        logoutButton.click();
        return this;
    }

    public homepage userPage() {
        userPage.click();
        return this;
    }

    public homepage newFilmsPage() {
        newFilmsPage.click();
        return this;
    }

    public String findFilm() {
        return findfilm.getAttribute("title");
    }
}
