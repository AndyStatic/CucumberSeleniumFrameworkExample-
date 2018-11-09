package Steps;

import Steps.Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GoogleSearchPage extends BaseUtil {

    private BaseUtil base;

    public GoogleSearchPage(BaseUtil base){
        this.base = base;
    }


    @Given("^I navigate to google search page$")
    public void iNavigateToGoogleSearchPage() throws Throwable {
        base.driver.navigate().to("https://www.google.com");
    }

    @When("^I enter the search keyword \"([^\"]*)\"$")
    public void iEnterTheSearchKeyword(String keyword) throws Throwable {
        System.out.println("I enter the search keyword");
    }

    @And("^I press the \"([^\"]*)\" button$")
    public void iPressTheButton(String button) throws Throwable {
        System.out.println("I press the");
    }
}
