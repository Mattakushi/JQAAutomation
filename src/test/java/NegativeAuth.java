import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeAuth extends Configuration {

    static page.Homepage Homepage;

    @BeforeClass
    public void setup(){
        runAndConfigDriver();
        Homepage = PageFactory.initElements(driver, page.Homepage.class);
        Homepage.goUrl();
    }

//    @DataProvider
//    public static Object[][] logins() {
//        return new Object[][]{
//              {"", ""},
//              {"Autotest", "!@#$%^&*("},
//              {"Фгещеуые", "123456789"}
//        };
//    }

    @DataProvider
    public Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/test.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<TestData> testData = new Gson().fromJson(dataSet, new TypeToken<List<TestData>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test(dataProvider = "getData")
    public void loginTest(TestData data) {
        Homepage.logining(data.getLogin(), data.getPass());
        Assert.assertEquals(Homepage.loginFailed(), "Ошибка авторизации");
    }

    @AfterClass
    public void down() {
        driver.quit();
    }

}
