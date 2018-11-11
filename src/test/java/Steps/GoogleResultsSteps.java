package Steps;

import Locators.GoogleResultsPageLocators;
import Steps.Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoogleResultsSteps extends BaseUtil {

    private GoogleResultsPageLocators googleResultsPageLocators;

    private BaseUtil base;

    public GoogleResultsSteps(BaseUtil base){
        this.base = base;
        this.googleResultsPageLocators = new GoogleResultsPageLocators();
        this.explicitWait=new WebDriverWait(base.driver, 60);
    }

    @Then("^list with results is displayed$")
    public void listWithResultsIsDisplayed() throws Throwable {
        WebElement allTab = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(googleResultsPageLocators.ALL_TAB_CSS_LOCATOR)));
        Assert.assertTrue(allTab.isDisplayed());
        Assert.assertTrue(allTab.getText().equals("All"));
    }

    @And("^results list contains \"([^\"]*)\" link$")
    public void resultsListContainsLink(String linkText) throws Throwable {
        WebElement elementWithLinkText = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(googleResultsPageLocators.getLinkTextXpath(linkText))));
        Assert.assertTrue(elementWithLinkText.isDisplayed());
        Assert.assertTrue(elementWithLinkText.getText().equals(linkText));
    }

    @When("^I click the link with title \"([^\"]*)\"$")
    public void iClickTheLinkWithTitle(String linkText) throws Throwable {
        WebElement elementWithLinkText = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(googleResultsPageLocators.getLinkTextXpath(linkText))));
        elementWithLinkText.click();
    }
}
