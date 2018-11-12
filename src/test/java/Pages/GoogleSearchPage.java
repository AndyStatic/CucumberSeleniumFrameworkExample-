package Pages;

import Steps.Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
    }

    //@FindBy(id = googleSearchPageLocators.SEARCH_BOX_ID_LOCATOR)
    @FindBy(id = "lst-ib")
    public WebElement searchBox;

    //@FindBy(xpath = googleSearchPageLocators.SEARCH_BUTTON_XPATH_LOCATOR)
    @FindBy(xpath = "//input[@value='Google Search' and @type='submit']")
    public WebElement searchButton;

    //Business Logic

    public void iEnterSearchText(String searchText){
        //explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id(googleSearchPageLocators.SEARCH_BOX_ID_LOCATOR)));
        searchBox.sendKeys(searchText);
    }

    public void iPressSearchButton(){
        //explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(googleSearchPageLocators.SEARCH_BUTTON_XPATH_LOCATOR)));
        searchButton.submit();
    }
}
