package Pages;

import Steps.Base.BaseUtil;
import Pages.Utils.ExplicitWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoogleResultsPage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public GoogleResultsPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    @FindBy(xpath = "//div[@id='hdtb-msb-vis']//div[contains(text(),'All')]")
    private WebElement allTab;

    @FindBy(xpath = "//h3[contains(text(),'Login Example - Semantic')]")
    private WebElement loginExampleSemanticLink;

    public void iPressLoginExamleSemanticLink(){
        waitForElementIsClickable(driver, loginExampleSemanticLink);
        loginExampleSemanticLink.click();
    }

    public void isGoogleResultsTabDisplayed(){
        waitForVisibility(driver, allTab);
        Assert.assertTrue(allTab.isDisplayed());
        Assert.assertTrue(allTab.getText().equals("All"));
    }

    public void isExampleSemanticLinkDisplayed(String linkText){
        waitForVisibility(driver, loginExampleSemanticLink);
        Assert.assertTrue(loginExampleSemanticLink.isDisplayed());
        Assert.assertTrue(loginExampleSemanticLink.getText().equals(linkText));
    }

}
