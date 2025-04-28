import org.example.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {

public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverSingleton.getDriver();
    }

    @AfterMethod
    public void closeDriver(){
        WebDriverSingleton.closeDriver();
    }
}
