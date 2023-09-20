
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.windows.WindowsDriver;

public class TestMaps {
    public WindowsDriver driver = null;
    @BeforeMethod
    public void setUp(){
        DesiredCapabilities cap = new DesiredCapabilities();
//windows application id needs to be given to open the app. Run Get-StartApps in powershell to get all windows app ids.
        cap.setCapability("app","Microsoft.WindowsMaps_8wekyb3d8bbwe!App");
//add platformname and device name
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "WindowsPC");

        try {
//create webdriver instance
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
//provide implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        System.out.println("test run successful");
    }
    @Test
    public void findofficeroute(){
        driver.findElementByAccessibilityId("SearchQueryTextBox").sendKeys("Jkytest");
        driver.findElement(By.xpath("(//*[@id='ChatListItem'])[1]"));
        //driver.findElementByName("Jkytest");
        driver.findElementByName("InputBarTextBox").sendKeys("message");
        //driver.findElementByAccessibilityId("SearchQueryTextBox").clear();
        driver.findElement(By.xpath("(//*[@id='ChatListItem'])[2]"));
        //driver.findElementByName("Jkytest2");
        driver.findElementByName("InputBarTextBox").sendKeys("message");


    }
}