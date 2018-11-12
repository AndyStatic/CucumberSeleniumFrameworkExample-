package Steps.Hooks;

import Steps.Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks extends BaseUtil {

    private BaseUtil base;
    private String browser;

    public Hooks(BaseUtil base){
        this.base = base;

        Properties properties = new Properties();
        InputStream input = null;
        try {

            String patentDir = System.getProperty("user.dir");
            input = new FileInputStream(patentDir+"/src/main/java/Config/config.properties");
            //input = new FileInputStream("C:/Users/Andrejs K/IdeaProjects/CucumberSeleniumFrameworkExample/src/main/java/Config/config.properties");

            // load a properties file
            properties.load(input);

            // get the property value and print it out
            System.out.println(properties.getProperty("browser"));
            browser = properties.getProperty("browser");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Before
    public void InitializeTest(){

        switch(browser) {
            case "chrome" :
                //Chrome Driver
                System.setProperty("webdriver.chrome.driver","E:\\libs\\chromedriver.exe");
                base.driver = new ChromeDriver();
                break;

            case "firefox" :
                //Initialize Test with Gecko Driver
                System.setProperty("webdriver.gecko.driver","E:\\libs\\geckodriver.exe");
                base.driver = new FirefoxDriver();
                break;

            case "edge" :
                //Edge Driver
                System.setProperty("webdriver.edge.driver","E:\\libs\\MicrosoftWebDriver.exe");
                base.driver = new EdgeDriver();
                break;

            default :
                System.out.println("Browser property is not defined");
        }

        base.driver.manage().window().maximize();
        //limits the time that the script allots for a web page to be displayed
        base.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

    }

    @After
    public void QuitDriver(){

        //delete all cookies
        base.driver.manage().deleteAllCookies();
        //Closes all browser windows and safely ends the session
        base.driver.quit();
    }
}
