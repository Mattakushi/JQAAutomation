package screenshots_tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class screenshot_test {

    WebDriver driver;
    String absolutePath = System.getProperty("user.dir") + "\\src\\test\\screenshots\\";

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://ru.simplesite.com/");
    }

    @Test
    public void shotScreen() throws IOException {
        Screenshot actualScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        File actualFile = new File(absolutePath + "actualfullpagescreen.png");
        ImageIO.write(actualScreenshot.getImage(), "png", actualFile);

        Screenshot expectedScreenshot = new Screenshot(ImageIO.read(new File(absolutePath + "fullpagescreen.png")));

        ImageDiff diff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot);
        File diffFile = new File(absolutePath + "diffFile.png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        Assert.assertEquals(diff.getDiffSize(), 0);
    }

    @Test
    public void elementScreenshot() throws IOException {
        WebElement header = driver.findElement(By.xpath("//div[@id='testimonials']"));
        Screenshot actualScreenshot = new AShot().takeScreenshot(driver, header);
        File actualFile = new File(absolutePath + "element\\actualElement.png");
        ImageIO.write(actualScreenshot.getImage(), "png", actualFile);

        Screenshot expectedScreenshot = new Screenshot(ImageIO.read(new File(absolutePath + "element\\element.png")));

        ImageDiff diff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot);
        File diffFile = new File(absolutePath + "element\\diffFile.png");
        ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        Assert.assertEquals(diff.getDiffSize(), 0);
    }

    @AfterClass
    public void Down() {
        driver.quit();
    }

}
