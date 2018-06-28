import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Authorization extends Configuration {

    private page.Homepage Homepage;

    @BeforeClass
    public void setup() {
        runAndConfigDriver();
        Homepage = PageFactory.initElements(driver, page.Homepage.class);
        Homepage.goUrl();
    }

    @Test
    public void loginTest() throws IOException {
        Homepage.logining("Autotest", "123456789");
        takeScreenshot();
        Assert.assertEquals(Homepage.loginedName(), "Autotest");
        Homepage.logoutButton();
    }

//    @DataProvider
//    public static Object[][] logins() {
//        return new Object[][]{
//                {"", ""},
//                {"Autotest", "!@#$%^&*("},
//                {"Фгещеуые", "123456789"}
//        };
//    }

    @DataProvider
    public Object[][] getJsonData() throws FileNotFoundException {

        //from json
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/test.json"));
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

    @Test(dataProvider = "getJsonData")
    public void negativeloginTest(TestData data) {
        Homepage.logining(data.getLogin(), data.getPass());
        Assert.assertEquals(Homepage.loginFailed(), "Ошибка авторизации");
    }

    //from excel
    @DataProvider
    public Object[][] getExcelData() {

        Integer start = 0;
        Object[][] returnValue = new Object[5][2];
        try {

            FileInputStream fis = new FileInputStream(new File("src/test/resources/excel.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(fis);

            XSSFSheet sh1 = wb.getSheetAt(0);

            for (Object[] each : returnValue) {
                each[0] = new DataFormatter().formatCellValue(sh1.getRow(start).getCell(0));
                each[1] = new DataFormatter().formatCellValue(sh1.getRow(start).getCell(1));
                start++;
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        return returnValue;
    }


    @Test(dataProvider = "getExcelData")
    public void negativeloginTest(String login, String pass) {
        Homepage.logining(login, pass);
        Assert.assertEquals(Homepage.loginFailed(), "Ошибка авторизации");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
