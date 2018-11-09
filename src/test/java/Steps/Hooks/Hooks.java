package Steps.Hooks;

import Steps.Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

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
    }

    @After
    public void QuitDriver(){
        //Closes all browser windows and safely ends the session
        //driver.quit();
    }
}
