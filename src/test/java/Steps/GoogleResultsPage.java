package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleResultsPage {
    @Then("^list with results is displayed$")
    public void listWithResultsIsDisplayed() throws Throwable {
        System.out.println("list with results is displayed");
    }

    @And("^results list contains \"([^\"]*)\" link$")
    public void resultsListContainsLink(String linkText) throws Throwable {
        System.out.println("results list contains");
    }

    @When("^I click the link with title \"([^\"]*)\"$")
    public void iClickTheLinkWithTitle(String linkText) throws Throwable {
        System.out.println("I click the link with title");
    }
}
