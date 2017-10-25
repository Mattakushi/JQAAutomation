package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class userpage {

    WebDriver driver;

    public userpage(WebDriver driver) {
        this.driver = driver;
    }

    public userpage username(){
        driver.findElement(By.xpath("//div[@class='padding_border']/b[2]")).getText();
        return this;
    }

    public userpage editUserButton() {
        driver.findElement(By.xpath("//div[@class='padding_border']/a")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='padding_border']/a")).click();
        return this;
    }

}
