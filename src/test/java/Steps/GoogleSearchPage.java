package Steps;

import Locators.GoogleSearchPageLocators;
import Steps.Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class GoogleSearchPage extends BaseUtil {

    private GoogleSearchPageLocators googleSearchPageLocators;

    private BaseUtil base;

    public GoogleSearchPage(BaseUtil base){
        this.base = base;
        this.googleSearchPageLocators = new GoogleSearchPageLocators();
    }


    @Given("^I navigate to google search page$")
    public void iNavigateToGoogleSearchPage() throws Throwable {
        base.driver.navigate().to(googleSearchPageLocators.GOOGLE_SEACH_PAGE);
    }

    @When("^I enter the search keyword \"([^\"]*)\"$")
    public void iEnterTheSearchKeyword(String keyword) throws Throwable {
        base.driver.findElement(By.id(googleSearchPageLocators.SEARCH_BOX_ID_LOCATOR)).sendKeys(keyword);
    }

    @And("^I press the \"([^\"]*)\" button$")
    public void iPressTheButton(String button) throws Throwable {
        if (button.equals("Google Search"))
            base.driver.findElement(By.xpath(googleSearchPageLocators.SEARCH_BUTTON_XPATH_LOCATOR)).click();
    }
}
