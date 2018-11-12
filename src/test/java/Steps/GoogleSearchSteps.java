package Steps;

import Locators.GoogleSearchPageLocators;
import Pages.GoogleSearchPage;
import Steps.Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GoogleSearchSteps extends BaseUtil {

    private GoogleSearchPageLocators googleSearchPageLocators;

    private BaseUtil base;
    private GoogleSearchPage googleSearchPage;

    public GoogleSearchSteps(BaseUtil base){
        this.base = base;
        this.googleSearchPageLocators = new GoogleSearchPageLocators();
    }

    @Given("^I navigate to google search page$")
    public void iNavigateToGoogleSearchPage() throws Throwable {
        //same as driver.get()
        base.driver.navigate().to(googleSearchPageLocators.GOOGLE_SEACH_PAGE);
    }

    @When("^I enter the search keyword \"([^\"]*)\"$")
    public void iEnterTheSearchKeyword(String keyword) throws Throwable {
        googleSearchPage = new GoogleSearchPage(base);
        googleSearchPage.iEnterSearchText(keyword);
    }

    @And("^I press the \"([^\"]*)\" button$")
    public void iPressTheButton(String button) throws Throwable {
        if (button.equals("Google Search")) {
            googleSearchPage.iPressSearchButton();
        }
    }
}
