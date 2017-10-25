package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homepage {

    WebDriver driver;

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
        driver.findElement(By.linkText("Вход")).click();
        return this;
    }

    public homepage loginFied(String loginName) {
        driver.findElement(By.name("login_name")).sendKeys(loginName);
        return this;
    }

    public homepage passField(String password) {
        driver.findElement(By.name("login_password")).sendKeys(password);
        return this;
    }

    public homepage loginButton() {
        driver.findElement(By.xpath("//button[@title='Войти']")).click();
        return this;
    }

    public homepage logoutButton() {
        driver.findElement(By.linkText("Выход")).click();
        return this;
    }

    public homepage userPage() {
        driver.findElement(By.id("logbtn")).click();
        return this;
    }

    public homepage newfilmsPage() {
        driver.findElement(By.xpath("//table[@class='menu']//td[2]")).click();
        return this;
    }

    public homepage findFilm(String title) {
        Assert.assertEquals(findfilm.getAttribute("title"), title);
        return this;
    }
}
