package Steps.Hooks;

import Steps.Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseUtil {

    private BaseUtil base;

    public Hooks(BaseUtil base){
        this.base = base;
    }

    @Before
    public void InitializeTest(){
        //Initialize Test with Gecko Driver
        System.setProperty("webdriver.gecko.driver","E:\\libs\\geckodriver.exe");
        base.driver = new FirefoxDriver();

        //base.driver.manage().window().maximize();
        //limits the time that the script allots for a web page to be displayed
        //base.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        //Chrome Driver
        //System.setProperty("webdriver.chrome.driver","E:\\libs\\chromedriver.exe");
        //base.driver = new ChromeDriver();

        //Edge Driver
        //System.setProperty("webdriver.edge.driver","E:\\libs\\MicrosoftWebDriver.exe");
        //base.driver = new EdgeDriver();

    }

    @After
    public void QuitDriver(){

        //delete all cookies
        base.driver.manage().deleteAllCookies();
        //Closes all browser windows and safely ends the session
        base.driver.quit();
    }
}
