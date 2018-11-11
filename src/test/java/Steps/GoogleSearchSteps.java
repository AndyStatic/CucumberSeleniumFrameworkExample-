package Steps;

import Locators.GoogleSearchPageLocators;
import Steps.Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchSteps extends BaseUtil {

    private GoogleSearchPageLocators googleSearchPageLocators;

    private BaseUtil base;

    public WebDriverWait explicitWait;

    public GoogleSearchSteps(BaseUtil base){
        this.base = base;
        this.googleSearchPageLocators = new GoogleSearchPageLocators();
        explicitWait=new WebDriverWait(base.driver, 60);
    }


    @Given("^I navigate to google search page$")
    public void iNavigateToGoogleSearchPage() throws Throwable {
        //same as driver.get()
        base.driver.navigate().to(googleSearchPageLocators.GOOGLE_SEACH_PAGE);
    }

    @When("^I enter the search keyword \"([^\"]*)\"$")
    public void iEnterTheSearchKeyword(String keyword) throws Throwable {
        WebElement searchBox = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id(googleSearchPageLocators.SEARCH_BOX_ID_LOCATOR)));
        searchBox.sendKeys(keyword);
    }

    @And("^I press the \"([^\"]*)\" button$")
    public void iPressTheButton(String button) throws Throwable {
        if (button.equals("Google Search")) {
            //change to .submit() after waitTime
            WebElement searchButton = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(googleSearchPageLocators.SEARCH_BUTTON_XPATH_LOCATOR)));
            searchButton.click();
        }
    }
}
