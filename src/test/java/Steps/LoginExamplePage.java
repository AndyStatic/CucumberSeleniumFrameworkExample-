package Steps;

import Locators.LoginExamplePageLocators;
import Steps.Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginExamplePage extends BaseUtil {

    private LoginExamplePageLocators loginExamplePageLocators;

    private BaseUtil base;

    public LoginExamplePage(BaseUtil base){
        this.base = base;
        this.loginExamplePageLocators = new LoginExamplePageLocators();
    }

    @Then("^I navigate to page with title \"([^\"]*)\"$")
    public void iNavigateToPageWithTitle(String linkText) throws Throwable {
        Assert.assertTrue(base.driver.getTitle().equals(linkText));
    }

    @And("^I press the \"([^\"]*)\" button on login example page$")
    public void iPressTheButtonOnLoginExamplePage(String button) throws Throwable {
        if (button.equals("Login"))
            base.driver.findElement(By.xpath(loginExamplePageLocators.LOGIN_BUTTON_XPATH_LOCATOR)).click();
    }

    @When("^I enter email address and password via DataTable$")
    public void iEnterEmailAddressAndPassword(DataTable dataTable) throws Throwable {

        //Option 1 via straight access to row/column stored values
        /*
        List<List<String>> credentials = dataTable.raw();
        String email = credentials.get(1).get(0);
        String password = credentials.get(1).get(1);
        System.out.println(email);
        System.out.println(password);
        */

        //Option 2 via separate class
        List<Account> accounts = new ArrayList<Account>();
        //Store all accounts
        accounts = dataTable.asList(Account.class);

        for (Account account: accounts) {
            base.driver.findElement(By.xpath(loginExamplePageLocators.EMAIL_INPUT_XPATH_LOCATOR)).sendKeys(account.email);
            base.driver.findElement(By.xpath(loginExamplePageLocators.PASSWORD_INPUT_XPATH_LOCATOR)).sendKeys(account.password);
        }

    }

    @When("^I enter \"([^\"]*)\" email address and \"([^\"]*)\" password$")
    public void iEnterAddressAnd(String email, String password) throws Throwable {
        base.driver.findElement(By.xpath(loginExamplePageLocators.EMAIL_INPUT_XPATH_LOCATOR)).sendKeys(email);
        base.driver.findElement(By.xpath(loginExamplePageLocators.PASSWORD_INPUT_XPATH_LOCATOR)).sendKeys(password);
    }

    //for DataTable step
    public class Account {
        public String email;
        public String password;

        public Account(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }
}
