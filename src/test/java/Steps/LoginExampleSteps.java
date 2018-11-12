package Steps;

import Pages.LoginExamplePage;
import Steps.Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginExampleSteps extends BaseUtil {

    private BaseUtil base;
    private LoginExamplePage loginExamplePage;

    public LoginExampleSteps(BaseUtil base){
        this.base = base;
    }

    @Then("^I navigate to page with title \"([^\"]*)\"$")
    public void iNavigateToPageWithTitle(String linkText) throws Throwable {
        loginExamplePage = new LoginExamplePage(base);
        Assert.assertTrue(base.driver.getTitle().equals(linkText));
    }

    @And("^I press the \"([^\"]*)\" button on login example page$")
    public void iPressTheButtonOnLoginExamplePage(String button) throws Throwable {
        if (button.equals("Login")) {
            loginExamplePage.iPressLoginButton();
        }
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

        //Option 2 via maps
        /*
        Map<String,String> credentials = (Map<String,String>) dataTable.asMaps(String.class,String.class);
        String email = credentials.get("email");
        String password = credentials.get("password");
        System.out.println(email);
        System.out.println(password);
        */
        
        //Option 3 via separate class
        List<Account> accounts = new ArrayList<Account>();
        //Store all accounts
        accounts = dataTable.asList(Account.class);

        for (Account account: accounts) {
            loginExamplePage.iEnterEmail(account.email);
            loginExamplePage.iEnterPassword(account.password);
        }

    }

    @When("^I enter \"([^\"]*)\" email address and \"([^\"]*)\" password$")
    public void iEnterAddressAnd(String email, String password) throws Throwable {
        loginExamplePage.iEnterEmail(email);
        loginExamplePage.iEnterPassword(password);
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
