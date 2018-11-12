package Pages;

import Steps.Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {

    WebDriver driver;
    WebDriverWait explicitWait;


    public GoogleSearchPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    //@FindBy(id = googleSearchPageLocators.SEARCH_BOX_ID_LOCATOR)
    @FindBy(id = "lst-ib")
    public WebElement searchBox;

    //@FindBy(xpath = googleSearchPageLocators.SEARCH_BUTTON_XPATH_LOCATOR)
    @FindBy(xpath = "//input[@value='Google Search' and @type='submit']")
    public WebElement searchButton;

    //Business Logic

    public void iEnterSearchText(String searchText){
        waitForVisibility(searchBox);
        searchBox.sendKeys(searchText);
    }

    public void iPressSearchButton(){
        waitForElementIsClickable(searchButton);
        searchButton.submit();
    }

    private void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementIsClickable(WebElement element) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
