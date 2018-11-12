package Pages;

import Steps.Base.BaseUtil;
import Steps.Utils.ExplicitWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public GoogleSearchPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    @FindBy(id = "lst-ib")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@value='Google Search' and @type='submit']")
    public WebElement searchButton;

    //Business Logic

    public void iEnterSearchText(String searchText){
        waitForVisibility(driver, searchBox);
        searchBox.sendKeys(searchText);
    }

    public void iPressSearchButton(){
        waitForElementIsClickable(driver, searchButton);
        searchButton.submit();
    }

}
