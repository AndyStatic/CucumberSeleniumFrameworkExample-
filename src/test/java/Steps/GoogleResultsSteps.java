package Steps;

import Pages.GoogleResultsPage;
import Steps.Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleResultsSteps extends BaseUtil {

    private BaseUtil base;
    private GoogleResultsPage googleResultsPage;

    public GoogleResultsSteps(BaseUtil base){
        this.base = base;
    }

    @Then("^list with results is displayed$")
    public void listWithResultsIsDisplayed() throws Throwable {
        googleResultsPage = new GoogleResultsPage(base);
        googleResultsPage.isGoogleResultsTabDisplayed();
    }

    @And("^results list contains \"([^\"]*)\" link$")
    public void resultsListContainsLink(String linkText) throws Throwable {
        if(linkText.equals("Login Example - Semantic")) {
            googleResultsPage.isExampleSemanticLinkDisplayed(linkText);
        }
    }

    @When("^I click the link with title \"([^\"]*)\"$")
    public void iClickTheLinkWithTitle(String linkText) throws Throwable {
        if(linkText.equals("Login Example - Semantic"))
            googleResultsPage.iPressLoginExamleSemanticLink();
    }
}
